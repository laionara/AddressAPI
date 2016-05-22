package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import model.Address;
import model.Response;
import service.AddressService;

@Controller
@Transactional
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	private Response response;
	
	public AddressController(){
	}
	
	@RequestMapping(value = "/{cep}", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	public @ResponseBody Response getAddressInJSON(@PathVariable("cep") String cep) {
		this.response = addressService.findByCep(cep);
		return this.response;
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView form() {
		return new ModelAndView("/address/addressForm", "address", new Address());
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Address address, RedirectAttributes redirect) {
		Response response = addressService.findByCep(address.getCep()) ;
		if(this.response.isNewAddress()){
			response = this.addressService.save(address, this.response);
		}else{
			response = this.addressService.update(address, this.response);
		}
		
		redirect.addFlashAttribute("response", response);
		return "redirect:/address/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(Response response) {
		ModelAndView model = new ModelAndView("address/addressList");
		model.addObject("message", response.getMessage());
		return model;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

}
