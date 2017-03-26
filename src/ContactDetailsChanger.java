
public class ContactDetailsChanger {
	
	public void changePhoneNumber(PhoneBook phoneBook, String oldPhoneNumber, String newPhoneNumber) {
		phoneBook.getContacts().stream()
								.forEach(contact -> {
									if(contact.getPhoneNumber().equals(oldPhoneNumber)) {
										contact.setPhoneNumber(newPhoneNumber);
									}
								});
	}
	
	public void changeAddress(PhoneBook phoneBook, String phoneNumber, String address) {
		phoneBook.getContacts().stream()
		.forEach(contact -> {
			if(contact.getPhoneNumber().equals(phoneNumber)) {
				contact.setAddress(address);
			}
		});
	}
}
