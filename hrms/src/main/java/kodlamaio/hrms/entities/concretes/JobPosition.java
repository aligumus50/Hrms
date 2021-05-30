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

@Entity
@Table(name = "job_position")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
//sorguyu loop a çevrimemesi için.
//Döngüye girmemek için. Her ürünün kategorisi her kategoriye ürün atıyor döngüye giriyor.
public class JobPosition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "position_number")
	private String positionNumber;

	@Column(name = "position_name")
	private String positionName;

	// jobAdversiments tablomuz jobposition tablosu ile ilişkili.
	@OneToMany(mappedBy = "jobPosition") //jobPosition field ismi
	private List<JobAdvertisement> jobAdvertisements;
}