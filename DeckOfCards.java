// DeckOfCards.java
// DeckOfCards class represents a deck of playing cards. 
import java.security.SecureRandom;

public class DeckOfCards 
{
	// random number generator 
	private static final SecureRandom randomNumbers = new SecureRandom();
	private static final int NUMBER_OF_CARDS = 52;
	
	private Card[] deck = new Card[NUMBER_OF_CARDS]; // card references 
	private int currentCard = 0;
	
	// constructor fills deck of Cards
	public DeckOfCards()
	{
		int[] faces = {1, 2, 3, 4, 5, 6,
				7, 8, 9, 10, 11};
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
		
		// populate deck with Card objects
		for (int count = 0; count < deck.length; count++)
		{
			deck[count] =
				new Card(faces[count % 11], suits[count / 13]);
		} // end of for loop 
	} // end of DeckOfCards Constructor 
	
	// shuffle deck of Cards with one-pass algorithm 
	public void shuffle()
	{
		// next call to method dealCard should start at deck[0] again 
		currentCard = 0;
		
		// for each Card, pick another random Card (0-51) and swap them 
		for (int first = 0; first < deck.length; first++)
		{
			// select a random number between 0 and 51
			int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
			
			// swap current Card with randomly selected Card
			Card temp = deck[first];
			deck[first] = deck[second];
			deck[second] = temp;
		} // end of for loop
	} // end of shuffle method 
	
	// deal one card 
	public Card dealCard()
	{
		// determine whether Cards remain to be dealt
		if (currentCard < deck.length)
		{
			return deck[currentCard++]; // return current Card in array
		}
		else 
		{
			return null; // return null to indicate that all Cards were dealt
		} // end of if/else 
	} // end of dealCard method
} // end of DeckOfCards class
