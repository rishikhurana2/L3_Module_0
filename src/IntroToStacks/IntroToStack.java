package IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class IntroToStack {
	public static void main(String[] args) {
		//1. Create a Stack of Doubles
		//   Don't forget to import the Stack class
		Stack<Double> s = new Stack<Double>();
		//2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		for (double i = 0; i < 101; i++) {
			Random r = new Random();
			double j = r.nextDouble() * 100;
			s.push(j);
		}
		//3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
		String num1 = JOptionPane.showInputDialog("Enter One number");
		String num2 = JOptionPane.showInputDialog("Enter another");
		int NUM1 = Integer.parseInt(num1);
		int NUM2 = Integer.parseInt(num2);
		//4. Pop all the elements off of the Stack. Every time a double is popped that is
		//   between the two numbers entered by the user, print it to the screen.
		System.out.println("Popping elements off stack...");
		System.out.println("Elements between " + NUM1 + " and " + NUM2);
		for (int i = 0; i < s.size(); i ++) {
			if (s.get(i) > NUM1 && s.get(i) < NUM2) {
				System.out.println(s.get(i));
			}
		}
		//   EXAMPLE:
		//   NUM 1: 65
		//   NUM 2: 75
		
		//   Popping elements off stack...
		//   Elements between 65 and 75:
		//   66.66876846
		//   74.51651681
		//   70.05110654
		//   69.21350456
		//   71.54506465
		//   66.47984807
		//   74.12121224
	}
}
