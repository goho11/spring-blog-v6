package com.example.blog.board;

import com.example.blog.Board.Board;
import com.example.blog.Board.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import(BoardRepository.class)
@DataJpaTest // DB 관련 자원들을 메모리(IoC)에 올림
public class BoardRepositoryTest { // test클래스는 test 붙이기

    @Autowired
    private BoardRepository boardRepository;

    @Test // 자체 스레드 생성
    public void findAll_test() {
        // given 생략가능
        // 매개변수에 파라미터못씀

        // when 어디서 찾을건지
        List<Board> boardList = boardRepository.findAll();

        // eye
        for(Board board : boardList) {
            System.out.println(board.getId());
            System.out.println(board.getTitle());
            System.out.println(board.getContent());
            System.out.println(board.getCreatedAt());
            System.out.println("===============");
        }

        // then - 상태검증
    }
}