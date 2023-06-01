package com.mertcandeniz.restfullwebservices;

import com.mertcandeniz.restfullwebservices.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDAOService {

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static {

        users.add(new User(1, "Mert", new Date()));
        users.add(new User(2, "Betül", new Date()));
        users.add(new User(3, "Sert", new Date()));

    }
    // findAll();
    // saveUser();
    // findUser();

    public List<User> findAll() {
        return users;
    }

    public User saveUser(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findUser(Integer id) {
        for (User user : users) {

            if (user.getId() == id) {
                return user;
            }

        }
        return null;
    }
}
