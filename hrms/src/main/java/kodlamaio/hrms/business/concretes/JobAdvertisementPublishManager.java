package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementPublishService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementPublishDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisementPublish;

@Service
public class JobAdvertisementPublishManager implements JobAdvertisementPublishService {

	@Autowired
	private JobAdvertisementPublishDao jobAdvertisementPublishDao;
	
	public JobAdvertisementPublishManager(JobAdvertisementPublishDao jobAdvertisementPublishDao) {
		super();
		this.jobAdvertisementPublishDao = jobAdvertisementPublishDao;
	}

	@Override
	public DataResult<List<JobAdvertisementPublish>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisementPublish>>(this.jobAdvertisementPublishDao.findAll(), "tüm ilanlar listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisementPublish>> getByIsPublish(Boolean isPublish) {
	
		return new SuccessDataResult<List<JobAdvertisementPublish>>(this.jobAdvertisementPublishDao.getByIsPublish(isPublish) , "yayınlanan ilanlar listelendir.");
	}

	@Override
	public Result add(JobAdvertisementPublish jobAdvertisementPublish) {
		
		this.jobAdvertisementPublishDao.save(jobAdvertisementPublish);
		return new SuccessResult("Yayınlanan ilanlara eklendi.");
	}

}
