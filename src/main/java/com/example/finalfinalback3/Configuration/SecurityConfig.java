package com.example.finalfinalback3.Configuration;

import org.springframework.cglib.core.internal.CustomizerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.Objects;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .csrf(AbstractHttpConfigurer::disable)//(csrf) ->csrf.ignoringRequestMatchers(new AntPathRequestMatcher("/api/**")))
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((request) -> request
//                        .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
//                        .requestMatchers(new AntPathRequestMatcher("/api/auth")).permitAll()
//                        .requestMatchers(new AntPathRequestMatcher("/registration")).permitAll()
//                        .requestMatchers(new AntPathRequestMatcher("/signin/**")).permitAll()
//                        .requestMatchers(new AntPathRequestMatcher("/registration/**")).permitAll()
                        .anyRequest().permitAll())
                //.cors(AbstractHttpConfigurer::disable)
                //.formLogin((form) -> form
                //        .loginProcessingUrl("/api/auth").permitAll()
                //        .loginPage("/signin").permitAll()
                //       .defaultSuccessUrl("/main"))

                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }

//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}
