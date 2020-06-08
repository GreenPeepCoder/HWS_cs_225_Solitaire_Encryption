/**
 * @author williambrooksmiller
 */
public class EncoderTester {

	/**
	 * @param args
	 */
	public static void main ( String[] args ) {
		// TODO Auto-generated method stub

		System.out.println("The letter form of 13 is: ");
		System.out.println("    expected output: M");
		System.out.print("    actual output:     " + convertToString(13));
		String passphrase = "SECRET KEY";

		String encodedM =
		    SolitaireEncoder.encrypt("you'll never guess this message!",passphrase,
		                             26);
		System.out.println("encrypt: 'you'll never guess this message'");
		System.out.println("     expected output: UKTUMUXRMOSPGVWSADBUHPJSFC");
		System.out.println("     actual output:     " + encodedM);

		System.out.println();
		String decodedM = SolitaireEncoder.decrypt(encodedM,passphrase,26);
		System.out.println("Encrypted message: " + encodedM);
		System.out.println("After decryption: ");
		System.out.println("     expected output: YOULLNEVERGUESSTHISMESSAGE");
		System.out.println("     actual output:     " + decodedM);
	}

	/**
	 * Convert an int value to a letter
	 * 
	 * @param sum
	 *          the int to convert to a letter - must be between 1 and 26
	 *          inclusive
	 * @return the letter conversion of the given int
	 */
	public static String convertToString ( int sum ) {

		if ( sum < 1 || sum > 26 ) {
			throw new IllegalArgumentException(
			                                   "Tried to convert an invalid int to letter."
			                                       + " int should be between 1 and 26 inclusive. Current int: "
			                                       + sum);
		}

		return String.valueOf((char) (sum + 64));

	}
}
