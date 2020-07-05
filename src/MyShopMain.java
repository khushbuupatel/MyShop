import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Till HD Level is implemented.
 * 
 * MyShopMain is an online shop CLI application which allows users to download
 * mobile applications (APPs) and publications like e-books and digital
 * magazines. Applications and publication items in the MyShop are either free
 * or can be bought for a price.
 * 
 * @author Khushbu Manojkumar Patel (s3823274)
 *
 */
public class MyShopMain {

	static MyShop shop;

	// array to store objects of Content and User type object
	static Content[] apps = new Application[100];
	static Content[] books = new Book[100];
	static Content[] magazines = new Magazine[100];
	static Comment[] comment = new Comment[100];
	static Customer[] customers = new Customer[100];
	static Admin[] admins = new Admin[100];

	// index variables to create new objects of different classes
	static int appNo = 0, bookNo = 0, magazineNo = 0, customerNo = 0, adminNo = 0;

	// object of Scanner class to take keyboard input from user
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// variable to store the option selected by the user from main menu
		int selectedOption = 0;

		// create an object of class MyShop
		shop = new MyShop();

		// load the contents required to test different functionalities
		loadContents();

		// variable to store the main menu items
		String[] menuContent = { "1.Show content", "2.Add content", "3.Show users", "4.Add users", "5.Change username",
				"6.Show particular item reviews", "7.Show all reviews", "8.Download content",
				"9.Show customer downloads", "10.Show item downloads", "11.Show all downloads in shop", "12. Become premium customer",
				"13.Show admin functionalities", "14.Quit" };

		// do while loop to display the menu to user until the user selects to quit
		do {

			System.out.println("\nPlease select one of the following options:");

			// display the menu to the user
			for (String menuItem : menuContent) {
				System.out.println(menuItem);
			}

			try {
				// taking the keyboard in try-catch block to handle exceptions like Input
				// Mismatch
				selectedOption = sc.nextInt();

				// switch case to implement functionality based on option selected by user
				switch (selectedOption) {
				case 1:
					// displays all the contents of the shop
					shop.showContent();
					break;
				case 2:
					// allows users to add new Application, Books and Magazines
					addItem();
					break;
				case 3:
					// displays all the users of the MyShop
					shop.showUsers();
					break;
				case 4:
					// allows to add new Customers or Admins
					addUser();
					break;
				case 5:
					// changes the username of the customer and admin
					System.out.print("Username '" + customers[1].getUsername() + "'");
					customers[1].changeName("neversaybye");
					System.out.println(" successfully changed to :" + customers[1].getUsername());

					System.out.print("Username '" + admins[1].getUsername() + "'");
					admins[1].changeName("superblack");
					System.out.println(" successfully changed to :" + admins[1].getUsername());
					break;
				case 6:
					// shows reviews for particular items
					apps[0].showReviews();
					books[0].showReviews();
					break;
				case 7:
					// displays all the reviews for all the contents of MyShop
					shop.showAllReviews();
					break;
				case 8:
					// downloads different Contents
					downloadContent();
					break;
				case 9:
					// displays downloads of a particular customer
					System.out.println("\n******* Customer Downloads *******");
					System.out.println("Note: If 0 downloads are there then please select option 8 to first download the content");
					customers[0].showDownloads();
					customers[1].showDownloads();
					break;
				case 10:
					// displays downloads of a particular item
					System.out.println("\n******* Item Downloads *******");
					apps[0].showDownloads();
					books[0].showDownloads();
					magazines[0].showDownloads();
					break;
				case 11:
					// displays downloads for all the contents of the shop
					System.out.println("\n******* All Downloads *******");
					shop.showDownloads();
					break;
				case 12:
					// upgrades a customer to Premium customer
					customers[2].becomePremium();
					// customer[3] doesn't have sufficient fund to become a premium customer
					customers[3].becomePremium();
					break;
				case 13:
					// implements different admin functionality
					adminFunctionality();
					break;
				case 14:
					// exits from the program
					exitProgram(sc);
				default:
					// shows an error message to user to select a valid option
					System.out.println("Please select a valid option");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid input entered! Please add the item again. ");

				// read the non numeric input entered by the user so that next
				// int(selectedOption) can be read
				sc.nextLine();
			}

			// displays the menu after every step performed until the end user selects to
			// exit from the program (i.e Option 13)
		} while (selectedOption != 14);

	}

