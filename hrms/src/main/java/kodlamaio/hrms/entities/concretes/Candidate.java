package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "candidate")
@PrimaryKeyJoinColumn(name = "user_id")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "curriculumVitaes" })
public class Candidate extends User {

	@NotBlank
	@NotNull
	// @Pattern(regexp = "[a-zA-Z]", message = "İsminiz sadece harflerden
	// oluşabilir. ")
	@Length(min = 3, message = "İsminiz en az 3 karakterden oluşmalıdır.")
	@Column(name = "first_name")
	private String firstName;

	@NotBlank
	@NotNull
	// @Pattern(regexp = "[a-zA-Z]", message = "İsminiz sadece harflerden
	// oluşabilir. ")
	@Length(min = 2, message = "Soyisminiz en az 2 karakterden oluşmalıdır.")
	@Column(name = "last_name")
	private String lastName;

	@NotBlank
	@NotNull
	@Length(min = 11, max = 11, message = "Kimlik numaranız 11 hane olmalıdır.")
	// @Pattern(regexp = "[0-9]" , message = "Kimlik numaranız sadece rakamlardan
	// oluşabilir. ")
	@Column(name = "nationality_identity")
	private String nationalityIdentity;

	@NotBlank
	@NotNull
	@Length(min = 4, max = 4, message = "Doğum yılınız 4 hane olmalıdır.")
	// @Pattern(regexp = "[0-9]", message = "Doğum yılınız sadece rakamlardan
	// oluşabilir.")
	@Column(name = "date_of_birth")
	private String dateOfBirth;

	// @NotBlank
	// @NotNull
	@Column(name = "is_mernis_verified")
	private boolean isMernisVerified;

	// @JsonIgnore
	// ana tablo burası
	// ana tablo üzerinden gidiyoruz.
	@JsonIgnore
	@OneToMany(mappedBy = "candidate") // field ismi
	private List<CurriculumVitae> curriculumVitaes; // candidatenin cvleri olur.

	// ana tablo burası
	// ana tablo üzerinden gidiyoruz.
	@JsonIgnore
	@OneToMany(mappedBy = "candidate") // field ismi
	private List<FavoriteJobAdvertisement> favoriteJobAdvertisements; // candidatein favori ilanları olur.

}
