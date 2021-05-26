package kodlamaio.hrms.core.utilities.results;

//Datanın başarılı olma durumu
public class SuccessDataResult<T> extends DataResult<T> {

	public SuccessDataResult(T data, String message) {
		super(data, true, message);
		// base e gönderdik.

	}

	public SuccessDataResult(T data) {
		super(data, true);
		// base e gönderdik.

	}

	// Alternatif mesaj göndermek istiyoruz gibi.
	public SuccessDataResult(String message) {
		super(null, true, message);
		// base e gönderdik.

	}

	public SuccessDataResult() {
		super(null, true);
		// base e gönderdik.

	}

}
