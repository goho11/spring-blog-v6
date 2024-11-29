package com.example.blog.board._core.practice;

import org.junit.jupiter.api.Test;

class Member {
    private Integer id;
    private String name;
    private String addr;

    private Member() {}

    public static Member builder() {
        return new Member();
    }

    public Member id(Integer id) {
        this.id = id;
        return this; // this는 아래의 m과 같다
    }

    public Member name(String name) {
        this.name = name;
        return this;
    }

    public Member addr(String addr) {
        this.addr = addr;
        return this;
    }
}

public class BuilderTest {

    @Test
    public void new_test() {
        // 빌더패턴: 내가 값을 채워넣으면 그 객체를 리턴 -원하는 값과 순서로 채우기 가능
        Member m = Member.builder()
                .id(1)
                .name("이름")
                .addr("주소");
    }
}
