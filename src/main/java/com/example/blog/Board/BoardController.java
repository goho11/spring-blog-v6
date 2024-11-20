package com.example.blog.Board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/board/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        boardService.게시글삭제(id);
        return "redirect:/";
    }

    @PostMapping("/board/{id}/update")
    public String update(@PathVariable("id") int id, BorderRequest.UpdateDTO updateDTO) {
        boardService.게시글수정하기(id, updateDTO);
        return "redirect:/board/" + id ;
    }

    @GetMapping("/board/{id}/update-form")
    public String updateForm(@PathVariable("id") int id, Model model) {
        BoardResponse.UpdateFormDTO updateFormDTO = boardService.게시글수정화면보기(id);
        model.addAttribute("model", updateFormDTO);
        return "update-form";
    }

    @GetMapping("/board/save-form")
    public String saveForm() {
        return "save-form";
    }

    @PostMapping("/board/save")
    public String saveV2(BorderRequest.SaveDTO saveDTO) {
        boardService.게시글쓰기(saveDTO);
        return "redirect:/";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable("id") int id, Model model) {
        BoardResponse.DetailDTO boardDetail = boardService.게시글상세보기(id);
        model.addAttribute("model", boardDetail);
        return "detail";
    }

    @GetMapping("/")
    public String list(Model model) {
        List<BoardResponse.DTO> boardList = boardService.게시글목록보기();
        model.addAttribute("models", boardList);
        return "list";
    }

}