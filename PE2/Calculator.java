import java.util.Scanner;

public class Calculator {
	public static void main(String args[]) {
		String operation;
		int firstNumber;
		int secondNumber;
		int result;

		Scanner takesInput = new Scanner(System.in);
		System.out.println("What operation would you like to perform (Addition, Multiplication, Division, or Subtraction)?");
		operation = takesInput.nextLine().toUpperCase();

		System.out.println("Enter your first number:");
		firstNumber = takesInput.nextInt();

		System.out.println("Enter your second number:");
		secondNumber = takesInput.nextInt();

		switch(operation) {
			case "ADDITION":
			result=firstNumber+secondNumber;
			System.out.printf("We added %d and %d. The answer is %d.",firstNumber,secondNumber,result);
			break;

			case "MULTIPLICATION":
			result=firstNumber*secondNumber;
			System.out.printf("Here we multiplied %d and %d. The answer is %d.",firstNumber,secondNumber,result);
			break;

			case "DIVISION":
			result=firstNumber/secondNumber;
			System.out.printf("This time we divided %d and %d. The answer is %d.",firstNumber,secondNumber,result);
			break;

			case "SUBTRACTION":
			result=firstNumber-secondNumber;
			System.out.printf("%d and %d were subtracted. The answer is %d.",firstNumber,secondNumber,result);
			break;

			default:
			System.out.printf("That is not a valid operation!");
		}


	}
}
