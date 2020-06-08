import java.util.Scanner;

/**
 * @author williambrooksmiller
 */
public class SolitaireMain {

	/**
	 * @param args
	 */
	public static void main ( String[] args ) {
		// TODO Auto-generated method stub

		int deckSize = 26;

		System.out.print("enter passphrase: ");
		Scanner scanner = new Scanner(System.in);
		String passphrase = scanner.nextLine();
		System.out.println();

		loop: for ( ; ; ) {


			System.out.print("encrypt, decrypt, or quit? [e/d/q] ");
			String userChoice = scanner.next();

			if ( userChoice.equals("e") == false && userChoice.equals("E") == false
			    && userChoice.equals("d") == false && userChoice.equals("D") == false
			    && userChoice.equals("q") == false && userChoice.equals("Q") == false ) {
				throw new IllegalArgumentException(
				                                   "that is an invalid choice. Must enter e, d, or q. Got: "
				                                       + userChoice);
			} else if ( userChoice.equals("e") || userChoice.equals("E") ) {
				System.out.print("enter message to be encrypted: ");
				Scanner scanMessage = new Scanner(System.in);
				String message = scanMessage.nextLine();
				String encodedM = SolitaireEncoder.encrypt(message,passphrase,deckSize);
				System.out.println();
				System.out.println("encrypted: " + encodedM);
				System.out.println();
			} else if ( userChoice.equals("d") || userChoice.equals("D") ) {
				System.out.print("enter encrypted message: ");
				Scanner scanEncyptedMessage = new Scanner(System.in);
				String encodedM = scanEncyptedMessage.nextLine();
				System.out.println();
				String decodedM =
				    SolitaireEncoder.decrypt(encodedM,passphrase,deckSize);
				System.out.println("decrypted: " + decodedM);
				System.out.println();
			} else {
				break loop;
			}
		}
	}// end of main

} // end of class
