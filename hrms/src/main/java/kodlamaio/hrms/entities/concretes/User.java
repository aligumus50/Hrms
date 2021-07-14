package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank
	@NotNull
	@Email(message = "geçersiz e-posta adresi girişi")
	@Column(name = "email_address")
	private String emailAddress;
	
	
	@NotBlank
	@NotNull
	//@Range(min = 6, max = 12, message = "Şifreniz en az 6 en fazla 12 karakterden oluşabilir.")
	@Column(name = "password_")
	private String password_;
	
	//@NotBlank
	//@NotNull	
	@Column(name = "is_verified")
	private boolean isVerified;
	
	//@NotBlank
	//@NotNull
	@Column(name = "created_date")
	private Date createdDate;
	

}
