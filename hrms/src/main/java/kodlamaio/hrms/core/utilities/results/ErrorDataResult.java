package kodlamaio.hrms.core.utilities.results;

//Datanın başarısız olma durumu
public class ErrorDataResult<T> extends DataResult<T> {

	public ErrorDataResult(T data, String message) {
		super(data, false, message);
		// base e gönderdik.

	}

	public ErrorDataResult(T data) {
		super(data, false);
		// base e gönderdik

	}

	// Alternatif mesaj göndermek istiyoruz gibi.
	public ErrorDataResult(String message) {
		super(null, false, message);
		// base e gönderdik.

	}

	public ErrorDataResult() {
		super(null, false);
		// base e gönderdik.

	}

}
