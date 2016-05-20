package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AddressDAO;
import model.Address;
import model.Response;

@Service
public class AddressService {

	@Autowired
	private AddressDAO addressDao;

	public Response findByCep(String cep){
		Response response = new Response();
		cep = this.clearCep(cep);
		if(cep.length() != 8){
			response.setError("CEP Inválido");
		}else{
			Address address = this.findAddress(cep);
			if(address == null){
				response.setError("CEP Não Encontrado");
			}
			response.setAddress(address);
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
	
}
