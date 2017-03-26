import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneBook {
	
	private List<Contact> contacts;

	public PhoneBook() {
		this.contacts = new ArrayList<>();
	}

	public void addContact(Contact contact) {
		this.contacts.add(contact);
	}

	public void deleteContact(int index) {
		this.contacts.remove(index);
	}
	
	public List<Contact> getContacts() {
		return Collections.unmodifiableList(this.contacts);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();		
		List<Contact> sortedContacts = this.contacts.stream()
													.sorted()
													.collect(Collectors.toList());
		int numContact = 1;
		for (Contact contact : sortedContacts) {
			sb.append(String.format("%d. %s%n", numContact, contact));
			numContact++;
		}
		return sb.toString();
						
	}
}
