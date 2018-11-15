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
    private Integer nextId;

    private UsersService() {
        this.users = new ArrayList<>();
        this.nextId = 1;

        save(new User("Szymon", "Nowak", 55, UserGender.Male));
        save(new User("Anna", "Kowalska", 33, UserGender.Female));
    }

    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    public void save(User user) {
        if (user.getId() != null) {
            users.stream()
                    .filter(e -> e.getId().equals(user.getId()))
                    .findFirst()
                    .ifPresent(e -> {
                        e.setFirstName(user.getFirstName());
                        e.setLastName(user.getLastName());
                        e.setAge(user.getAge());
                        e.setGender(user.getGender());
                    });
        } else {
            user.setId(nextId++);
            users.add(user);
        }
    }

    public User findById(int id) throws UserNotFoundException {
        return users.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " does not exists"));
    }

    public List<User> findByQuery(String query) {
        List<User> usersToReturn = new ArrayList<>();
        for (User user : users) {
            String userRepresentation = user.getFirstName() + " " + user.getLastName();
            if (userRepresentation.contains(query)) {
                usersToReturn.add(user);
            }
        }
        return usersToReturn;
    }
}
