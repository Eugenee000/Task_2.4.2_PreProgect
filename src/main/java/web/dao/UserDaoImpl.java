package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User user, Long id) {
        User user1 = getUserById(id);
        user1.setName(user.getName());
        user1.setLastName(user.getLastName());
        user1.setAge(user.getAge());
        entityManager.merge(user1);
    }


    @Override
    public void deleteUser(Long id) {
        entityManager.createQuery("delete from User where id=:id").setParameter("id", id).executeUpdate();
    }
}
