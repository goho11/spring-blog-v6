package com.example.blog.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;
import java.util.Optional;

@Import(BoardRepository.class)
@DataJpaTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void findByIdJoinUserAndReply_test() {
        int id = 1;

        boardRepository.findByIdJoinUserAndReply(id);
    }

    @Test
    public void findByJoinUser_test() {
        int id = 1;

        boardRepository.findByIdJoinUser(id);
    }

    @Test
    public void findById_test() {
        // given
        Integer id = 1;

        // when
        Optional<Board> boardOP = boardRepository.findById(id);
    }

    @Test
    public void findAll_test() {
        // given

        // when
        List<Board> boardList = boardRepository.findAll();

        // eye
        for(Board board : boardList) {
            System.out.println(board.getId());
            System.out.println(board.getTitle());
            System.out.println(board.getContent());
            System.out.println(board.getCreatedAt());
            System.out.println("===============");
        }
    }
}