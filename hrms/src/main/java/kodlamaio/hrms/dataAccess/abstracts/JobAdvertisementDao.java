package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	//Tablodaki ilgili alana göre where koşulu.
	List<JobAdvertisement> getByJobDescription(String name);
	
	//Aktif iş ilanlarını listeleme
	List<JobAdvertisement> getByStatus(Boolean status);
	
	//Aktif iş ilanlarını tarihe göre listeleme
	List<JobAdvertisement> getByStatusOrderByCreatedDateAsc(Boolean status);
	
	//Bir firmaya ait aktif iş ilanlarını listeleme
	List<JobAdvertisement> getByEmployeerIdAndStatus(int employeerId, Boolean status);
	
	//Bir firmanın ilanını pasife alma durumu.
	@Transactional
	@Modifying
	@Query("UPDATE JobAdvertisement j SET j.status = false WHERE j.id =?1 AND j.employeer.id=?2")
	int updateStatusAndEmployeerId(int id, int employeerId);


	
	
	
	
}
