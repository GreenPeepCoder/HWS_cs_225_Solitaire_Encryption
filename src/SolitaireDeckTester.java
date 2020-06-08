/**
 * @author williambrooksmiller
 */
public class SolitaireDeckTester {

	/**
	 * @param args
	 */
	public static void main ( String[] args ) {

		// print1();
		// print2();
		// print3();
		// print4();
		// print5();
		// print6();
		// print7();
		// print8();
		// print9();
		// print10();
		// print12();
		// print13();
		// printFindJoker1Test();
		// printFindJoker2Test();
		// print11();
		// printTripleCutTest();
		// printCountCutTest();
		// printToStringTest();
		printTripleCutTest2();
		tripleCutFirstCase();
		tripleCutSecondCase();
	}

	/**
	 * 
	 */
  private static void tripleCutSecondCase () {
	  // TODO Auto-generated method stub
  	System.out.println("----------------");
		System.out.println("tripleCut Second Case:");
		System.out.println("original deck: ");
		SolitaireDeck deck = getExample();
		deck.print();
		System.out.println();
		System.out.println("after the triple cut:");
		System.out.println("expected output: 4 5 6 7B 3 7A 1 2");
		System.out.print("actual output:   ");
		deck.tripleCut();
		deck.print();
  }

	/**
	 * 
	 */
	private static void tripleCutFirstCase () {
		// TODO Auto-generated method stub
		System.out.println("----------------");
		System.out.println("tripleCut First Case:");
		System.out.println("original deck: ");
		SolitaireDeck deck = new SolitaireDeck(5);
		deck.print();
		System.out.println();
		System.out.println("After the triple cut:");
		System.out.println("expected output: 6A 6B 1 2 3 4 5");
		System.out.print("actual output:     ");
		deck.tripleCut();
		deck.print();
		System.out.println("----------------");
		System.out.println();
	}

	/**
	 * 
	 */
	private static void printTripleCutTest2 () {
		// TODO Auto-generated method stub

		System.out.println("----------------");
		System.out.println("tripleCut test:");
		SolitaireDeck deck = new SolitaireDeck(6);
		System.out.println("original deck:");
		deck.print();
		System.out.println("    firstTripleCutSize =     "
		    + deck.getFirstTripleCutSize());
		System.out.println("    secondTripleCutSize = "
		    + deck.getSecondTripleCutSize());
		System.out.println();
		System.out.println("deck.getNthCard(deck.getFirst"
		    + "TripleCutSize.getPrev()) = ");// TODO
		// make
		// this
		// getNthNode
		System.out.println("    expected: 6");

		// at this point:
		DoubleListNode tempHeadGroup1 = deck.getHead();
		DoubleListNode tempTailGroup1 =
		    deck.getNthNode(deck.getFirstTripleCutSize()).getPrev();

		System.out.println("    actual: " + tempTailGroup1.getCard());
		System.out.println("----------------");
		System.out.println();

		DoubleListNode tTG1 = deck.findFirstJoker().getPrev();
		if ( tTG1.getCard() == tempTailGroup1.getCard() ) {
			System.out
			    .println("just getting the first joker's previous node DOES WORK");
		}
		System.out.println();
	}

	/**
	 * 
	 */
	private static void printToStringTest () {
		// TODO Auto-generated method stub
		System.out.println("-------------------");
		System.out.println("toString test");
		System.out.println(" original deck via NOT toString() method: ");
		SolitaireDeck deck = getExample();
		deck.print();
		System.out.println("deck via the toString() method: ");
		System.out.println(deck.toString());
	}

	/**
	 * 
	 */
	private static void printCountCutTest () {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("-------------------");

		System.out.println("CountCut Test:");
		System.out.println("Original deck:");
		SolitaireDeck deck = getExample();
		deck.print();
		System.out.println("after deck.countCut(4): ");
		System.out.println("    expected output: 7A 4 5 1 2 7B 3 6");
		System.out.print("    acutal output:     ");

		deck.CountCut(4);
		deck.print();
		System.out.println("-------------------");

		System.out.println();
	}

