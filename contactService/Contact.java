package contactService;

// Class for contact info
public class Contact {

	private final String ID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	//Constructor to be called by ContactService
	protected Contact(String _ID, String _firstName, String _lastName, String _phone, String _address) {
		ID = _ID;
		
		if (ID == null || ID == "" || ID.length() > 10)
			throw new IllegalArgumentException("Invalid ID");
		
		SetFirstName(_firstName);
		SetLastName(_lastName);
		SetPhone(_phone);
		SetAddress(_address);
	}

	public String GetID() {return ID;}
	public String GetFirstName() {return firstName;}
	public String GetLastName() {return lastName;}
	public String GetPhone() {return phone;}
	public String GetAddress() {return address;}
	
	protected void SetFirstName(String _firstName) {
		if (_firstName == null || _firstName == "" || _firstName.length() > 10)
			throw new IllegalArgumentException("Invalid First Name");
		
		firstName = _firstName;
	}
	protected void SetLastName(String _lastName) {
		if (_lastName == null || _lastName == "" || _lastName.length() > 10)
			throw new IllegalArgumentException("Invalid Last Name");
		
		lastName = _lastName;
	}
	protected void SetPhone(String _phone) {
		if (_phone == null || _phone.length() != 10)
			throw new IllegalArgumentException("Invalid Phone Number");
		
		phone = _phone;
	}
	protected void SetAddress(String _address) {
		if (_address == null || _address == "" || _address.length() > 30)
			throw new IllegalArgumentException("Invalid Address");
		
		address = _address;
	}
}