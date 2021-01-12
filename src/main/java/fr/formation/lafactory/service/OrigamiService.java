package fr.formation.lafactory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.lafactory.dao.IOrigamiRepository;
import fr.formation.lafactory.model.Category;
import fr.formation.lafactory.model.Origami;

@Service
public class OrigamiService implements IOrigamiService {
	
	@Autowired
	private IOrigamiRepository origamiRepository;
	
	@Override
	public List<Origami> getAllOrigamis() {
		return origamiRepository.findAll();
	}
	
	@Override
	public void saveOrigami(Origami origami) {
		this.origamiRepository.save(origami);
	}
	
	@Override
	public Origami getOrigamiById(long id) {
		Optional<Origami> optional = origamiRepository.findById(id);
		Origami origami = null;
		if (optional.isPresent()) {
			origami = optional.get();
		}
		else {
			throw new RuntimeException("Origami not found for id :: " + id);
		}
		
		return origami;
	}
	
	@Override
	public void deleteOrigamiById(long id) {
		this.origamiRepository.deleteById(id);
	}
	
	@Override
	public List<Origami> getOrigamisByCategory(Category category) {
		return origamiRepository.findByCategory(category);
	}
}
