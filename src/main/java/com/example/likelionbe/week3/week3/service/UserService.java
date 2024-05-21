package com.example.likelionbe.week3.week3.service;

import com.example.likelionbe.week3.week3.domain.User;
import org.springframework.ui.Model;


public interface UserService {

    void saveUser(String id, String password);

    User login(String id, String password, Model model);
}
