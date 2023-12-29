package com.example.finalfinalback3.Security;

import com.example.finalfinalback3.DTO.UserAuthDTO;
import com.example.finalfinalback3.DTO.UserRegisterDTO;
import com.example.finalfinalback3.Entity.UserEntity;
import com.example.finalfinalback3.Exceptions.DataAlreadyExistsException;
import com.example.finalfinalback3.Exceptions.DataNotFoundException;
import com.example.finalfinalback3.Exceptions.PasswordsNotSameException;
import com.example.finalfinalback3.Model.Token;
import com.example.finalfinalback3.Repository.UserRepository;
import com.example.finalfinalback3.Service.DocumentService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@Service
public class AuthService implements UserDetailsService {
    
    private final AuthRepository authRepo;
    private final DocumentService docService;
    private final UserRepository userRepo;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    public AuthService(AuthRepository authRepo, DocumentService docService, UserRepository userRepo, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.authRepo = authRepo;
        this.docService = docService;
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public Token authUser(UserAuthDTO user,
                            Map<String, String> headers) throws DataNotFoundException,
                                                                PasswordsNotSameException {
        UserEntity find_user = authRepo.findByLogin(user.getLogin());
        //String token = StringUtils.tokenizeToStringArray(headers.get("cookie"), "=")[1];
        if (find_user == null){
            throw new DataNotFoundException("Такого пользователя не существует!");
        }
        if (!passwordEncoder.matches(user.getPassword(), find_user.getPassword())){
            throw new PasswordsNotSameException("Неверный пароль!");
        }//find_user.getId();
        //find_user.setToken(token);
        //userRepo.save(find_user);
        return  new Token(find_user.getToken());
    }

    public Token registration(UserRegisterDTO user) throws DataAlreadyExistsException,
            PasswordsNotSameException {
        UserEntity find_user = authRepo.findByLogin(user.getLogin());
        if (find_user != null) {
            throw new DataAlreadyExistsException("Пользователь с таким логином уже существует!");
        }
        if (!user.getPassword().equals(user.getPassword_confirm())){
            throw new PasswordsNotSameException("Пароли не совпадают");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Кодируем пароль пользователя перед сохранением
        user.setPassword_confirm(passwordEncoder.encode(user.getPassword_confirm()));
        UserEntity new_user = authRepo.save(modelMapper.map(user, UserEntity.class));
        new_user.setToken(hashCode(user.getLogin()));
        //docService.addDocument(new_user.getId());
        return new Token(authRepo.save(new_user).getToken());
    }


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserEntity user = authRepo.findByLogin(login);
        if (user != null){
            throw new UsernameNotFoundException("Такой пользователь не найден");
        }
        return modelMapper.map(user, UserAuthPrincipal.class);
    }

    //TODO вынести отдельным классом
    private String hashCode(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
