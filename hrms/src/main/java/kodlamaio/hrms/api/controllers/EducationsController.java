package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Education;

@CrossOrigin
@RestController
@RequestMapping("api/educations")
public class EducationsController {

	private EducationService educationService;

	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Education>> getAll() {
		
		return this.educationService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Education education) {
		
		return this.educationService.add(education);
	}
	
	@GetMapping("/getByCurriculumVitae_IdOrderByEndDateDesc")
	public DataResult<List<Education>> getByCurriculumVitae_IdOrderByEndDateDesc(int curriculumvitaeId) {
	
		return this.educationService.getByCurriculumVitae_IdOrderByEndDateDesc(curriculumvitaeId);
	}
	
	
}
