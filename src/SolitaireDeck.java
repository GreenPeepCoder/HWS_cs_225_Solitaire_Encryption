/**
 * represents the deck of cards (with size ³ 1) used to generate keystream
 * values
 * 
 * @author williambrooksmiller
 */
public class SolitaireDeck {

	private DoubleListNode head_;
	private DoubleListNode tail_;
	private DoubleListNode jokerA_;
	private DoubleListNode jokerB_;
	private int deckSize_;

	/**
	 * create a solitaire deck
	 * 
	 * @param deckSize
	 *          - the number of cards in the deck not including jokers - (must be
	 *          1)
	 */
	public SolitaireDeck ( int deckSize ) {

		if ( deckSize < 1 ) {
			throw new IllegalArgumentException("the deck size must be  1: currect"
			    + " deck size is: " + deckSize);
		}

		deckSize_ = deckSize;
		head_ = new DoubleListNode(new SolitaireCard(1));
		jokerA_ = new DoubleListNode(new SolitaireCard(deckSize_ + 1,'A'));
		jokerB_ = new DoubleListNode(new SolitaireCard(deckSize_ + 1,'B'));
		tail_ = jokerB_;
		jokerB_.setNext(head_);
		jokerB_.setPrev(jokerA_);
		jokerA_.setNext(jokerB_);
		head_.setPrev(tail_);
		tail_.setNext(head_);

		// at this point, 1 _ _ 3A 3B

		// initialize the rest of the deck
		int i = 2;
		DoubleListNode current = head_;
		for ( ; i <= deckSize_ ; ) {
			DoubleListNode temp = new DoubleListNode(new SolitaireCard(i));
			current.setNext(temp);
			temp.setPrev(current);
			current = current.getNext();
			i++;
			assert current == temp : "current does not equal temp";

		}

		current.setNext(jokerA_);
		jokerA_.setPrev(current);

		assert head_.getPrev() == tail_ : "The head does not link back to the tail";
		assert tail_.getNext() == head_ : "The tail does not link back to the head";
	}

	/**
	 * Print the contents of a linked list.
	 * 
	 * @param head
	 *          head of the list
	 * @return
	 */
	public void print () {
		DoubleListNode current = head_;
		for ( int i = 0 ; i <= deckSize_ + 1 ; i++ ) {
			// print out one element (current element)
			System.out.print(current.getCard() + " ");
			current = current.getNext();
		}
		System.out.println();
		// System.out.println("End of print.");
	}

	/**
	 * Print the contents of a linked list.
	 * 
	 * @param head
	 *          head of the list - should be circular
	 * @return
	 */
	public void printHead ( DoubleListNode head, DoubleListNode tail ) {
		assert head != null : "can't print a null head";

		DoubleListNode current = head;
		for ( ; current.getPrev() != tail ; ) {
			// print out one element (current element)
			System.out.print(current.getCard() + " ");
			current = current.getNext();
		}
		System.out.println();
		// System.out.println("End of print.");
	}

	/**
	 * Print the contents of a linked list.
	 * 
	 * @param head
	 *          head of the list
	 * @return
	 */
	public void printMore () {
		DoubleListNode current = head_;
		for ( int i = 0 ; i <= deckSize_ + 3 ; i++ ) {
			// print out one element (current element)
			System.out.print(current.getCard() + " ");
			current = current.getNext();
		}
		System.out.println();
		// System.out.println("End of print.");
	}

	/**
	 * get the size of the deck
	 * 
	 * @return the nubmer of cards in the deck - not including jokers - should be
	 *         <= 1
	 */
	public int getDeckSize () {
		assert deckSize_ >= 1 : "The deck size should be <= 1. Current deck size: "
		    + deckSize_;

		return deckSize_;
	}

	/**
	 * the top card
	 * 
	 * @return the card that is on the top of the deck (the head_)
	 */
	public SolitaireCard getTopCard () {
		return head_.getCard();
	}

	/**
	 * the bottom of the deck
	 * 
	 * @return the card that is on the bottom of the deck (the tail_)
	 */
	public SolitaireCard getBottomCard () {
		return tail_.getCard();
	}

