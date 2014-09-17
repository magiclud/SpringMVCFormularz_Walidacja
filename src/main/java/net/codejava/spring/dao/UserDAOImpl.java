package net.codejava.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.codejava.spring.model.User;

@Repository//This annotation is used to indicate that a class functions as a repository and needs to have exception translation applied transparently on it. The benefit of exception translation is that the service layer only has to deal with exceptions from Spring’s DataAccessException hierarchy, even when using plain JPA in the DAO classes.
public class UserDAOImpl implements UserDAO {

	@Autowired//to autowire the dependency of the ContactDAOImpl on the SessionFactory.
	private SessionFactory sessionFactory;

	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	public List<User> listUser() {
		return sessionFactory.getCurrentSession().createQuery("from User")
                .list();
	}

	public void removeUser(Integer id) {
		User user = (User) sessionFactory.getCurrentSession().load(
                User.class, id);
        if (null != user) {
            sessionFactory.getCurrentSession().delete(user);
        }

	}

}
