package com.example.blog.Board;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// JPQL 활용
@RequiredArgsConstructor
@Repository
public class BoardRepository {

    // JPA는 EntityManager로 DB에 접근 (자바에서 DBConnection)
    private final EntityManager em;

    public void delete(int id) {
       em.createQuery("delete from Board b where id = :id")
               .setParameter("id", id)
               .executeUpdate();
    }

    public void save(Board board) {
        // 비영리
        em.persist(board);
        // 동기화 완료(영속화됨)
    }

    public List<Board> findAll() {
        return em.createQuery("select b from Board b order by b.id desc", Board.class)
                .getResultList();
    }

    public Optional<Board> findById(int id) {
        // 관리하는 id있으면 들고 오고 아니면 날리기
        // return타입 Board.class클래스 객체
        return Optional.ofNullable(em.find(Board.class, id));
    }
}