	/**
	 * get the Nth card in the deck
	 * 
	 * @param n
	 *          the position in the deck of the card to return - must be < 1 and >
	 *          deckSize_
	 * @return the card in the specified position in the deck
	 */
	public SolitaireCard getNthCard ( int n ) {

		if ( n < 0 || n > deckSize_ + 1 ) {
			throw new IllegalArgumentException(
			                                   "an invalide n was given to the 'getNthCard' method ");
		}

		DoubleListNode current = head_;
		if ( n == deckSize_ + 1 ) {
			return tail_.getCard();
		}
		for ( int i = 0 ; i < n ; i++ ) {

			current = current.getNext();
		}
		return current.getCard();
	}

	/**
	 * get the Nth card in the deck
	 * 
	 * @param n
	 *          the position in the deck of the card to return - must be <= 1 and
	 *          > deckSize_+1
	 * @return the card in the specified position in the deck
	 */
	public DoubleListNode getNthNode ( int n ) {

		if ( n < 0 || n > deckSize_ + 2 ) {
			throw new IllegalArgumentException(
			                                   "an invalide n was given to the 'getNthCard' method. the n that was entered was: "
			                                       + n);
		}

		DoubleListNode current = head_;
		if ( n == deckSize_ + 1 ) {
			return tail_;
		}
		for ( int i = 0 ; i < n ; i++ ) {

			current = current.getNext();
		}
		return current;
	}

	/**
	 * get the head of the deck list
	 * 
	 * @return head_
	 */
	public DoubleListNode getHead () {
		assert head_.getPrev() == tail_ : "head_'s getPrev() != tail_";
		assert head_ != null : "head is null - SolitaireDeck - getHead()";
		return head_;
	}

	/**
	 * get the head of the deck list
	 * 
	 * @return tail_
	 */
	public DoubleListNode getTail () {
		assert tail_.getNext() == head_ : "tail_'s next pointer != head_";
		assert tail_ != null : "tail is null - SolitaireDeck - getTail()";
		return tail_;
	}

	/**
	 * swap jokerA with the card immediately after it in the deck
	 */
	public void swapJokerA () {
		boolean newTailPre = false; // preCurr becomes new tail
		boolean newTailCurr = false; // curr becomes new tail
		boolean changeHead = false;
		DoubleListNode curr = head_;

		for ( int i = 0 ; i < deckSize_ + 2 ; i++ ) {
			if ( curr.getCard().isJokerA() ) { // at this point, curr == jokerA
				DoubleListNode postCurr = curr.getNext();
				DoubleListNode preCurr = curr.getPrev();
				DoubleListNode tempA =
				    new DoubleListNode(curr.getCard(),postCurr,postCurr.getNext());

				// check special cases
				if ( curr.getCard() == tail_.getCard() ) {
					newTailPre = true;
				}
				if ( postCurr.getCard() == tail_.getCard() ) {
					newTailCurr = true;
				}
				if ( curr.getCard() == head_.getCard() ) {
					changeHead = true;
				}

				assert postCurr.getCard() != tail_.getCard();
				assert curr.getCard() != head_.getCard();

				preCurr.setNext(postCurr);
				postCurr.setPrev(preCurr);

				postCurr.getNext().setPrev(tempA);
				postCurr.setNext(tempA);
				// at this point, "normal case" has been handled

				// update tail
				if ( newTailCurr == true ) {
					tail_ = curr;
					assert tail_.getNext() == curr.getNext() : "updating tail didn't work"
					    + " - swapJokerA: getNext()";
					assert tail_.getPrev() == curr.getPrev() : "updating tail didn't work"
					    + " - swapJokerA: getPrev()";
				}
				if ( newTailPre == true ) {
					assert newTailCurr == false;
					tail_ = preCurr;
					assert tail_.getNext() == preCurr.getNext();
					assert tail_.getPrev() == preCurr.getPrev();
				} else if ( newTailCurr == true ) {
					assert newTailPre == false;
					tail_ = curr;
					assert tail_.getNext() == curr.getNext();
					assert tail_.getPrev() == curr.getPrev();
				}
				if ( changeHead == true ) {
					head_ = postCurr;
					assert head_.getNext() == postCurr.getNext();
					assert head_.getPrev() == postCurr.getPrev();
					assert tail_ == preCurr;
				}
				return; // the swap has been made - stop the loop
			}
			curr = curr.getNext();
		}

	}

