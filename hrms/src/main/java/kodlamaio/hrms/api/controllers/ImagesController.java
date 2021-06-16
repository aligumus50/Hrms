package kodlamaio.hrms.api.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.entities.concretes.Image;

@RestController
@RequestMapping("api/images")
public class ImagesController {

	private ImageService imageService;

	@Autowired
	public ImagesController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}

	@PostMapping("/imageUpload")
	public ResponseEntity<?> imageUpload(@RequestBody Image image, @RequestParam("multipart") MultipartFile multipartFile,Model model) throws IOException {
		
		return new ResponseEntity<>(this.imageService.imageUpload(image, multipartFile),HttpStatus.OK);
	}

}
