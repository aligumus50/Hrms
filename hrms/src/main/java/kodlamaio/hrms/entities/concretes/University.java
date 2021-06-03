package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "university")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educations"})
//sorguyu loop a çevrimemesi için.
public class University {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "university_name")
	private String universityName;
	
	
	// Education tablomuz university tablosu ile ilişkili.
	@JsonIgnore
    @OneToMany(mappedBy = "university") //university field ismi
	private List<Education> educations;

}
