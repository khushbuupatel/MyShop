
public class Customer extends User {

	private String phoneNo;
	private double amount;
	private int customerDownloads = 0;
	private boolean isPremium = false;

	Customer(String ID, String username, String phoneNo) {
		this(ID, username, phoneNo, 50.0);
	}

	Customer(String ID, String username, String phoneNo, double amount) {
		super(ID, username);
		this.phoneNo = phoneNo;
		this.amount = amount;
	}

	protected boolean download(Content itemToDownload) {
		boolean isDownloaded = false;

		double itemPrice = isPremium ? itemToDownload.price * 0.2 : itemToDownload.price;

		if (this.amount >= itemPrice) {
			this.amount -= itemPrice;
			this.customerDownloads++;
			itemToDownload.itemDownloads++;
			isDownloaded = true;
		} else {
			System.out.println(this.getUsername() + " doesn't have suffient amount to download " + itemToDownload.getName());
		}

		return isDownloaded;
	}

	protected void download(Content[] itemsToDownload) {

		double itemPrices = 0;

		for (Content item : itemsToDownload)
			itemPrices += item.price;

		if (itemPrices < this.amount) {
			for (Content item : itemsToDownload) {
				double itemPrice = isPremium ? item.price * 0.2 : item.price;
				this.amount -= itemPrice;
				this.customerDownloads++;
				item.itemDownloads++;
			}
		} else
			System.out.println(this.getUsername() + " doesn't have suffient amount to download the item(s) ");
	}

	protected void showDownloads() {
		System.out.println("\nTotal downloads by customer '" + this.getUsername() + "' are " + this.customerDownloads + "\n");
	}

	protected void becomePremium() {

		if (this.amount >= 100) {
			this.amount -= 100;
			this.isPremium = true;
		} else {
			System.out.println(this.getUsername() + " doesn't have sufficient funds to become a premium member");
		}
	}

}
