package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.FavoriteJobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.FavoriteJobAdvertisement;


@CrossOrigin
@RestController
@RequestMapping("api/favoritejobadvertisements")
public class FavoriteJobAdvertisementsController {

	FavoriteJobAdvertisementService favoriteJobAdvertisementService;

	@Autowired
	public FavoriteJobAdvertisementsController(FavoriteJobAdvertisementService favoriteJobAdvertisementService) {
		super();
		this.favoriteJobAdvertisementService = favoriteJobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<FavoriteJobAdvertisement>> getAll() {
		
		return this.favoriteJobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody FavoriteJobAdvertisement favoriteJobAdvertisement) {
		
		return this.favoriteJobAdvertisementService.add(favoriteJobAdvertisement);
	}
	
	@PostMapping("/delete")
	public Result deleteFavoriteJobAdvertisement(@RequestParam int jobAdvertisementId, @RequestParam int candidateId) {
		
		return this.favoriteJobAdvertisementService.deleteFavoriteJobAdvertisement(jobAdvertisementId, candidateId);
	}
	
	
}
