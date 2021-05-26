package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employeer;

public interface EmployeerDao extends JpaRepository<Employeer, Integer>{

	Employeer findByEmailAddressEquals(String emailAddress);

}
