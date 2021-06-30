package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@CrossOrigin
@RestController
@RequestMapping("api/jobadvertisements")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll() {

		return this.jobAdvertisementService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {

		return this.jobAdvertisementService.add(jobAdvertisement);
	}

	@GetMapping("/getByJobDescription")
	public DataResult<List<JobAdvertisement>> getByJobDescription(@RequestParam String name) {

		return this.jobAdvertisementService.getByJobDescription(name);
	}

	@Transactional
	@GetMapping("/getByStatus")
	public DataResult<List<JobAdvertisementDto>> getByStatus(Boolean status) {
		return this.jobAdvertisementService.getByStatus(status);
	}

	// aktif iş ilanı2
	@GetMapping("/getJobAdvertisementDetailsByStatus")
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetailsByStatus(Boolean status) {

		return this.jobAdvertisementService.getJobAdvertisementDetailsByStatus(status);

	}

	/*@GetMapping("/getByStatusOrderByCreatedDateAsc")
	public DataResult<List<JobAdvertisement>> getJobAdvertisementDetailsByStatusOrderDate(Boolean status) {
		return this.jobAdvertisementService.getByStatusOrderByCreatedDateAsc(status);
	}*/
	
	@GetMapping("/getJobAdvertisementDetailsByStatusOrderDate")
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetailsByStatusOrderDate(Boolean status) {
		return this.jobAdvertisementService.getJobAdvertisementDetailsByStatusOrderDate(status);
	}

	/*@GetMapping("/getByEmployeerIdAndStatus")
	public DataResult<List<JobAdvertisement>> getByEmployeerId(int employeerId, Boolean status) {

		return this.jobAdvertisementService.getByEmployeerIdAndStatus(employeerId, status);
	}*/
	
	@GetMapping("/getJobAdvertisementDetailsByStatusAndByEmployeer")
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetailsByStatusAndByEmployeer(int employeerId, Boolean status) {

		return this.jobAdvertisementService.getJobAdvertisementDetailsByStatusAndByEmployeer(employeerId, status);
	}

	@PostMapping("updateStatusAndEmployeerId")
	public Result updateStatusAndEmployeerId(@RequestParam int id, @RequestParam int employeerId, @RequestParam  Boolean status) {

		return this.jobAdvertisementService.updateStatusAndEmployeerId(id, employeerId, status);
	}
	
	@GetMapping("/getByEmployeerId")
	public DataResult<List<JobAdvertisement>> getByEmployeer_Id(@RequestParam int employeerId) {
		
		return this.jobAdvertisementService.getByEmployeer_Id(employeerId);
	}
	
	@PostMapping("updateStatusByEmployeer")
	public Result updateStatusByEmployeer(@RequestParam int id, @RequestParam Boolean status) {
		
		return this.jobAdvertisementService.updateStatusByEmployeer(id, status);
	}
	
	@GetMapping("findJobAdvertisementByCityId")
	public DataResult<List<JobAdvertisement>> findJobAdvertisementByCityId(@RequestParam List<Integer> ids) {
		
		return this.jobAdvertisementService.findJobAdvertisementByCityId(ids);
	}
	
	@GetMapping("/getAllByPage")
	public DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize) {
		
		return this.jobAdvertisementService.getAll(pageNo, pageSize);
	}

}
