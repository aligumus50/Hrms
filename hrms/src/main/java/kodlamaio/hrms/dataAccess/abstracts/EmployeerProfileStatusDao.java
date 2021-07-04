package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.entities.concretes.EmployeerProfileStatus;

public interface EmployeerProfileStatusDao extends JpaRepository<EmployeerProfileStatus, Integer> {

	EmployeerProfileStatus getById(int employeerProfileStatusId);
	
	EmployeerProfileStatus getTopByEmployeer_IdOrderByIdDesc(int employeerId);
	
	List<EmployeerProfileStatus> getByStatus(Boolean status);

	// Bir personelin firma bilgilerini onaylama durumu
	@Transactional
	@Modifying
	@Query("UPDATE EmployeerProfileStatus e SET e.status = ?2, e.systemPersonnel.id=?3 WHERE e.id =?1")
	int updateEmployeerProfileStatusBySytemPersonnel(int id, Boolean status, int systemPersonnelId);
}
