import java.util.List;
import java.util.Scanner;

public class Menu {

	private PhoneBook phoneBook;
	private Scanner scanner;
	private String input;
	ContactDetailsChanger contactDetailsChanger;
	BookSearchProvider bookSearchProvider;

	public Menu(PhoneBook phoneBook) {
		this.phoneBook = phoneBook;
		contactDetailsChanger = new ContactDetailsChanger();
		bookSearchProvider = new BookSearchProvider();
		this.scanner = new Scanner(System.in);
		input = "";
	}

	public void mainMenu() {
		System.out.println("Press the corresponding key:");
		System.out.println("1. Add Contact");
		System.out.println("2. Delete Contact");
		System.out.println("3. Show all contacts");
		System.out.println("4. Search for a contact by Name");
		System.out.println("5. Search for a contact by Phone Number");
		System.out.println("6. Change contact's phone number");
		System.out.println("7. Change contact's address");
		System.out.println("8. Close the Phone Book");

		input = scanner.nextLine();

		try {
			int choice = Integer.valueOf(input);
			switch (choice) {
			case 1:
				this.addContact();
				break;
			case 2:
				this.removeContact();
				break;
			case 3:
				this.showAllContacts();
				break;
			case 4:
				this.searchContactByNameOption();
				break;
			case 5:
				this.searchContactByPhoneNumber();
				break;
			case 6:
				this.changePhoneNumber();
				break;
			case 7:
				this.changeAddress();
				break;
			case 8:
				this.closePhoneBook();
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Invalid Input");
		}
	}

	public void addContact() {
		
		try {
			System.out.print("[First Name]: ");
			input = scanner.nextLine();
			String firstName = input.trim();
			
			System.out.print("[Last Name]: ");
			input = scanner.nextLine();
			String lastName = input.trim();
			
			System.out.print("[Address]: ");
			input = scanner.nextLine();
			String address = input.trim();
			
			System.out.print("[Phone Number]: ");
			input = scanner.nextLine();
			String phoneNumber = input.trim();
			
			Contact contact = new Contact(firstName, lastName, address, phoneNumber);
			phoneBook.addContact(contact);
			
			System.out.println();
			System.out.println("Contact Saved!");
			System.out.println();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Invalid Input");
		}
	}
	
	public void removeContact() {
		if(!(phoneBook.getContacts().size() == 0)) {
			System.out.println(phoneBook);
			System.out.println();
			System.out.println("Write the number of the contact that you want to be deleted: ");
			input = scanner.nextLine();
			try {
				int numContact = Integer.valueOf(input);
				this.phoneBook.deleteContact(numContact - 1);   	//the first index in the list is 0 not 1
				System.out.println("The Contact is successfully deleted!");
				System.out.println();
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("Invalid Input");
			}
		} else {
			System.out.println("The Phone Book is empty!");
			System.out.println();
		}
	}
	
	public void showAllContacts() {
		if(!(phoneBook.getContacts().size() == 0)) {
			System.out.println(phoneBook);
		} else {
			System.out.println("The Phone Book is empty!");
			System.out.println();
		}
	}
	
	public void searchContactByNameOption() {
		System.out.println("[First Name][Last Name]: ");
		input = scanner.nextLine();
		try {
			String[] tokens = input.split("\\s+");
			String firstName = tokens[0];
			String lastName = tokens[1];
			List<Contact> contacts = bookSearchProvider.searchByName(phoneBook, firstName, lastName);
			
			contacts.stream().forEach(System.out::println);
			System.out.println();
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Invalid Input");
		}
	}
	
	public void searchContactByPhoneNumber() {
		System.out.println("[Phone Number]: ");
		input = scanner.nextLine();
		try {
			String phoneNumber = input;
			Contact contact = bookSearchProvider.searchByPhoneNumber(phoneBook, phoneNumber);
			System.out.println(contact);
			System.out.println();
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Invalid Input");
		}
	}
	
	public void changePhoneNumber() {
		System.out.println("Write the phone number that needs to be changed: ");
		input = scanner.nextLine();
		try {
			String oldNumber = input;
			System.out.print("Write the new phone number: ");
			input = scanner.nextLine();
			String newNumber = input;
			contactDetailsChanger.changePhoneNumber(phoneBook, oldNumber, newNumber);
			
			System.out.println("The number is changed!");
			System.out.println();
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Invalid Input");
		}
	}
	
	public void changeAddress() {
		System.out.println("Write the phone number of the person: ");
		input = scanner.nextLine();
		try {
			String phoneNumber = input;
			System.out.println("Write the new address of the person: ");
			input = scanner.nextLine();
			String address = input;
			contactDetailsChanger.changeAddress(phoneBook, phoneNumber, address);
			System.out.println("The address is changed!");
			System.out.println();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Invalid Input");
		}
	}
	
	public void closePhoneBook() {
		System.out.println("The Phone Book is closing...");
		System.exit(0);
	}

}
