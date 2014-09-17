package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.User;

public interface UserDAO {

	public void addUser(User user);

	public List<User> listUser();

	public void removeUser(Integer id);
}