	/**
	 * swap jokerA with the card immediately after it in the deck
	 */
	public void swapJokerB () { // TODO make better comments

		for ( int j = 0 ; j < 2 ; j++ ) {

			boolean newTailPre = false; // preCurr becomes new tail
			boolean newTailCurr = false; // curr becomes new tail
			boolean changeHead = false;
			DoubleListNode curr = head_;

			for ( int i = 0 ; i < deckSize_ + 2 ; i++ ) {
				if ( curr.getCard().isJokerB() ) { // at this point, curr == jokerA
					DoubleListNode postCurr = curr.getNext();
					DoubleListNode preCurr = curr.getPrev();
					DoubleListNode tempB =
					    new DoubleListNode(curr.getCard(),postCurr,postCurr.getNext());

					// check special cases
					if ( curr.getCard() == tail_.getCard() ) {
						newTailPre = true;
					}
					if ( postCurr.getCard() == tail_.getCard() ) {
						newTailCurr = true;
					}
					if ( curr.getCard() == head_.getCard() ) {
						changeHead = true;
					}

					assert postCurr.getCard() != tail_.getCard();
					assert curr.getCard() != head_.getCard();

					preCurr.setNext(postCurr);
					postCurr.setPrev(preCurr);

					postCurr.getNext().setPrev(tempB);
					postCurr.setNext(tempB);
					// at this point, "normal case" has been handled

					// update tail
					if ( newTailCurr == true ) {
						tail_ = curr;
						assert tail_.getNext() == curr.getNext() : "updating tail didn't work"
						    + " - swapJokerA: getNext()";
						assert tail_.getPrev() == curr.getPrev() : "updating tail didn't work"
						    + " - swapJokerA: getPrev()";
					}
					if ( newTailPre == true ) {
						assert newTailCurr == false;
						tail_ = preCurr;
						assert tail_.getNext() == preCurr.getNext();
						assert tail_.getPrev() == preCurr.getPrev();
					} else if ( newTailCurr == true ) {
						assert newTailPre == false;
						tail_ = curr;
						assert tail_.getNext() == curr.getNext();
						assert tail_.getPrev() == curr.getPrev();
					}
					if ( changeHead == true ) {
						head_ = postCurr;
						assert head_.getNext() == postCurr.getNext();
						assert head_.getPrev() == postCurr.getPrev();
						assert tail_ == preCurr;
					}
					break; // the swap has been made - stop the loop
				}
				curr = curr.getNext();
			}
		}
	}

	/**
	 * See if the deck has the specified card
	 * 
	 * @param card
	 *          the card to look for in the deck
	 * @return true if the card is in the deck, false otherwise
	 */
	public boolean contains ( SolitaireCard card ) {
		// TODO Auto-generated method stub
		DoubleListNode current = head_;
		for ( int i = 0 ; i < deckSize_ + 2 ; i++ ) {
			if ( current.getCard().getValue() == card.getValue() ) {

				if ( current.getCard().isJokerA() && card.isJokerA() ) {
					return true;
				}
				if ( current.getCard().isJokerB() && card.isJokerB() ) {
					return true;
				}
				if ( current.getCard().isJoker() == false && card.isJoker() == false ) {
					return true;
				}

			}
			current = current.getNext();
		}
		return false;
	}

	/**
	 * remove the specified node from the list TODO improve these comments
	 * 
	 * @param nodeToRemove
	 */
	public void removeNode ( DoubleListNode nodeToRemove ) {
		if ( head_ == nodeToRemove ) { // the node to remove is the first node
			DoubleListNode temp = head_;
			head_ = head_.getNext();
			head_.setPrev(tail_);
			temp.setNext(null);
			temp.setPrev(null);
		} else if ( tail_ == nodeToRemove ) { // the node to remove is the last
			// node
			DoubleListNode temp = tail_.getPrev();
			temp.setNext(head_);
			head_.setPrev(temp);
			tail_ = temp;
			// tail_.setNext(head_);
		} else {
			DoubleListNode temp = head_;
			while ( temp.getNext() != nodeToRemove ) {
				temp = temp.getNext();
			}
			DoubleListNode temp2 = temp.getNext();
			temp.setNext(temp2.getNext());
			temp2.getNext().setPrev(temp);
		}
		deckSize_--;
	}

