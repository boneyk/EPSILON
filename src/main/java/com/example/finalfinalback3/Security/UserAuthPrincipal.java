package com.example.finalfinalback3.Security;

import com.example.finalfinalback3.Entity.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.util.Streamable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class UserAuthPrincipal implements UserDetails {
    private UserEntity user;

    //Переписать под список ролей TODO
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> collect = Streamable.of(user.getRole())
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());
        // return Collections.singleton(new SimpleGrantedAuthority(user.getRole()))
        return collect;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
