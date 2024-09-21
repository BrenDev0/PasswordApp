package PasswordApp;
import java.util.Scanner;

public class Password {
	private String password;
	private String site;
	
	
	// constructor
	public Password() {
		// ask for the site that the password is needed
		System.out.print("Enter the site where this password is needed: ");
		Scanner thesite = new Scanner(System.in);
		this.site = thesite.nextLine();
		
		
		// Ask if a randomly generated password is needed, else receive password.
		System.out.print("Password Options.\n1 - Enter password manualy.\n2 - Generate a random password.\nEnter code here: ");
		Scanner  in = new Scanner(System.in);
		int passwordOption = in.nextInt();
		
		switch(passwordOption) {
			case 1:
				enterPassword();
				break;
			case 2:
				generateRandomPassword();
				break;
			default:
				break;
		}
		
		
		// submit data to database 
	}
	
	//
	
	// Generate a random Password
	private String generateRandomPassword() {
		return "";
	}
	
	// Submit password to database
	
	// Get password 
	
	// enter a  password
	private void enterPassword() {
		// Get password from user 
		String enteredPassword;
		System.out.print("Enter a password: ");
		Scanner firstInput = new Scanner(System.in);
		enteredPassword = firstInput.nextLine();
		
		
		// Verify the password before setting
		System.out.print("Enter password again: ");
		Scanner verifyPassword = new Scanner(System.in);
		String verifiedPassword = verifyPassword.nextLine();
		
		if (verifiedPassword.equals(enteredPassword)) {
			this.password = enteredPassword;
			System.out.println("Password accepted!");
			verifyPassword.close();
		} else {
			System.out.println("Passwords did not match try again...");
			enterPassword();
		}
			
	}
	
	
	// 

}
