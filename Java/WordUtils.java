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
		loadWords();
	}
	
	/**	Load all of the dictionary from a file into words array. */
	private void loadWords () {
		Scanner input = null;
		input = FileUtils.openToRead(WORD_FILE);
		int count = 0;
		while(input.hasNext())
		{
			words[count] = input.next();
			count++;
		}	
		
		input.close();
	}
	
	/**	Find all words that can be formed by a list of letters.
	 *  @param letters	string containing list of letters
	 *  @return			array of strings with all words found.
	 */
	public String [] findAllWords (String letters)
	{
		int count = 0;
		boolean check = true;
		boolean bool = true;
		String [] matched = new String [words.length];
		char c = '?';
		
		String newLetters = new String("");
		for(int i = 0; i < words.length; i++)
		{
		    if (words[i].length() <= letters.length()) 
		    {
		    	newLetters = letters;
		    	for(int j = 0; j < words[i].length(); j++)
				{
					bool = true;
					c = words[i].charAt(j);
					if(newLetters.length() >= 1)
					{
						if(newLetters.indexOf(c) == -1)
						{
							check = false;
							j = words[i].length();
						}
						else if(newLetters.length() >= 1)
						{
							String string1 = new String("");
							String string2 = new String("");
							int num = 0;
							num = newLetters.indexOf(c);
							string1 = newLetters.substring(0,num);
							string2 = newLetters.substring(num+1,newLetters.length());
							newLetters = string1+string2;
						
							if((words[i].length() == j+1) && (words[i].length() < letters.length()))
							{
							matched[count] = words[i];
							count++;
							bool = false;
							}
						} // else if
				    } //if
					else
						j = words[i].length();
			    } // for
				
				if(check && bool)
				{
					matched[count] = words[i];
					count++;
				}
				check = true;
			
		    } // if
		}// for

		return matched;	
	}
	
	/**	Print the words found to the screen.
	 *  @param wordsList	array containing the words to be printed
	 */
	public void printWords (String [] wordList)
	{ 
		System.out.println();
		for (int i = 0; i < wordList.length; i++) 
		{
			if(wordList[i] != null)
			{
				if((i + 1) % 5 != 0)
					System.out.printf("%-15s\t", wordList[i]);
					else
						System.out.printf("%-15s\n", wordList[i]);
			}
		}
		System.out.println();

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
		int num = 0;
		int length = 0;
		int [] listScores = new int [wordList.length];
		for (int i=0 ;i<wordList.length; i++)
		{
			if(wordList[i] != null) 
				length++;
		}
		for(int a = 0; a < length; a++)
		{
			listScores[a] = getScore(wordList[a], scoreTable);
		}
		
		int count = 0;
		for(int j = 1; j < listScores.length; j++)
		{
				num = listScores[j];
				if(listScores[j] > num)
				{
					num = listScores[j];
					count = j;
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
			int num = 0;
			num = word.charAt(i) - 'a';
			finalScore += scoreTable[num];
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
