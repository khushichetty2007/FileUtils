/**
 *	Provides utilities for word games:
 *	1. finds all words in the dictionary that match a list of letters
 *	2. prints an array of words to the screen in tabular format
 *	3. finds the word from an array of words with the highest score
 *	4. calculates the score of a word according to a table
 *
 *	Uses the FileUtils and Prompt classes.
 *	
 *	@author Khushi Chetty
 *	@since	October 22 2023
 */
import java.util.Scanner; 
public class WordUtils
{
	private String[] words;		// the dictionary of words
	
	// File containing dictionary of almost 100,000 words.
	private final String WORD_FILE = "wordList.txt";
	
	/* Constructor */
	public WordUtils() 
	{ 
		words = new String [90934];
	}
	
	/**	Load all of the dictionary from a file into words array. */
	private void loadWords () {
		Scanner input = FileUtils.openToRead(WORD_FILE);
		int count = 0;
		while (input.hasNext())
		{
			words[count] = input.next();
			//input.nextLine();
			count++;
		}
	}
	
	/**	Find all words that can be formed by a list of letters.
	 *  @param letters	string containing list of letters
	 *  @return			array of strings with all words found.
	 */
	public String [] findAllWords (String letters)
	{
		boolean ifTrue = true;
		int counter = 0;
		String [] match= new String[words.length];
		for (int i = 0; i<words.length; i++)
		{
			for (int x =0; x<words[i].length(); x++)
			{
				if(letters.indexOf(words[i].charAt(x))==-1)
				{
					x= words[i].length();
					ifTrue = false;
				}
				else
				{
					letters = letters.substring(x,x+1);
				}
			}
			if (ifTrue)
			{
				match[counter] = words[i];
				counter++;
			}
		}
		return match;
	}
	
	/**	Print the words found to the screen.
	 *  @param wordsList	array containing the words to be printed
	 */
	public void printWords (String [] wordList)
	{ 
		for (int a = 0; a < wordList.length; a++) {
			if ((a+1)%5!=0)
			{
				System.out.printf("%-15s\t", wordList[a]);
			}
			else
			{
				System.out.printf("%-15s\n", wordList[a]);
			}
		}
	}
	
	/**	Finds the highest scoring word according to a score table.
	 *
	 *  @param word  		An array of words to check
	 *  @param scoreTable	An array of 26 integer scores in letter order
	 *  @return   			The word with the highest score
	 */
	public String bestWord (String [] wordList, int [] scoreTable)
	{
		String best = "";
		int count = 0;
		int bestScore = 0;
		int score = 0;
		int [] listScore = new int [wordList.length];
		for (int i=0 ;i<wordList.length; i++)
		{
			score = getScore (wordList[i], scoreTable);
			listScore[i] = score;
		}
		for (int a = 0; a<listScore.length; a++)
		{
			bestScore = listScore[a];
			
			if (bestScore <listScore[a])
			{
				bestScore = listScore[a];
				count = a;
			}
		}
		best = wordList[count];
		return best;
	}
	
	/**	Calculates the score of one word according to a score table.
	 *
	 *  @param word			The word to score
	 *  @param scoreTable	An array of 26 integer scores in letter order
	 *  @return				The integer score of the word
	 */
	public int getScore (String word, int [] scoreTable)
	{
		int finalScore = 0;
		word = word.toLowerCase();
		for (int i = 0; i<word.length(); i++)
		{
			
				int num = word.charAt(i)-'a';
				finalScore += scoreTable[num];
				System.out.print(finalScore);
		}
		return finalScore;
	}
	
	/***************************************************************/
	/************************** Testing ****************************/
	/***************************************************************/
	public static void main (String [] args)
	{
		WordUtils wu = new WordUtils();
		wu.run();
	}
	
	public void run() {
		String letters = Prompt.getString("Please enter a list of letters, from 3 to 12 letters long, without spaces");
		loadWords();
		String [] word = findAllWords(letters);
		System.out.println();
		printWords(word);
		
		// Score table in alphabetic order according to Scrabble
		int [] scoreTable = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
		String best = bestWord(word,scoreTable);
		System.out.println("\nHighest scoring word: " + best + "\nScore = " 
							+ getScore(best, scoreTable) + "\n");
	}
}
