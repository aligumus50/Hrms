package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ActivationService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Activation;

@CrossOrigin
@RestController
@RequestMapping("api/activations")
public class ActivationsController {

	
	ActivationService activationService;
	
	@Autowired
	public ActivationsController(ActivationService activationService) {
		super();
		this.activationService = activationService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Activation activation) {
		
		return this.activationService.add(activation);
	}
	
	
}
