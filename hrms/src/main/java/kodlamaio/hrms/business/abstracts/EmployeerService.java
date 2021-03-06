package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employeer;


public interface EmployeerService {

	DataResult<List<Employeer>> getAll();
	
	Result add(Employeer employeer);
	
	DataResult<Employeer> getById(int employeerId);
	
	Result updateEmployeerById(int employeerId, String companyName, String emailAddress, String webSiteAddress, String telNumber, String password_);
	
	//update işlemi jsona yazma
	Result update(Employeer employeer);
	
	//update gerçekleştirme onay sonrası
	Result confirmUpdate(int employeerId);
	
	
	
	
	
	 
	
}
