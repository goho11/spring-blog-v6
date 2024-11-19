package com.example.blog.Board;

import jakarta.transaction.Transactional;
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

    public BoardResponse.UpdateFormDTO 게시글수정화면보기(int id) {
        Board board = boardRepository.findById(id); // 바로 return 불가능>DTO
        return new BoardResponse.UpdateFormDTO(board);
    }

    // 진행방향: 다같이 모든 화면을 만들고(vs코드로) > 코드 세분화함(순서대로 / 거꾸로)
    // 선생님 추천(반대로) 1.레 2.컨 3.서
    public BoardResponse.DetailDTO 게시글상세보기(int id) {
        Board board = boardRepository.findById(id); // 바로 return 불가능>DTO
        return new BoardResponse.DetailDTO(board);
    }

    @Transactional
    public void 게시글쓰기(BorderRequest.SaveDTO saveDTO) {
        boardRepository.save(saveDTO.getTitle(), saveDTO.getContent());
    } // commit

    @Transactional
    public void 게시글삭제(int id) {
        boardRepository.delete(id);
    } // commit or rollback 이 됨

    @Transactional // commit or rollback
    public void 게시글수정하기(int id, BorderRequest.UpdateDTO updateDTO) {
        // 꺼내서 날리기 -왜 꺼내는지? 수정기능에만 의존되도록
        // 서비스와 컨트롤러는 1대1 매칭 (서비스 여러개 때려도 돌아는 감)
        boardRepository.update(id, updateDTO.getTitle(), updateDTO.getContent());
    }
}