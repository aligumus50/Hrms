package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "work_type")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
//sorguyu loop a çevrimemesi için.
public class WorkType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "type_name")
	private String typeName;
	
	// jobAdversiments tablomuz worktype tablosu ile ilişkili.
	@OneToMany(mappedBy = "workType") //workType field ismi.
	private List<JobAdvertisement> jobAdvertisements;

}
