package com.example.blog.Board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardResponse.DTO> 게시글목록보기() {

        List<BoardResponse.DTO> dtos = new ArrayList<>();

        List<Board> boardList = boardRepository.findAll();

        for (Board board : boardList) {
            BoardResponse.DTO dto = new BoardResponse.DTO(board);
            dtos.add(dto);
        }
        return dtos;
    }
}

