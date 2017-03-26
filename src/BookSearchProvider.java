import java.util.List;
import java.util.stream.Collectors;

public class BookSearchProvider {
	
	public List<Contact> searchByName(PhoneBook phoneBook, String firstName, String lastName) {
		List<Contact> foundContacts = phoneBook.getContacts().stream()
								.filter(person -> (person.getFirstName() + " " + person.getLastName()).equals(firstName + " " + lastName))
								.collect(Collectors.toList());
		return foundContacts;
	}
	
	public Contact searchByPhoneNumber(PhoneBook phoneBook, String phoneNumber) {
		Contact person = null;	
		for (Contact contact : phoneBook.getContacts()) {
			if (phoneNumber.equals(contact.getPhoneNumber())) {
				person = contact;
			}
		}								
		return person;
	}
	
}
