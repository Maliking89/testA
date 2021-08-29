package fr.doranco.ecommerce.model.dao;

import java.util.List;
import java.util.Map;

import fr.doranco.ecommerce.entity.User;


public interface IUserDao {
	
	User getUser(Integer id) throws Exception;
	User getUserByEmail(String email) throws Exception;
	User addUser(User user) throws Exception;
	void updateUser(User user) throws Exception;
	void removeUser(User user) throws Exception;
	
	List<User> getUsers() throws Exception;
	
	
	
	List<User> getUsersByVille(String ville) throws Exception;
	
	//chercher les utilasteur par ville (paris liste utilisateur paris 
	Map<String,List<User>> getUsersOfVille()throws Exception;
	
}
