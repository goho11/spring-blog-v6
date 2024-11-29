package com.example.blog.board;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class BoardRepository {

    private final EntityManager em;

    public void delete(int id) {
       em.createQuery("delete from Board b where id = :id")
               .setParameter("id", id)
               .executeUpdate();
    }

    public void save(Board board) {
        em.persist(board);
    }

    public List<Board> findAll() {
        return em.createQuery("select b from Board b order by b.id desc", Board.class)
                .getResultList();
    }

    public Optional<Board> findById(int id) {
        return Optional.ofNullable(em.find(Board.class, id));
    }
}