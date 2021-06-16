package kodlamaio.hrms.api.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployeerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employeer;

@CrossOrigin
@RestController
@RequestMapping("api/employeers")
public class EmployeersController {

	private EmployeerService employeerService;
	
	@Autowired
	public EmployeersController(EmployeerService employeerService) {
		super();
		this.employeerService = employeerService;
	}

	
	@GetMapping("/getall")
	public DataResult<List<Employeer>> getAll(){
		
		return this.employeerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Employeer employeer) {
		
		return this.employeerService.add(employeer);
	}
}
