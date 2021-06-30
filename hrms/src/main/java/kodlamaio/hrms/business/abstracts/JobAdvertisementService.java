package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize);
	
	//DataResult<List<JobAdvertisement>> getAllSorted();
	
	Result add(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> getByJobDescription(String name);
	
	DataResult<List<JobAdvertisement>> getByEmployeer_Id(int employeerId);
	
	DataResult<List<JobAdvertisementDto>> getByStatus(Boolean status);
	
	//Aktif iş ilanları
	
	DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetailsByStatus(Boolean status);
	
	//DataResult<List<JobAdvertisement>> getByStatusOrderByCreatedDateAsc(Boolean status);
	
	DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetailsByStatusOrderDate(Boolean status);
	
	//DataResult<List<JobAdvertisement>> getByEmployeerIdAndStatus(int employeerId, Boolean status);
	
	DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetailsByStatusAndByEmployeer(int employeerId, Boolean status);
	
	Result updateStatusAndEmployeerId(int id, int employeerId,  Boolean status);
	
	Result updateStatusByEmployeer(int id, Boolean status);
	
 	DataResult<List<JobAdvertisement>> findJobAdvertisementByCityId(@Param("id") List<Integer> ids);
	
	
}
