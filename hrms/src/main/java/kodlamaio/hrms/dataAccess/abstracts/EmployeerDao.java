package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.entities.concretes.Employeer;

public interface EmployeerDao extends JpaRepository<Employeer, Integer> {

	Employeer findByEmailAddressEquals(String emailAddress);

	Employeer getById(int employeerId);

	@Transactional
	@Modifying
	@Query("Update Employeer e Set e.companyName=?2, e.emailAddress=?3, e.webSiteAddress=?4, e.telNumber=?5, e.password_=?6 WHERE e.id =?1")
	int updateEmployeerById(int employeerId, String companyName, String emailAddress, String webSiteAddress, String telNumber, String password_);

}
