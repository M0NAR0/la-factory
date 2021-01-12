package fr.formation.lafactory.service;

import java.util.List;

import fr.formation.lafactory.model.Category;
import fr.formation.lafactory.model.Origami;

public interface IOrigamiService {
	
	List<Origami> getAllOrigamis();
	
	void saveOrigami(Origami origami);
	
	Origami getOrigamiById(long id);
	
	void deleteOrigamiById(long id);
	
	List<Origami> getOrigamisByCategory(Category category);
}
