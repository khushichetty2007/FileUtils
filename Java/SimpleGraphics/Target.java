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
	private GOval circle;
	private final double RADIUS = 200;
	private GRect square;
	private final double SIDE = 40;
	private int [] radiuses;
	
	/**	The init() method is executed before the run() method.
	 *	All initialization steps should be performed here.
	 */
	public void init() 
	{

	}
	
	/**	The run() method is executed after init().
	 *	The bulk of the program should be performed here.
	 *	Exercise hint: Use one-dimensional arrays for the GOval's and GRect's.
	 */
	public void run() 
	{
		System.out.print(this.getSize());
		circle = new GOval(357, 0, RADIUS , RADIUS);
		circle.setFilled(true);
		circle.setFillColor(Color.RED);
		add(circle);
		
	}
}