	/**
	 * This method is used to add new contents like Application, Book or magazine to
	 * MyShop by taking keyboard input from user
	 * 
	 * @throws InputMismatchException
	 */
	static private void addItem() throws InputMismatchException {

		// variable to take input from user
		int itemType;
		// variable to store Item menu contents
		String[] itemContent = { "1.Application", "2.Book", "3.Magazine" };

		// display the menu
		System.out.println("Please select one of the following items to add:");
		for (String item : itemContent) {
			System.out.println(item);
		}

		// take input from user
		itemType = sc.nextInt();
		// read the ENTER character entered by user after entering the Item menu type
		// (itemType)
		sc.nextLine();

		switch (itemType) {
		case 1:
			// add new Application to MyShop
			apps[appNo] = addItemDetails(itemType);
			shop.addContent(apps[appNo++]);
			System.out.println("\nNew application is added!\nPlease select Show Content to display the newly added application.");
			break;
		case 2:
			// add new Book to MyShop
			books[bookNo] = addItemDetails(itemType);
			shop.addContent(books[bookNo++]);
			System.out.println("\nNew book is added!\nPlease select Show Content to display the newly added book.");
			break;
		case 3:
			// add new Magazine to MyShop
			magazines[magazineNo] = addItemDetails(itemType);
			shop.addContent(magazines[magazineNo++]);
			System.out.println("\nNew magazine is added!\nPlease select Show Content to display the newly added magazine.");
			break;
		default:
			// display error message if invalid no entered by user
			System.out.println("Not a valid item!\n");
			break;
		}
	}

	/**
	 * This method is used to ask details to users for different content types like
	 * Application, Books and magazines
	 * 
	 * @param itemType (1 = Application, 2 = Book, 3 = Magazine)
	 * 
	 * @return Content Content type object based on the new item added
	 * 
	 * @throws InputMismatchException
	 */
	private static Content addItemDetails(int itemType) throws InputMismatchException {

		// variables to store details of different Content type objects
		String ID, name, osType, publisher, author;
		int noOfPages, noOfAuthors;
		double price, volume;
		String[] authors;

		// variable to return the Content object created
		Content content;

		// take input for details that are common for all the 3 Content type objects
		System.out.print("Enter ID for the Item: ");
		ID = sc.nextLine();
		System.out.print("Enter Name for the Item: ");
		name = sc.nextLine();
		System.out.print("Enter Price for the Item (Add '0.0' if free): ");
		price = sc.nextDouble();
		sc.nextLine();

		if (itemType == 1) {
			// ask for OS version if item to be added is Application
			System.out.print("Enter minimum OS Type required for the Application: ");
			osType = sc.nextLine();

			// create new Application object
			content = new Application(ID, name, price, osType);

		} else {

			// ask for Publisher and No of pages for Books and Magazines
			System.out.print("Please enter the Publisher: ");
			publisher = sc.nextLine();
			System.out.print("Please enter no of pages: ");
			noOfPages = sc.nextInt();

			if (itemType == 2) {

				// ask for No of authors if the item to be added is Book
				System.out.print("Please enter no of authors for this book:");
				noOfAuthors = sc.nextInt();

				// initialize the author array based on the above input
				authors = new String[noOfAuthors];
				sc.nextLine();

				// ask for Name of authors
				for (int i = 0; i < noOfAuthors; i++) {
					System.out.print("Please enter Author no " + (i + 1) + ": ");
					author = sc.nextLine();
					authors[i] = author;
				}

				// create new Book object based on details entered by user
				content = new Book(ID, name, price, publisher, noOfPages, authors);
			} else {

				// ask for Volume of magazine if item to be added is Magazine
				System.out.print("Please enter volume for magazine: ");
				volume = sc.nextDouble();

				// create new Magazine object
				content = new Magazine(ID, name, price, publisher, noOfPages, volume);
			}
		}

		// return the new Content type object created
		return content;
	}

	/**
	 * This method is used to ask input from End-user to create new Users
	 * 
	 * @throws InputMismatchException
	 */
	private static void addUser() throws InputMismatchException {

		// variable to store type of User to be entered by end-user and the menu
		int userType;
		String[] userTypes = { "1.New user", "2.Become a member", "3.Admin" };

		// variable to store the new User type object i.e. Customer of Admin
		User user;

		System.out.println("Select the user type: ");

		// display the User menu
		for (String type : userTypes)
			System.out.println(type);

		// take keyboard input from end user
		userType = sc.nextInt();
		sc.nextLine();

		// call method to get User details from end-user
		user = addUserDetails(userType);

		// add User to the MyShop class
		shop.addUser(user);
	}

	/**
	 * This method takes keyboard input from end user to add new Customers and
	 * Admins
	 * 
	 * @param userType (1 = New customer, 2 = New member, 3 = Admin)
	 * 
	 * @return User returns new User type object created
	 * 
	 * @throws InputMismatchException
	 */
	private static User addUserDetails(int userType) throws InputMismatchException {

		// variables to store details of new users to be added
		String ID, username, phoneNo, password;
		int level;
		double amount;

		User user;

		// ask for details common to both Customer and Admin type user
		System.out.println("Please enter your user ID: ");
		ID = sc.nextLine();
		System.out.println("Please enter your username: ");
		username = sc.nextLine();

		if (userType == 3) {

			// ask for details to be entered for Admins
			System.out.println("Please enter your password: ");
			password = sc.nextLine();
			System.out.println("Please enter your level: ");
			level = sc.nextInt();

			// add new Admin to the MyShop
			user = new Admin(ID, username, password, level);
			System.out.println("New Admin user added: " + username + "\n");

		} else {

			// ask for details specific to Customer type User object
			System.out.println("Please enter your Phone no: ");
			phoneNo = sc.nextLine();

			if (userType == 2) {

				// ask for amount to be added for the new customer
				System.out.println("Please enter the amount to be added: ");
				amount = sc.nextInt();

				// add the customer to MyShop
				user = new Customer(ID, username, phoneNo, amount);
				System.out.println("New customer added: " + username + "\n");
			} else {
				// add the customer to MyShop (default amount will be added i.e 50.0)
				user = new Customer(ID, username, phoneNo);
				System.out.println("New customer added: " + username + "\n");
			}
		}

		// return the new User object that is created
		return user;
	}

