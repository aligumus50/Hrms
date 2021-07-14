package kodlamaio.hrms.core.adapter.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapter.abstracts.EmailSendService;
import kodlamaio.hrms.core.adapter.abstracts.GenerateCodeService;

@Service
@Qualifier("emailService")
@Component
public class EmailSendManager implements EmailSendService{
	
	private JavaMailSender javaMailSender;
	private GenerateCodeService generateCodeService;
	

	@Autowired
	public EmailSendManager(JavaMailSender javaMailSender, GenerateCodeService generateCodeService) {
		super();
		this.javaMailSender = javaMailSender;
		this.generateCodeService = generateCodeService;
	}

	@Override
	public void sendEmail( String to, String subject, String text) {
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		simpleMailMessage.setFrom("kodlamaiohrms@gmail.com");
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(text);
		
		this.javaMailSender.send(simpleMailMessage);

		
	}

	@Override
	public String sendEmail(String emailAddress) {
		
		String code = this.generateCodeService.GenerateCode();
	
		return code;
	}
	
	

}
