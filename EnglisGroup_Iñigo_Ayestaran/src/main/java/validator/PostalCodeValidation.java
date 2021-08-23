package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import domain.PostalCode;

public class PostalCodeValidation implements Validator{

    @Override
    public boolean supports(Class<?> klass) {
        return PostalCode.class.isAssignableFrom(klass);
    }

	@Override
	public void validate(Object target, Errors errors) {
    	/*
		if(!errors.hasErrors()) {
    		PostalCode postalCode = (PostalCode) target;
    		}
            */
    	}
    	
}
