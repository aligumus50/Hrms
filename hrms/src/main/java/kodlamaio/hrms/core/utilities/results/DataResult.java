package kodlamaio.hrms.core.utilities.results;

//Burada bir de data göndermemiz gerek.
//Success ve message dışında bir de data göndermek için T generic yapı kullandık.

public class DataResult<T> extends Result {

	private T data;

	public DataResult(T data, boolean success) {

		// base sınıfında set edildiği için ayrıca set etme yapılmıyor.
		// Base'in Constructorını çalıştırır.
		// Success ve mesaj bilgisini base e göndermiş oluyoruz.
		super(success);
		this.data = data;

	}

	public DataResult(T data, boolean success, String message) {
		super(success, message);
		this.data = data;

	}

	public T getData() {

		return this.data;
	}

}
