package com.example.finalfinalback3.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("*"));
//        // другие настройки CORS
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}
