package com.example.finalfinalback3.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .csrf(AbstractHttpConfigurer::disable)//(csrf) ->csrf.ignoringRequestMatchers(new AntPathRequestMatcher("/api/**")))
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests((request) -> request
//                        .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
//                        .requestMatchers(new AntPathRequestMatcher("/api/auth")).permitAll()
//                        .requestMatchers(new AntPathRequestMatcher("/api/auth/reg")).permitAll()
                        //.requestMatchers(new AntPathRequestMatcher("/api/admin/**")).hasAuthority("ROLE_ADMIN")
//                        .requestMatchers(new AntPathRequestMatcher("/signin/**")).permitAll()
//                        .requestMatchers(new AntPathRequestMatcher("/registration/**")).permitAll()
                        .anyRequest().permitAll())
                //.cors(AbstractHttpConfigurer::disable)
                //.formLogin((form) -> form
                //        .loginProcessingUrl("/api/auth").permitAll()
                        //.loginPage("/signin").permitAll()
                //        .failureForwardUrl("/error")
                //        .defaultSuccessUrl("/api/tours")
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(6);
    }


}
