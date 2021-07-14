package kodlamaio.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CandidateUserCheckService;
import kodlamaio.hrms.core.adapter.abstracts.EmailCheckService;
import kodlamaio.hrms.core.adapter.abstracts.EmailSendService;
import kodlamaio.hrms.core.adapter.abstracts.GenerateCodeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Activation;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private CandidateUserCheckService candidateUserCheckService;
	private EmailCheckService emailCheckService;
	private EmailSendService emailSendService;
	private GenerateCodeService generateCodeService;
	private ActivationService activationService;
	
	private String code;

	@Autowired
	public CandidateManager(CandidateDao candidateDao,
			@Qualifier("mernisValidation") CandidateUserCheckService candidateUserCheckService,
			EmailCheckService emailCheckService, @Qualifier("emailService") EmailSendService emailSendService,
			GenerateCodeService generateCodeService, ActivationService activationService) {
		super();
		this.candidateDao = candidateDao;
		this.candidateUserCheckService = candidateUserCheckService;
		this.emailCheckService = emailCheckService;
		this.emailSendService = emailSendService;
		this.generateCodeService=generateCodeService;
		this.activationService = activationService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {

		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "İş arayanlar listelendi.");
	}

	@Override
	public Result add(Candidate candidate) {

		if (!checkAllFieldsControl(candidate)) {

			return new ErrorResult("Tüm Alanlar Zorunludur.");

		}

		else if (this.candidateUserCheckService.checkIfRealPerson(candidate) == false) {

			return new ErrorResult("TC Kimlik Numarası Doğrulanamadı");
		}

		else if (this.candidateDao.findByNationalityIdentityEquals(candidate.getNationalityIdentity()) != null) {

			return new ErrorDataResult<>("TC Kimlik Numarası Zaten Var");
		}

		else if (this.candidateDao.findByEmailAddressEquals(candidate.getEmailAddress()) != null) {

			return new ErrorDataResult<>("Mail Adresi Zaten Var");
		}

		else if (checkCandidateEmailAddress(candidate) == false) {

			return new ErrorResult("Email Adresinizi Kontro Ediniz.");
		}

		else {

			/*String code = this.generateCodeService.GenerateCode();
			String text = "doğrulama kodunuz: " +code;
			this.emailSendService.sendEmail(candidate.getEmailAddress().toString(), "kodlamaio.hrms doğrulama kodu",
					text);*/
		
			//System.out.println("kod: " + code);

			//System.out.println("kod giriniz:");
			//Scanner readCode = new Scanner(System.in);
			//String recievedCode = readCode.next();
			//System.out.println("okunan değer: " + recievedCode);
			//if (/*code.equals(recievedCode)*/) {

				
				//System.out.println("Kod doğrulama başarılı kaydınız tamamlanmıştır.");
				//this.candidateDao.save(candidate);
				//Activation activation = new Activation();
				//activation.setUser(candidate);
				//activation.setActivation_Code(code);
				//activation.setCreated_Date_Activation(new Date());
				
				//activationService.add(activation);
				
				
				
			}

			//else {

			//	System.out.println("yanlış kod girdiniz");
			//}

			/*
			 * this.candidateDao.save(candidate);
			 * this.emailSendService.sendEmail(candidate.getEmailAddress().toString(),
			 * "kodlamaio.hrms doğrulama kodu",
			 * "sisteme kaydınızın gerçekleşebilmesi için doğrulama kodunuz: Z3YN3B");
			 */

			return new SuccessResult("İş arayan kişisi doğrulamayı geçti. Mail Gelen Kutunuzu Kontrol Edin");

		//}

	}

	private boolean checkAllFieldsControl(Candidate candidate) {

		if (candidate.getFirstName().isEmpty() && candidate.getLastName().isEmpty()
				&& candidate.getNationalityIdentity().isEmpty() && candidate.getDateOfBirth() == null
				&& candidate.getEmailAddress().isEmpty() && candidate.getPassword_().isEmpty()) {

			return false;
		}
		return true;
	}

	private boolean checkCandidateEmailAddress(Candidate candidate) {

		if (this.emailCheckService.checkIfRealEmailAddress(candidate.getEmailAddress()) != false) {

			return true;
		}
		return false;
	}

	@Override
	public Result sendMailToCandidate(String email) {
		
		code = this.generateCodeService.GenerateCode();
		String text = "doğrulama kodunuz: " +code;
		this.emailSendService.sendEmail(email, "kodlamaio.hrms doğrulama kodu",
				text);
		//System.out.println(code);
		return new SuccessResult("mail gönderildi.");
	}

	@Override
	public Result save(Candidate candidate, String code) {
		
		if(this.code.equals(code)) {
			
			this.candidateDao.save(candidate);
			Activation activation = new Activation();
			activation.setUser(candidate);
			activation.setActivation_Code(code);
			activation.setCreated_Date_Activation(new Date());
			
			activationService.add(activation);
		return new SuccessResult("İş arayan kişisi eklendi");
		}
		
		else {
			
			return new SuccessResult("Doğrulama Kodunuz yanlış girdiniz.");
		}
		
	}

}
