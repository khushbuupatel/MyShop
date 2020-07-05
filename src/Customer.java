import java.util.ArrayList;

/**
 * Customer class extends abstract User class to provide implementation to
 * create new Customer objects and provide implementation to download particular
 * content, download contents in bulk, display downloads and upgrade customer to
 * premium type
 *
 */
public class Customer extends User {

	// variables to store Customer details
	private String phoneNo;
	private double amount;

	// variable to keep count of items downloaded by customer
	private int customerDownloads = 0;

	// arraylist to store names of content downloaded by customer
	private ArrayList<String> customerDownloadNames = new ArrayList<String>();

	// boolean variable to identify if the customer is Premium
	private boolean isPremium = false;

	/**
	 * Constructor to initialize new Customers objects with defaul account balance
	 * as 50.0
	 * 
	 * @param ID
	 * @param username
	 * @param phoneNo
	 */
	Customer(String ID, String username, String phoneNo) {
		this(ID, username, phoneNo, 50.0);
	}

	/**
	 * Constructor to initialize new Customers objects with custom amount
	 * 
	 * @param ID
	 * @param username
	 * @param phoneNo
	 * @param amount
	 */
	Customer(String ID, String username, String phoneNo, double amount) {
		super(ID, username);
		this.phoneNo = phoneNo;
		this.amount = amount;
	}

	/**
	 * This method displays details of Customer objects
	 */
	public void showUserDetails() {
		super.showUserDetails();
		System.out.println("Amount: " + this.amount);
		System.out.println("PhoneNo: " + this.phoneNo);
		System.out.println("----------------------------");
	}

	/**
	 * This method is used to download content for particular customer and updates
	 * its download count
	 * 
	 * @param itemToDownload Content type object to be downloaded for the customer
	 * 
	 * @return isDownloaded true if the Content is downloaded successfully
	 * 
	 */
	protected boolean download(Content itemToDownload) {

		// set return variable to false initially
		boolean isDownloaded = false;

		// provide 20% discount to Premium customers
		double itemPrice = isPremium ? itemToDownload.getItemPrice() * 0.2 : itemToDownload.getItemPrice();

		// check if customer has sufficient funds to download the item
		if (this.amount >= itemPrice) {

			// deduct the item price of the content to be downloaded from customer's balance
			this.amount -= itemPrice;

			// increment the customer download count by 1
			this.customerDownloads++;

			// increment particular content item download count by 1
			this.customerDownloadNames.add(itemToDownload.getName());
			itemToDownload.setItemDownload(itemToDownload.getItemDownloads() + 1);

			isDownloaded = true;
			System.out.println(itemToDownload.getName() + " is successfully downloaded by " + this.getUsername());

		} else {
			// if sufficient balance is not available print following message
			System.out.println(
					this.getUsername() + " doesn't have suffient amount to download " + itemToDownload.getName());
		}

		// return true if downloaded successfully
		return isDownloaded;
	}

	/**
	 * This method allows customers to download content items in bulk after
	 * performing necessary checks
	 * 
	 * @param itemsToDownload list of Content type objects
	 */
	protected void download(Content[] itemsToDownload) {

		// variable to store total item prices for the content item list
		double itemPrices = 0, itemPrice;

		// calculate total amount by summation of items prices to be downloaded
		for (Content item : itemsToDownload) {

			// calculate discounted price if the customer is Premium
			itemPrices += isPremium ? item.getItemPrice() * 0.2 : item.getItemPrice();
		}

		// check if the user has sufficient balance to bulk download
		if (itemPrices < this.amount) {

			// download each item from the list
			for (Content item : itemsToDownload) {

				// deduct the item price from the customer's balance
				itemPrice = isPremium ? item.getItemPrice() * 0.2 : item.getItemPrice();
				this.amount -= itemPrice;

				// increment the customer item download and content item downloads counts by 1
				this.customerDownloads++;
				item.setItemDownload(item.getItemDownloads() + 1);

				// add the content name in the customer
				this.customerDownloadNames.add(item.getName());
				
				// display the name of items downloaded
				System.out.println("-" + item.getName());
			}
			
			System.out.println("Successfully downloaded above items for customer: " + this.getUsername());
		} else {
			// display following message if customer has insufficient funds
			System.out.println(this.getUsername() + " doesn't have suffient amount to bulk download the item(s) ");
		}
	}

	/**
	 * This method displays downloads total download count and content names of
	 * items downloaded by the customer
	 */
	protected void showDownloads() {
		System.out.println("\n#" + this.getUsername() + " : " + this.customerDownloads + " download(s)");

		for (String contentName : this.customerDownloadNames) {
			System.out.println("-" + contentName);
		}
	}

	/**
	 * This methods upgrades a customer to premium at a 100$ cost after performing
	 * necessary checks
	 */
	protected void becomePremium() {

		// check if user has at least 100$ balance
		if (this.amount >= 100) {
			
			// deduct 100$ from customer's account
			this.amount -= 100;
			this.isPremium = true;

			System.out.println("\n" + this.getUsername() + " became a Premium customer!");
			System.out.println("Amount remaining after deduction of 100$: " + this.amount);

		} else {
			System.out.println("\n" + this.getUsername() + " doesn't have sufficient funds to become a premium member");
			System.out.println("Amount available: " + this.amount);
		}
	}

}
