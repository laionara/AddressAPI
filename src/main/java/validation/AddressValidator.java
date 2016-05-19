package validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import model.Address;

@Component
public class AddressValidator implements Validator {

	public boolean supports(Class<?> address) {
		return Address.class.isAssignableFrom(address);
	}

	public void validate(Object target, Errors errors) {
		String cep = (String) target;
		cep = this.onlyNumbers(cep);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.address.cep");
		if(cep.length() != 7){
			
		}
		
	}
	
	public String onlyNumbers(String str) {
		if (str != null) {
		    return str.replaceAll("[^0123456789]", "");
		} else {
		return "";
		}
		
	}


}
