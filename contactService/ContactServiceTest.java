package contactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

	@Test
	void testConctactServiceClass() {		
		
		// Contact doesn't exist
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.GetContactService().ViewContact("1234");
		});
		
		// Add contact
		ContactService.GetContactService().AddContact("1234", "John", "Doe", "asdfg12345", "Anytown, USA");
		
		// Cannot add contact with duplicate ID
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.GetContactService().AddContact("1234", "Jo", "De", "asdfg12345", "Anyplace, US");
		});
		
		// Contact exists
		assertFalse(ContactService.GetContactService().ViewContact("1234") == null);
		
		// Update contact
		ContactService.GetContactService().UpdateContact("1234", "Johnny", "Doe-eyed", "hjkl;67890", "Somewhere, Canada");
		
		// Contact is updated
		assertTrue(ContactService.GetContactService().ViewContact("1234").GetFirstName() == "Johnny");
		assertTrue(ContactService.GetContactService().ViewContact("1234").GetLastName() == "Doe-eyed");
		assertTrue(ContactService.GetContactService().ViewContact("1234").GetPhone() == "hjkl;67890");
		assertTrue(ContactService.GetContactService().ViewContact("1234").GetAddress() == "Somewhere, Canada");
		
		// Remove contact
		ContactService.GetContactService().RemoveContact("1234");
		
		// Contact doesn't exist
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.GetContactService().ViewContact("1234");
		});
	}
	
	

}
