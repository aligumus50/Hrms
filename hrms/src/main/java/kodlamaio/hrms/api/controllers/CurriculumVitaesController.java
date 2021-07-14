package kodlamaio.hrms.api.controllers;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;

@CrossOrigin
@RestController
@RequestMapping("api/curriculumvitaes")
public class CurriculumVitaesController {

	CurriculumVitaeService curriculumVitaeService;
	
	@Autowired
	public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
		super();
		this.curriculumVitaeService = curriculumVitaeService;
	}

	@GetMapping("/getall")
	public DataResult<List<CurriculumVitae>> getAll() {
		
		return this.curriculumVitaeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CurriculumVitae curriculumVitae) {
		
		return this.curriculumVitaeService.add(curriculumVitae);
	}
	
	@PostMapping("imageUpload")
	public ResponseEntity<?> imageUpload(@RequestParam int curriculumVitaeId, @RequestParam MultipartFile multipartFile) throws IOException {
		
		return new ResponseEntity<>(this.curriculumVitaeService.imageUpload(curriculumVitaeId, multipartFile),HttpStatus.OK);
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<List<CurriculumVitae>> getByCandidateId(int candidateId) {
		
		return this.curriculumVitaeService.getByCandidateId(candidateId);
	}
	
	@GetMapping("/getById")
	public DataResult<CurriculumVitae> getById(int curriculumVitaeId) {
		
		return this.curriculumVitaeService.getById(curriculumVitaeId);
	}
}
