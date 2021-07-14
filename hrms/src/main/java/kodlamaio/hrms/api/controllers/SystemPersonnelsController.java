package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SystemPersonnelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.validation.abstracts.HandleValidationExceptionService;
import kodlamaio.hrms.entities.concretes.SystemPersonnel;

@CrossOrigin
@RestController
@RequestMapping("/api/systempersonnels")
public class SystemPersonnelsController {

	private SystemPersonnelService systemPersonnelService;
	private HandleValidationExceptionService handleValidationExceptionService;

	@Autowired
	public SystemPersonnelsController(SystemPersonnelService systemPersonnelService,
			HandleValidationExceptionService handleValidationExceptionService) {
		super();
		this.systemPersonnelService = systemPersonnelService;
		this.handleValidationExceptionService = handleValidationExceptionService;
	}

	@GetMapping("/getall")
	public DataResult<List<SystemPersonnel>> getAll() {

		return this.systemPersonnelService.getAll();
	}

	/*public Result add(SystemPersonnel systemPersonnel) {

		return this.systemPersonnelService.add(systemPersonnel);
	}*/
	
	@PostMapping("/add")
	// @valid doğrulanması gereken bir alan olduğunu belirtmek için.
	// validasyondan geçir demek.
	public ResponseEntity<?> add(@Valid @RequestBody SystemPersonnel systemPersonnel) {

		return ResponseEntity.ok(this.systemPersonnelService.add(systemPersonnel));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		
		
		return this.handleValidationExceptionService.handleValidationException(exceptions);
	}
	
	@GetMapping("/getById")
	public DataResult<SystemPersonnel> getById(int userId) {
		
		return this.systemPersonnelService.getById(userId);
	}
}
