package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "education")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","curriculumVitae"})
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	//@Column(name = "curriculum_vitae_id")
	//private int curriculumVitaeId;
	
	//@Column(name = "university_id")
	//private int universityId;
	
	//@Column(name = "school_id")
	//private int schoolId;
	
	//@Column(name = "study_department_id")
	//private int studyDepartmentId;
	
	@Column(name = "starting_Date")
	private Date startingDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@ManyToOne()
	@JoinColumn(name="curriculum_vitae_id")
	private CurriculumVitae curriculumVitae;
	
	@ManyToOne()
	@JoinColumn(name="university_id")
	private University university;
	
	@ManyToOne()
	@JoinColumn(name="study_department_id")
	private StudyDepartment studyDepartment;
	
	@ManyToOne()
	@JoinColumn(name="school_id")
	private School school;

}
