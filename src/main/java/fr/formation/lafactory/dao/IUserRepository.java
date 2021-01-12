package fr.formation.lafactory.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.lafactory.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	
	public Optional<User> findByUsername(String username);
}
