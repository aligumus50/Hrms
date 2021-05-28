package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	@Column(name = "employeer_id")
	private int employeerId;
	
	@Column(name = "job_position_d")
	private int jobPositionId;
	
	@Column(name = "job_description")
	private String jobDescription;
	
	@Column(name = "city_id")
	private int cityId;
	
	@Column(name = "number_of_open_positions")
	private int numberOfOpenPositions;
	
	@Column(name = "min_salary")
	private String minSalary;
	
	@Column(name = "max_salary")
	private String maxSalary;
	
	@Column(name = "created_date")
	private Date createdDate; //default değer oluştur.
	
	@Column(name = "application_last_date")
	private Date applicationLastDate;
	
	@Column(name = "status")
	private boolean status;

}
