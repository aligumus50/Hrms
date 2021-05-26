package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Activation;

public interface ActivationDao extends JpaRepository<Activation, Integer>{

}
