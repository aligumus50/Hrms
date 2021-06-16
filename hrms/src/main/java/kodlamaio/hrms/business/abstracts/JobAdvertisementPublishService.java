package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisementPublish;

public interface JobAdvertisementPublishService {

	DataResult<List<JobAdvertisementPublish>> getAll();
	
	Result add(JobAdvertisementPublish jobAdvertisementPublish);
	
	DataResult<List<JobAdvertisementPublish>> getByIsPublish(Boolean isPublish);
}
