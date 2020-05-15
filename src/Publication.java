
public class Publication extends Content{

	private String publisher;
	private int noOfPages;
	
	Publication(String ID, String name, double price, String publisher, int noOfPages) {
		super(ID, name, price);
		this.publisher = publisher;
		this.noOfPages = noOfPages;
	}
	
	public void showItemDetails() {
		super.showItemDetails();
		System.out.println("Publisher: " + this.publisher);
		System.out.println("No of Pages: " + this.noOfPages);
	}
	
}
