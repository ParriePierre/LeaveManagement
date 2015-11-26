package model;

import java.util.ArrayList;

/**
 * Employes stores an array of Employee. It may add an employee or check a password
 * @author parrie
 *
 */
public class Employes {
	
	private ArrayList<Employee> employes;

	public Employes() {
		employes = new ArrayList<Employee>();
		
		addEmployee("P", "L", "test", "test");
	}
	
	/**
	 * Instantiate a new employee and add it to the list
	 * @param FirstName First name of the employee
	 * @param LastName Last name of the employee
	 * @param Login Login chosen by the employee
	 * @param Password Password chose by the employee
	 */
	public void addEmployee(String FirstName, String LastName, String Login, String Password) {
		Employee person = new Employee(FirstName, LastName, Login, Password);
		employes.add(person);
	}
	
	/**
	 * Go through the list of account and check the password once the account is found. Return true if the password is correct.
	 * @param Login Login of the employee
	 * @param Password Password of the employee
	 * @return Returns true if the password is correct, false is the password is wrong or the login doesn't exists 
	 */
	public Boolean checkCredentials(String Login,String Password) {
		
		Employee e = getEmployee(Login);
		
		if(e != null){
			if(e.checkPassword(Password))
				return true;
		}
		return false;
	}
	
	/**
	 * Go through Employes list to get an employee
	 * @param Login The login of the employee to look for
	 * @return The employee object or null
	 */
	public Employee getEmployee(String Login) {
		if(!employes.isEmpty()){
			for (Employee e : employes) {
				if(e.getLogin().equals(Login))
					return e;
			}
		}
		return null;
	}
}
