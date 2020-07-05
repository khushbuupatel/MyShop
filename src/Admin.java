/**
 * Admin class extends abstract User class and provides implementation for
 * methods for login functionality, display Admin details and level of admin
 *
 */
public class Admin extends User {

	// variable to store Admin user details
	private String password;
	private int level;

	/**
	 * Constructor to initialize Admin objects
	 * 
	 * @param ID
	 * @param username
	 * @param password
	 * @param level
	 */
	Admin(String ID, String username, String password, int level) {
		super(ID, username);
		this.password = password;
		this.level = level;
	}

	/**
	 * This method displays the Admin details
	 */
	public void showUserDetails() {
		super.showUserDetails();

		System.out.println("Level: " + this.level);
		System.out.println("----------------------------");
	}

	/**
	 * This method returns the level of admin
	 * 
	 * @return level
	 */
	public int getLevel() {
		return this.level;
	}

	/**
	 * This method takes keyboard input to enter password for Admin and true if
	 * password is correct, else false.
	 * 
	 * @return isLogin true is login is successful
	 */
	protected boolean login() {

		// variable to store user input and boolean return variable
		String userInput;
		boolean isLogin = false;

		System.out.println( this.getUsername() + " please enter your password to change the price");

		// ask user to enter admin password
		System.out.println("Password: ");
		userInput = MyShopMain.sc.nextLine();

		// return true if password is correct
		if (userInput.equals(this.password))
			isLogin = true;

		return isLogin;
	}
}
