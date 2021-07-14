package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeerProfileStatusService;
import kodlamaio.hrms.business.abstracts.EmployeerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeerProfileStatusDao;
import kodlamaio.hrms.entities.concretes.EmployeerProfileStatus;

@Service
public class EmployeerProfileStatusManager implements EmployeerProfileStatusService{

	EmployeerProfileStatusDao employeerProfileStatusDao;
	EmployeerService employeerService;
	
	@Autowired
	public EmployeerProfileStatusManager(EmployeerProfileStatusDao employeerProfileStatusDao,@Lazy EmployeerService employeerService) {
		super();
		this.employeerProfileStatusDao = employeerProfileStatusDao;
		this.employeerService = employeerService;
	}

	@Override
	public Result add(EmployeerProfileStatus employeerProfileStatus) {
		
		this.employeerProfileStatusDao.save(employeerProfileStatus);
		return new SuccessResult("profil güncellemesi eklendi.");
		
	}
	
	

	@Override
	public DataResult<List<EmployeerProfileStatus>> getAll() {
		
		return new SuccessDataResult<List<EmployeerProfileStatus>>(this.employeerProfileStatusDao.findAll(), "tüm bilgiler listelendi.");
	}

	@Override
	public DataResult<EmployeerProfileStatus> getById(int employeerProfileStatusId) {
		
		return new SuccessDataResult<EmployeerProfileStatus>(employeerProfileStatusDao.getById(employeerProfileStatusId),"ilgili id listelendi");
	}


	@Override
	public Result updateEmployeerProfileStatusBySytemPersonnel(int id, Boolean status, int systemPersonnelId) {
		
		this.employeerProfileStatusDao.updateEmployeerProfileStatusBySytemPersonnel(id, status, systemPersonnelId);
		return new SuccessResult("Onaylama işlemi gerçekleşti.");
	}

	@Override
	public DataResult<EmployeerProfileStatus> getTopByEmployeer_IdOrderByIdDesc(int employeerId) {
		
		return new SuccessDataResult<EmployeerProfileStatus>(this.employeerProfileStatusDao.getTopByEmployeer_IdOrderByIdDesc(employeerId), "son employeer bilgisi.");
	}

	@Override
	public DataResult<List<EmployeerProfileStatus>> getByStatus(Boolean status) {
		
		return new SuccessDataResult<List<EmployeerProfileStatus>>(this.employeerProfileStatusDao.getByStatus(status), "Status a göre listelendi.");
	}

	

}
