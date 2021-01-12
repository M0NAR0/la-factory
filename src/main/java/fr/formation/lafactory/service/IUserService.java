package fr.formation.lafactory.service;

import java.util.List;

import fr.formation.lafactory.model.User;

public interface IUserService {

	List<User> getAllUsers();
	
	void saveUser(User user);
	
	User getUserById(long id);
	
	void deleteUserById(long id);
}
