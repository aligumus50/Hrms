package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.City;

//city
public interface CityDao extends JpaRepository<City, Integer> {

}
