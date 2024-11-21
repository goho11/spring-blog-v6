package com.example.blog._core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 1. HelloAspect 만들기
 2. @GetMapping 포인트컷
 3. 포인트컷 직전에 동작구성 @Before → JoinPoint
 4. 매개변수에 integer가 있으면 [n번아 안녕] 출력
 */
@Component
@Aspect
public class HelloAspect {

    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void hello(JoinPoint jpo) {

        Object[] args = jpo.getArgs();

        for (Object arg : args) {
            if (arg instanceof Integer) {
                Integer num = (Integer) arg;
                System.out.println(num + "번아 안녕");

            }
        }
    }
}