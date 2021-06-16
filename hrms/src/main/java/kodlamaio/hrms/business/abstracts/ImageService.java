package kodlamaio.hrms.business.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;


import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.Image;

public interface ImageService {

	Result imageUpload(Image image, MultipartFile multipartFile) throws IOException;
}
