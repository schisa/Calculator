	// Catch exceptions
	import java.util.InputMismatchException;
	// Scanner for user input
	import java.util.Scanner;
	// Import so I don't need to us system.print and I can just use out.print 
	import static java.lang.System.out;

	//Start the calculator class 
	public class Calculator  {
		// This class asks a user to input a number 1-5 for what type of calculation they want to do
		// If the user inputs a non-int or a non menu choice it will return an error message
		// The user then inputs two floats and the program calculates the result
		public static int menu(Scanner userInput) {
			//Create inputInt for value to be returned to main method
			int inputInt;
			do { // Loop until the user enters a value between 1 and 5
				try {
					// Get users input for menu choice
					inputInt = userInput.nextInt(); 
					//Check to see to see if user inserted the correct values 
					if (inputInt >= 1 && inputInt <= 5) {
						//Leave loop since the user used a correct value
						break; 
					} 
					//Else statement to catch all integer inputs that are not a menu choice.  
					else {
						out.println("That is not a menu option. Please re-enter your choice: ");
						continue; // Not a valid
					}
				//Catch the exception if the user tries to input a non integer value 	
				} catch (final InputMismatchException e) {
				    	out.println("You have entered an invalid choice, please re-enter your choice: ");
				    	// discard the invalid input
				    	userInput.nextLine(); 
				    	// Start loop again because the user needs to choose valid inputs
						continue; 
				}
			//Infinite loop. User must stay in this method until they input a correct value. 
			} while (true);
			//Return the users menu option to main method
			return inputInt;
		}
		//Method for setting the math operation string when the user is inputting floats 
		//For example, when a user decides to use addition it will ass the user which floats they would like to add
		public static String mathOperationString1(int menuChoice){
		//Create choice to return to main method
		String choice = "";
		//Check if user inputs 5 to exit the program. Set string 
		switch(menuChoice){
			// Addition.
			case 1: choice = "add";
					//Leave switch 
					break;
			// Subtract
			case 2: choice = "subtract";
					//Leave switch 
					break;
			// Multiply 
			case 3: choice = "multiply";
					//Leave switch 
					break;
			// Divide 
			case 4: choice = "divide";
					//Leave switch 
					break; 
			// Exit 
			case 5: //Display goodbye message
					out.println("Thanks for using Stephen Chisa's Handy Calculator");
					//Exit the program 
					System.exit(0);	
		}
		//Return string to main
		return choice; 
		}
		// Method for setting the math operation string in the final result 
		// For example, when a user decides to use addition the final string will include the word "adding".
		public static String mathOperationString2(int menuChoice){
		//Create choice to return to main method
		String choice = "";
		//Check if user inputs 5 to exit the program. Set string 
		switch(menuChoice){
			//Menu 1: addition.
			case 1: choice = "adding";
					//Leave switch 
					break;
			//Menu 2: subtract
			case 2: choice = "subtracting";
					//Leave switch 
					break;
			//Menu 3: multiply 
			case 3: choice = "multiplying";
					//Leave switch 
					break;
			//Menu 4: Divide 
			case 4: choice = "dividing";
					//Leave switch 
					break; 
		}
		// Return string to main
		return choice; 
		}
		// Method for user to input two float values 
		public static void getCalcFloats(int menuChoice ,String mathString ,float [] myFloats, Scanner userInput){
			out.printf("Enter two floats to %s, separated by a space: ", mathString);
			do { // Loop until we have correct input
				try {
					//Get user input for two floats
					myFloats[0] = userInput.nextFloat();
					myFloats[1] = userInput.nextFloat(); 
					//check if the user is trying to divide by 0
					if(menuChoice == 4 && myFloats[1] == 0){
						out.println("You cannot divide by zero please reenter both floats: ");
						// Start loop again because the user needs to choose valid inputs
						continue;
					}
					// leave the loop since the user provided valid input
					break; 
				} 
				// Catch the exception if the user tries to insert a non-float value
				catch (final InputMismatchException e) {
					out.println("You have entered invalid floats please re-enter: ");
					// discard non-float value 
					userInput.nextLine(); 
					// Start loop again because the user needs to choose valid inputs
					continue; 
				}
			// Infinite loop. User must stay in this method until they input a correct value. 
			} while (true);
		}
		// Method for calculating
		public static float calcValues(int menuOption, float number1, float number2){
			float result = 0; 
			// Start a switch based on the users menu option
			switch(menuOption){
				// Addition 
				case 1: // Calculate First float + second float 
						result = number1 + number2;
						break;
				// Subtraction 
				case 2: // Calculate first float - second float
						result = number1 - number2;
						break; 
				// Multiplication 
				case 3: // Calculate first float * second float 
						result = number1 * number2; 
						break;
				// Division 
				case 4: // Calculate result for number1/number2
						// I previously checked if number2 is 0
						result = number1 / number2; 
					    break;
				}
			// Return the calculated value 
			return result; 
		}
		// Main Method 
		public static void main(String[] args) {
			// Begin do while loop so program keeps running until the user exits.
			do{
				// Welcome the user to the calculator. Display menu.
				out.println("Welcome to Stephen Chisa's Handy Calculator");
				out.print("\n\t1.Addition \n\t2.Subtraction \n\t3.Multiplication \n\t4.Division \n\t5.Exit \n\nWhat would you like to do? ");
				// Enable scanner
				Scanner input = new Scanner(System.in);
				// Run the menu method and store the values in menuChoice 
				int menuChoice = menu(input);
				// Run method to get a string for "add", "subtract", "multiply" or "divide" 
				String mathFirstString = mathOperationString1(menuChoice);
				float [] calcFloats = new float[2];
				// Run the getTwoFloats method. Return the values into the myFloats array
				getCalcFloats(menuChoice, mathFirstString,calcFloats, input); 
				// Run method to get a string for "adding", "subtracting", "multiplying" or "dividing" 
				String mathSecondString = mathOperationString2(menuChoice);
				// Calculate the result of the inputs 
				float Calculated = calcValues(menuChoice, calcFloats[0], calcFloats[1]);
				// Display the result of the calculation
				out.printf("Result of %s %.2f and %.2f is: %.2f.", mathSecondString,calcFloats[0], calcFloats[1], Calculated);
			    // Press enter to continue message 
			    out.println("\n\nPress enter key to continue..."); 
				input.nextLine();
				// Pause until user presses enter  
				input.nextLine();
 
			}while(true);
		}
	}


