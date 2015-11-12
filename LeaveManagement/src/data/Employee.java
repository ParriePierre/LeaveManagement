package data;

/**
 * Represents the employee. An employee is a first and last name, a login and a password
 * @author parrie
 *
 */
public class Employee {
	
	private String FirstName;
	private String LastName;
	
	private String Login;
	private String Password;
	
	public Employee(String firstName, String lastName, String login,
			String password) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Login = login;
		Password = password;
	}

	public String getFirstName() {
		return FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public String getLogin() {
		return Login;
	}
	
	/**
	 * Checks the password
	 * @param password Input password
	 * @return True if input password equals to stored password, else false.
	 */
	protected Boolean checkPassword(String password) {
		if(Password.equals(password))
			return true;
		else
		{
			System.err.println("Wrong password.");
			return false;
		}
	}
}
