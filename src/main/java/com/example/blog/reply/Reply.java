package com.example.blog.reply;

import com.example.blog.board.Board;
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
@Table(name = "reply_tb")
@Entity
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String comment;

    @CreationTimestamp
    private Timestamp createdAt;

    @ManyToOne(fetch = FetchType.LAZY) // 유저1 : 댓글n
    private User user;

    @ManyToOne(fetch = FetchType.LAZY) // 보드1 : 댓글n
    private Board board;

    @Builder
    public Reply(Integer id, String comment, Timestamp createdAt, User user, Board board) {
        this.id = id;
        this.comment = comment;
        this.createdAt = createdAt;
        this.user = user;
        this.board = board;
    }
}
