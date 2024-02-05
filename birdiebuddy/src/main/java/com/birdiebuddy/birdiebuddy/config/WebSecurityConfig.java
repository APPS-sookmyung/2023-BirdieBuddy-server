package com.birdiebuddy.birdiebuddy.config;

import com.birdiebuddy.birdiebuddy.user.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    private final UserDetailsService userService;

    @Bean
    public WebSecurityCustomizer configure(){
        return (web) -> web.ignoring()
                .requestMatchers("/static/**"); // 특정 요청과 일치하는 url에 대한 액세스 설정.
    } // 정적 리소스에 인증, 인가 서비스 적용 X
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(authorizeRequests -> //authorizeRequest는 authorizeHttpRequest로 바뀜
                        authorizeRequests
                                .requestMatchers("/api/user/signin", "/api/user/login","/api/user/allusers").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(formLogin->
                        formLogin
                                .loginPage("/api/user/login")
                                .defaultSuccessUrl("/api/encyclopedia")
                )
                .logout(logout ->
                        logout
                                .logoutSuccessUrl("/api/user/login")
                                .invalidateHttpSession(true)
                );
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailService userDetailService) throws Exception {
        AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authBuilder
                .userDetailsService(userDetailService)
                .passwordEncoder(bCryptPasswordEncoder);

        return authBuilder.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
