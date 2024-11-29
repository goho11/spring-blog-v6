package com.example.blog.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.sql.Timestamp;

// Builder 문법:
// 1. 풀생성자(@AllArgsConstructor)있어야 사용가능
// 2. 컬렉션은 빌더 불가능
// 적용:
// 1. 생성자 생성 및 Builder 붙이기
// 2. 어노테이션 수정
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter // private값 접근. private - 객체지향(상태는 행위를 통해 변경)
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
