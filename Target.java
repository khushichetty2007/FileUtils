/**
 *	Target.java
 *
 *	To compile Linux:	javac -cp .:acm.jar Target.java
 *	To execute Linux:	java -cp .:acm.jar Target
 *	To compile MS Powershell:	javac -cp ".;acm.jar" Target.java
 *	To execute MS Powershell:	java -cp ".;acm.jar" Target
 *
 *	@author	Khushi
 *	@since	September 19 2023
 */
 
/*	All package classes should be imported before the class definition.
 *	"java.awt.Color" means package java.awt contains class Color. */
import java.awt.Color;

/*	The following libraries are in the acm.jar file. */
import acm.program.GraphicsProgram;
import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.graphics.GPoint;
import acm.graphics.GPolygon;
import acm.graphics.GRect;
import acm.graphics.GRectangle;

public class Target extends GraphicsProgram 
{
	
	/*	All fields and constants should be declared here.
	 *	Only constants (final) are initialized here. */
	private GOval [] circle;
	private double radius;
	private final double SIDE = 60;
	private GRect [] squares ;
	
	/**	The init() method is executed before the run() method.
	 *	All initialization steps should be performed here.
	 */
	public void init() 
	{
		circle = new GOval [5];
		radius = 240;
		squares = new GRect[55];
		
	}
	
	/**	The run() method is executed after init().
	 *	The bulk of the program should be performed here.
	 *	Exercise hint: Use one-dimensional arrays for the GOval's and GRect's.
	 */
	public void run() 
	{
		int x = 270;
		int y = 370;
		for (int i = 0; i<circle.length ; i++)
		{
			circle[i]= new GOval(x, y, radius , radius);
			circle[i].setFilled(true);
			if (i%2 == 0)
				circle[i].setFillColor(Color.RED);
			else
				circle[i].setFillColor(Color.WHITE);
			add(circle[i]);
			x +=19;
			y+=22;
			radius -= 40;
		}
		int xpos = 135;
		int ypos= 0;
		int num = 0;
		int counter = 10;
		for (int a = 0; a<10 ; a++)
		{
			for (int b = 0; b<counter; b++)
			{
				squares[num] =new GRect(xpos +50*b, ypos, 50, 20);
				squares[num].setFilled(true);
				squares[num].setFillColor(Color.WHITE);
				add(squares[num]);
				num ++;
			}
			counter--;
			xpos = xpos +25;
			ypos = ypos +20;
		}
		
		
			
		//System.out.print(this.getSize());
		
		
	}
}
