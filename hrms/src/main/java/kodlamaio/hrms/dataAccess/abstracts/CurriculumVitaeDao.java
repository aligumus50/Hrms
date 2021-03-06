package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae, Integer>{

	List<CurriculumVitae> getByCandidateId(int candidateId);
	
	CurriculumVitae getById(int curriculumVitaeId);
}
