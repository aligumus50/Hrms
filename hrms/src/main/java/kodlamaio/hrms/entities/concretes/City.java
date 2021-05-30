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
@Table(name = "cities")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
//sorguyu loop a çevrimemesi için.
//Döngüye girmemek için. Her ürünün kategorisi her kategoriye ürün atıyor döngüye giriyor.
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "cityName")
	private String cityName; // name

	// jobAdversiments tablomuz cities tablosu ile ilişkili.
	@OneToMany(mappedBy = "city") //city field ismi
	private List<JobAdvertisement> jobAdvertisements;

}
