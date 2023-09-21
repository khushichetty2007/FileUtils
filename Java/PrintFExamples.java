/**
 *@author Khushi Chetty
 **/
 
 public class PrintFExamples
 {
	 public static void main(String [] args)
	 {
		 int i = 23;
		 double e = 23.5;
		 String str = "hello world";
		 
		 // outputs String 
		 System.out.printf("%s after \n", str); //open format
		 System.out.printf("%20s after\n", str);// right justified
		 System.out.printf("%-20s after\n", str);//left justify
		 
		 //output integers
		 System.out.printf("%d after \n", i);//open format
		 System.out.printf("%20d after \n", i); //right justify
		 System.out.printf("%-20d after \n", i); //left justify
		 
		 // output double number
		 System.out.printf("%f after \n", e);//open format
		 System.out.printf ("%20f after \n", e);//right justified
		 System.out.printf("%20.2f after \n", e);// decimal places
		 System.out.printf("%20e after \n", e);//print exponent using base 10
		 
		 //formating text
		 String mystr = String.format(
		 System.out.println(mystr);
	 }
 }
