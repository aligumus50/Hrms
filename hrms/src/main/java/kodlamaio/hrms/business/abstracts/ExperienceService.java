package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Experience;

public interface ExperienceService {

	DataResult<List<Experience>> getAll();
	
	Result add(Experience experience);
	
	DataResult<List<Experience>> getByCurriculumVitae_IdOrderByEndDateDesc(int curriculumvitaeId);
}
