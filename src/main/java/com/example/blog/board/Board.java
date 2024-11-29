package com.example.blog.board;

import com.example.blog.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "board_tb")
@Entity
public class Board { // n
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;

    @ManyToOne // 연관관계 설정 // Hibernate이 자동 테이블 생성
    private User user;

    @CreationTimestamp
    private Timestamp createdAt;

    @Builder
    public Board(Integer id, String title, String content, User user, Timestamp createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
        this.createdAt = createdAt;
    }

    // 업데이트 메서드
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
