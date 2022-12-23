import java.util.*;

public class TwentyOne 
{
	public static void playGame()
	{
		Scanner input = new Scanner(System.in);

		DeckOfCards myDeckOfCards = new DeckOfCards();
		Stack <Card> player = new Stack<Card>();
		Stack <Card> dealer = new Stack<Card>();
		myDeckOfCards.shuffle();
		
		for (int k = 0; k < 2; k++ )
		{
			player.push(myDeckOfCards.dealCard());
			dealer.push(myDeckOfCards.dealCard());
		}
		System.out.print("Dealers first card: ");
		int dealOne = dealer.pop().getface();
		System.out.println(dealOne);

		System.out.print("Your cards: ");
		int first = player.pop().getface();
		int second = player.pop().getface();
		System.out.print(first);
		System.out.println("," + second);

		System.out.println("You are trying to get close to 21");
		System.out.println("If your total is more than 21 you're out of the game");
		System.out.print("Your total is " );
		int total = first + second;
		System.out.println(total);
		if (total > 21)
		{
			System.out.println("You lost the game");
			System.out.println("Your total was greater than 21");
			System.out.println("Try again thanks for playing");
			System.out.println();
			return;
		}

		System.out.print("Would you like to get another card (hit) ");
		System.out.println("or would you like to stay");
		System.out.print("Your Choice: ");
		String answer = input.nextLine().toUpperCase();
		char ans = answer.charAt(0);

		while (ans == 'Y' || ans == 'H')
		{
			player.push(myDeckOfCards.dealCard());
			System.out.print("Your new card is: ");
			int newCard = player.pop().getface();
			System.out.println(newCard);

			total += newCard;
			System.out.println("New total: " + total);

			if (total > 21)
			{
				System.out.println("You lost the game");
				System.out.println("Your total was greater than 21");
				System.out.println("Try again thanks for playing");
				System.out.println();
				return;
			}

			System.out.println("Would you like to hit: ");
			answer = input.nextLine().toUpperCase();
			ans = answer.charAt(0);
		}

		int dealTwo = dealer.pop().getface();
		System.out.println("Dealers second card: " + dealTwo);

		int dealTotal = dealOne + dealTwo;
		System.out.println("Dealers total is: " + dealTotal);
		System.out.println("Dealer must hit until they get greater than 16");
		while (dealTotal < 17)
		{
			dealer.push(myDeckOfCards.dealCard());
			int dealerNew = dealer.pop().getface();
			System.out.println("Dealers new card is: " + dealerNew);

			dealTotal += dealerNew;
			System.out.println("New Dealer Total: " + dealTotal);
			System.out.println();
			if (dealTotal > 21)
			{
				System.out.println("You win the game");
				System.out.println("Dealer total was greater than 21");
				System.out.println("Thanks for playing");
				System.out.println();
				return;
			}
			else if (dealTotal == 21)
			{
				System.out.println("You lost the game");
				System.out.println("Dealer total was 21");
				System.out.println("Try again thanks for playing");
				System.out.println();
				return;
			}
			if (dealTotal > 16)
			{
				break;
			}
		}
		if (total > dealTotal)
		{
			System.out.println("Your total: " + total);
			System.out.println("You win the game");
			System.out.println("Your total was closer to 21");
			System.out.println("Thanks for playing");
			System.out.println();
			return;
		}
		else 
		{
			System.out.println("You lost the game");
			System.out.println("Dealer total was closer to 21");
			System.out.println("Try again thanks for playing");
			System.out.println();
			return;
		}
	} 
}