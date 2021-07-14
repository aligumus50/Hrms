package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "favorite_job_advertisement")
public class FavoriteJobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	//@Column(name = "candidate_id")
	//private int candidateId;
	
	//@Column(name = "job_advertisement_id")
	//private int JobAdvertisementId;
	
	@Column(name = "created_date")
	private Date createdDate;
	

	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	
	@ManyToOne
	@JoinColumn(name="job_advertisement_id")
	private JobAdvertisement jobAdvertisement;

}
