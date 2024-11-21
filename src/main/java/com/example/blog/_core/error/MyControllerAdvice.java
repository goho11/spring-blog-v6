package com.example.blog._core.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

// 에러처리
// 원하는 Exception 터트리기
@ControllerAdvice // 모든 컨트롤러에서 발생하는 예외 처리
public class MyControllerAdvice {

    @ResponseBody
    @ExceptionHandler(Exception400.class)
    public String err400(Exception400 e) {
        System.out.println("err400");
        // 자바스크립트 코드
        String body = """
                <script>
                    alert('${msg}');
                    history.back();
                </script>    
                """.replace("${msg}", e.getMessage()); // msg를 메세지로 변환

        return body;
    }

    @ResponseBody
    @ExceptionHandler(Exception404.class)
    public String err404(Exception404 e) {
        System.out.println("err404");
        String body = """
                <script>
                    alert('${msg}');
                    history.back();
                </script>    
                """.replace("${msg}", e.getMessage());

        return body;
    }
}
