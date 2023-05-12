package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.entity.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private EntityManager entityManager;

    public List<User> getAllUsers() {
        return null;
    }
}
