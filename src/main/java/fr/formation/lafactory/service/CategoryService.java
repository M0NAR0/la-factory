package fr.formation.lafactory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.lafactory.dao.ICategoryRepository;
import fr.formation.lafactory.model.Category;

@Service
public class CategoryService implements ICategoryService {
	
	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
	
	@Override
	public void saveCategory(Category category) {
		this.categoryRepository.save(category);
	}
	
	@Override
	public Category getCategoryById(long id) {
		Optional<Category> optional = categoryRepository.findById(id);
		Category category = null;
		if (optional.isPresent()) {
			category = optional.get();
		}
		else {
			throw new RuntimeException("Category not found for id :: " + id);
		}
		
		return category;
	}
	
	@Override
	public void deleteCategoryById(long id) {
		this.categoryRepository.deleteById(id);
	}
}
