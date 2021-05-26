package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateUserCheckService {

	boolean checkIfRealPerson(Candidate candidate);
}
