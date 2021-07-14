package kodlamaio.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_advertisement")
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	// @Column(name = "employeer_id")
	// private int employeerId;

	// @Column(name = "job_position_id")
	// private int jobPositionId;

	@Column(name = "job_description")
	private String jobDescription;

	// @Column(name = "city_id")
	// private int cityId;

	// @Column(name="work_type_id")
	// private int workTypeId;

	// @Column(name="work_time_id")
	// private int workTimeId;

	@Column(name = "number_of_open_positions")
	private int numberOfOpenPositions;

	@Column(name = "min_salary")
	private String minSalary;

	@Column(name = "max_salary")
	private String maxSalary;

	@Column(name = "created_date")
	private Date createdDate; // default değer oluştur.

	@Column(name = "application_last_date")
	private Date applicationLastDate;

	@Column(name = "status") // aktif-pasif
	private boolean status;

	@ManyToOne()
	@JoinColumn(name = "employeer_id") // employeer id ile employeer tablosunu joinledik.
	private Employeer employeer; // employeerin iş ilanları olur.

	@ManyToOne()
	@JoinColumn(name = "city_id") // city_id ile city tablosunu joinledik.
	private City city; // City nin iş ilanları olur.

	@ManyToOne()
	@JoinColumn(name = "job_position_id") // city_id ile city tablosunu joinledik.
	private JobPosition jobPosition; // City nin iş ilanları olur.

	@ManyToOne()
	@JoinColumn(name = "work_type_id") // work_type_id ile worktype tablosunu joinledik.
	private WorkType workType; // worktype in iş ilanları olur.

	@ManyToOne()
	@JoinColumn(name = "work_time_id") // work_type_id ile worktype tablosunu joinledik.
	private WorkTime workTime; // worktype in iş ilanları olur.

	@JsonIgnore
	@OneToOne(mappedBy = "jobAdvertisement")
	private JobAdvertisementPublish jobAdvertisementPublish;

	// ana tablo burası
	// ana tablo üzerinden gidiyoruz.
	@JsonIgnore
	@OneToMany(mappedBy = "jobAdvertisement") // field ismi
	private List<FavoriteJobAdvertisement> favoriteJobAdvertisements; // ilanın favorileri olur.

}
