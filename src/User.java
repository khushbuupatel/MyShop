/**
 * Abstract User class to provide implementation for Customer and Admin classes
 *
 */
public abstract class User {

	// variabls to store user details
	private String userID, username;

	/**
	 * Constructor to initialize user type object
	 * 
	 * @param ID
	 * @param username
	 */
	User(String ID, String username) {
		this.userID = ID;
		this.username = username;
	}

	/**
	 * This method is used to change the username of the user
	 * 
	 * @param newUsername new username
	 */
	protected void changeName(String newUsername) {
		this.username = newUsername;
	}

	/**
	 * This method returns the ID of the user
	 * 
	 * @return userID
	 */
	public String getUserID() {
		return this.userID;
	}

	/**
	 * This method returns the username of the user
	 * 
	 * @return username
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * This method displays the user details
	 */
	protected void showUserDetails() {
		System.out.println("******* ID: " + this.userID + " ******* ");
		System.out.println("Username: " + this.username);
	}
}
