package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("api/jobadvertisements")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getByJobDescription")
	public DataResult<List<JobAdvertisement>> getByJobDescription(@RequestParam String name){
		
		return this.jobAdvertisementService.getByJobDescription(name);
	}
	
	@GetMapping("/getByStatus")
	public DataResult<List<JobAdvertisement>> getByStatus(Boolean status){
		return this.jobAdvertisementService.getByStatus(status);
	}
	
	@GetMapping("/getByStatusOrderByCreatedDateAsc")
	public DataResult<List<JobAdvertisement>> getByStatusOrderByCreatedDateAsc(Boolean status){
		return this.jobAdvertisementService.getByStatusOrderByCreatedDateAsc(status);
	}
	
	@GetMapping("/getByEmployeerIdAndStatus")
	public DataResult<List<JobAdvertisement>> getByEmployeerId(int employeerId, Boolean status){
		
		return this.jobAdvertisementService.getByEmployeerIdAndStatus(employeerId, status);
	}
	
	@PostMapping("updateStatusAndEmployeerId")
	public Result updateStatusAndEmployeerId(@RequestParam int id, @RequestParam int employeerId) {
		
		return this.jobAdvertisementService.updateStatusAndEmployeerId(id, employeerId);
	}
	
	
	
	
}


