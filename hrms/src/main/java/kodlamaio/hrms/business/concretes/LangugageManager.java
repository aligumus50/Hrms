package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concretes.Language;

@Service
public class LangugageManager implements LanguageService {

	private LanguageDao languageDao;
	
	public LangugageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public DataResult<List<Language>> getAll() {
		
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll(), "Bilinen diller listelendi.");
	}

	@Override
	public Result add(Language language) {
		
		this.languageDao.save(language);
		return new SuccessDataResult<>("Dil deneyimi eklendi.");
	}

}
