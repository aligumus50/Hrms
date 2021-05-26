package kodlamaio.hrms.core.adapter.concretes;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapter.abstracts.EmailSendService;

@Service
@Qualifier("emailService")
public class EmailSendManager implements EmailSendService{


	@Override
	public void sendEmail(String emailAddress) {
		
	
			
			System.out.println(emailAddress + " email adressine aktivasyon kodu gönderildi.");
	
		

		
	}
	
	

}
