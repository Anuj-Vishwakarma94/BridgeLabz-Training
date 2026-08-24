package com.FundooNotesApp.service;

import com.FundooNotesApp.dto.MessageResponse;
import com.FundooNotesApp.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User register(User user);

    User findByEmail(String email);

    MessageResponse forgotPassword(String email);

    MessageResponse resetPassword(String token, String newPassword);
}