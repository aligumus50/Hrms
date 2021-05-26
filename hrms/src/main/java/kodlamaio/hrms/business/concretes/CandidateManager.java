package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CandidateUserCheckService;
import kodlamaio.hrms.core.adapter.abstracts.EmailCheckService;
import kodlamaio.hrms.core.adapter.abstracts.EmailSendService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private CandidateUserCheckService candidateUserCheckService;
	private EmailCheckService emailCheckService;
	private EmailSendService emailSendService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, 
			@Qualifier("fakeValidation") CandidateUserCheckService candidateUserCheckService,
			EmailCheckService emailCheckService,
			@Qualifier("emailService") EmailSendService emailSendService) {
		super();
		this.candidateDao = candidateDao;
		this.candidateUserCheckService = candidateUserCheckService;
		this.emailCheckService=emailCheckService;
		this.emailSendService=emailSendService;
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

		else if (this.candidateDao.findByNationalityIdentityEquals(candidate.getNationalityIdentity()) != null) {

			return new ErrorDataResult<>("TC Kimlik Numarası Zaten Var");
		}

		else if (this.candidateDao.findByEmailAddressEquals(candidate.getEmailAddress()) != null) {

			return new ErrorDataResult<>("Mail Adresi Zaten Var");
		}
		
		else if (this.candidateUserCheckService.checkIfRealPerson(candidate)==false) {

			return new ErrorResult("TC Kimlik Numarası Doğrulanamadı"); }

		else if (this.candidateDao.findByNationalityIdentityEquals(candidate.
				getNationalityIdentity()) != null) {
				 
				return new ErrorDataResult<>("TC Kimlik Numarası Zaten Var"); }

				else if
				 (this.candidateDao.findByEmailAddressEquals(candidate.getEmailAddress()) !=
				 null) {

				return new ErrorDataResult<>("Mail Adresi Zaten Var"); }
		
				else if(checkCandidateEmailAddress(candidate)==false) {
					
					return new ErrorResult("Email Adresinizi Kontro Ediniz.");
				} 
		else {
			this.candidateDao.save(candidate);
			this.emailSendService.sendEmail(candidate.getEmailAddress());
			return new SuccessResult("İş arayan kişisi eklendi. Mail Gelen Kutunuzu Kontrol Edin");
			


		}
 
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
		
		if(this.emailCheckService.checkIfRealEmailAddress(candidate.getEmailAddress())!=false) {
			
			return true;
		}
		return false;
	}
	
	

}
