package fr.formation.lafactory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.formation.lafactory.model.Category;
import fr.formation.lafactory.service.ICategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listCategories", categoryService.getAllCategories());
		return "index";
	}
	
	@GetMapping("/showNewCategoryForm")
	public String showNewCategoryForm(Model model) {
		// create model attribute to bind form data
		Category category = new Category();
		model.addAttribute("category", category);
		return "new_category";
	}
	
	@PostMapping("/saveCategory")
	public String saveCategory(@ModelAttribute("category") Category category) {
		// save category to database
		categoryService.saveCategory(category);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		
		// get category from the service
		Category category = categoryService.getCategoryById(id);
		
		// set category as a model attribute to pre-populate the form
		model.addAttribute("category", category);
		return "update_category";
	}
	
	@GetMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable(value = "id") long id) {
		
		// call delete category method
		this.categoryService.deleteCategoryById(id);
		return "redirect:/";
	}
}
