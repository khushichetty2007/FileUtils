/*
 * @author Khushi Chetty
 * @since August 29 2023
 * File: DoubleBeeperKarel.java
 * -----------------------------
 * The DoubleBeeperKarel class extends the basic Karel class
 * so that Karel doubles the number of beepers on a corner.
 */

import stanford.karel.*;

public class DoubleBeeperKarel extends SuperKarel {

	public void run() {
		move();
		doubleBeepers();
		move();
	}
	
	public void doubleBeepers() {
		
		while (noBeepersPresent()){
			move();
		}
		while( beepersPresent()){
			pickBeeper();
			move();
			putBeeper();
			turnAround();	
			move();
			turnAround();
		}
		move();
		turnAround();
		while (beepersPresent()){
			pickBeeper();
			move();
			putBeeper();
			putBeeper();
			turnAround();
			move();
			turnAround();
			
		}
		turnAround();
		turnAround();
		move();
		turnAround();
	
	}
	    
}
