package web.service;

import web.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveOrUpdateUser(User user);

    User getUser(int id);

    void deleteUser(int id);
}
