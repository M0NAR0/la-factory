package fr.formation.lafactory.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.formation.lafactory.model.Origami;
import fr.formation.lafactory.model.Step;
import fr.formation.lafactory.service.ICategoryService;
import fr.formation.lafactory.service.IOrigamiService;
import fr.formation.lafactory.service.IStepService;

@Controller
public class OrigamiController {

	@Autowired
	private IOrigamiService origamiService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private IStepService stepService;
	
	/* USER */
	@GetMapping("/origami/{id}")
	public String viewOrigamiDetails(@PathVariable(value = "id") long id, Model model) {
		Origami origami = origamiService.getOrigamiById(id);
		Comparator<Step> compareByOrder = (Step s1, Step s2) -> Integer.compare(s1.getOrder(), s2.getOrder());
		List<Step> steps = stepService.getStepsByOrigami(origami);
		Collections.sort(steps, compareByOrder);
		model.addAttribute("origami", origami);
		model.addAttribute("listSteps", steps);
		return "origami_details";
	}
	
	/* ADMIN */
	
	// display list of origamis
	@GetMapping("/admin/origamis")
	public String viewHomePage(Model model) {
		model.addAttribute("listOrigamis", origamiService.getAllOrigamis());
		return "admin/origamis/list";
	}
	
	@GetMapping("/admin/origamis/showNewOrigamiForm")
	public String showNewOrigamiForm(Model model) {
		// create model attribute to bind form data
		Origami origami = new Origami();
		model.addAttribute("origami", origami);
		model.addAttribute("listCategories", categoryService.getAllCategories());
		return "admin/origamis/new_origami";
	}
	
	@PostMapping("/admin/origamis/saveOrigami")
	public String saveOrigami(@ModelAttribute("origami") Origami origami) {
		// save origami to database
		origamiService.saveOrigami(origami);
		return "redirect:/admin/origamis";
	}
	
	@GetMapping("/admin/origamis/showFormForOrigamiUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		
		// get origami from the service
		Origami origami = origamiService.getOrigamiById(id);
		
		// set origami as a model attribute to pre-populate the form
		model.addAttribute("origami", origami);
		model.addAttribute("listCategories", categoryService.getAllCategories());
		return "admin/origamis/update_origami";
	}
	
	@GetMapping("/admin/origamis/deleteOrigami/{id}")
	public String deleteOrigami(@PathVariable(value = "id") long id) {
		
		// call delete origami method
		this.origamiService.deleteOrigamiById(id);
		return "redirect:/admin/origamis";
	}
}
