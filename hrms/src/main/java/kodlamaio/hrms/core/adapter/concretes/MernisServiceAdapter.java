package kodlamaio.hrms.core.adapter.concretes;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateUserCheckService;
import kodlamaio.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
@Qualifier("mernisValidation")
public class MernisServiceAdapter implements CandidateUserCheckService{

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		boolean result=true;
		try {
			result = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong("23455996070") ,"ali","gümüş",1990);
					
					/*Long.parseLong(candidate.getNationalityIdentity()), 
					candidate.getFirstName().toUpperCase(), 
					candidate.getLastName().toUpperCase(), 1990
					//candidate.getDateOfBirth().getYear()
					);*/
			
			System.out.println(candidate.getFirstName());

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	
}
