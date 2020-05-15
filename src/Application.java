
public class Application extends Content {

	private String osType;

	Application(String ID, String name, String os) {
		this(ID, name, 0.0, os);
	}

	Application(String ID, String name, double price, String os) {
		super(ID, name, price);
		this.osType = os;
	}

	protected void showItemDetails() {
		System.out.println("****** Application ID: " + this.getID() + " ******");
		super.showItemDetails();
		System.out.println("Operating System: " + this.osType);
		System.out.println("-----------------------------------\n");
	}

}
