package kodlamaio.hrms.core.adapter.concretes;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapter.abstracts.EmailSendService;

@Service
@Qualifier("fakeEmailService")
public class FakeEmailSendManager implements EmailSendService{

	
	@Override
	public String sendEmail(String emailAddress) {
			
			System.out.println(emailAddress + " email adressine aktivasyon kodu gönderildi.");
			
			return null;
		
	}

	@Override
	public void sendEmail(String to, String subject, String text) {
		// TODO Auto-generated method stub
		
	
	}

}
