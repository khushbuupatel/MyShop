import java.util.InputMismatchException;
import java.util.Scanner;

public class MyShopMain {

	static MyShop shop;
	static Content[] apps = new Application[100];
	static Content[] books = new Book[100];
	static Content[] magazines = new Magazine[100];
	static Customer[] customers = new Customer[100];
	static Admin[] admins = new Admin[100];

	static int appNo = 0, bookNo = 0, magazineNo = 0, customerNo = 0, adminNo = 0;

	static Comment[] comment = new Comment[100];

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int selectedOption = 0;
		shop = new MyShop();

		loadContents();

		String[] menuContent = { "1.Show content", "2.Add content", "3.Show users", "4.Add users",
				"5.Show particular item reviews", "6.Show all reviews", "7.Download content", "8.Show customer downloads",
				"9.Show item downloads", "10.Show all downloads", "11.Show admin functionality", "12.Quit" };

		do {

			try {
				System.out.println("Please select one of the following options:");

				for (String menuItem : menuContent) {
					System.out.println(menuItem);
				}

				selectedOption = sc.nextInt();

				switch (selectedOption) {
				case 1:
					shop.showContent();
					break;
				case 2:
					addItem();
					break;
				case 3:
					shop.showUser();
					break;
				case 4:
					addUser();
					break;
				case 5:
					showComments(false);
					break;
				case 6:
					showComments(true);
					break;
				case 7:
					downloadContent();
					break;
				case 8:
					customers[0].showDownloads();
					break;
				case 9:
					magazines[0].showDownloads();
					break;
				case 10:
					shop.showDownloads();
					break;
				case 11:
					adminFunctionality();
					break;
				case 12:
					exitProgram(sc);
				default:
					// Show an error message to user to select a valid option
					System.out.println("Please select a valid option");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input entered");

				// read the non numeric input entered by the user so that next int can be read
				sc.nextLine();
			}

			// Display the menu after every step performed until the end user selects to
			// exit from the program (i.e Option 4)
		} while (selectedOption != 12);

	}

	static private void addItem() throws InputMismatchException {

		int itemType;
		String[] itemContent = { "1.Application", "2.Book", "3.Magazine" };

		System.out.println("Please select one of the following items to add:");
		for (String item : itemContent) {
			System.out.println(item);
		}

		itemType = sc.nextInt();
		sc.nextLine();

		switch (itemType) {
		case 1:
			apps[appNo] = addItemDetails(itemType);
			shop.addContent(apps[appNo++]);
			System.out.println("New application is added!\n");
			break;
		case 2:
			books[bookNo] = addItemDetails(itemType);
			shop.addContent(books[bookNo++]);
			System.out.println("New book is added!\n");
			break;
		case 3:
			magazines[magazineNo] = addItemDetails(itemType);
			shop.addContent(magazines[magazineNo++]);
			System.out.println("New magazine is added!\n");
			break;
		default:
			System.out.println("Not a valid item!\n");
			break;
		}
	}

	private static Content addItemDetails(int itemType) throws InputMismatchException {

		String ID, name, osType, publisher, author;
		String[] authors;
		int noOfPages, noOfAuthors;
		double price, volume;
		Content content;

		System.out.print("Enter ID for the Item: ");
		ID = sc.nextLine();
		System.out.print("Enter Name for the Item: ");
		name = sc.nextLine();
		System.out.print("Enter Price for the Item (Add '0.0' if free): ");
		price = sc.nextDouble();
		sc.nextLine();

		if (itemType == 1) {

			System.out.print("Enter minimum OS Type required for the Application: ");
			osType = sc.nextLine();
			content = new Application(ID, name, price, osType);

		} else {

			System.out.print("Please enter the Publisher: ");
			publisher = sc.nextLine();
			System.out.print("Please enter no of pages: ");
			noOfPages = sc.nextInt();

			if (itemType == 2) {

				System.out.print("Please enter no of authors for this book:");
				noOfAuthors = sc.nextInt();
				authors = new String[noOfAuthors];
				sc.nextLine();
				
				for (int i = 0; i < noOfAuthors; i++) {
					System.out.print("Please enter Author no " + (i + 1) + ": ");
					author = sc.nextLine();
					authors[i] = author;
				}

				content = new Book(ID, name, price, publisher, noOfPages, authors);
			} else {

				System.out.print("Please enter volume for magazine: ");
				volume = sc.nextDouble();
				content = new Magazine(ID, name, price, publisher, noOfPages, volume);
			}
		}

		return content;
	}

	private static void addUser() throws InputMismatchException {

		int userType;
		User user;
		String[] userTypes = { "1.New user", "2.Become a member", "3.Admin" };

		System.out.println("Select the user type: ");

		for (String type : userTypes)
			System.out.println(type);

		userType = sc.nextInt();
		sc.nextLine();

		user = addUserDetails(userType);
		shop.addUser(user);
	}

	private static User addUserDetails(int userType) throws InputMismatchException {
		String ID, username, phoneNo, password;
		int level;
		double amount;

		User user;

		System.out.println("Please enter your user ID: ");
		ID = sc.nextLine();
		System.out.println("Please enter your username: ");
		username = sc.nextLine();

		if (userType == 3) {

			System.out.println("Please enter your password: ");
			password = sc.nextLine();
			System.out.println("Please enter your level: ");
			level = sc.nextInt();

			user = new Admin(ID, username, password, level);
			System.out.println("New Admin user added: " + username + "\n");

		} else {

			System.out.println("Please enter your Phone no: ");
			phoneNo = sc.nextLine();

			if (userType == 2) {
				System.out.println("Please enter the amount to be added: ");
				amount = sc.nextInt();
				user = new Customer(ID, username, phoneNo, amount);
				System.out.println("New customer added: " + username + "\n");
			} else {
				user = new Customer(ID, username, phoneNo);
				System.out.println("New premium customer added: " + username + "\n");
			}

		}

		return user;
	}

