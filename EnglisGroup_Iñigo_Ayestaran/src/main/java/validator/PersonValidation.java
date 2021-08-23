package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import domain.Person;

public class PersonValidation implements Validator {

    @Override
    public boolean supports(Class<?> klass) {
        return Person.class.isAssignableFrom(klass);
    }

    @Override
    public void validate(Object target, Errors errors) {
    	if(!errors.hasErrors()) {
    		Person person = (Person) target;
            
            
            if (person.getCode1() >= person.getCode2()){
            	errors.rejectValue("code1", "code1NotLower.registration.code1", "code1 must be lower than code2");
            }
    	}
    }
}
