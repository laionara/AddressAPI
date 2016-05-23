package com.github.addressapi.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.addressapi.model.Address;
import com.github.addressapi.model.Response;
import com.github.addressapi.service.AddressService;

@Controller
@Transactional
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	public AddressController(){
	}
	
	/**
	 * O método  getAddressInJSON recebe o cep, verifica se o mesmo é válido ou se já está cadastrado e responde em formato JSON
	 */
	@RequestMapping(value = "/{cep}", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	public @ResponseBody Response getAddressInJSON(@PathVariable("cep") String cep) {
		return addressService.findByCep(cep);
		
	}
	
	/**
	 * Redireciona a url /form para a página JSP do formulário Address
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView form() {
		return new ModelAndView("/address/addressForm", "address", new Address());
	}
	
	/**
	 * Verifica se o preenchimento do formulário foi completo e se o cep é válido.   
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Address address, BindingResult result, RedirectAttributes redirect) {
		Response response = new Response();
		if(result.hasErrors()){
			response.setMessage("Erro: campo obrigatório");
			redirect.addFlashAttribute("message", response.getMessage());
			return "redirect:/address/form"; 
		}
		response = addressService.findByCep(address.getCep());
		if(response.isValidCep()){
			response = this.addressService.saveRegister(address, response);
		}else{
			redirect.addFlashAttribute("message", response.getMessage());
			return "redirect:/address/form";
		}
		
		redirect.addFlashAttribute("response", response);
		return "redirect:/address/list";
	}
	
	/**
	 * Atualizando a lista com todos os endereços cadastrados e enviando a mensagem referente ao
	 * cadastro ou atualização do endereço.
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.DELETE})
	public ModelAndView list(Response response) {
		List<Address> addressList = this.addressService.findAll();
		ModelAndView model = new ModelAndView("address/addressConsult");
		model.addObject("addressList", addressList);
		model.addObject("message", response.getMessage());
		
		return model;
	}
	
	/**
	 * Envia o id do endereço selecionado na tabela de endereços método deleteAddress do AddressService.
	 */
	@RequestMapping(value = "/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String delete(@PathVariable("id") Long id, RedirectAttributes redirect) {
		Response response = this.addressService.deleteAddress(id);
		redirect.addFlashAttribute("response", response);
		return "redirect:/address/list";
	}
	
}
