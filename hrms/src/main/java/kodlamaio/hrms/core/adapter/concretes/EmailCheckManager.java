package kodlamaio.hrms.core.adapter.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapter.abstracts.EmailCheckService;

@Service
public class EmailCheckManager implements EmailCheckService {

	@Override
	public boolean checkIfRealEmailAddress(String emailAddress) {

		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(emailAddress);

		if (!matcher.matches()) {

			return false;

		}

		return true;
	}

}
