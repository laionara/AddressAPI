package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Address;
import model.Response;
import service.AddressService;
import validation.AddressValidator;

@Controller
@Transactional
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@Autowired
	private AddressValidator addressValidator;
	
	@RequestMapping(value = "/{cep}", method = RequestMethod.GET)
	public @ResponseBody Response getAddressInJSON(@Valid @PathVariable("cep") String cep) {
		//addressValidator.validate(cep, null);
		return addressService.findByCep(cep);
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(new AddressValidator());
	}
	
}
