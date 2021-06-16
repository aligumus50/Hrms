package kodlamaio.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "curriculum_vitae")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educations"})
public class CurriculumVitae {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	//@Column(name = "candidate_id")
	//private int candidateId;
	
	@Column(name = "explanation")
	private String explanation;
	
	@Column(name = "profile_photo_link")
	private String profilePhotoLink;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	
	@ManyToOne()
	@JoinColumn(name="candidate_id") //tablo ismi
	private Candidate candidate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "curriculumVitae")
	private List<Education> educations;
	
	@JsonIgnore
	@OneToMany(mappedBy = "curriculumVitae")
	private List<Experience> experiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "curriculumVitae")
	private List<Language> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "curriculumVitae") //field ismi
	private List<Ability> abilities;
	
	@JsonIgnore
	@OneToOne(mappedBy = "curriculumVitae")
	private Image image;
	

}
