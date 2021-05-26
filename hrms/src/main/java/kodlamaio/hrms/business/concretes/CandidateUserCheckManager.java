package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateUserCheckService;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
@Qualifier("fakeValidation")
public class CandidateUserCheckManager implements CandidateUserCheckService{

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		// TODO Auto-generated method stub
		return true;
	}

}
