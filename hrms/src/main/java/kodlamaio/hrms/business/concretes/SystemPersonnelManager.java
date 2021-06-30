package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemPersonnelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemPersonnelDao;
import kodlamaio.hrms.entities.concretes.SystemPersonnel;

@Service
public class SystemPersonnelManager implements SystemPersonnelService {

	private SystemPersonnelDao systemPersonnelDao;

	public SystemPersonnelManager(SystemPersonnelDao systemPersonnelDao) {
		super();
		this.systemPersonnelDao = systemPersonnelDao;
	}

	@Override
	public DataResult<List<SystemPersonnel>> getAll() {

		return new SuccessDataResult<List<SystemPersonnel>>(this.systemPersonnelDao.findAll(),
				"Sistem personeli listelendi");
	}

	@Override
	public Result add(SystemPersonnel systemPersonnel) {

		if (this.systemPersonnelDao.findByEmailAddressEquals(systemPersonnel.getEmailAddress()) != null) {

			return new ErrorDataResult<>("Mail Adresi Zaten Var");
		}

		else {
			this.systemPersonnelDao.save(systemPersonnel);
			return new SuccessDataResult<>("Sistem Personeli Eklendi");
		}

	}

	@Override
	public DataResult<SystemPersonnel> getById(int userId) {
		
		return new SuccessDataResult<SystemPersonnel>(this.systemPersonnelDao.getById(userId), "Sistem personeli listelendi");
	}

}
