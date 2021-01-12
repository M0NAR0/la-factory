package fr.formation.lafactory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.lafactory.dao.IUserRepository;
import fr.formation.lafactory.model.User;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@Override
	public void saveUser(User user) {
		this.userRepository.save(user);
	}
	
	@Override
	public User getUserById(long id) {
		Optional<User> optional = userRepository.findById(id);
		User user = null;
		if (optional.isPresent()) {
			user = optional.get();
		}
		else {
			throw new RuntimeException("User not found for id :: " + id);
		}
		
		return user;
	}
	
	@Override
	public void deleteUserById(long id) {
		this.userRepository.deleteById(id);
	}
}
