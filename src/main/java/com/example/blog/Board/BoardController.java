package com.example.blog.Board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor // hibernate 생성자를 만들어줌
@Controller
public class BoardController {

    // final : 객체가 생성될 때 반드시 초기화. 이후 변경 불가능
    // boardService 필드를 final로 선언
    private final BoardService boardService; // 생성자

    @GetMapping("/")
    public String list(Model model) { // DS(request 객체를 model 객체로 랩핑하여 전달)

        List<BoardResponse.DTO> boardList = boardService.게시글목록보기(); // 요청을 위임받고 다시 보냄

        model.addAttribute("models", boardList); // 받아서 모델에 저장

        return "list"; // 리턴 파일을 템플릿파일에서 찾음.
                       // viewresolver를 가지고 있어서 앞뒤로 적용 - 문자열 그대로 요청

    }

}
