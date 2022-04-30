package com.example.furnitureworld.service;

import com.example.furnitureworld.entity.User;
import com.example.furnitureworld.entity.UserType;
import com.example.furnitureworld.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User save(User user) {
        String encode = passwordEncoder.encode(user.getPassword());
        user.setType(UserType.USER);
        user.setPassword(encode);
        return userRepository.save(user);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
