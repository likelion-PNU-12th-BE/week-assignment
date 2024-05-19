package com.example.likelionbe.week3.week3.repository;

import java.util.HashMap;
import java.util.Map;

import com.example.likelionbe.week3.week3.domain.User;
import org.springframework.stereotype.Repository;


@Repository
public class InMemoryUserRepository implements UserRepository {

    private static final Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        final String id = user.getId();
        users.put(id, user);
    }

    @Override
    public User findById(String id) {
        return users.get(id);
    }
}
