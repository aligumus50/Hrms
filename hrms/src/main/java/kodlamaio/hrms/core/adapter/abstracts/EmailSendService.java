package kodlamaio.hrms.core.adapter.abstracts;



public interface EmailSendService {

	void sendEmail( String to, String subject, String text);

	String sendEmail(String emailAddress);
}
