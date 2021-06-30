package kodlamaio.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeService {

	DataResult<List<CurriculumVitae>> getAll();
	
	Result add(CurriculumVitae curriculumVitae);
	
	DataResult<CurriculumVitae> imageUpload(int curriculumVitaeId, MultipartFile multipartFile) throws IOException;
	
	
	DataResult<List<CurriculumVitae>> getByCandidateId(int candidateId);
	
	DataResult<CurriculumVitae> getById(int curriculumVitaeId);
}
