package com.github.addressapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.addressapi.dao.AddressDAO;
import com.github.addressapi.model.Address;
import com.github.addressapi.model.Response;

@Service
public class AddressService {

	@Autowired
	private AddressDAO addressDao;

	public Response findByCep(String cep){
		Response response = new Response();
		cep = this.clearCep(cep);
		if(cep.length() != 8){
			response.setMessage("CEP inválido");
		}else{
			response.setValidCep(true);
			Address address = this.findAddress(cep);
			if(address == null){
				response.setMessage("CEP não cadastrado");
				response.setNewAddress(true);
			}else{
				response.setAddress(address);
				response.setMessage("CEP já cadastrado");
			}
		}
		return response;
	}
	
	public Address findAddress(String cep) {
		String cepWithZeros = String.format("%1$-8s", cep).replace(' ', '0');
		if(cepWithZeros.equals("00000000"))
			return null;
		Address address = addressDao.findByCEP(cepWithZeros);
		if(address != null)
			return address;
		return findAddress(cep.substring(0, cep.length() - 1));
	}
	
	public String clearCep(String cep) {
		if (cep != "") {
		  cep = cep.replaceAll("[^\\d]", "");
		} 
		return cep;
	}
	public Response saveRegister(Address address, Response response){
		if(response.isNewAddress()){
			response = this.save(address, response);
		}else{
			response = this.update(address, response);
		}
		return response;
	}
	
	public Response save(Address address, Response response){
		
		Address newAddress = new Address();
		//Include
		newAddress = addressDao.save(address);
		response.setAddress(newAddress);
		response.setMessage("Endereço cadastrado com sucesso");
		return response;
	}
	
	public Response update(Address address, Response response){
		address.setId(response.getAddress().getId());
		response.setAddress(address);
		addressDao.update(address);
		response.setMessage("Endereço atualizado com sucesso");
		return response;
	}

	public List<Address> findAll() {
		return this.addressDao.findAll();
	}
	
	public Address findById(Long id) {
		return this.addressDao.findById(id);
	}

	public Response deleteAddress(Long id) {
		Address address = this.findById(id);
		Response response = new Response();
		if(address != null){
			this.addressDao.delete(address);
			response.setMessage("Registro removido com sucesso");
			
		}
		return response;
	}
	
	
}
