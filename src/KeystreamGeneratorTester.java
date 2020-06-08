/**
 * @author williambrooksmiller
 */
public class KeystreamGeneratorTester {

	/**
	 * @param args
	 */
	public static void main ( String[] args ) {
		// TODO Auto-generated method stub

		 printKey();

		 test_nextKeystreamValue();
	}

	/**
	 * 
	 */
	private static void test_nextKeystreamValue () {
		// TODO Auto-generated method stub
		KeystreamGenerator key = new KeystreamGenerator(26);
		key.key("SECRET KEY");
		System.out.println("Testing nextKeyStreamValue(): ");
		System.out.println("input: passphrase = SECRET KEY");
		System.out.println("     expected output: 22");
		System.out.print("     actual output: ");
		System.out.println(key.nextKeystreamValue());

	}

	/**
	 * 
	 */
	private static void printKey () {
		// TODO Auto-generated method stub
		KeystreamGenerator key = new KeystreamGenerator(26);
		System.out.println("Test 'Keying the Deck': ");
		System.out.println("passphrase: SECRET KEY");
		System.out.println("     expected output: 1 23 25 27B 2 22 10 11 12 13 "
		    + "14 15 16 17 18 19 20 21 7 5 9 27A 26 8 3 24 6 4 ");
		System.out.print("     actual output:     ");
		key.key("SECRET KEY");
		key.getDeck().print();
		System.out.println();
	}

}