	/**
	 * exchange cards before the first joker with cards after the second joker
	 * (doesn't matter which is A or B)
	 */
	/*
	 * public void tripleCut () { int firstSize = getFirstTripleCutSize();
	 * DoubleListNode current = head_; DoubleListNode headGroup1 = head_; loop:
	 * for(int i = 0; i<deckSize_+1; i++){ if(current.getCard().isJoker()){ break
	 * loop; } firstSize++; current = current.getNext(); } DoubleListNode
	 * tailGroup1 = current.getPrev(); current = null; current.setNext(null);
	 * current.setPrev(null); }
	 */

	/**
	 * cut the deck after a specified number of cards
	 * 
	 * @param n
	 *          the number of cards before the cut - should be between 1 and
	 *          deckSize_+2
	 */
	public void CountCut ( int n ) {

		if ( n < 1 || n > deckSize_ + 2 ) {
			throw new IllegalArgumentException(
			                                   "Entered an invalid number for CountCut()");
		}

		SolitaireCard originalTail = this.getBottomCard();

		this.removeNode(tail_);

		DoubleListNode current = head_;
		for ( int i = 1 ; i < deckSize_ + 2 ; i++ ) {
			if ( i == n ) {
				DoubleListNode next = current.getNext();
				head_ = next;
				tail_ = current;

				assert head_.getPrev() == tail_;
				assert tail_.getNext() == head_;
			}
			current = current.getNext();
		}

		this.insertAtTail(originalTail);
	}

	/**
	 * 
	 */
	public void printTripleCutStats () {
		// TODO Auto-generated method stub
		System.out.println("Number of cards before the first joker: "
		    + getFirstTripleCutSize());
		System.out.println("Number of cards after the second joker: "
		    + getSecondTripleCutSize());
		System.out.println();
		System.out.println("the head of the first goup: " + head_.getCard());
		System.out.println("the tail of the first group "
		    + this.getNthNode(getFirstTripleCutSize() - 1).getCard());
		System.out.println("The head of the second group: "
		    + this.getNthNode(deckSize_ + 2 - getSecondTripleCutSize()).getCard());
		System.out.println("That tail of the second group: " + tail_.getCard());
		System.out.println();
		System.out.println("The first joker is: " + findFirstJoker().getCard());
		System.out.println("The second joker is: " + findSecondJoker().getCard());

	}

	/**
	 * @return
	 */
	public int getSecondTripleCutSize () {
		// TODO Auto-generated method stub
		int secondSize = 0; // num of cards after second joker in the deck
		boolean increase1 = true;
		boolean increase2 = false;
		DoubleListNode curr = head_;

		lab1: for ( int i = 0 ; i < deckSize_ + 1 ; i++ ) {
			if ( curr.getCard().isJoker() && increase1 == true ) {
				increase1 = false;
				curr = curr.getNext();
				continue lab1;
			} else if ( curr.getCard().isJoker() && increase1 == false ) {
				increase2 = true;
			}
			if ( increase2 == true ) {
				secondSize++;
			}
			curr = curr.getNext();
		} // end of for loop
		  // at this point, we have the number of cards before the first joker
		  // (firstSize) and the number of cards after the second joker (secondSize)
		return secondSize;
	}

