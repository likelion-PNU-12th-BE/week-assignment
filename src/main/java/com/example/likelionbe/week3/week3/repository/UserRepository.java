package com.example.likelionbe.week3.week3.repository;

import com.example.likelionbe.week3.week3.domain.User;


public interface UserRepository {

    void save(User user);

    User findById(String id);
}
