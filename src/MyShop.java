import java.util.ArrayList;

public class MyShop {

	// array list to store content objects
	private ArrayList<Content> contents = new ArrayList<Content>();

	// array list to store users objects
	private ArrayList<User> users = new ArrayList<User>();

	protected void addContent(Content content) {
		// add the content into your content list
		contents.add(content);
	}

	protected void showContent() {

		if (contents.size() <= 0) {
			System.out.println("No contents are available to display");
		} else {

			System.out.println("Following are the available contents: ");

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

	protected void addUser(User user) {
		// add the user to your list of users
		users.add(user);
	}

	protected void showUser() {
		if (users.size() <= 0) {
			System.out.println("No users available!");
		} else {

			System.out.println("Following users found: ");

			for (User user : users) {
				user.showUserDetails();
			}
		}
	}

	// possible methods here
	protected void showAllReviews() {
		System.out.println("\nComments for Applications, Books and Magazines!\n");
		for (Content content : contents) {
			if (!content.itemComments.isEmpty())
				content.showReviews();
		}
	}

	protected void showDownloads() {
		System.out.println("**** Total downloads ****");
		for (Content content : contents) {
			if (content.itemDownloads > 0)
				content.showDownloads();
		}
	}

	protected void setPrice(boolean isAdmin, int level, double price) {
		if (isAdmin && level > 5) {

			for (Content content : contents) {
				content.price = (price <= 0) && (content.price <= Math.abs(price)) ? 0.0 : content.price + price;
			}
			System.out.println("Prices of all the items have been updated!\n");

		} else
			System.out.println("You are not allowed to change the prices of the contents");
	}
}