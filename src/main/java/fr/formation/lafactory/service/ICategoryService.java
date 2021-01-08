package fr.formation.lafactory.service;

import java.util.List;

import fr.formation.lafactory.model.Category;

public interface ICategoryService {
	
	List<Category> getAllCategories();
	
	void saveCategory(Category category);
	
	Category getCategoryById(long id);
	
	void deleteCategoryById(long id);
}
