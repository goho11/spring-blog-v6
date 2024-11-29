package com.example.blog.user;

import com.example.blog._core.error.Exception401;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User 로그인(UserRequest.LoginDTO loginDTO) {
        User userPs = userRepository.findByUsername(loginDTO.getUsername());
        if(!userPs.getPassword().equals(loginDTO.getPassword())) {
            throw new Exception401("비밀번호가 틀립니다");
        }
        return userPs;
    }
}
