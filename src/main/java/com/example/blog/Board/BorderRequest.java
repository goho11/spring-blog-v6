package com.example.blog.Board;

import lombok.Data;

public class BorderRequest {

    @Data
    public static class SaveDTO {
        private String title;
        private String content;

        public Board toEntity() {
            Board board = new Board(null, title, content, null);
            return board;
        }
    }

    @Data
    public static class UpdateDTO {
        private String title;
        private String content;
    }

}
