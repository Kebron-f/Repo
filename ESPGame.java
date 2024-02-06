/*
 * Class: CMSC203 
 * Instructor:Ahmed Tarek
 * Description: This program imitates the EPS game.
   It accepts console input from the user and provides
    information on the console window.This program also
    tracks score of every time it runs.
 * Due: 02/06/2024
 * Platform/compiler:
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: ____Kebron_Ghile______
*/
import java.util.Scanner;
public class ESPGame {

	public static void main(String[] args) {
		
		final String colorRed="Red";
		final String colorOrange="Orange";
		final String colorYellow="Yellow";
		final String colorGreen="Green";
		final String colorBlue="Blue";
		final String colorPurple="Purple";
		final String colorIndego="Indego";
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		
		String name = input.nextLine();
		
		System.out.print("Describe yourself: ");
		String selfDescripion = input.nextLine();
		
		int randomNumber ;
		String randomColor = "";
		int score = 0;
		
		for(int i = 1 ; i <= 10; i++) {
			System.out.println("\nRound " + i + "\n");
			randomNumber = (int)(Math.random()*6);
			switch(randomNumber) {
			case 0:
				randomColor = colorRed;
				break;
			case 1:
				randomColor = colorOrange; 
				break;
			case 2:
				randomColor = colorYellow;
				break;
			case 3:
				randomColor = colorGreen;
				break;
			case 4:
				randomColor = colorBlue;
				break;
			case 5:
				randomColor = colorPurple;
				break;
			case 6:
				randomColor = colorIndego;
				break;
			}
			
			String colorChoice=null;
			
			
			//System.out.println("The random Number we are looking for is " + randomColor);
			do {
				System.out.println("I am thinking of a color.");
				System.out.println("Is it Red,Orange,Yellow,Green,Blue,Purple,Indego");
				System.out.println("Enter your Guess : ");
				colorChoice = input.nextLine();
				
				if(colorChoice.equalsIgnoreCase(randomColor)) {
					System.out.println("You got it right! I was thinking of "+ randomColor + ".");
					score ++;
					break;
				}
				
				else if(
						colorChoice.equalsIgnoreCase(colorRed) ||
						colorChoice.equalsIgnoreCase(colorOrange) ||
						colorChoice.equalsIgnoreCase(colorYellow) ||
						colorChoice.equalsIgnoreCase(colorGreen) ||
						colorChoice.equalsIgnoreCase(colorBlue) ||
						colorChoice.equalsIgnoreCase(colorPurple) ||
						colorChoice.equalsIgnoreCase(colorIndego))
				{
					System.out.println("I was thinking of " + randomColor+ ".");
					
					break;
					
				}
				
				System.out.println("Please choose from the colors provided.");
				
			} while(!colorChoice.equalsIgnoreCase(colorRed) ||
					!colorChoice.equalsIgnoreCase(colorOrange) ||
					!colorChoice.equalsIgnoreCase(colorYellow) ||
					!colorChoice.equalsIgnoreCase(colorGreen) ||
					!colorChoice.equalsIgnoreCase(colorBlue) ||
					!colorChoice.equalsIgnoreCase(colorPurple) ||
					!colorChoice.equalsIgnoreCase(colorIndego));
		}
		//System.out.println(randomColor);
		System.out.println("\nGame Over\n");
		System.out.println("You've guessed " + score + " out of 10 colors correctly.");
		System.out.println("User Name :" + name);
		System.out.println("User Description :" + selfDescripion);
		System.out.println("Due Date: 02/06/2024");
		
		
	}

}
