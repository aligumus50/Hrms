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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.validation.abstracts.HandleValidationExceptionService;
import kodlamaio.hrms.entities.concretes.Candidate;


@CrossOrigin
@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {

	private CandidateService candidateService;
	private HandleValidationExceptionService handleValidationExceptionService;

	@Autowired
	public CandidatesController(CandidateService candidateService,
			HandleValidationExceptionService handleValidationExceptionService) {
		super();
		this.candidateService = candidateService;
		this.handleValidationExceptionService = handleValidationExceptionService;
	}

	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll() {

		return this.candidateService.getAll();
	}

	/*
	 * @PostMapping("/add") public Result add(@RequestBody Candidate candidate) {
	 * return this.candidateService.add(candidate); }
	 */

	@PostMapping("/add")
	// @valid doğrulanması gereken bir alan olduğunu belirtmek için.
	// validasyondan geçir demek.
	public ResponseEntity<?> add(@Valid @RequestBody Candidate candidate) {

		return ResponseEntity.ok(this.candidateService.add(candidate));
	}
	
	@PostMapping("/sendemailtocandidate")
	public Result sendMailToCandidate(@RequestParam String email) {
		
		return this.candidateService.sendMailToCandidate(email);
	}
	
	@PostMapping("/save")
	public Result save(@RequestBody Candidate candidate, @RequestParam String code) {
		
		return this.candidateService.save(candidate,code);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		
		
		return this.handleValidationExceptionService.handleValidationException(exceptions);
	}

	/*
	 * //global exception handler //.class typeof demek tipini vermek için.
	 * 
	 * @ExceptionHandler(MethodArgumentNotValidException.class)
	 * 
	 * @ResponseStatus(HttpStatus.BAD_REQUEST) public ErrorDataResult<Object>
	 * handleValidationException(MethodArgumentNotValidException exceptions){
	 * //hangi alan, neyin kontrol edeceği Map<String, String> validationErros = new
	 * HashMap<String, String>(); for (FieldError fieldError :
	 * exceptions.getBindingResult().getFieldErrors()) {
	 * 
	 * validationErros.put(fieldError.getField(), fieldError.getDefaultMessage()); }
	 * 
	 * ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErros,
	 * "Doğrulama Hataları");
	 * 
	 * return errors; }
	 */
}
