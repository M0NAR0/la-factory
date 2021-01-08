package fr.formation.lafactory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.lafactory.model.Step;

@Repository
public interface IStepRepository extends JpaRepository<Step, Long> {
	
}
