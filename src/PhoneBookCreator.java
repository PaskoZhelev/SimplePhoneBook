
public class PhoneBookCreator {
	
	public static void main(String[] args) {
		
		PhoneBook phoneBook = new PhoneBook();
		Menu menu = new Menu(phoneBook);
		ContactsCounter contactsCounter = new ContactsCounter();
		
		
		while(true) {
			System.out.printf("There are %d contacts in the Phone Book%n%n", contactsCounter.count(phoneBook));
			menu.mainMenu();
		}
	}
}