	/**
	 * 
	 */
	private static void printTripleCutTest () {
		// TODO Auto-generated method stub
		System.out.println("-------------------");

		System.out.println("TripleCut Test:");
		System.out.println("original deck:");
		SolitaireDeck deck = getExample();
		deck.print();
		// deck.tripleCut();
		System.out.println("    expected output: 4 5 6 7B 3 7A 1 2");
		System.out.print("    actual output:   ");
		deck.print();
		// System.out.println("pring a little
		// more to make sure the tail connects"
		// + " back to the head");
		// deck.printMore();
		System.out.println();
		System.out.println("-------------------");

	}

	/**
	 * 
	 */
	private static void printFindJoker2Test () {
		// TODO Auto-generated method stub
		System.out.println("-------------------");

		System.out.println("findSecondJoker Test:");
		System.out.println("Test findSecondJoker() method");
		System.out.println("original deck: ");
		SolitaireDeck deck = getExample();
		deck.print();
		System.out.println("    expected output: 7A");
		System.out.print("    actual output:     ");
		System.out.println(deck.findSecondJoker().getCard());
		System.out.println("-------------------");

		System.out.println();
	}

	/**
	 * 
	 */
	private static void printFindJoker1Test () {
		// TODO Auto-generated method stub
		System.out.println("-------------------");

		System.out.println("findFirstJoker Test:");
		System.out.println("Testing the findJoker methods:");
		System.out.println("original deck:");
		SolitaireDeck deck = getExample();
		deck.print();
		System.out.println("findFirstJoker()");
		System.out.println("    expected output: 7B");
		System.out.print("    actual output:     ");
		System.out.println(deck.findFirstJoker().getCard());
		System.out.println("Test to see if the next and"
		    + " prev pointers are the same ");
		System.out.println("7B's next node:");
		System.out.println("    expected output: 3");
		System.out.print("    actual output:     ");
		System.out.println(deck.findFirstJoker().getNext().getCard());
		System.out.println("7B's previous node:");
		System.out.println("    expected output: 2");
		System.out.print("    actual output:     ");
		System.out.println(deck.findFirstJoker().getPrev().getCard());
		System.out.println("-------------------");

		System.out.println();
	}

	/**
	 * @return
	 */
	private static SolitaireDeck getExample () {
		// TODO Auto-generated method stub
		SolitaireDeck deckTest = new SolitaireDeck(6);
		deckTest.swapJokerB();
		deckTest.swapJokerA();
		deckTest.swapJokerA();
		deckTest.swapJokerA();
		deckTest.swapJokerA();
		return deckTest;
	}

	/**
	 * 
	 */
	private static void testConstructor () {
		// TODO Auto-generated method stub
		{// first test block
			SolitaireDeck deck = new SolitaireDeck(10);
			System.out.println("-------------------");

			System.out.println("1)");
			System.out.println("Testing: Solitaire Constructor");
			System.out.println("Input: deckSize = 10");
			System.out.println("Expected Output: 1 2 3 4 5 6 7 8 9 10 11A 11B");
			System.out.print("Actual output:      ");
			deck.print();
			System.out.println("-------------------");

			System.out.println();
		} // end of first test block
	}

	/**
	 * 
	 */
	private static void test_getDeckSize () {
		// TODO Auto-generated method stub
		{// 2nd test block - getDeckSize of a deck of 7
			System.out.println("-------------------");

			System.out.println("2)");
			SolitaireDeck deck = new SolitaireDeck(7);
			System.out.println("Testing: getDeckSize()");
			System.out.println("Input: deckSize_ = 7");
			System.out.println("Expected output: 7");
			System.out.print("Actual output:      ");
			System.out.println(deck.getDeckSize());
			System.out.println("-------------------");

			System.out.println();

		} // end of 2nd test block
	}

	/**
	 * 
	 */
	private static void testGetTopBottom () {
		// TODO Auto-generated method stub
		{// 3rd test block - getTopCard() and getBottomCard()
			SolitaireDeck deck = new SolitaireDeck(26);
			System.out.println("-------------------");

			System.out.println("3)");
			System.out.println("getTopCard");
			System.out.println("deck state: size of 12");
			System.out.println("expected output: 1");
			System.out.print("Actual output:      ");
			System.out.println(deck.getTopCard());
			System.out.println();
			System.out.println("getBottomCard");
			System.out.println("deck state: size of 26");
			System.out.println("expected output: 27B");
			System.out.print("Actual output:      ");
			System.out.println(deck.getBottomCard());
			deck.print();
			System.out.println("-------------------");

			System.out.println();
		} // end of test block 3
	}

