
/**
 *	Counts the frequency of letters in a file and produces a histogram.
 *
 *	@author	Khushi Chetty
 *	@since	9/14/2023
 */
public class LetterCount {
	
	// Fields go here, all must be private
	private int []letterCount;
	/* Constructor */							
	public LetterCount()
	{
		letterCount = new int [26]; // array for counting number of letters. 
	}
	
	/* Main routine */
	public static void main(String[] args) {
		LetterCount lc = new LetterCount();
		if (args.length != 1)
			System.out.println("Usage: java LetterCount <inputFile>");
		else
			lc.run(args);
	}
	
	/**	The core program of the class, it
	 *	- opens the input file
	 *	- reads the file and counts the letters
	 *	- closes the input file
	 *	- prints the histogram of the letter count
	 */
	public void run(String[] args) {
		String fileName = args[0];
		Scanner readIn = FileUtils.openToRead(fileName);
		while (readIn.hasNext())
		{
			String str = readIn.next();
			for (int i = 0; i< str.length() ; i++)
			{
				String str2 = str.toLowerCase();
				char letter = str.charAt(i);
				if (letter >= 97 && letter <= 122)
				{
					int index = letter -97;
					letterCount[index] ++; 
				}
			}
		}
		System.out.print(" Histogram of letter frequency in " + fileName);
		int maxVal = 0;
		for (int i = 0; i< letterCount.length ; i++)
		{
			maxVal = Math.max(maxVal, letterCount[i]);
		}
		for (int j = 0; j< letterCount.length ; j++)
		{
			System.out.printf("%s:%5d ", "" + char(j+97), letterCount[i]);
			for (in x = 0; x< letterCount.length ; x++)
			{
				int number = letterCount[x];
				int plus = (int) (number *60 / maxVal);
				
			}
		}
	}
	
}
