package PasswordApp;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

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
				System.out.print(generateRandomPassword());
				break;
			default:
				break;
		}
		
		
		// submit data to database 
	}
	
	//
	
	// Generate a random Password
	private String generateRandomPassword() {
		System.out.print("How many characters must the password contain(min 8 characters): ");
		Scanner lengthIn = new Scanner(System.in);
		int passwordLength = lengthIn.nextInt();
		char[] randomPassword = new char[passwordLength];
		String uppercase = "ABCDEFGHIJKLMNOPQRZTUVWXYZ";
		String lowercase = "abcdefghijklmnopqrstuvwxyz";
		String nums = "0123456789";
		String specialChars = "!@#$%^&*";
		String passwordSet = uppercase + lowercase + nums + specialChars;
		// fill the array with random characters
		for(int i = 0; i < passwordLength; i++) {
			int randomChar = (int) (Math.random() * passwordSet.length());
			randomPassword[i] = passwordSet.charAt(randomChar);
		}
		
		// password requirements
		Pattern uppercaseChar = Pattern.compile("[A-Z]");
		Pattern number = Pattern.compile("[0-9]");
		Pattern symbols = Pattern.compile("[^a-zA-Z0-9]");
		
		
		// check to see if all requirements are present, if not insert them
		Matcher uppercaseRe = uppercaseChar.matcher(new String(randomPassword));
		if (!uppercaseRe.find()) {
			int randomIndex = (int) (Math.random() * passwordLength);
			int randomUppercaseChar = (int) (Math.random() * uppercase.length());
			
			randomPassword[randomIndex] = uppercase.charAt(randomUppercaseChar);
		}
		
		Matcher numberRe = number.matcher(new String(randomPassword));
		if (!numberRe.find()) {
			int randomIndex = (int) (Math.random() * passwordLength);
			int randomNum = (int) (Math.random() * nums.length());
			
			randomPassword[randomIndex] = nums.charAt(randomNum);
		}
		
		Matcher symbolsRe = symbols.matcher(new String(randomPassword));
		if (!symbolsRe.find()) {
			int randomIndex = (int) (Math.random() * passwordLength);
			int randomSymbol = (int) (Math.random() * specialChars.length());
			
			randomPassword[randomIndex] = specialChars.charAt(randomSymbol);
		}
		//return password to user 
		return "Password For " + this.site + " is: " + new String(randomPassword);
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
