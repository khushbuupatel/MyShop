
//Add the packages that you need, e.g.
import java.util.Hashtable;
import java.util.ArrayList;

public class MyShop {

	// Instance variables that you need.
	// Declare a private variable (array or similar) to store your Content objects
	// here
	private ArrayList<Content> contents = new ArrayList<Content>();

	// Declare a private variable (array or similar) to store your User objects here
	private ArrayList<User> users = new ArrayList<User>();

	public MyShop() {
		// any code you need here
	}

	public void addContent(Content content) {
		// add the content into your content list
		contents.add(content);
	}

	public void showContent() {

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

	public void addUser(User user) {
		// add the user to your list of users
		users.add(user);
	}

	public void showUser() {
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

		} else
			System.out.println("You are not allowed to change the prices of the contents");
	}
}