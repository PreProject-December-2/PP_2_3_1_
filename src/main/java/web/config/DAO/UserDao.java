package web.config.DAO;

import web.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUser();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);
}
