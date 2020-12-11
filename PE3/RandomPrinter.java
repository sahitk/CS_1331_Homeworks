//I worked on the homework assignment alone, using only course materials

import java.util.Random;

public class RandomPrinter {
	public static void main(String args[]) {
		Random rand = new Random();
		randomController(rand);
	}

	public static void powersOfTwo() {
		System.out.printf("Running the powersOfTwo method%n");
		double exp=0.0;
		int result=1;
		while((int)Math.pow(2.0,exp)<100) {
			result=(int)Math.pow(2.0,exp);
			System.out.printf("    2 raised to the %d is %d%n",(int)exp,result);
			exp++;
		}
	}

	public static void parameterPrinter(int parameter) {
		System.out.printf("Running the parameterPrinter method%n");
		System.out.printf("    Method took the parameter %d%n",parameter);
	}

	public static void randomNumber() {
		System.out.printf("Running the randomNumber method%n");
		int num=(int)(Math.random()*9+1.5);
		System.out.printf("    Your random number is %d%n",num);
	}

	public static void randomController(Random rand) {
		System.out.printf("Starting to call the methods!%n");
		
		int random=rand.nextInt(5)+1;
		for (int i=0;i<random;i++) {
			powersOfTwo();
		}

		random=rand.nextInt(5)+5;
		parameterPrinter(random);

		random=rand.nextInt(10)+1;
		for (int i=0;i<random;i++) {
			randomNumber();
		}
	}
}
