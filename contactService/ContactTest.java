package contactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	void testContactClass() {
		
		// Create contact
		Contact contact = new Contact("1234", "John", "Doe", "asdfg12345", "Anytown, USA");
		
		// Check contact info
		assertTrue(contact.GetID().equals("1234"));
		assertTrue(contact.GetFirstName().equals("John"));
		assertTrue(contact.GetLastName().equals("Doe"));
		assertTrue(contact.GetPhone().equals("asdfg12345"));
		assertTrue(contact.GetAddress().equals("Anytown, USA"));
	}
	
	@Test
	void testContactIDExceptions() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "John", "Doe", "asdfg12345", "Anytown, USA");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("", "John", "Doe", "asdfg12345", "Anytown, USA");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789asdf", "John", "Doe", "asdfg12345", "Anytown, USA");
		});
	}
	
	@Test
	void testContactFirstNameExceptions() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", null, "Doe", "asdfg12345", "Anytown, USA");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", "", "Doe", "asdfg12345", "Anytown, USA");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", "JohnJohnJohnny", "Doe", "asdfg12345", "Anytown, USA");
		});
	}
	
	@Test
	void testContactLastNameExceptions() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", "John", null, "asdfg12345", "Anytown, USA");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", "John", "", "asdfg12345", "Anytown, USA");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", "John", "DoeDoeDoe-eyed", "asdfg12345", "Anytown, USA");
		});
	}
	
	@Test
	void testContactPhoneExceptions() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", "John", "Doe", null, "Anytown, USA");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", "John", "Doe", "", "Anytown, USA");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", "John", "Doe", "asdfghjkl;1234567890", "Anytown, USA");
		});
	}
	
	@Test
	void testContactAddressExceptions() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", "John", "Doe", "asdfg12345", null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", "John", "Doe", "asdfg12345", "");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", "John", "Doe", "asdfg12345", "Anytown, USA, North America, Planet Earth, Solar Sytem, Milky Way Galaxy, Known Universe");
		});
	}

}
