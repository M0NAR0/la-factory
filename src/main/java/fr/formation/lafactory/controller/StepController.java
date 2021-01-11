package fr.formation.lafactory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.formation.lafactory.model.Step;
import fr.formation.lafactory.service.IOrigamiService;
import fr.formation.lafactory.service.IStepService;

@Controller
public class StepController {
	
	@Autowired
	private IStepService stepService;
	
	@Autowired
	private IOrigamiService origamiService;

	@GetMapping("/admin/steps")
	public String viewListSteps(Model model) {
		model.addAttribute("listSteps", stepService.getAllSteps());
		return "admin/steps/list";
	}
	
	@GetMapping("/admin/steps/showNewStepForm")
	public String showNewStepForm(Model model) {
		// create model attribute to bind form data
		Step step = new Step();
		model.addAttribute("step", step);
		model.addAttribute("listOrigamis", origamiService.getAllOrigamis());
		return "admin/steps/new_step";
	}
	
	@PostMapping("/admin/steps/saveStep")
	public String saveStep(@ModelAttribute("step") Step step) {
		// save step to database
		stepService.saveStep(step);
		return "redirect:/";
	}
	
	@GetMapping("/admin/steps/showFormForStepUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		
		// get step from the service
		Step step = stepService.getStepById(id);
		
		// set step as a model attribute to pre-populate the form
		model.addAttribute("step", step);
		model.addAttribute("listOrigamis", origamiService.getAllOrigamis());
		return "admin/steps/update_step";
	}
	
	@GetMapping("/admin/steps/deleteStep/{id}")
	public String deleteStep(@PathVariable(value = "id") long id) {
		
		// call delete step method
		this.stepService.deleteStepById(id);
		return "redirect:/";
	}
}
