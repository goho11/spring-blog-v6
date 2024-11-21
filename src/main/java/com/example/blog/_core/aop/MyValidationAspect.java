package com.example.blog._core.aop;

import com.example.blog._core.error.Exception400;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component //@Aspect 같이 붙여다님
@Aspect // 관점지향 클래스로 지정
public class MyValidationAspect {

    // 행위
    // 실행 before직전, after직후, around전후 모두 -around는 문법이 다르다(코드확인)
    // 포스트매핑 실행 직전 -컨트롤러 import 복붙
    @Before("@annotation(org.springframework.web.bind.annotation.PostMapping)") // 포인트컷 자리
    public void validationCheck(JoinPoint jp) {
        Object[] args = jp.getArgs();

        // 포스트매핑마다 errors확인되면 때리기
        for (Object arg : args) {
            if (arg instanceof Errors) {
                Errors errors = (Errors) arg;

                if (errors.hasErrors()) {
                    String errMsg = errors.getFieldErrors().get(0).getField() + " : "
                            + errors.getFieldErrors().get(0).getDefaultMessage();
                    throw new Exception400(errMsg);
                }
            }
        }

    }
}
