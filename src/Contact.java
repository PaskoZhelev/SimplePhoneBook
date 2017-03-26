
public class Contact implements Comparable<Contact> {
	private String firstName;		
	private String lastName;
	private String address;
	private String phoneNumber;
	
	public Contact(String firstName, String lastName, String address, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s | %s | %s", this.firstName, this.lastName, this.phoneNumber, this.address);
	}

	@Override
	public int compareTo(Contact anotherContact) {
		return this.firstName.compareTo(anotherContact.getFirstName());
	}
	
}
