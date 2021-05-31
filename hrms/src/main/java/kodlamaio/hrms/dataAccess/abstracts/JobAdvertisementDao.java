package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;


public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	//Tablodaki ilgili alana göre where koşulu.
	List<JobAdvertisement> getByJobDescription(String name);
	
	//Aktif iş ilanlarını listeleme
	
	//Metot ile kullanım
	List<JobAdvertisement> getByStatus(Boolean status); 
	
	//query ile kullanım
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto" + 
			"(e.companyName, jp.positionName, j.numberOfOpenPositions, j.createdDate, j.applicationLastDate)" +
			"From JobAdvertisement j Inner Join j.employeer e Inner Join j.jobPosition jp Where status=?1")
	List<JobAdvertisementDto> getJobAdvertisementDetailsByStatus(Boolean status);
	
	//Aktif iş ilanlarını tarihe göre listeleme
	//List<JobAdvertisement> getByStatusOrderByCreatedDateAsc(Boolean status);
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto" + 
			"(e.companyName, jp.positionName, j.numberOfOpenPositions, j.createdDate, j.applicationLastDate)" +
			"From JobAdvertisement j Inner Join j.employeer e Inner Join j.jobPosition jp Where status=?1 Order By j.createdDate ASC")
	List<JobAdvertisementDto> getJobAdvertisementDetailsByStatusOrderDate(Boolean status);
	
	//Bir firmaya ait aktif iş ilanlarını listeleme
	//List<JobAdvertisement> getByEmployeerIdAndStatus(int employeerId, Boolean status);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto" + 
			"(e.companyName, jp.positionName, j.numberOfOpenPositions, j.createdDate, j.applicationLastDate)" +
			"From JobAdvertisement j Inner Join j.employeer e Inner Join j.jobPosition jp Where j.employeer.id=?1 And status=?2")
	List<JobAdvertisementDto> getJobAdvertisementDetailsByStatusAndByEmployeer(int employeerId, Boolean status);
	
	//Bir firmanın ilanını pasife alma durumu.
	@Transactional
	@Modifying
	@Query("UPDATE JobAdvertisement j SET j.status = false WHERE j.id =?1 AND j.employeer.id=?2")
	int updateStatusAndEmployeerId(int id, int employeerId);
	

	
	
	


	
	
	
	
}
