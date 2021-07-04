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

import kodlamaio.hrms.business.abstracts.EmployeerProfileStatusService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployeerProfileStatus;

@CrossOrigin
@RestController
@RequestMapping("api/employeerProfileStatuses")
public class EmployeerProfileStatusesController {

	EmployeerProfileStatusService employeerProfileStatusService;

	@Autowired
	public EmployeerProfileStatusesController(EmployeerProfileStatusService employeerProfileStatusService) {
		super();
		this.employeerProfileStatusService = employeerProfileStatusService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EmployeerProfileStatus employeerProfileStatus) {
		
		return this.employeerProfileStatusService.add(employeerProfileStatus);
	}
	
	@GetMapping("/getall")
	public DataResult<List<EmployeerProfileStatus>> getAll() {
		
		return this.employeerProfileStatusService.getAll();
	}
	
	@PostMapping("/updateStatusBySytemPersonnel")
	public Result updateEmployeerProfileStatusBySytemPersonnel(@RequestParam int id,@RequestParam Boolean status,@RequestParam int systemPersonnelId) {
		
		return this.employeerProfileStatusService.updateEmployeerProfileStatusBySytemPersonnel(id, status, systemPersonnelId);
		
	}
	
	@GetMapping("/getTopByEmployeer_IdOrderByIdDesc")
	public DataResult<EmployeerProfileStatus> getTopByEmployeer_IdOrderByIdDesc(int employeerId) {
		
		return this.employeerProfileStatusService.getTopByEmployeer_IdOrderByIdDesc(employeerId);
	}
	
	@GetMapping("/getByStatus")
	public DataResult<List<EmployeerProfileStatus>> getByStatus(Boolean status) {
		
		return this.employeerProfileStatusService.getByStatus(status);
	}
	
	
	
}
