package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),
				"İş İlanları Listelendi.");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		if (checkAllFieldsControl(jobAdvertisement) == false) {

			return new ErrorResult("Tüm Alanlar Zorunludur.");
		} else {
			this.jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessDataResult<>("İş İlanı Başarıyla Eklendi.");
		}
	}

	// dropdown iş pozisyonu kontrolü eklenecek.
	// dropdown açılır liste eklenecek.
	private boolean checkAllFieldsControl(JobAdvertisement jobAdvertisement) {

		if (jobAdvertisement.getJobDescription().isEmpty() || jobAdvertisement.getNumberOfOpenPositions() == 0
				|| jobAdvertisement.getApplicationLastDate() == null

		) {

			return false;
		}
		return true;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByJobDescription(String name) {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByJobDescription(name),
				"İş İlanları Listelendi.");

	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getByStatus(Boolean status) {

		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getByStatus(status),
				"İş İlanı Listelendi. Filtre");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetailsByStatus(Boolean status) {

		return new SuccessDataResult<List<JobAdvertisementDto>>(
				this.jobAdvertisementDao.getJobAdvertisementDetailsByStatus(status),
				" " + status + " ilanları listeledi");

	}

	/*
	 * @Override public DataResult<List<JobAdvertisement>>
	 * getByStatusOrderByCreatedDateAsc(Boolean status) {
	 * 
	 * return new
	 * SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.
	 * getByStatusOrderByCreatedDateAsc(status)); }
	 */

	@Override
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetailsByStatusOrderDate(Boolean status) {

		return new SuccessDataResult<List<JobAdvertisementDto>>(
				this.jobAdvertisementDao.getJobAdvertisementDetailsByStatusOrderDate(status));
	}

	/*
	 * @Override public DataResult<List<JobAdvertisement>>
	 * getByEmployeerIdAndStatus(int employeerId, Boolean status) { // TODO
	 * Auto-generated method stub return new
	 * SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.
	 * getByEmployeerIdAndStatus(employeerId, status)); }
	 */

	@Override
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetailsByStatusAndByEmployeer(int employeerId,
			Boolean status) {

		return new SuccessDataResult<List<JobAdvertisementDto>>(
				this.jobAdvertisementDao.getJobAdvertisementDetailsByStatusAndByEmployeer(employeerId, status));
	}

	@Override
	public Result updateStatusAndEmployeerId(int id, int employeerId, Boolean status) {

		if (status == true) {
			this.jobAdvertisementDao.updateStatusAndEmployeerId(id, employeerId, status);
			return new SuccessResult("İlan Yayında");
		} else {
			this.jobAdvertisementDao.updateStatusAndEmployeerId(id, employeerId, status);
			return new SuccessResult("İlan Yayından Kaldırıldı.");
		}

	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployeer_Id(int employeerId) {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEmployeer_Id(employeerId),
				"employeer göre listelendi");

	}

	@Override
	public Result updateStatusByEmployeer(int id, Boolean status) {
		if (status == true) {
			this.jobAdvertisementDao.updateStatusByEmployeer(id, status);
			return new SuccessResult("İlan Yayında");
		} else {
			this.jobAdvertisementDao.updateStatusByEmployeer(id, status);
			return new SuccessResult("İlan Yayından Kaldırıldı.");
		}

	}

	@Override
	public DataResult<List<JobAdvertisement>> findJobAdvertisementByCityId(List<Integer> ids) {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findJobAdvertisementByCityId(ids),
				"şehirlere göre filtrelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize) {

		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(pageable).getContent());
	}

}
