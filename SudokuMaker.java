/**
 *	SudokuMaker - Creates a Sudoku puzzle using recursion and backtracking
 *
 *	@author
 *	@version
 *
 */
public class SudokuMaker {

	private int[][] puzzle;
	private String str;
	
	public SudokuMaker()
	{
		puzzle = new int[9][9];
		str = "";
	}
	public void fillInRow()
	{
		String str = 
		boolean bool = false;
		 if (puzzles[0][9] != 0)
		 {
			 move();
		 }
			 
		while(bool == false)
		{
			
		}
			

	}
	public void checkColumn
		
	/**
	 *	printPuzzle - prints the Sudoku puzzle with borders
	 *	If the value is 0, then print an empty space; otherwise, print the number.
	 */
	public void printPuzzle() {
		System.out.print("  +-----------+-----------+-----------+\n");
		String value = "";
		for (int row = 0; row < puzzle.length; row++) {
			for (int col = 0; col < puzzle[0].length; col++) {
				// if number is 0, print a blank
				if (puzzle[row][col] == 0) value = " ";
				else value = "" + puzzle[row][col];
				if (col % 3 == 0)
					System.out.print("  |  " + value);
				else
					System.out.print("  " + value);
			}
			if ((row + 1) % 3 == 0)
				System.out.print("  |\n  +-----------+-----------+-----------+\n");
			else
				System.out.print("  |\n");
		}
	}
}
