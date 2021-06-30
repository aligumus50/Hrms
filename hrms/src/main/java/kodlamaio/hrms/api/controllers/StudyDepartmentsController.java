package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.StudyDepartmentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.StudyDepartment;

@CrossOrigin
@RestController
@RequestMapping("api/studydepartments")
public class StudyDepartmentsController {

	StudyDepartmentService studyDepartmentService;
	
	@Autowired
	public StudyDepartmentsController(StudyDepartmentService studyDepartmentService) {
		super();
		this.studyDepartmentService = studyDepartmentService;
	} 
	
	@GetMapping("/getall")
	public DataResult<List<StudyDepartment>> getall(){
		
		return this.studyDepartmentService.getall();
	}
}
