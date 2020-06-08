import java.util.HashMap;
import java.util.Map;

/**
 * @author williambrooksmiller
 */
public class KeystreamGenerator {

	SolitaireDeck deck_;

	/**
	 * create a new KeystreamGenerator with a specified deck size
	 * 
	 * @param deckSize
	 *          the number of cards in the deck - not including jokers
	 */
	public KeystreamGenerator ( int deckSize ) {

		if ( deckSize < 1 ) {
			throw new IllegalArgumentException("deckSize can't be <1 - "
			    + "KeystreamGenerator");
		}

		deck_ = new SolitaireDeck(deckSize);
	}

	/**
	 * key the deck
	 * 
	 * @param passphrase
	 *          the phrase used to key the deck
	 */
	public void key ( String passphrase ) {

		for ( int i = 0 ; i < passphrase.length() ; i++ ) {
			char current = Character.toLowerCase(passphrase.charAt(i));

			if ( Character.isLetter(current) ) {
				deck_.swapJokerA();
				deck_.swapJokerB();
				deck_.tripleCut();
				int count = deck_.getBottomCard().getValue();
				deck_.CountCut(count);

				int charNum = Character.getNumericValue(current) - 9;

				// System.out.println("the numeric value of the current letter: "
				// + current + " = " + charNum);

				deck_.CountCut(charNum);
			}

		}
	}

	/**
	 * generate and return the next keystream value
	 *
	 * @return the next keystream value - must be between 1 and the deck size
	 */
	public int nextKeystreamValue () {

		for ( ; true ; ) {

			deck_.swapJokerA();
			deck_.swapJokerB();
			deck_.tripleCut();
			deck_.CountCut(deck_.getBottomCard().getValue());
			SolitaireCard nextKeystreamCard =
			    deck_.getNthCard(deck_.getTopCard().getValue());
			
			if ( nextKeystreamCard.isJoker() == false ) {

				int nextKeystream = nextKeystreamCard.getValue();

				assert nextKeystream >= 1 : "the next keystream is too small: "
				    + nextKeystream;
				assert nextKeystream <= deck_.getDeckSize() : "the next keystream value is too big: "
				    + nextKeystream;

				return nextKeystream;

			}
		}
	}

	/**
	 * @return the deck used
	 */
	public SolitaireDeck getDeck () {
		return deck_;
	}
}
