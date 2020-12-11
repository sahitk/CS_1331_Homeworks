//I worked on the homework assignment alone, using only course materials

public class Groceries {
	public static void main(String args[]) {
		String name="Brad";
		int cash=50;
		double taxRate=0.1;
		double subtotal=42.3;
		double change=cash-subtotal*(1+taxRate);
		System.out.printf("%s has $%.2f dollars remaining!\n%s started with %d dollars!",name,change,name,cash);
	}
}
