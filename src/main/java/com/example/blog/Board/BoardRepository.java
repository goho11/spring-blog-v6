package com.example.blog.Board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class BoardRepository {

    // JPA는 EntityManager로 DB에 접근 (자바에서 DBConnection)
    private final EntityManager em;

    public List<Board> findAll() {
        Query q = em.createNativeQuery("select * from board_tb order by id desc", Board.class);
        return q.getResultList();
    }
}