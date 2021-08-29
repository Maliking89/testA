package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.model.dao.IUserDao;
import fr.doranco.ecommerce.model.dao.UserDao;

public class UserMetier implements IUserMetier {

	private final IUserDao userDao = new UserDao();
	
	@Override
	public User addUser(User user) throws Exception {
		user.setNom(user.getNom().toUpperCase());
		user.setPrenom(user.getPrenom().substring(0, 1).toUpperCase().concat(user.getPrenom().substring(1).toLowerCase()));
		
		return userDao.addUser(user);
	}

	@Override
	public List<User> getUsers() throws Exception {
		return userDao.getUsers();
	}

	@Override
	public void remove(User user) throws Exception {
		userDao.removeUser(user);
		
	}

	@Override
	public void update(User user) throws Exception {
		userDao.updateUser(user);
		
	}

	@Override
	public User getUserByEmail(String email) throws Exception {
		
		return userDao.getUserByEmail(email);
	}
	
	

}
