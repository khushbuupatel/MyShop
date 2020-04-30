
public class User {

	protected String ID, username;

	User(String ID, String username) {
		this.ID = ID;
		this.username = username;
	}

	protected void showUserDetails() {
		System.out.println("Username: " + this.username + " User ID: " + this.ID);
	}

	protected void changeName(String newUsername) {
		this.username = newUsername;
	}
	
}
