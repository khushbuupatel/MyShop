
public class User {

	private String userID, username;

	User(String ID, String username) {
		this.userID = ID;
		this.username = username;
	}

	protected void changeName(String newUsername) {
		this.username = newUsername;
	}
	
	public String getUserID() {
		return this.userID;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	protected void showUserDetails() {
		System.out.println("-> Username: " + this.username + "\n   User ID: " + this.userID);
	}
}
