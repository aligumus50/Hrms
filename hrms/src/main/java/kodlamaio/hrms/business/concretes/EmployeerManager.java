package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeerService;
import kodlamaio.hrms.core.adapter.abstracts.EmailCheckService;
import kodlamaio.hrms.core.adapter.abstracts.EmailSendService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeerDao;
import kodlamaio.hrms.entities.concretes.Employeer;


@Service
public class EmployeerManager implements EmployeerService {

	private EmployeerDao employeerDao;
	private EmailCheckService emailCheckService;
	private EmailSendService emailSendService;

	@Autowired
	public EmployeerManager(EmployeerDao employeerDao, EmailCheckService emailCheckService,
			@Qualifier("emailService") EmailSendService emailSendService) {
		super();
		this.employeerDao = employeerDao;
		this.emailCheckService = emailCheckService;
	}

	@Override
	public DataResult<List<Employeer>> getAll() {

		return new SuccessDataResult<List<Employeer>>(this.employeerDao.findAll(), "İş Verenler Listelendi.");
	}

	@Override
	public Result add(Employeer employeer) {
		if (!checkAllFieldsControl(employeer)) {

			return new ErrorResult("Tüm Alanlar Zorunludur.");

		}

		else if (this.employeerDao.findByEmailAddressEquals(employeer.getEmailAddress()) != null) {

			return new ErrorDataResult<>("Mail Adresi Zaten Var");
		}

		else if (checkEmployeerEmailAddress(employeer) == false) {

			return new ErrorResult("Email Adresinizi Kontro Ediniz.");
		}

		else {
			this.employeerDao.save(employeer);
			this.emailSendService.sendEmail(employeer.getEmailAddress());
			return new SuccessResult("İş Veren Şirketi Eklendi. Mail Gelen Kutunuzu Kontrol Edin.");
		}

	}

	private boolean checkAllFieldsControl(Employeer employeer) {

		if (employeer.getCompanyName().isEmpty()

				&& employeer.getWebSiteAddress().isEmpty()

				&& employeer.getTelNumber().isEmpty()

				&& employeer.getEmailAddress().isEmpty()

				&& employeer.getPassword_().isEmpty()

		) {

			return false;
		}
		return true;
	}

	private boolean checkEmployeerEmailAddress(Employeer employeer) {

		if (this.emailCheckService.checkIfRealEmailAddress(employeer.getEmailAddress()) != false) {

			return true;
		}
		return false;
	}

	

}
