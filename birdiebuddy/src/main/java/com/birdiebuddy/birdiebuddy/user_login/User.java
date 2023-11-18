package com.birdiebuddy.birdiebuddy.user_login;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Table(name = "users")
@Entity // member 엔티티 지정.
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자.
//@AllArgsConstructor

public class User implements UserDetails { //MemberDetails를 상속받아 인증객체로 사용
    @Id // id 필드를 기본키로 지정.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 자동으로 1씩 증가.
    @Column(name = "user_id", updatable = false) // id 수정 불가능.
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @Builder
    public User(String email, String password, String auth){
        this.email = email;
        this.password = password;
    }

    @Override // 권한 반환 ?
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(new SimpleGrantedAuthority("user"));
    }

    //사용자 id 반환
    @Override
    public String getUsername(){
        return email;
    }

    //사용자 pw 반환
    @Override
    public String getPassword(){
        return password;
    }

    //계정 만료 여부 반환
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    //계정 잠금 여부 반환
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    //패스워드 만료 여부 반환
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    //계정 사용 가능 여부 반환
    @Override
    public boolean isEnabled(){ // 계정사용가능한지 확인
        return true;
    }





}

