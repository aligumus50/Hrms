package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobPositionService {

	// List<JobPosition> getAll();
	// İşlem başarılı mı başarısız mı bilmiyoruz.

	DataResult<List<JobPosition>> getAll();

	Result add(JobPosition jobPosition); // Ekleme işlemi resultın kendisini dönderiyoruz.

	DataResult<JobPosition> getByPositionName(String positionName);

}
