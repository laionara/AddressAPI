package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import dao.AddressDAO;
import model.Address;
import service.AddressService;

public class AddressServiceTest {

	@Mock
	private Address address;
	
	@Mock
	private AddressService addressService;
	
	@Mock
	private AddressDAO addressDao;
	
	@Before
	public void setUp(){
		this.address = new Address();
		this.addressService = new AddressService();
	}
	
	@Test
	public void testClearCepNull(){
		//Arrange
		String cep="";
		//Act
		this.addressService.clearCep(cep);
		//test
		assertEquals("", cep, cep);
	}
	
	@Test
	public void testClearCepNotNull(){
		//Arrange
		
		String cep="12345678";
		//Act
		this.addressService.clearCep(cep);
		//test
		assertEquals("", cep, cep);
	}
	
	@Test
	public void testfindAddressZeros(){
		//Arrange
		String cep="00000000";
		this.address.setCep(cep);
		//Act
		this.addressService.findAddress(cep);
		//test
		assertEquals(this.address, null);
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public AddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

}
