package com.example.blog.board;

import com.example.blog.reply.Reply;
import com.example.blog.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "board_tb")
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;

    // 연관관계 설정(n:1.board가 n)
    // LAZY: 지연로딩
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    // 테이블 조회할 때만 영향을 준다
    // mappedBy = "변수명" -연관관계가 있는 변수명 적는 문법
    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // fk의 변수명이 뭐야?
    private List<Reply> replise = new ArrayList<>();

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
