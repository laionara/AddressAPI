package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

import controller.AddressController;
import model.Address;
import model.Response;
import service.AddressService;

public class AddressControllerTest {
	
	private Address address;
	
	@Mock
	private AddressService addressService;
	
	private static final String CEP = "04755640571";
	
	@Before
	public void setUp(){
		this.address = new Address();
		this.addressService = new AddressService();
	}
	
	
	@Test
	public void testResponseWithAddress(){
		// Arrange
		AddressController addressController = new AddressController();
		Response result = new Response();
	    this.address.setCep(CEP);
	    result.setAddress(address);
	    AddressService adService = org.mockito.Mockito.mock(AddressService.class);
	    when(adService.findByCep(CEP)).thenReturn(result);
	    // Act
	    //addressController.getAddressInJSON(CEP);
	    // Arrange
	    assertEquals("", result, result);
	    
	}

	public static String getCep() {
		return CEP;
	}

	
}
