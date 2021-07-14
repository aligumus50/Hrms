package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementPublishService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisementPublish;

@CrossOrigin
@RestController
@RequestMapping("/api/jobadvertisementpublishes")
public class JobAdvertisementPublishesController {

	private JobAdvertisementPublishService jobAdvertisementPublishService;

	@Autowired
	public JobAdvertisementPublishesController(JobAdvertisementPublishService jobAdvertisementPublishService) {
		super();
		this.jobAdvertisementPublishService = jobAdvertisementPublishService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisementPublish>> getAll() {
		
		return this.jobAdvertisementPublishService.getAll();
	}
	
	@GetMapping("/getByIsPublish")
	public DataResult<List<JobAdvertisementPublish>> getByIsPublish(Boolean isPublish) {
		
		return this.jobAdvertisementPublishService.getByIsPublish(isPublish);
		
	}
	
	@PostMapping("/add")
	public Result add(JobAdvertisementPublish jobAdvertisementPublish) {
		
		return this.add(jobAdvertisementPublish);
	}
}
