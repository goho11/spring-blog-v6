package com.example.blog.board;

import com.example.blog._core.util.Encoding;
import lombok.Data;

public class BoardResponse {

    @Data
    public static class UpdateFormDTO {
        private int id;
        private String title;
        private String content;
        private String createdAt;

        public UpdateFormDTO(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.content = board.getContent();
            this.createdAt = Encoding.formatToStr(board);
        }
    }

    @Data
    public static class DetailDTO {
        private int id;
        private String title;
        private String content;
        private String createdAt;

        public DetailDTO(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.content = board.getContent();
            // Encoding클래스의 날짜변환 메서드 가져와 적용
            this.createdAt = Encoding.formatToStr(board);
        }
    }

    @Data
    public static class SaveDTO {
        private int id;
        private String title;

        public SaveDTO(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
        }
    }

    @Data
    public static class DTO {
        private int id;
        private String title;

        public DTO(Board board) { // Board객체 통째로 받기
            this.id = board.getId();
            this.title = board.getTitle();
        }
    }
}
