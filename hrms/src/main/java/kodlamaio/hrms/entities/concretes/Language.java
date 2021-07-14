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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "language")
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	//@Column(name = "curriculum_vitae_id")
	//private int curriculumVitaeId;
	
	//@Column(name = "foreign_language_id")
	//private int foreignLanguageId;
	
	@Column(name = "language_level")
	private String languageLevel;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@ManyToOne()
	@JoinColumn(name="curriculum_vitae_id")
	private CurriculumVitae curriculumVitae;
	
	@ManyToOne()
	@JoinColumn(name="foreign_language_id")
	private ForeignLanguage foreignLanguage;

}
