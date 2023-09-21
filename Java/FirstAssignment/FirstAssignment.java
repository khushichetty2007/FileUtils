/**
 *	FirstAssignment.java
 *	Display a brief description of your summer vacation on the screen.
 *
 *	To compile Linux:	javac -cp .:mvAcm.jar FirstAssignment.java
 *	To execute Linux:	java -cp .:mvAcm.jar FirstAssignment
 *
 *	To compile MS Powershell:	javac -cp ".;mvAcm.jar" FirstAssignment.java
 *	To execute MS Powershell:	java -cp ".;mvAcm.jar" FirstAssignment
 *
 *	@author	Your name
 *	@since	Today's date
 */
import java.awt.Font;
import acm.program.GraphicsProgram;
import acm.graphics.GLabel;

public class FirstAssignment extends GraphicsProgram {
    
    public void run() {
    	//	The font to be used
    	Font f = new Font("Serif", Font.BOLD, 18);
    	
    	//	Line 1
    	GLabel s1 = new GLabel("What I did on my summer vacation ...", 10, 20);
    	s1.setFont(f);
    	add(s1);
    	GLabel s2 = new GLabel("I went to India with my family.", 10, 40);
    	s2.setFont(f);
    	add(s2);
    	GLabel s3 = new GLabel("In india i met my family and friends.", 10, 60);
    	s3.setFont(f);
    	add(s3);
    	GLabel s4 = new GLabel("I went to Goa with my uncles and aunts to celebrate my sisters birthday.", 10, 80);
    	s4.setFont(f);
    	add(s4);
    	GLabel s5 = new GLabel("In Goa we explored the shopping, places and food. ", 10, 100);
    	s5.setFont(f);
    	add(s5);
    	GLabel s6 = new GLabel("I really enjoyed my time there and we retuned back to my granmas house", 10, 120);
    	s6.setFont(f);
    	add(s6);
    	GLabel s7 = new GLabel("I met my cousins and freinds. ", 10, 140);
    	s7.setFont(f);
    	add(s7);
    	GLabel s8 = new GLabel("I had some great homemade food by my grandmother", 10, 160);
    	s8.setFont(f);
    	add(s8);
    	GLabel s9 = new GLabel("I also had the chance to explre and try out street food", 10, 180);
    	s9.setFont(f);
    	add(s9);
    	GLabel s10 = new GLabel("I had a great time bonding with my family.", 10, 200);
    	s10.setFont(f);
    	add(s10);
    	GLabel s11 = new GLabel("I also loved exploring new places", 10, 220);
    	s11.setFont(f);
    	add(s11);
    	GLabel s12 = new GLabel("Overall it was amazing and i had the best time!", 10, 240);
    	s12.setFont(f);
    	add(s12);
    	    	
    	//	Continue adding lines until you have 12 to 15 lines
    	
    }
    
}
