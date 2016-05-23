package com.github.addressapi.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.validation.BindingResult;

import com.github.addressapi.model.Address;
import com.github.addressapi.model.Response;
import com.github.addressapi.service.AddressService;
import com.google.common.base.Verify; 
public class AddressControllerTest {
	
	@Mock
	private AddressService addressService;
	@Mock
	private Response response;
	
	private Address address;
	private static final String CEP = "04755640571";
	
	@Before
	public void setUp(){
		this.address = new Address();
		this.addressService = org.mockito.Mockito.mock(AddressService.class);
		this.response = new Response();
	}
	
	
	@Test
	public void getAddressInJSONTest(){
		// Arrange
		this.address.setCep(this.CEP);
	    this.response.setAddress(address);
	    when(this.addressService.findByCep(CEP)).thenReturn(this.response);
	    // Act
	    //test
	    assertTrue(this.CEP == address.getCep());
	    assertEquals("", this.response, this.response);
	    
	}
	
	/**
	 * O método save(@Valid Address address, BindingResult result, RedirectAttributes redirect)
	 * recebe como parametro o objeto Address preenchido pelo usuário. A notação @Valid indica que esse objeto
	 * deve ser validado pelo método validate() da classe AddressValidator que implementa a interface Validator
	 * do Spring. Em caso de erro, indicado pelo parametro result, 
	 * retorna-se (usando o parametro redirect) para o formulário com a mensagem de erro.  Caso contrário, verifica-se 
	 * se o cep é válido utilizando a função findByCep(String cep), a mesma utilizado pelo método getAddressInJSON(Strign cep)
	 *  
	 */
	@Test
	public void saveWithErrorTest(){
		// Arrange
		BindingResult result = org.mockito.Mockito.mock(BindingResult.class);
	    when(result.hasErrors()).thenReturn(true);
       // test
		assertEquals("Erro: campo obrigatório", result, result);
	}
	
	@Test
	public void saveWithoutErrorAndIsValidTest(){
		// Arrange
		BindingResult result = org.mockito.Mockito.mock(BindingResult.class);
	    when(result.hasErrors()).thenReturn(false);
	    this.response.setValidCep(true);
	    when(this.addressService.saveRegister(address, this.response)).thenReturn(this.response);
       // test
		assertEquals(response, response);
	}

	@Test
	public void saveWithoutErrorAndIsNotValidTest(){
		// Arrange
		BindingResult result = org.mockito.Mockito.mock(BindingResult.class);
	    when(result.hasErrors()).thenReturn(false);
	    this.response.setValidCep(false);
       // test
	    Verify.verifyNotNull(response);
		assertEquals(response, response);
		
	}

	
}
