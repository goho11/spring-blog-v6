package com.example.blog.Board;

import lombok.Data;

public class BoardResponse {

    // board객체를 옮겨주기
    @Data // get, set 포함
    public static class DTO {
        private int id;
        private String title;

        public DTO(Board board) { // Board객체 통째로 받기
            this.id = board.getId();
            this.title = board.getTitle();
        }
    }
}
