package com.example.restfulwebservices.service;

import com.example.restfulwebservices.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static Integer userIdCounter = 0;
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(++userIdCounter, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++userIdCounter, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++userIdCounter, "Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        user.setId(++userIdCounter);
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
