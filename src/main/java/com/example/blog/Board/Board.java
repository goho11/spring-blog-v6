package com.example.blog.Board;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor // DB 조회해 가져온 RS를, 디폴트 생성자 호출해 new하고 값을 채움
@Getter
@Table(name = "board_tb") // 테이블 이름 지정
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private Timestamp createdAt;
}
