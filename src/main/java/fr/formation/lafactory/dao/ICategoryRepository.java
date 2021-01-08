package fr.formation.lafactory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.lafactory.model.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
	
}
