/*
 * File: UnevenRoadRepair.java
 * -----------------------------
 * The UnevenRoadRepair class extends the basic Karel class
 * so that Karel fills a pothole with a beeper.
 */

import stanford.karel.*;

public class UnevenRoadRepairKarel extends SuperKarel {

	public void run() {
		
		while( frontIsClear() ){
			
			if (rightIsClear()){
				fillPothole();
			}
			move();
		}
		
		
	}
	public void fillPothole(){
		turnRight();
		move();
		if (noBeepersPresent())
			putBeeper();
		turnAround();
		move();
		turnRight();
	}
    
}
