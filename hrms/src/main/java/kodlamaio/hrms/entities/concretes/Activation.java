package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="activation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column(name="user_id")
	private int User_Id;
	
	@Column(name="activation_code")
	private String Activation_Code;
	
	@Column(name="created_date_activation")
	private Date Created_Date_Activation;

}