	/**
	 * perform a triple cut: all the cards in the deck before the first joker are
	 * exchanged with all the cards in the deck after the second joker
	 */
	public void tripleCut () {

		if ( this.getFirstTripleCutSize() != 0
		    && this.getSecondTripleCutSize() == 0 ) {

			DoubleListNode temp1 = this.findFirstJoker();
			DoubleListNode temp2 = this.findFirstJoker().getPrev();

			head_ = temp1;
			tail_ = temp2;

		} else if ( this.getFirstTripleCutSize() == 0
		    && this.getSecondTripleCutSize() != 0 ) {

			DoubleListNode temp1 = this.findSecondJoker();
			DoubleListNode temp2 = this.findSecondJoker().getNext();

			head_ = temp2;
			tail_ = temp1;

		} else if ( this.getFirstTripleCutSize() != 0
		    && this.getSecondTripleCutSize() != 0 ) {

			DoubleListNode h1 = head_;
			DoubleListNode t1 = this.findFirstJoker().getPrev();
			DoubleListNode h2 = this.findFirstJoker();
			DoubleListNode t2 = this.findSecondJoker();
			DoubleListNode h3 = this.findSecondJoker().getNext();
			DoubleListNode t3 = tail_;

			h2.setPrev(t3);
			t3.setNext(h2);

			h1.setPrev(t2);
			t2.setNext(h1);

			h3.setPrev(t1);
			t1.setNext(h3);

			head_ = h3;
			tail_ = t1;

		}

		assert head_ != null : "head_ is null at this point in the program";
		assert tail_ != null : "tail_ is null at this point in the program";
		assert head_.getNext() == tail_;
		assert tail_.getPrev() == head_;

	}

	/**
	 * @return
	 */
	public int getFirstTripleCutSize () {
		// TODO Auto-generated method stub
		int firstSize = 0; // the number of cards before the first joker in the deck
		boolean increase1 = true;
		DoubleListNode curr = head_;

		lab1: for ( int i = 0 ; i < deckSize_ + 1 ; i++ ) {
			if ( curr.getCard().isJoker() && increase1 == true ) {
				increase1 = false;
				curr = curr.getNext();
				continue lab1;
			}
			if ( increase1 == true ) {
				firstSize++;
			}

			curr = curr.getNext();
		} // end of for loop
		  // at this point, we have the number of cards before the first joker
		  // (firstSize) and the number of cards after the second joker (secondSize)
		return firstSize;
	}

	/**
	 * @return
	 */
	public DoubleListNode findSecondJoker () { // TODO make this private once
		                                         // it's
		                                         // tested
		// TODO Auto-generated method stub
		DoubleListNode current = this.findFirstJoker().getNext();
		loop: for ( ; current != head_ ; ) {
			if ( current.getCard().isJoker() ) {
				break loop;
			}
			current = current.getNext();
		}
		return current;
	}

	/**
	 * @return the first joker in the deck
	 */
	public DoubleListNode findFirstJoker () { // TODO make this private once
		                                        // it's
		                                        // been tested
		// TODO Auto-generated method stub
		DoubleListNode current = head_;
		loop: for ( int i = 0 ; i < deckSize_ + 1 ; i++ ) {
			if ( current.getCard().isJoker() ) {
				break loop;
			}
			current = current.getNext();
		}
		return current;
	}

	/**
	 * Insert a new card into the deck
	 * 
	 * @param newHead
	 *          the new card to insert into the deck - should be a card that is
	 *          not already in the deck
	 */
	public void insertAtHead ( SolitaireCard newHead ) {

		if ( this.contains(newHead) ) {
			throw new IllegalArgumentException("tried to insert a card that is "
			    + "already in the deck");
		}

		DoubleListNode newHeadNode = new DoubleListNode(newHead);
		newHeadNode.setNext(head_);
		newHeadNode.setPrev(tail_);
		tail_.setNext(newHeadNode);
		head_.setPrev(newHeadNode);
		head_ = newHeadNode;
		deckSize_++;
	}

	/**
	 * Insert a new card into the deck
	 * 
	 * @param newTail
	 *          the new card to insert into the deck - should be a card that is
	 *          not already in the deck
	 */
	public void insertAtTail ( SolitaireCard newTail ) {

		if ( this.contains(newTail) ) {
			throw new IllegalArgumentException("tried to insert a card that is "
			    + "already in the deck");
		}

		DoubleListNode newTailNode = new DoubleListNode(newTail);
		newTailNode.setPrev(tail_);
		head_.setPrev(newTailNode);
		newTailNode.setNext(head_);
		tail_.setNext(newTailNode);
		tail_ = newTailNode;
		deckSize_++;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString () {
		DoubleListNode current = head_;
		String deckString = "";
		for ( int i = 0 ; i < deckSize_ + 2 ; i++ ) {
			deckString = deckString.concat(current.getCard().toString());
			deckString = deckString.concat(" ");
			current = current.getNext();
		}
		return deckString;
	}
}
