package kodlamaio.hrms.entities.concretes;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employeer")
@PrimaryKeyJoinColumn(name="user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
//sorguyu loop a çevrimemesi için.
//Döngüye girmemek için. Her ürünün kategorisi her kategoriye ürün atıyor döngüye giriyor.
@ToString(exclude="jobAdvertisements") //iş ilanı olanlara update eklenmiyordu böyle bir çözüm buldum.
@TypeDef(name = "json", typeClass = JsonBinaryType.class)
public class Employeer extends User{

	@NotBlank
	@NotNull
	@Pattern(regexp = "[a-zA-Z0-9]")
	@Column(name="company_name")
	private String companyName;
	
	@NotBlank
	@NotNull
	@Pattern(regexp = "/^((ftp|http|https):\\/\\/)?(www.)?(?!.*(ftp|http|https|www.))[a-zA-Z0-9_-]+(\\.[a-zA-Z]+)+((\\/)[\\w#]+)*(\\/\\w+\\?[a-zA-Z0-9_]+=\\w+(&[a-zA-Z0-9_]+=\\w+)*)?$/gm")
	@Column(name="web_site_address")
	private String webSiteAddress;
	
	@NotBlank
	@NotNull
	@Length(min=10, max = 10)
	@Pattern(regexp="(^$|[0-9]{10})")
	@Column(name="tel_number")
	private String telNumber;
	
	@NotBlank
	@NotNull
	@Column(name="is_system_verified")
	private boolean isSystemVerified;
	
	
	@Type(type="json")
	@Column(name="update_profile")
	private Map<String, Object> updateProfile;
	

	//jobAdversiments tablomuz employeer tablosu ile ilişkili.
	@OneToMany(mappedBy = "employeer") //employeer field ismi
	private List<JobAdvertisement> jobAdvertisements;


}
