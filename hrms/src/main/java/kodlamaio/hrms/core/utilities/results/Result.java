package kodlamaio.hrms.core.utilities.results;

public class Result {

	private boolean success; // işlem başarılı mı?
	private String message; // işlem sonucunda mesaj göndermek istersek?

	public Result(boolean success) {

		this.success = success;
	}

	public Result(boolean success, String message) {

		// this.success = success; isSucccesde de set etme işlemi var.
		this(success); // Tek parametreli olanı çağırıp set ediyor.
		this.message = message;
	}

	public boolean isSuccess() {

		return this.success;
	}

	public String getMessage() {

		return this.message;
	}
}
