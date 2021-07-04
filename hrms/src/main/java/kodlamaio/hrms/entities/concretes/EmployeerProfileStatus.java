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
@Table(name="employeer_profile_status")
public class EmployeerProfileStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	//@Column(name = "employeer_id")
	//private int employeerId;
	
	//@Column(name = "system_personnel_id")
	//private int systemPersonnelId;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@ManyToOne
	@JoinColumn(name="employeer_id")
	private Employeer employeer;
	
	@ManyToOne
	@JoinColumn(name="system_personnel_id")
	private SystemPersonnel systemPersonnel;

}
