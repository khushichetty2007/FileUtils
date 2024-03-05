import java.util.List;		// used by expression evaluator
import java.util.Scanner;
/**
 *	<Description goes here>
 *
 *	@author	Khushi Chetty
 *	@since	Mar 2 2024
 */
public class SimpleCalc {
	
	private ExprUtils utils;	// expression utilities
	
	private ArrayStack<Double> valueStack;		// value stack
	private ArrayStack<String> operatorStack;	// operator stack

	// constructor	
	public SimpleCalc() {
		
	}
	
	public static void main(String[] args) {
		SimpleCalc sc = new SimpleCalc();
		sc.run();
	}
	
	public void run() {
		System.out.println("\nWelcome to SimpleCalc!!!");
		runCalc();
		System.out.println("\nThanks for using SimpleCalc! Goodbye.\n");
	}
	
	/**
	 *	Prompt the user for expressions, run the expression evaluator,
	 *	and display the answer.
	 */
	public void runCalc() {
		String str  = new String();
		
		while ( !(str.equalsIgnoreCase("q")))
		{
			str = Prompt.getString("");
			if (str.equalsIgnoreCase("h"))
			{
				printHelp();
			}
			else
			{
				tokenize(str);
				evaluateExpression
			}
		}
		
		
	}
	public void tokenize(String str)
	{
		for (int i = 0; i<str.length(); 
		{
			int num = 0;
			String letter = new String();
			String numStr = new String();
			letter = str.substring(i, i+1);
			if (letter.charAt(0)>= 48 && letter.charAt(0)<=57)
			{
				while (letter.charAt(0)>= 48 && letter.charAt(0)<=57)
				{
					numStr += letter;
					i++;
				}
				num = Integer.parseDouble(numstr);
				valueStack.add(num);
				
			}
			else 
			{
				if(hasPrecedence(letter, operatorStack.get(i-1)))
				{
					operatorStack.add(letter);
					i++;
				}
				else
				{
					evaluateExpression(operatorStack);
					
				}
		}
	}
	
	/**	Print help */
	public void printHelp() {
		System.out.println("Help:");
		System.out.println("  h - this message\n  q - quit\n");
		System.out.println("Expressions can contain:");
		System.out.println("  integers or decimal numbers");
		System.out.println("  arithmetic operators +, -, *, /, %, ^");
		System.out.println("  parentheses '(' and ')'");
	}
	
	/**
	 *	Evaluate expression and return the value
	 *	@param tokens	a List of String tokens making up an arithmetic expression
	 *	@return			a double value of the evaluated expression
	 */
	public double evaluateExpression(List<String> tokens) {
		double value = 0;
		
		return value;
	}
	
	/**
	 *	Precedence of operators
	 *	@param op1	operator 1
	 *	@param op2	operator 2
	 *	@return		true if op2 has higher or same precedence as op1; false otherwise
	 *	Algorithm:
	 *		if op1 is exponent, then false
	 *		if op2 is either left or right parenthesis, then false
	 *		if op1 is multiplication or division or modulus and 
	 *				op2 is addition or subtraction, then false
	 *		otherwise true
	 */
	private boolean hasPrecedence(String op1, String op2) {
		if (op1.equals("^")) return false;
		if (op2.equals("(") || op2.equals(")")) return false;
		if ((op1.equals("*") || op1.equals("/") || op1.equals("%")) 
				&& (op2.equals("+") || op2.equals("-")))
			return false;
		return true;
	}
	 
}
