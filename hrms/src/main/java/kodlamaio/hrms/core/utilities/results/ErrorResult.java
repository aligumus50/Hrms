package kodlamaio.hrms.core.utilities.results;

//Result ın başarısız olma durumu

public class ErrorResult extends Result {

	public ErrorResult() {

		super(false);
	}

	public ErrorResult(String message) {

		super(false, message);
	}

}