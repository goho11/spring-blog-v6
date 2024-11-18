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

    // 1118 글삭제
    public void delete(int id) {
        Query q = em.createNativeQuery("delete from board_tb where id=?");
        q.setParameter(1, id);
        q.executeUpdate(); // insert, update, delete 때 사용 함
    }

    // 1118 글쓰기
    public void save(String title, String content) {
        Query q = em.createNativeQuery("insert into board_tb(title, content, created_at) values (?, ?, now())");
        q.setParameter(1, title);
        q.setParameter(2, content);
        q.executeUpdate(); // 넣고 커밋해 -정상 return값은 1
    }

    // 글전체보기
    public List<Board> findAll() {
        Query q = em.createNativeQuery("select * from board_tb order by id desc", Board.class);
        return q.getResultList(); // 통신코드
    }

    // 1118 글상세보기
    public Board findById(int id) {
        Query q = em.createNativeQuery("select * from board_tb where id = ?", Board.class);
        q.setParameter(1, id); // 물음표 완성하기 (물음표 순서, 물음표에 바인딩될 변수값)
        // (Board) : 다운캐스팅. getSingleResult 타입은 object
        return (Board) q.getSingleResult(); // 통신코드. 한개만 반환
    }
}