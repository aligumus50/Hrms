package kodlamaio.hrms.core.validation.abstracts;

import org.springframework.web.bind.MethodArgumentNotValidException;

import kodlamaio.hrms.core.utilities.results.ErrorDataResult;

public interface HandleValidationExceptionService {

	ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions);
}
