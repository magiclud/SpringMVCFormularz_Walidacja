package net.codejava.spring.service;

import java.util.List;
import net.codejava.spring.model.User;

public interface UserService {
	public void addUser(User contact);

	public List<User> listUser();

	public void removeUser(Integer id);

}
