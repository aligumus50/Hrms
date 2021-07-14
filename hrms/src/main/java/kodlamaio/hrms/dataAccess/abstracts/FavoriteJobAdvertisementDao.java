package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.entities.concretes.FavoriteJobAdvertisement;

public interface FavoriteJobAdvertisementDao extends JpaRepository<FavoriteJobAdvertisement, Integer> {

	@Transactional
	@Modifying
	@Query("Delete From FavoriteJobAdvertisement f WHERE f.jobAdvertisement.id =?1 AND f.candidate.id=?2")
	int deleteFavoriteJobAdvertisement(int jobAdvertisementId, int candidateId);
}
