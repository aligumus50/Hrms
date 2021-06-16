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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_advertisement_publish")
public class JobAdvertisementPublish {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	//@Column(name = "job_Advertisement_Id")
	//private int jobAdvertisementId;
	
	//@Column(name = "system_Personnel_Id")
	//private int systemPersonnelId;
	
	@Column(name = "is_Publish")
	private boolean isPublish;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@OneToOne
	@JoinColumn(name="job_advertisement_id")
	private JobAdvertisement jobAdvertisement;
	

	@ManyToOne
	@JoinColumn(name="system_Personnel_Id")
	private SystemPersonnel systemPersonnel;
	

}
