package contactService;
import java.util.*;

// Singleton class for managing contact objects
public class ContactService {
	
	// Structure for storing contacts
	private Map<String, Contact> Contacts = new HashMap<String, Contact>();
	
	// Singleton setup
	private static ContactService instance = null;
	private ContactService() {};	
	public static ContactService GetContactService() {
		if (instance == null)
			instance = new ContactService();
		
		return instance;
	}
	
	public String AddContact(String _ID, String _firstName, String _lastName, String _phone, String _address) {
		
		if (Contacts.containsKey(_ID))
			throw new IllegalArgumentException("ID is already in use");
		
		try {
			Contact p = new Contact(_ID, _firstName, _lastName, _phone, _address);
			
			Contacts.put(_ID, p);
			
			return "Contact " + _ID + " successfully created";
		}
		catch(IllegalArgumentException e) {
			return e.getMessage();
		}
		
	}
	
	public String RemoveContact(String _ID) {
		
		if (!Contacts.containsKey(_ID))
			throw new IllegalArgumentException("No contact with that ID exists");
		
		Contacts.remove(_ID);
		
		return "Contact removed";
	}
	
	public String UpdateContact(String _ID, String _firstName, String _lastName, String _phone, String _address) {
				
		ViewContact(_ID).SetFirstName(_firstName);
		ViewContact(_ID).SetLastName(_lastName);
		ViewContact(_ID).SetPhone(_phone);
		ViewContact(_ID).SetAddress(_address);
		
		return "Parameters updated";
	}
	
	public Contact ViewContact(String _ID) {
		if (!Contacts.containsKey(_ID))
			throw new IllegalArgumentException("No contact with that ID exists");
		
		return Contacts.get(_ID);
	}
}
