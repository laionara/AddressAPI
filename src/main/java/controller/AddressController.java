package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Response;
import service.AddressService;

@Controller
@Transactional
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	public AddressController(){
		
	}
	
	@RequestMapping(value = "/{cep}", method = RequestMethod.GET)
	public @ResponseBody Response getAddressInJSON(@Valid @PathVariable("cep") String cep) {
		return addressService.findByCep(cep);
	}
	
//	@InitBinder
//	protected void initBinder(WebDataBinder binder){
//		binder.setValidator(new AddressValidator());
//	}
	
}
