/**
 * @author williambrooksmiller
 */
public class SolitaireEncoder {

	/**
	 * @param message
	 *          the message to be encrypted
	 * @param passphrase
	 *          the phrase used to key the deck before encryption
	 * @param deckSize
	 *          the number of cards in the deck, not including 2 jokers
	 * @return the encrypted message of the given message
	 */
	public static String encrypt ( String message, String passphrase, int deckSize ) {

		KeystreamGenerator keystreamGen = new KeystreamGenerator(deckSize);
		keystreamGen.key(passphrase);
		String encryptedMessage = "";

		for ( int i = 0 ; i < message.length() ; i++ ) {

			char current = Character.toLowerCase(message.charAt(i));

			if ( Character.isLetter(current) ) {

				int charNum = Character.getNumericValue(current) - 9;

				int nextKeystreamValue = keystreamGen.nextKeystreamValue();
				int sum = nextKeystreamValue + charNum;
				if ( sum > 26 ) {
					sum = sum - 26;
				}
				assert sum >= 1 && sum <= 26 : "encryption sum is invalid. "
				    + "Should be between 1 and 26. Current sum = " + sum;
				String nextLetter = convertIntToString(sum);
				encryptedMessage = encryptedMessage + nextLetter;
			}

		}

		return encryptedMessage;

	}

	/**
	 * @param message
	 * @param passphrase
	 * @param deckSize
	 * @return
	 */
	public static String decrypt ( String message, String passphrase, int deckSize ) {

		KeystreamGenerator keystreamGen = new KeystreamGenerator(deckSize);
		keystreamGen.key(passphrase);
		String decryptedMessage = "";

		for ( int i = 0 ; i < message.length() ; i++ ) {
			char current = Character.toLowerCase(message.charAt(i));
			int charNum = Character.getNumericValue(current) - 9;

			int nextKeystreamValue = keystreamGen.nextKeystreamValue();
			int difference = charNum - nextKeystreamValue;

			if ( difference <= 0 ) {
				difference = difference + 26;

				assert difference >= 1 && difference <= 26 : "the difference in the "
				    + "decrypt method is wrong! Should be between 1 and 26 inclusive."
				    + " Got: " + difference;
			}
			String nextLetter = convertIntToString(difference);
			decryptedMessage = decryptedMessage + nextLetter;
		}

		return decryptedMessage;

	}

	/**
	 * Convert an int value to a letter
	 * 
	 * @param sum
	 *          the int to convert to a letter - must be between 1 and 26
	 *          inclusive
	 * @return the letter conversion of the given int
	 */
	private static String convertIntToString ( int sum ) {

		if ( sum < 1 || sum > 26 ) {
			throw new IllegalArgumentException(
			                                   "Tried to convert an invalid int to letter."
			                                       + " int should be between 1 and 26 inclusive. Current int: "
			                                       + sum);
		}

		return String.valueOf((char) (sum + 64));

	}
}