	/**
	 * 
	 */
	private static void test_getNthCard () {
		// TODO Auto-generated method stub
		{// 4th test block - test getNthCard - n is in the middle of the deck
			SolitaireDeck deck = new SolitaireDeck(14);
			System.out.println("-------------------");

			System.out.println("4)");
			System.out.println("Testing: getNthCard(n)");
			System.out.println("input: n = 11");
			System.out.println("state: deckSize_ = 14");
			System.out.println("Expected Output: 12");
			System.out.print("Actual output:      ");
			System.out.println(deck.getNthCard(11));
			System.out.println("-------------------");

			System.out.println();
		} // end of test block 4
	}

	/**
	 * 
	 */
	private static void test_getNthCard2 () {
		// TODO Auto-generated method stub
		{// 5th test block - test getNthCard - n is the top card in the deck
			System.out.println("-------------------");

			System.out.println("5)");
			SolitaireDeck deck = new SolitaireDeck(14);
			System.out.println("Testing: getNthCard(n)");
			System.out.println("input: n = 0");
			System.out.println("state: deckSize_ = 14");
			System.out.println("Expected Output: 1");
			System.out.print("Actual output:      ");
			System.out.println(deck.getNthCard(0));
			System.out.println("-------------------");

			System.out.println();
		} // end of test block 5

	}

	/**
	 * 
	 */
	private static void test_getNthCard3 () {
		// TODO Auto-generated method stub
		{// 6th test block - test getNthCard - n is the bottom card in the deck
			SolitaireDeck deck = new SolitaireDeck(14);
			System.out.println("-------------------");

			System.out.println("6)");
			System.out.println("Testing: getNthCard(n)");
			System.out.println("input: n = 15");
			System.out.println("state: deckSize_ = 14");
			System.out.println("Expected Output: 15B");
			System.out.print("Actual output:      ");
			System.out.println(deck.getNthCard(15));
			System.out.println("-------------------");

			System.out.println();

		} // end of test block 6
	}

	/**
	 * 
	 */
	private static void test_removeNode () {
		// TODO Auto-generated method stub
		{// 7th testing block - test removeNode
			SolitaireDeck deck = new SolitaireDeck(3);
			System.out.println("-------------------");

			System.out.println("7)");
			System.out.println("Testing: removeNode(deck.getHead())");
			System.out.println("state: deckSize_ = 3");
			System.out.println("Expected Output: 2 3 4A 4B");
			System.out.print("Actual output:      ");
			deck.removeNode(deck.getHead());
			deck.print();
			System.out.println("	now remove the second card in the deck");
			System.out.println("Explected output: 2 4A 4B");
			System.out.print("Actual output:      ");
			deck.removeNode(deck.getHead().getNext());
			deck.print();
			System.out.println("-------------------");

			System.out.println();
		} // end of test block 7
	}

	/**
	 * 
	 */
	private static void test_swapJokerA () {
		// TODO Auto-generated method stub
		{// test block 8
			System.out.println("-------------------");

			System.out.println("8)");
			System.out.println("Test simple swapJokerA");
			System.out.println("original deck:");
			SolitaireDeck deck = new SolitaireDeck(3);
			deck.print();
			System.out.println("After swapping jokerA: ");
			System.out.println("    expected output: 1 2 3 4B 4A");
			System.out.print("    actual output:     ");
			deck.swapJokerA();
			deck.print();
			System.out
			    .println("check to see if head_ and tail_ point to the correct "
			        + "cards: ");
			System.out.println("    expected output: head_ = 1");
			System.out.println("    actual output: head_ =     " + deck.getTopCard());
			System.out.println("    expected output: tail_ = 4A");
			System.out.println("    actual output: tail_ =     "
			    + deck.getBottomCard());
			System.out.println("-------------------");

			System.out.println();
		} // end of test block 8
	}

