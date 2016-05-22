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
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rua", "Campo obrigatório");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numero", "Campo obrigatório");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cep", "Campo obrigatório");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cidade", "Campo obrigatório");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "estado", "Campo obrigatório");
	}
	
	public String onlyNumbers(String str) {
		if (str != null) {
		    return str.replaceAll("[^0123456789]", "");
		} else {
		return "";
		}
		
	}


}
