/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card card1 = new Card("king", "hearts", 7);
		Card card2 = new Card("ace", "spades", 1);
		Card card3 = new Card("joker", "funny", 4);
		
		System.out.println(card1.matches(card2));
		System.out.println(card1.matches(card1));
		System.out.println(card3.rank());
		System.out.println(card2.suit());
		System.out.println(card1.pointValue());
		System.out.println(card1.toString());
		System.out.println(card2.toString());
		System.out.println(card3.toString());
	}
}
