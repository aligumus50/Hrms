package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertisementPublish;

public interface JobAdvertisementPublishDao extends JpaRepository<JobAdvertisementPublish, Integer>{

	List<JobAdvertisementPublish> getByIsPublish(Boolean isPublish);
	
}
