package kodlamaio.hrms.business.concretes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.core.adapter.abstracts.ImageCloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService{

	private CurriculumVitaeDao curriculumVitaeDao;
	private ImageCloudinaryService imageCloudinaryService;

	
	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao, ImageCloudinaryService imageCloudinaryService) {
		super();
		this.curriculumVitaeDao = curriculumVitaeDao;
		this.imageCloudinaryService = imageCloudinaryService;

	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAll(), "cv listelendi.");
	}

	@Override
	public Result add(CurriculumVitae curriculumVitae) {
		
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessDataResult<>("Cv eklendi");
	}

	@Override
	public DataResult<CurriculumVitae> imageUpload(int curriculumVitaeId, MultipartFile multipartFile) throws IOException {
		
		CurriculumVitae curriculumVitae = this.curriculumVitaeDao.findById(curriculumVitaeId).get();
		var result = this.imageCloudinaryService.imageUpload(multipartFile);
		curriculumVitae.setProfilePhotoLink(result.getData().get("url").toString());
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessDataResult<>("Fotoğrafınız başarıyla kaydedildi.");
	}

	@Override
	public DataResult<List<CurriculumVitae>> getByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.getByCandidateId(candidateId),"Adaya ait cv listelendi");
	}

	@Override
	public DataResult<CurriculumVitae> getById(int curriculumVitaeId) {
		
		return new SuccessDataResult<CurriculumVitae>(this.curriculumVitaeDao.getById(curriculumVitaeId), "id ye ait cv listelendi");
	}

	

	

}
