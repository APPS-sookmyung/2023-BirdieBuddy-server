package com.birdiebuddy.birdiebuddy.user.entity;

import lombok.*;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Table(name = "MEMBER")
@Entity
@Getter @Setter
@NoArgsConstructor//(access = AccessLevel.PROTECTED)
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //primary key

    // login, 회원가입
    @Column(name = "user_id", nullable = false, updatable = false, unique = true)
    private String userId; //id 수정 불가능
    @Column(name = "email", nullable = false)
    private String email; //email == name
    @Column(name = "password")
    private String pw;
    @Column(name = "image")
    private String image;

//    // 동정횟수, 도움횟수, 씨앗(아이템), 포스트(동정) 관리
//    @Column(name = "watch")
//    private int watch; // 동정횟수 watch = len(posts)
//    @Column(name = "illation")
//    private int illation; // 도움횟수
//    @Column(name = "seed", columnDefinition = "int default 0")
//    private int seed; // 씨앗 - 아이템 개수, 초기값 0
//    @Column(name = "item")
//    private List<String> item; // 씨앗으로 구매한 재화
//    @Column(name = "posts")
//    private List<String> posts = new ArrayList<>(); // 동정 포스트 리스트

    @Builder
    public User(String userId, String email, String pw, String image, String auth){
        this.userId = userId;
        this.email = email;
        this.pw = pw;
        this.image = image;
    }


    public void update(String img) {
        this.image = img;
    }

    //재화 구매
    //소유 씨앗 > itm의 씨앗값 -> 소유 -= itm.seed && Item에 해당 itm 추가

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(new SimpleGrantedAuthority("MEMBER"));
    }
    @Override
    public String getUserName(){
        return email;
    } //사용자 고유 id 반환

    @Override
    public String getPassword(){
        return pw;
    } //사용자 패스워드 반환
    @Override
    public boolean isAccountNonExpired(){
        return true;
    } //계정 만료 여부
    @Override
    public boolean isAccountNonLocked(){
        return true;
    } //계정 잠금 여부 반환

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    } //패스워드 만료여부
    @Override
    public boolean isEnabled(){
        return true;
    } //계정 사용 가능 여부


}
