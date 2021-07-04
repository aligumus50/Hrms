package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployeerProfileStatus;

public interface EmployeerProfileStatusService {

	Result add(EmployeerProfileStatus employeerProfileStatus);
	
	DataResult<List<EmployeerProfileStatus>> getAll();
	
	DataResult<List<EmployeerProfileStatus>> getByStatus(Boolean status);
	
	Result updateEmployeerProfileStatusBySytemPersonnel(int id, Boolean status, int systemPersonnelId);
	
	DataResult<EmployeerProfileStatus> getById(int id);
	
	DataResult<EmployeerProfileStatus> getTopByEmployeer_IdOrderByIdDesc(int employeerId);
	
	
}
