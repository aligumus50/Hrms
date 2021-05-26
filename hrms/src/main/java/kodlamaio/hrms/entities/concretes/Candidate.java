package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name="candidate")
@PrimaryKeyJoinColumn(name="user_id")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candidate extends User {
	
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "nationality_identity")
	private String nationalityIdentity;
	
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	@Column(name = "is_mernis_verified")
	private boolean isMernisVerified;
	
}
