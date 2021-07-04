package kodlamaio.hrms.api.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/getById")
	public DataResult<Employeer> getById(@RequestParam int employeerId) {
		
		return this.employeerService.getById(employeerId);
	}
	
	@PostMapping("/updateById")
	public Result updateEmployeerById(int employeerId, String companyName, String emailAddress, String webSiteAddress,
			String telNumber, String password_) {
		
		return this.employeerService.updateEmployeerById(employeerId, companyName, emailAddress, webSiteAddress, telNumber, password_);
		
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Employeer employeer) {
		
		return this.employeerService.update(employeer);
	}
	
	@PostMapping("/confirmUpdate")
	public Result confirmUpdate(@RequestParam int employeerId) {
		
		return this.employeerService.confirmUpdate(employeerId);
	}
}
