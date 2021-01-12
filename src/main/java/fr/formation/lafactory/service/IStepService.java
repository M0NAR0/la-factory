package fr.formation.lafactory.service;

import java.util.List;

import fr.formation.lafactory.model.Origami;
import fr.formation.lafactory.model.Step;

public interface IStepService {
	
	List<Step> getAllSteps();
	
	void saveStep(Step step);
	
	Step getStepById(long id);
	
	void deleteStepById(long id);
	
	List<Step> getStepsByOrigami(Origami origami);
}
