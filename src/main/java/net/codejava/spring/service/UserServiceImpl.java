package net.codejava.spring.service;

import java.util.List;

import net.codejava.spring.dao.UserDAO;
import net.codejava.spring.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service//@Service stereotype annotation used to decorate the ContactServiceImpl class is a specialized form of the @Component annotation
public class UserServiceImpl implements UserService {

	@Autowired
    private UserDAO usertDAO;
     
    @Transactional
    public void addUser(User user) {
        usertDAO.addUser(user);
    }
 
    @Transactional
    public List<User> listUser() {
 
        return  usertDAO.listUser();
    }
 
    @Transactional
    public void removeUser(Integer id) {
    	 usertDAO.removeUser(id);
    }

}
