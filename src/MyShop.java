import java.util.ArrayList;

/**
 * MyShop class provides implementation methods to add contents, add users,
 * display contents, display users, display reviews for items, displays
 * downloads and set prices for content
 *
 */
public class MyShop {

	// array list to store content objects
	private ArrayList<Content> contents = new ArrayList<Content>();

	// array list to store users objects
	private ArrayList<User> users = new ArrayList<User>();

	/**
	 * This method add new items to MyShop
	 * 
	 * @param content item of Content type object to be added
	 */
	protected void addContent(Content content) {
		// add new item into array list of Content type
		contents.add(content);
	}

	/**
	 * This method displays all the contents available in MyShop
	 */
	protected void showContent() {

		if (contents.size() <= 0) {
			System.out.println("No contents are available to display");
		} else {

			System.out.println("Following contents are available: \n");

			// display details specific to different Content type object
			for (Content item : contents) {
				if (item instanceof Application) {
					item.showItemDetails();
				} else if (item instanceof Book) {
					item.showItemDetails();
				} else {
					item.showItemDetails();
				}
			}
		}
	}

	/**
	 * This method is used to add users to MyShop
	 * 
	 * @param user
	 */
	protected void addUser(User user) {
		// add the user to array list of User object
		users.add(user);
	}

	/**
	 * This method displays users of MyShop
	 */
	protected void showUsers() {
		if (users.size() <= 0) {
			System.out.println("No users available!");
		} else {

			System.out.println("Following users found: ");

			// print Customers of MyShop
			System.out.println("\n# CUSTOMERS #\n");
			for (User user : users) {
				if (user instanceof Customer)
					user.showUserDetails();
			}

			// print Admins of MyShop
			System.out.println("\n# ADMINS #\n");
			for (User user : users) {
				if (user instanceof Admin)
					user.showUserDetails();
			}
		}
	}

	/**
	 * This method displays the reviews for all the contents of MyShop
	 */
	protected void showAllReviews() {
		System.out.println("\nComments for Applications, Books and Magazines!\n");

		// loop through all content of MyShop
		for (Content content : contents) {

			// display the reviews if present for particular item
			if (!content.itemComments.isEmpty())
				content.showReviews();
		}
	}

	/**
	 * This method displays the no of downloads for each content of MyShop
	 */
	protected void showDownloads() {
		System.out.println("\nNote: If no contents are downloaded then please "
				+ "select option 7 to first download the contents");

		// display total downloads for each content that has been download by any user
		for (Content content : contents) {
			if (content.getItemDownloads() > 0)
				content.showDownloads();
		}
	}

	/**
	 * This method is used to update price in bulk for all the contents of MyShop if
	 * the admin level is > 5
	 * 
	 * @param isAdmin boolean indicating if he/she is a Admin ()
	 * @param level   level of the admin
	 * @param price   updated price for the contents of MyShop
	 */
	protected void setPrice(boolean isAdmin, int level, double price) {
		double itemPrice;

		// checks if the password is correct and that level is >5
		if (isAdmin && level > 5) {

			// price for each and every content of MyShop is updated
			for (Content content : contents) {

				// this will check if price is to be deducted than it should not go below 0.0
				// and if price is to be added than it directly adds the price to original price
				itemPrice = (price <= 0) && (content.getItemPrice() <= Math.abs(price)) ? 0.0
						: content.getItemPrice() + price;

				// set the price
				content.setItemPrice(itemPrice);
			}
			System.out.println("Prices of all the items have been updated!\n");

		// if the admin level <=5 than display the following message
		} else
			System.out.println(
					"You are not allowed to change the prices of the contents in bulk as admin level is less than 5");
	}
}