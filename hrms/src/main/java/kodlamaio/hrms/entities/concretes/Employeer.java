package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employeer")
@PrimaryKeyJoinColumn(name="user_id")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employeer extends User{

	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_site_address")
	private String webSiteAddress;
	
	@Column(name="tel_number")
	private String telNumber;
	
	@Column(name="is_system_verified")
	private boolean isSystemVerified;


}
