import java.util.Scanner;

// Card shuffling and dealing

public class HSCardGame
{
	public static void main(String[] args)
	{
		char ans;
		String answer;
		Scanner input = new Scanner(System.in);

		introduction();
		TwentyOne.playGame();

		System.out.println("Would you like to play again: ");
		answer = input.nextLine().toUpperCase();
		ans = answer.charAt(0);
		
		while (ans == 'Y')
		{
			TwentyOne.playGame();
			System.out.println("Would you like to play again: ");
			answer = input.nextLine().toUpperCase();
			ans = answer.charAt(0);
		}
		
	}
	private static void introduction() 
	{
		System.out.println("Hello and welcome to the Card Game 21");
		System.out.println("\nThe objective is to get 21 as the hand you have by adding the cards that you get.");
		System.out.println("You are not trying to beat each other you are trying to beat the dealer (who is also playing)");
		System.out.println("");
		System.out.println("Keep in mind Kings, Jacks, and Queens are all worth 10 \n");
	}
} 
