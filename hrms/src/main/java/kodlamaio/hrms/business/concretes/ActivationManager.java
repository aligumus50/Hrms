package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ActivationDao;
import kodlamaio.hrms.entities.concretes.Activation;

@Service
public class ActivationManager implements ActivationService {

	ActivationDao activationDao;

	@Autowired
	public ActivationManager(ActivationDao activationDao) {
		super();
		this.activationDao = activationDao;
	}

	@Override
	public Result add(Activation activation) {

		this.activationDao.save(activation);
		return new SuccessResult("Aktivasyon kodu oluşturuldu.");
	}

}
