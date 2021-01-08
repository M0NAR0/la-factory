package fr.formation.lafactory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.lafactory.dao.IStepRepository;
import fr.formation.lafactory.model.Step;

@Service
public class StepService implements IStepService {

	@Autowired
	private IStepRepository stepRepository;
	
	@Override
	public List<Step> getAllSteps() {
		return stepRepository.findAll();
	}
	
	@Override
	public void saveStep(Step step) {
		this.stepRepository.save(step);
	}
	
	@Override
	public Step getStepById(long id) {
		Optional<Step> optional = stepRepository.findById(id);
		Step step = null;
		if (optional.isPresent()) {
			step = optional.get();
		}
		else {
			throw new RuntimeException("Step not found for id :: " + id);
		}
		
		return step;
	}
	
	@Override
	public void deleteStepById(long id) {
		this.stepRepository.deleteById(id);
	}
}
