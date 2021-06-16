package kodlamaio.hrms.core.validation.concretes;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.validation.abstracts.HandleValidationExceptionService;

@Service
public class HandleValidationExceptionManager implements HandleValidationExceptionService{

	
	@Override
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		
		//hangi alan, neyin kontrol edeceği
				Map<String, String> validationErros = new HashMap<String, String>();
				for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
					
					validationErros.put(fieldError.getField(), fieldError.getDefaultMessage());
				}
				
				ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErros, "Doğrulama Hataları");
				
				return errors;
	}

}
