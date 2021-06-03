package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.StudyDepartment;

public interface StudyDepartmentDao extends JpaRepository<StudyDepartment, Integer>{

}
