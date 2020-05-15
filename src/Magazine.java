
public class Magazine extends Publication{

	private double volume;
	
	Magazine(String ID, String name, double price, String publisher, int noOfPages, double volume) {
		super(ID, name, price, publisher, noOfPages);
		this.volume = volume;
	}
	
	public void showItemDetails() {
		System.out.println("****** Magazine ID: " + this.getID() + " ******");
		super.showItemDetails();
		System.out.println("Volume: " + this.volume);
		System.out.println("-----------------------------------\n");
	}
}
