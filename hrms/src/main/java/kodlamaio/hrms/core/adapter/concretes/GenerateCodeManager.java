package kodlamaio.hrms.core.adapter.concretes;

import java.util.Random;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapter.abstracts.GenerateCodeService;

@Service
public class GenerateCodeManager implements GenerateCodeService {

	@Override
	public String GenerateCode() {
		
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();

	    String code = random.ints(leftLimit, rightLimit + 1)
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    //System.out.println(code);
		return code;
	}

}
