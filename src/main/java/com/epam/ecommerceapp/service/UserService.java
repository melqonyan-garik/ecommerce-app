package com.epam.ecommerceapp.service;

import com.epam.ecommerceapp.model.User;
import com.epam.ecommerceapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }
}
