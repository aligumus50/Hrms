package kodlamaio.hrms.business.concretes;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.adapter.abstracts.ImageCloudinaryService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.concretes.Image;

@Service
public class ImageManager implements ImageService {

	private ImageDao imageDao;
	private ImageCloudinaryService imageCloudinaryService;
	
	@Autowired
	public ImageManager(ImageDao imageDao, ImageCloudinaryService imageCloudinaryService) {
		super();
		this.imageDao = imageDao;
		this.imageCloudinaryService = imageCloudinaryService;
	}

	@Override
	public Result imageUpload(Image image, MultipartFile multipartFile) throws IOException {
		var result = this.imageCloudinaryService.imageUpload(multipartFile);
		image.setImageName(result.getData().get("original_filename").toString());
		image.setImageUrl(result.getData().get("url").toString());
		this.imageDao.save(image);
		return new SuccessDataResult<>("Fotoğrafınız başarıyla kaydedildi.");

	}

	
}
