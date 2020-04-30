import java.util.Scanner;

public class Admin extends User {

	private String password;
	private int level;

	Admin(String ID, String username, String password, int level) {
		super(ID, username);
		this.password = password;
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}

	protected boolean login() {
		Scanner sc = new Scanner(System.in);

		String userInput;
		boolean isLogin = false;

		System.out.println("Add your password: ");
		userInput = sc.next();

		if (userInput.equals(this.password))
			isLogin = true;

		return isLogin;
	}
}
