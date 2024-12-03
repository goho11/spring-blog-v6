package com.example.blog.board;

import com.example.blog._core.error.Exception404;
import com.example.blog.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardResponse.DTO> 게시글목록보기() {
        return boardRepository.findAll().stream()
                .map(BoardResponse.DTO::new)
                .toList();
    }

    public BoardResponse.UpdateFormDTO 게시글수정화면보기(int id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new Exception404("해당 id의 게시글이 없습니다 : " + id));
        return new BoardResponse.UpdateFormDTO(board);
    }

    @Transactional
    public void 게시글수정하기(int id, BoardRequest.UpdateDTO updateDTO) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new Exception404("해당 id의 게시글이 없습니다 : " + id));

        board.update(updateDTO.getTitle(), updateDTO.getContent());
    }

    // 1202 Join > service 메서드 이름 변경
    // 1203 메서드 findByIdJoinUserAndReply로 변경 -상세보기에 댓글 보이게
    public BoardResponse.DetailDTO 게시글상세보기(int id, User sessionUser) {
        Board board = boardRepository.findByIdJoinUserAndReply(id)
                .orElseThrow(() -> new Exception404("해당 id의 게시글이 없습니다 : " + id));
        return new BoardResponse.DetailDTO(board, sessionUser);
    }

    @Transactional
    public void 게시글쓰기(BoardRequest.SaveDTO saveDTO) {
        boardRepository.save(saveDTO.toEntity());
    }

    @Transactional
    public void 게시글삭제(int id) {
        boardRepository.delete(id);
    }

}