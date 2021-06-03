package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceDao;
import kodlamaio.hrms.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService {

	private ExperienceDao experienceDao;

	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	@Override
	public DataResult<List<Experience>> getAll() {
		
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll(), "İş tecrübeleri listelendi");
	}

	@Override
	public Result add(Experience experience) {
		
		this.experienceDao.save(experience);
		return new SuccessDataResult<>("İş deneyimi eklendi");
	}

	@Override
	public DataResult<List<Experience>> getByCurriculumVitae_IdOrderByEndDateDesc(int curriculumvitaeId) {
		
		return new SuccessDataResult<List<Experience>>(this.experienceDao.getByCurriculumVitae_IdOrderByEndDateDesc(curriculumvitaeId), "Deneyimler tarihe göre sıralandı.");
	}
}
