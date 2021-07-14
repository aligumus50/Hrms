package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Activation;


public interface ActivationService {

	Result add(Activation activation);
}
