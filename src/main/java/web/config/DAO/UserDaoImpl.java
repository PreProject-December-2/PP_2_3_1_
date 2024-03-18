package web.config.DAO;

package web.config.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;


import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoimpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getAllUser() {

        List<User> users = entityManager.createQuery("from User ", User.class).getResultList();
        users.forEach(user -> System.out.println(user.getName()));
        return users;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    @Transactional
    public User getUser(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        Query query = entityManager.createQuery("DELETE FROM User u WHERE u.id = :userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }


}
