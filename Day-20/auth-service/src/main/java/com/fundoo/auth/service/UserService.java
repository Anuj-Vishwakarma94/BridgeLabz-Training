package com.fundoo.auth.service;

import com.fundoo.auth.dto.MessageResponse;
import com.fundoo.auth.entity.User;

public interface UserService {
    User register(User user);
    User findByEmail(String email);
    User findById(Long id);
    MessageResponse forgotPassword(String email);
    MessageResponse resetPassword(String token, String newPassword);
}