	/**
	 * 
	 */
	private static void jokerSwapTests () {
		// TODO Auto-generated method stub
		{ // test block 9 System.out.println("Testing back-to-back swapJokerA ");
			System.out.println("------------------------------");
			System.out.println("9)");
			System.out.println("testing a double jokerA swap");
			System.out.println("original deck:");
			SolitaireDeck deck = new SolitaireDeck(3);
			deck.print();
			System.out.println();
			System.out.println("after the first swapJokerA():");
			System.out.println("    expected output: 1 2 3 4B 4A");
			System.out.print("    actual output:     ");
			deck.swapJokerA();
			deck.print();
			System.out.println("head_ = " + deck.getTopCard());
			System.out.println("tail_ = " + deck.getBottomCard());
			System.out.println();
			System.out.println("after the second swapJokerA():");
			System.out.println("    expected output: 1 4A 2 3 4B");
			System.out.print("    actual output:     ");
			deck.swapJokerA();
			deck.print();
			System.out.println("the new head is: " + deck.getTopCard());
			System.out.println("the new tail is: " + deck.getBottomCard());
			System.out.println();
			System.out.println("after 3rd swap");
			System.out.println("    expected output: 1 2 4A 3 4B");
			System.out.print("    actual output:     ");
			deck.swapJokerA();
			deck.print();
			System.out.println("the new head is: " + deck.getTopCard());
			System.out.println("the new tail is: " + deck.getBottomCard());
			System.out.println();
			System.out.println("after 4th swap");
			System.out.println("    expected output: 1 2 3 4A 4B");
			System.out.print("    actual output:     ");
			deck.swapJokerA();
			deck.print();
			System.out.println("the new head is: " + deck.getTopCard());
			System.out.println("the new tail is: " + deck.getBottomCard());

			System.out.println("------------------------------");
			System.out.println();
		} // end of test block 9
	}

	/**
	 * 
	 */
	private static void test_jokerSwapB () {
		// TODO Auto-generated method stub
		{ // testing block 10
			System.out.println("-------------------");

			System.out.println("10)");
			System.out.println("testing swapJokerB()");
			System.out.println("original deck:");
			SolitaireDeck deck = new SolitaireDeck(5);
			deck.print();
			System.out.println("    expected output: 1 2 6B 3 4 5 6A");
			System.out.print("    actual output:     ");
			deck.swapJokerB();
			deck.print();
			System.out.println();
			System.out.println("after second swapJokerB:");
			System.out.println("    expected output: 1 2 3 4 6B 5 6A");
			System.out.print("    actual output:     ");
			deck.swapJokerB();
			deck.print();
			System.out.println();
			System.out.println("after third swapJokerB:");
			System.out.println("    expected output: 1 2 3 4 5 6A 6B");
			System.out.print("    actual output:     ");
			deck.swapJokerB();
			deck.print();
			System.out.println("------------------------------");
			System.out.println();
		} // end of test block 10
	}

	/**
	 * 
	 */
	private static void tripleCutHelperMethod () {
		// TODO Auto-generated method stub
		{ // test block 11
			System.out.println("-------------------");
			System.out.println("11)");
			System.out.println("testing helper methods for tripleCut()");
			System.out.println("original deck:");
			SolitaireDeck deck = getExample();
			deck.print();

			deck.printTripleCutStats();
			System.out.println("-------------------");
			System.out.println();// TODO this isn't working at the moment, come back
			                     // and fix it!
		} // end of test block 11

	}

	/**
	 * 
	 */
	private static void test_insertAtHead () {
		// TODO Auto-generated method stub
		{ // test block 12
			System.out.println("-------------------");

			System.out.println("12)");
			System.out.println("Testing insertAtHead()");
			System.out.println("original deck:");
			SolitaireDeck deck = new SolitaireDeck(3);
			deck.print();
			SolitaireCard newHead = new SolitaireCard(14);
			deck.insertAtHead(newHead);
			System.out.println("Card inserted: 14");
			System.out.println("    expected output: 14 1 2 3 4A 4B");
			System.out.print("    actual output:     ");
			deck.print();
			System.out.println("-------------------");
			System.out.println();
		} // end of test block 12
	}

	/**
	 * 
	 */
	private static void test_insertAtTail () {
		// TODO Auto-generated method stub
		{ // test block 13
			System.out.println("-------------------");

			System.out.println("13)");
			System.out.println("Testing insertAtTail()");
			System.out.println("original deck:");
			SolitaireDeck deck = new SolitaireDeck(3);
			deck.print();
			SolitaireCard newTail = new SolitaireCard(14);
			deck.insertAtTail(newTail);
			System.out.println("Card inserted: 14");
			System.out.println("    expected output: 1 2 3 4A 4B 14 ");
			System.out.print("    actual output:     ");
			deck.print();
			System.out.println("-------------------");
			System.out.println();

		} // end of test block 13
	}
}
