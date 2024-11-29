package com.example.blog.user;

import com.example.blog._core.error.Exception401;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final EntityManager em;

    public User findByUsername(String username) {
        Query q = em.createQuery("select u from User u where u.username = :username", User.class);
        q.setParameter("username", username);
            try {
                return (User) q.getSingleResult();
            } catch (Exception e) {
                throw new Exception401("아이디를 찾을 수 없습니다");
            }

        }
    }