	/**
	 * This method creates new Applications, Books, Magazines and Customers objects
	 * to test various functionalities of MyShopMain java application
	 */
	static private void loadContents() {

		// create new applications
		apps[appNo++] = new Application("app1", "Pokemon", 5.3, "androidV4");
		apps[appNo++] = new Application("app2", "Mario", 5, "iOSV10");
		apps[appNo++] = new Application("app3", "Calendar", "androidV3");

		// create new publications
		String[] authors1 = { "L. Tolstoy" };
		books[bookNo++] = new Book("b1", "War and Peace", 12.55, "The Russian Messenger", 1225, authors1);
		String[] authors2 = { "F. Scott Fitzgerald" };
		books[bookNo++] = new Book("b2", "The great gatsby", 10, "Charles Scribner's Sons", 180, authors2);
		String[] authors3 = { "Thomas H. Cormen", "Charles E. Leiserson", "Ronald L. Rivest", "Clifford Stein" };
		books[bookNo++] = new Book("b3", "Introduction to algorithms", 100, "MIT Press", 1312, authors3);

		// create new magazines
		magazines[magazineNo++] = new Magazine("m1", "Forbes", 8.99, "Forbes Media", 50, 201904);

		// create new customers
		customers[customerNo++] = new Customer("c1", "coolguy", "0412000", 400);
		customers[customerNo++] = new Customer("c2", "neversaynever", "0433191", 1000);
		customers[customerNo++] = new Customer("c3", "Hello 123", "0413456", 400);
		customers[customerNo++] = new Customer("c4", "Jackie Chan", "0417654");

		// create new admins
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

		// add new customers to the shop
		shop.addUser(customers[0]);
		shop.addUser(customers[1]);
		shop.addUser(customers[2]);
		shop.addUser(customers[3]);

		// add new admins to the shop
		shop.addUser(admins[0]);
		shop.addUser(admins[1]);

		// create new Comment objects with Ratings and comment messages
		comment[0] = new Comment(customers[0], "This is a fantastic game!");
		comment[1] = new Comment(customers[1], 5);
		comment[2] = new Comment(customers[2], 3, "This is an average game!");
		comment[3] = new Comment(customers[3], "I quite like this game!", 4);

		// add reviews to different Contents
		apps[0].addReview(comment[0]);
		apps[0].addReview(comment[1]);
		apps[0].addReview(comment[2]);
		apps[0].addReview(comment[3]);
		apps[1].addReview(new Comment(customers[3], "The game crashes frequently"));
		books[0].addReview(new Comment(customers[1], "I love Tolstoy!"));

	}

	/**
	 * This method is used to download different contents for different customers.
	 * It also allows customers to downloads contents in bulk.
	 */
	private static void downloadContent() {

		// download single item at a time for different Customers
		customers[0].download(books[0]);
		customers[0].download(magazines[0]);

		customers[2].download(books[0]);
		customers[2].download(magazines[0]);

		customers[3].download(apps[1]);
		customers[3].becomePremium();
		customers[3].download(magazines[0]);

		// download many items in one go
		System.out.println("\nBulk Download: ");

		Content[] contentList = { books[0], books[1], books[2], magazines[0], apps[0], apps[1], apps[2] };
		customers[1].download(contentList);

	}

	/**
	 * This method is used to test the Admin functionalities.
	 */
	private static void adminFunctionality() {

		// read the space input (ENTER added after taking menu input from user)
		sc.nextLine();

		// admin[0] Username: "SuperBlack" Password: "opensesame"
		// admin[1] Ussername: "Adele" password: "kitty123"
		System.out.println("***The following code demonstrates the single item price update functionality.\n***");
		
		// an admin can reset the price for an item
		books[0].setPrice(admins[0].login(), 14.25);
		magazines[0].setPrice(admins[1].login(), 10);

		System.out.println("***The following code demonstrates the bulk price update functionality.\n***");
		
		// an admin with level > 5 bulk reduces all prices by 10%
		shop.setPrice(admins[0].login(), admins[0].getLevel(), -0.10);

		// an admin with level <=5 is refused to update content prices in bulk
		shop.setPrice(admins[1].login(), admins[1].getLevel(), -0.10);
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
