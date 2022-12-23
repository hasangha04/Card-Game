public class Card 
{
	private final int face; // face of card ("Ace", "Twos")
	private final String suit; // suit of card ("Hearts", "Diamonds", etc)	

	// two-argument constructor initializes card's face and suit
	public Card(int cardFace, String cardSuit)
	{
		this.face = cardFace; // initialize face of card
		this.suit = cardSuit; // initialize suit of card
	} 
	
	public int getface()
	{
		return face;
	}
	
	// return String representation of Card
	public String toString()
	{
		return face + " of " + suit;
	} 
} 
