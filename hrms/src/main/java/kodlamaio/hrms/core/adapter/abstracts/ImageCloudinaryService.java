package kodlamaio.hrms.core.adapter.abstracts;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface ImageCloudinaryService {

	DataResult<Map> imageUpload(MultipartFile multipartFile) throws IOException;
}