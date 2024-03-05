package com.birdiebuddy.birdiebuddy.config;

import com.birdiebuddy.birdiebuddy.user.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity//(debug = true)
public class WebSecurityConfig {
    @Bean
    public WebSecurityCustomizer configure(){
        return (web) -> web.ignoring()
                .requestMatchers("/static/**","/error","/exception/**","/resources/**","/favicon.ico"); // 특정 요청과 일치하는 url에 대한 액세스 설정.
    } // 정적 리소스에 인증, 인가 서비스 적용 X
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeHttpRequests(authorizeRequests -> //authorizeRequest는 authorizeHttpRequest로 바뀜
                        authorizeRequests
//                                .requestMatchers("/api/user/allusers","/api/user/find/{id}","/api/user/signin", "/api/user/login").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/user/find/{id}","/api/user/allusers").permitAll()
                                .requestMatchers(HttpMethod.POST,"/api/user/signin", "/api/user/login").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(formLogin->
                        formLogin
                                //.loginPage("/api/user/login")
                                .permitAll()
                )
                .logout(logout ->
                        logout
                                .invalidateHttpSession(true) // 로그아웃 시 세션 종료
                                .clearAuthentication(true) // 로그아웃 시 권한 제거
                                .permitAll()
                )
        ;
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