	static private void showComments(boolean showAllReviews) {

		if (showAllReviews) {
			shop.showAllReviews();
		} else {
			apps[0].showReviews();
			books[0].showReviews();
		}
	}

	static private void loadContents() {

		// create new publications
		String[] authors1 = { "L. Tolstoy" };
		books[bookNo++] = new Book("b1", "War and Peace", 12.55, "The Russian Messenger", 1225, authors1);
		String[] authors2 = { "F. Scott Fitzgerald" };
		books[bookNo++] = new Book("b2", "The great gatsby", 10, "Charles Scribner's Sons", 180, authors2);
		String[] authors3 = { "Thomas H. Cormen", "Charles E. Leiserson", "Ronald L. Rivest", "Clifford Stein" };
		books[bookNo++] = new Book("b3", "Introduction to algorithms", 100, "MIT Press", 1312, authors3);

		// create new magazines
		magazines[magazineNo++] = new Magazine("m1", "Forbes", 8.99, "Forbes Media", 50, 201904);

		// create new applications
		apps[appNo++] = new Application("app1", "Pokemon", 5.3, "androidV4");
		apps[appNo++] = new Application("app2", "Mario", 5, "iOSV10");
		apps[appNo++] = new Application("app3", "Calendar", "androidV3");

		// create new customers
		customers[customerNo++] = new Customer("c1", "coolguy", "0412000", 400);
		customers[customerNo++] = new Customer("c2", "neversaynever", "0433191", 1000);
		customers[customerNo++] = new Customer("c3", "Hello 123", "0413456", 400);
		customers[customerNo++] = new Customer("c4", "Jackie Chan", "0417654");

		// Adding new admins
		admins[adminNo++] = new Admin("a1", "SuperBlack", "opensesame", 10);
		admins[adminNo++] = new Admin("a2", "Adele", "kitty123", 3);

		// add new applications to the shop
		shop.addContent(apps[0]);
		shop.addContent(apps[1]);
		shop.addContent(apps[2]);

		// add new publications to the shop
		shop.addContent(books[0]);
		shop.addContent(books[1]);
		shop.addContent(books[2]);
		shop.addContent(magazines[0]);

		shop.addUser(customers[0]);
		shop.addUser(customers[1]);
		shop.addUser(customers[2]);
		shop.addUser(customers[3]);

		shop.addUser(admins[0]);
		shop.addUser(admins[1]);

		customers[1].changeName("neversaybye"); // change the user name
		admins[1].changeName("superblack"); // make the user name in lowercase

		comment[0] = new Comment(customers[0], "This is a fantastic game!");
		comment[1] = new Comment(customers[1], 5);
		comment[2] = new Comment(customers[2], 3, "This is an average game!");
		comment[3] = new Comment(customers[3], "I quite like this game!", 4);

		apps[0].addReview(comment[0]);
		apps[0].addReview(comment[1]);
		apps[0].addReview(comment[2]);
		apps[0].addReview(comment[3]);
		apps[1].addReview(new Comment(customers[3], "The game crashes frequently"));
		books[0].addReview(new Comment(customers[1], "I love Tolstoy!"));

	}

	private static void downloadContent() {
		customers[0].download(books[0]);
		customers[0].download(magazines[0]);

		Content[] list = { books[0], books[1], books[2], magazines[0], apps[0], apps[1], apps[2] };

		// download many items in one go
		customers[1].download(list);

		customers[2].becomePremium();
		customers[2].download(books[0]);
		customers[2].download(magazines[0]);

		shop.showDownloads();
	}

	private static void adminFunctionality() {

		sc.nextLine();
		
		// an admin can reset the price for an item
		books[0].setPrice(admins[0].login(), 14.25);
		
		// an admin with level > 5 bulk reduces all prices by 10%
		shop.setPrice(admins[0].login(), admins[0].getLevel(), -0.10);
	}
	
	private static void downloadsomething() {
		// Simulating transactions, showing content etc etc.
		// They can be driven by menu input as well.
		customers[0].download(books[0]);
		customers[0].download(books[2]);
		customers[0].download(magazines[0]);
		customers[1].download(magazines[0]);
		customers[2].download(magazines[0]);

		customers[2].becomePremium();
		customers[2].download(books[0]);
		customers[2].download(apps[0]);
		shop.showDownloads();

		customers[3].download(apps[1]);
		customers[3].becomePremium();
		customers[3].download(magazines[0]);
		shop.showDownloads();

		customers[customerNo++] = new Customer("c5", "neverenough", "0486734", 2000);
		Content[] list = { books[0], books[1], books[2], magazines[0], apps[0], apps[1], apps[2] };

		// download many items in one go
		customers[1].download(list);
		shop.showDownloads();
	}

	/**
	 * This method is used to exit from the application
	 * 
	 * @param sc Scanner class object to close the scanner before exiting from the
	 *           program
	 */
	private static void exitProgram(Scanner sc) {
		sc.close();
		System.out.println("Quitting...\nDone!");
		System.exit(0);
	}
}
