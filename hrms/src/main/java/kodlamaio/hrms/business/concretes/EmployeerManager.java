package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import kodlamaio.hrms.business.abstracts.EmployeerProfileStatusService;
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
import kodlamaio.hrms.entities.concretes.EmployeerProfileStatus;

@Service
public class EmployeerManager implements EmployeerService {

	private EmployeerDao employeerDao;
	private EmailCheckService emailCheckService;
	private EmailSendService emailSendService;
	private EmployeerProfileStatusService employeerProfileStatusService;
	ObjectMapper objectMapper;

	@Autowired
	public EmployeerManager(EmployeerDao employeerDao, EmailCheckService emailCheckService,
			@Qualifier("emailService") EmailSendService emailSendService, ObjectMapper objectMapper,
			EmployeerProfileStatusService employeerProfileStatusService) {
		super();
		this.employeerDao = employeerDao;
		this.emailCheckService = emailCheckService;
		this.emailSendService = emailSendService;
		this.objectMapper = objectMapper;
		this.employeerProfileStatusService = employeerProfileStatusService;
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
			// this.emailSendService.sendEmail(employeer.getEmailAddress());
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

	@Override
	public DataResult<Employeer> getById(int employeerId) {

		return new SuccessDataResult<Employeer>(this.employeerDao.getById(employeerId), "İş veren listelendi.");
	}

	@Override
	public Result updateEmployeerById(int employeerId, String companyName, String emailAddress, String webSiteAddress,
			String telNumber, String password_) {

		this.employeerDao.updateEmployeerById(employeerId, companyName, emailAddress, webSiteAddress, telNumber,
				password_);
		return new SuccessResult("İş veren bilgileri güncellendi");
	}

	@Override
	public Result update(Employeer employeer) {

		// id ye sahip employeerin bilgilerini updateEmployeera atadık.
		Employeer updateEmployeerProfile = getById(employeer.getId()).getData();
		System.out.println("ilk bilgi:" + updateEmployeerProfile);
		System.out.println("employeer:" + employeer);

		// employeer nesnesini jsona çevirdik.
		Map<String, Object> updateProfile = objectMapper.convertValue(employeer, Map.class);

		System.out.println("ikinci bilgi" + updateProfile);

		// Employeerdan türetilen updaateEmpProfile ilgili json set ettik.
		updateEmployeerProfile.setUpdateProfile(updateProfile);

		this.employeerDao.save(updateEmployeerProfile);

		EmployeerProfileStatus employeerProfileStatus = new EmployeerProfileStatus(0, false, new Date(),
				updateEmployeerProfile, null);

		employeerProfileStatusService.add(employeerProfileStatus);

		return new SuccessDataResult<>("Güncel bilgiler onaya gönderildi.");
	}

	@Override
	public Result confirmUpdate(int employeerId) {

		Employeer previousEmployeerInfo = getById(employeerId).getData();

		Employeer newEmployeerInfo = objectMapper.convertValue(previousEmployeerInfo.getUpdateProfile(),Employeer.class);

		employeerDao.save(newEmployeerInfo);
		
		return new SuccessResult("Güncelleme İşlemi Onaylanmıştır.");
	}

}
