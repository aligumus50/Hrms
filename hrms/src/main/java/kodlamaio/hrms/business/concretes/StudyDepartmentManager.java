package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.StudyDepartmentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.StudyDepartmentDao;
import kodlamaio.hrms.entities.concretes.StudyDepartment;

@Service
public class StudyDepartmentManager implements StudyDepartmentService {

	StudyDepartmentDao studyDepartmentDao;
	
	@Autowired
	public StudyDepartmentManager(StudyDepartmentDao studyDepartmentDao) {
		super();
		this.studyDepartmentDao = studyDepartmentDao;
	}
	@Override
	public DataResult<List<StudyDepartment>> getall() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<StudyDepartment>>(this.studyDepartmentDao.findAll(), "Bölümler listelendi");
	}

}
