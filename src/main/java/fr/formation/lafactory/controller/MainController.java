package fr.formation.lafactory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.lafactory.service.ICategoryService;
import fr.formation.lafactory.service.IOrigamiService;

@Controller
public class MainController {
	
	@Autowired
	private IOrigamiService origamiService;
	
	@Autowired
	private ICategoryService categoryService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listCategories", categoryService.getAllCategories());
		model.addAttribute("listOrigamis", origamiService.getAllOrigamis());
		return "index";
	}
}
