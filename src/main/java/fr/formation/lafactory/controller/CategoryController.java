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
import fr.formation.lafactory.service.IOrigamiService;

@Controller
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private IOrigamiService origamiService;
	
	/* USER */
	
	@GetMapping("/category?id={id}")
	public String showOrigamisForCategory(@PathVariable(value = "id") long id, Model model) {
		model.addAttribute("listCategories", categoryService.getAllCategories());
		model.addAttribute("listOrigamis", origamiService.getOrigamisByCategory(categoryService.getCategoryById(id)));
		return "index";
	}
	
	/* ADMIN */
	
	// display list of categories
	@GetMapping("/admin/categories")
	public String viewHomePage(Model model) {
		model.addAttribute("listCategories", categoryService.getAllCategories());
		return "admin/categories/list";
	}
	
	@GetMapping("/admin/categories/showNewCategoryForm")
	public String showNewCategoryForm(Model model) {
		// create model attribute to bind form data
		Category category = new Category();
		model.addAttribute("category", category);
		return "admin/categories/new_category";
	}
	
	@PostMapping("/admin/categories/saveCategory")
	public String saveCategory(@ModelAttribute("category") Category category) {
		// save category to database
		categoryService.saveCategory(category);
		return "redirect:/admin/categories";
	}
	
	@GetMapping("/admin/categories/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		
		// get category from the service
		Category category = categoryService.getCategoryById(id);
		
		// set category as a model attribute to pre-populate the form
		model.addAttribute("category", category);
		return "admin/categories/update_category";
	}
	
	@GetMapping("/admin/categories/deleteCategory/{id}")
	public String deleteCategory(@PathVariable(value = "id") long id) {
		
		// call delete category method
		this.categoryService.deleteCategoryById(id);
		return "redirect:/admin/categories";
	}
}
