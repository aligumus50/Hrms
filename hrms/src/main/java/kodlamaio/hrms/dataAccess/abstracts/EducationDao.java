package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer> {

	List<Education> getByCurriculumVitae_IdOrderByEndDateDesc(int curriculumvitaeId);

	// Bir educationı güncelleme
	//@Transactional
	//@Modifying
	//@Query("UPDATE Education e SET e.startingDate WHERE e.id = :educationId")
	//int updateStatusByEducationId(@Param(value="educationId") int educationId);
}
