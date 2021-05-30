package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employeer")
@PrimaryKeyJoinColumn(name="user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
//sorguyu loop a çevrimemesi için.
//Döngüye girmemek için. Her ürünün kategorisi her kategoriye ürün atıyor döngüye giriyor.
public class Employeer extends User{

	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_site_address")
	private String webSiteAddress;
	
	@Column(name="tel_number")
	private String telNumber;
	
	@Column(name="is_system_verified")
	private boolean isSystemVerified;
	
	//jobAdversiments tablomuz employeer tablosu ile ilişkili.
	@OneToMany(mappedBy = "employeer") //employeer field ismi
	private List<JobAdvertisement> jobAdvertisements;


}
