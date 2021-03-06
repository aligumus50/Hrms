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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "abilities")
public class Ability {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	//@Column(name = "curriculum_vitae_id")
	//private int curriculumVitaeId;
	
	@NotBlank
	@NotNull
	@Column(name = "programming_language_name")
	private String programmingLanguageName;
	
	@NotBlank
	@NotNull
	@Column(name = "created_date")
	private Date createdDate;
	
	@NotBlank
	@NotNull
	@ManyToOne()
	@JoinColumn(name="curriculum_vitae_id")
	private CurriculumVitae curriculumVitae;

}
