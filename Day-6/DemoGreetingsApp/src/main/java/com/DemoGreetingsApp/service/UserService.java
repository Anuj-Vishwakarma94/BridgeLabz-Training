package com.DemoGreetingsApp.service;

import com.DemoGreetingsApp.model.User;

public interface UserService {

    User registerUser(User user);

    User loginUser(String email, String password);

}