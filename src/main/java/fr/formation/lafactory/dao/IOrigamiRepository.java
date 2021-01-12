package fr.formation.lafactory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.lafactory.model.Category;
import fr.formation.lafactory.model.Origami;

@Repository
public interface IOrigamiRepository extends JpaRepository<Origami, Long> {
	
	public List<Origami> findByCategory(Category category);
}
