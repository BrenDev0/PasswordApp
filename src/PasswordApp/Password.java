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
		thesite.close();
		
		// Ask if a randomly generated password is needed, else receive password.
		System.out.print("Password Options.\n1 - Enter password manualy.\n2 - Generate a random password.\nEnter code here: ");
		
		// submit data to database 
	}
	
	// Generate a random Password
	
	// Submit password to database
	
	// Get password 
	
	// Set new password 

}
