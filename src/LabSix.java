import java.util.Scanner;

/*
 * 
 * Zachariah Zatina
 * 
 * Takes a string and translates it into Pig Latin
 * 
 */
public class LabSix {

	public static void main(String[] args) {
		// Variable list
		Scanner scnr = new Scanner(System.in);
		String input;
		String cont = "a";
		boolean bigLoopRun = true;
		boolean smallLoopRun = true;
		
		// App intorduction
		System.out.println("Welcome to the English to Pig Latin translator!");
		System.out.println("===============================================");
		System.out.println("");

		// While loop to keep application going based on user input
		while (bigLoopRun == true) {
			// have this here so it resets the loop later and allows app to ask to continue
			// after the second round and beyond
			smallLoopRun = true;
			
			// Prompt for user input
			System.out.print("Enter what you want to have translated: ");
			input = scnr.nextLine();
			
			// Part that calls methods and changes the string as needed.
			input = getLowerCase(input);
			input = translatePigLatin(input);
			input = capitalizeFirstLetter(input);
			
			// Output of the translated word
			System.out.println("");
			System.out.println(input);
			
			// Asking user if they want to go again.
			System.out.println("");
			System.out.print("Would you like to have another word translated? (y/n): ");
			// This while loop is to see if the entire app loops again AND validates for non
			// 'y' and 'n' responses
			while (smallLoopRun == true) {
				cont = scnr.next();
				scnr.nextLine();
				
				// if else loop to test if the user wants to use the application again
				if (cont.equalsIgnoreCase("y")) {
					smallLoopRun = false;
					System.out.println("");
					continue;
				} else if (cont.equalsIgnoreCase("n")) {
					smallLoopRun = false;
					bigLoopRun = false;
				} else {
					System.out.print("That is not a valid response (y/n): ");
				}
			}
		}
		
		System.out.println("");
		System.out.println("Thank you for using this application!");
		scnr.close();

	}
	// Method to turn the entire word to lower case.
	public static String getLowerCase(String word) {
		return word.toLowerCase();
	}
	
	// Method to actually translate the word to pig latin, accounts for if the first word is a vowel or not
	public static String translatePigLatin(String word) {
		String letter;
		String restWord;
		letter = word.substring(0, 1);
		restWord = word.substring(1);

		if (letter.equalsIgnoreCase("a") || letter.equalsIgnoreCase("e") || letter.equalsIgnoreCase("i")
				|| letter.equalsIgnoreCase("o") || letter.equalsIgnoreCase("u")) {
			return letter + restWord + "way";
		} else {
			return restWord + letter + "ay";
		}
	}
	// Method to capitalize the first letter of the newly translated pig-latin word.
	public static String capitalizeFirstLetter(String word) {
		String letter;
		String restWord;
		letter = word.substring(0, 1);
		restWord = word.substring(1);

		return letter.toUpperCase() + restWord;
	}

}
