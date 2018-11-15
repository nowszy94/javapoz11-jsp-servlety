package com.sda.servlets.users;

import java.util.ArrayList;
import java.util.List;

public class UsersService {

    private static UsersService instance;

    public static UsersService instanceOf() {
        if (instance == null) {
            instance = new UsersService();
        }
        return instance;
    }

    private List<User> users;

    private UsersService() {
        this.users = new ArrayList<>();

        this.users.add(new User("Szymon", "Nowak", 55, UserGender.Male));
        this.users.add(new User("Anna", "Kowalska", 33, UserGender.Female));
    }

    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    public void save(User user) {
        users.add(user);
    }

    public User findById(int id) {
        return users.get(id);
    }
}
