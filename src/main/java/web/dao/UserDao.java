package web.dao;

import web.entity.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void saveOrUpdateUser(User user);

    User getUser(int id);

    void deleteUser(int id);
}
