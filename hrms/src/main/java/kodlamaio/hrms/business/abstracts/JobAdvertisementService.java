package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();
	
	Result add(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> getByJobDescription(String name);
	
	DataResult<List<JobAdvertisement>> getByStatus(Boolean status);
	
	DataResult<List<JobAdvertisement>> getByStatusOrderByCreatedDateAsc(Boolean status);
	
	DataResult<List<JobAdvertisement>> getByEmployeerIdAndStatus(int employeerId, Boolean status);
	
	Result updateStatusAndEmployeerId(int id, int employeerId);
}
