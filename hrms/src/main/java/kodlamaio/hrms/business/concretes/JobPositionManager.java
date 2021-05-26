package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {

		// Success data result dönderiyoruz. Data ve message gönderdik.
		//return new SuccessDataResult<>(this.jobPositionDao.findAll(), "İş pozisyonları listelendi.");
		
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "İş pozisyonları listelendi.");

		// if()logic durumlar varsa ErrorDataResult dönderebiliriz.
	}

	@Override
	public Result add(JobPosition jobPosition) {

		if (this.jobPositionDao.findByPositionNameEquals(jobPosition.getPositionName()) != null) {

			return new ErrorDataResult<>("Kayıtlı Bir Pozisyonu Eklemeye Çalışıyorsunuz.");
		}

		else {

			return new SuccessDataResult<JobPosition>(this.jobPositionDao.save(jobPosition), "İş pozisyonu başarı ile eklendi.");
		}

	}

	@Override
	public DataResult<JobPosition> getByPositionName(String positionName) {
		// TODO Auto-generated method stub
		return null;
	}

}
