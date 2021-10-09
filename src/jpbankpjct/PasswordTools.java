package jpbankpjct;

public class PasswordTools {
	


	public static String[] generate(String freshPass)
	{

		//        String myPassword = freshPass;


		// Generate Salt. The generated value can be stored in DB.
		String salt = PasswordUtils.getSalt(30);

		// Protect user's password. The generated value can be stored in DB.
		String encrypted = PasswordUtils.generateSecurePassword(freshPass, salt);
		String combo[] = {salt,encrypted};

		// Print out protected password
		//        System.out.println("My secure password = " + mySecurePassword);
		//        System.out.println("Salt value = " + salt);
		return combo;

	}

	public static Boolean verify(String savedPass, String passwordSalt, String inputPassword) {

		Boolean passwordMatch = PasswordUtils.verifyUserPassword(inputPassword, savedPass, passwordSalt);

		return passwordMatch;
	}

	static Boolean verify(String encrytedPass, String existEncrytedPass) {

		Boolean passwordMatch = encrytedPass.equalsIgnoreCase(existEncrytedPass);

		return passwordMatch;
	}


}
