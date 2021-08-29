package fr.doranco.ecommerce.metier;

import java.util.List;

import fr.doranco.ecommerce.entity.User;

public interface IUserMetier {

	User addUser(User user) throws Exception;
	List<User> getUsers() throws Exception;
	void remove(User user) throws Exception;
	void update(User user) throws Exception;
	User getUserByEmail(String email) throws Exception;
}
