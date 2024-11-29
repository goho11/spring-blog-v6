package com.example.blog.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.sql.Timestamp;

// Builder 문법:
// 1. 풀생성자(@AllArgsConstructor)가 있어야 빌더 사용가능
// 2. 컬렉션 빌더 불가
// 간단하게(기존 클래스 수정)
// 1. 생성자 만들고 2. 어노테이션 지우고, NoAr에 붙이고 3. 생성자에 Builder 붙이기
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter // private이라서 값에 접근을 위해서. private - 객체지향(상태를 행위로 지향)
@Table(name = "user_tb")
@Entity // 연속성. 엔티티매니저가 관리 가능
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;

    @CreationTimestamp
    private Timestamp createdAt;

    @Builder
    public User(Integer id, String username, String password, String email, Timestamp createdAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
    }
}
