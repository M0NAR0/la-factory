package fr.formation.lafactory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.lafactory.model.Origami;
import fr.formation.lafactory.model.Step;

@Repository
public interface IStepRepository extends JpaRepository<Step, Long> {
	
	public List<Step> findByOrigami(Origami origami);
}
