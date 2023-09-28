
/**
 *	MVCipher - This program takes a word as input for the key. Using this key
 * it encrypts the text in a text file. To encrypt it shifts the letters accordinng
 * to what position the letter in the key holds. It does this will the end
 * of the text file. Then it writes it to a new text file. To decrypt it 
 * does the same thing but backwards and writed it to the decrypt file. 
 *	Requires Prompt and FileUtils classes.
 *	
 *	@author	Khushi Chetty
 *	@since	Sep 21 
 */
 
import java.util.Scanner;
public class MVCipher 
{
	
	private String key ;
	private int choice;
	private String inputFile;
	private String outputFile;
	private String str;
		
	/** Constructor */
	public MVCipher() 
	{
		key = "";
	}
	
	public static void main(String[] args) {
		MVCipher mvc = new MVCipher();
		mvc.run();
	}
	
	/**
	 *	Method header goes here
	 */
	public void run() 
	{
		System.out.println("\n Welcome to the MV Cipher machine!\n");
		
		/* Prompt for a key and change to uppercase
		   Do not let the key contain anything but alpha
		   Use the Prompt class to get user input */
		do 
		{
			key = Prompt.getString("Please input a word to use as key (letters only) ->");
		}while(key.length()< 3);
		key = key.toUpperCase();
		
		/* Prompt for encrypt or decrypt */
		do 
		{
			choice = Prompt.getInt("Encrypt or decrypt?", 1, 2);
		}while( !(choice == 1 ||  choice == 2));
		if (choice == 1)
		{
			encrypt();
		}
		else
			decrypt();
			
		/* Prompt for an input file name */
		if (choice ==1)
		{
			String question = "Name of file to encrypt";
		}
		else 
			String question = "Name of file to decrypt";

		inputFile= Prompt.getString (question);
		/* Prompt for an output file name */
		outputFile = Prompt.getString("Name of output file -> ");
		
		/* Read input file, encrypt or decrypt, and print to output file */
		Scanner readIn = FileUtils.openToRead(inputFile);
		while (readIn.hasNextLine())
		{
			str += readIn.nextLine();
			str += "\n";
			encypt();
		}
		
		/* Don't forget to close your output file */
		if (choice == 1)
		{
			encrypt();
		}
		else
			decrypt();
	}
	public void encrypt ()
	{
		for (int x = 0; x<str.length() ; x++)
		{
			str.charAt(x);
			
		}
	}
	public void decrypt()
	{
	}
	
	// other methods go here
	
}
