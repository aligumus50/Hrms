package kodlamaio.hrms.core.adapter.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapter.abstracts.EmailCheckService;
import kodlamaio.hrms.core.adapter.abstracts.EmailSendService;

@Service
@Qualifier("emailService")
@Component
public class EmailSendManager implements EmailSendService{
	
	private JavaMailSender javaMailSender;

	@Autowired
	public EmailSendManager(JavaMailSender javaMailSender) {
		super();
		this.javaMailSender = javaMailSender;
	}

	/*@Override
	public void sendEmail( String to, String subject, String text) {
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		simpleMailMessage.setFrom("kodlamaiohrms@gmail.com");
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(text);
		
		this.javaMailSender.send(simpleMailMessage);
		

		
	}*/

	@Override
	public void sendEmail(String emailAddress) {
		// TODO Auto-generated method stub
		
	}
	
	

}
