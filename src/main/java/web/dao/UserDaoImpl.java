package web.dao;

import org.springframework.stereotype.Repository;
import web.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u from User u", User.class);
        return query.getResultList();
    }

    @Override
    public void saveOrUpdateUser(User user) {

    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }
}
