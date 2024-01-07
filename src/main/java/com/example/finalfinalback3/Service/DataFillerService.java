package com.example.finalfinalback3.Service;

import com.example.finalfinalback3.DTO.ImageAddDTO;
import com.example.finalfinalback3.DTO.PersonalInfoAddDTO;
import com.example.finalfinalback3.DTO.TourAddDTO;
import com.example.finalfinalback3.DTO.UserRegisterDTO;
import com.example.finalfinalback3.Model.Token;
import com.example.finalfinalback3.Security.AuthService;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DataFillerService {

    private final AuthService authService;
    private final TourService tourService;
    private final ImageService imageService;
    private final UserService userService;
    public DataFillerService(AuthService authService, TourService tourService, ImageService imageService, UserService userService) {
        this.authService = authService;
        this.tourService = tourService;
        this.imageService = imageService;
        this.userService = userService;
    }

    @PostConstruct
    @Transactional
    @SneakyThrows
    public void fillData() {
        UserRegisterDTO user1 = new UserRegisterDTO("Dum@gmail.com", "Hr0mE", "smth", "smth");
        UserRegisterDTO user2 = new UserRegisterDTO("Numbers@gmail.com", "123", "123", "123");
        UserRegisterDTO user3 = new UserRegisterDTO("Not_admin@gmail.com", "Not_admin", "true", "true");
        UserRegisterDTO user4 = new UserRegisterDTO("Petrovich@gmail.com", "Petrovich", "123", "123");

        authService.registration(user1);
        Token user2_token = authService.registration(user2);
        authService.registration(user3);
        authService.registration(user4);

        //userService.setUserRoleAdmin(user2_id);


        ImageAddDTO image1 = new ImageAddDTO("egyptanoubis", "/images/", "anoubis", "1920x1080", ".png");
        ImageAddDTO image2 = new ImageAddDTO("thailandbangkok", "/images/", "bangkok", "1920x1080", ".png");
        ImageAddDTO image3 = new ImageAddDTO("japantokyo", "/images/", "japantokyo", "1920x1080", ".png");
        ImageAddDTO image4 = new ImageAddDTO("koreaseoul", "/images/", "koreaseoul", "1920x1080", ".png");
        ImageAddDTO image5 = new ImageAddDTO("americamaiami", "/images/", "americamaiami", "1920x1080", ".png");
        ImageAddDTO image6 = new ImageAddDTO("russiabaikal", "/images/", "russiabaikal", "1920x1080", ".png");
        imageService.addImage(image1);
        imageService.addImage(image2);
        imageService.addImage(image3);
        imageService.addImage(image4);
        imageService.addImage(image5);
        imageService.addImage(image6);

        TourAddDTO tour1 = new TourAddDTO("Горячая путёвка в Египет!", "Египет", "Анубис", LocalDate.of(2024, 7, 1), LocalDate.of(2024, 7, 16), "Международный", 30, 99999, "some description here. Lorem ipsum sol amer grou fat yvur sop gtariqus divun gopraf");
        TourAddDTO tour2 = new TourAddDTO("Гостеприимный Тайланд", "Тайланд", "Бангкок", LocalDate.of(2024, 9, 15), LocalDate.of(2024,10, 15), "Международный", 64, 150156, "some description here. Lorem ipsum sol amer grou fat yvur sop gtariqus divun gopraf");
        TourAddDTO tour3 = new TourAddDTO("Страна восходящего Солнца!", "Япония", "Токио", LocalDate.of(2024, 6, 8), LocalDate.of(2024,6, 1), "Международный", 15, 90000, "some description here. Lorem ipsum sol amer grou fat yvur sop gtariqus divun gopraf");
        TourAddDTO tour4 = new TourAddDTO("Страна будущего!", "Корея", "Сеул", LocalDate.of(2024, 10, 18), LocalDate.of(2024,8, 18), "Международный", 100, 200000, "some description here. Lorem ipsum sol amer grou fat yvur sop gtariqus divun gopraf");
        TourAddDTO tour5 = new TourAddDTO("Бархатистые пески Майями!", "Америка", "Майями", LocalDate.of(2024, 7, 31), LocalDate.of(2024,6, 1), "Международный", 10, 502000, "some description here. Lorem ipsum sol amer grou fat yvur sop gtariqus divun gopraf");
        TourAddDTO tour6 = new TourAddDTO("Зимний Байкал", "Россия", "Байкал", LocalDate.of(2024, 1, 8), LocalDate.of(2023,12, 29), "По России", 120, 50000, "some description here. Lorem ipsum sol amer grou fat yvur sop gtariqus divun gopraf");

        tourService.addTour(tour1);
        tourService.addTour(tour2);
        tourService.addTour(tour3);
        tourService.addTour(tour4);
        tourService.addTour(tour5);
        tourService.addTour(tour6);

        //PersonalInfoAddDTO person1 = new PersonalInfoAddDTO("Epsilon Developer team", "+79991115050");

        //userService.addPersonalInfo(person1, user2_token.getToken());
    }

}
