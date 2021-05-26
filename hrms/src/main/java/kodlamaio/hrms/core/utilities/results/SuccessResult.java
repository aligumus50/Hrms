package kodlamaio.hrms.core.utilities.results;

//Result ın başarılı olma durumu

public class SuccessResult extends Result {

	public SuccessResult() {

		super(true);
	}

	public SuccessResult(String message) {

		super(true, message);
	}

}
