package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//data transformation object
//tek tablolarda da kullanılabilir.
//bir tabloda 100 kolon yerine sadece çalışılması gereken kolonlar için kullanılır.

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {

	private String companyName;
	private String positionName;
	private int numberOfOpenPositions;
	private Date createdDate;
	private Date applicationLastDate;
	private String typeName;
	private String timeTypeName;
	
}
