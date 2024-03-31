package Team_8_V3;

import lejos.hardware.Button;
import lejos.hardware.Sound;

public class ProjectV3 {

	public static void main(String[] args) {
		DataExchange de = new DataExchange();
		
        System.out.println("Press any key to start");
        Button.LEDPattern(4);     // flash green led and
        Sound.beepSequenceUp(); 
       // make sound when ready.
       Button.waitForAnyPress();
 
        try {
        	AvoidObject th1 = new AvoidObject(de,16);
            th1.start();
            //th1.setPriority(10);
           
        }catch(Exception e) {
        	System.out.println("Ultrasonicss error");
        }
//        
        try {
        	ColorSensor th2 = new ColorSensor(de,16,18);  
        	th2.start(); 
        	
        }catch(Exception e) {
        	System.out.println("Colorss error");
        }
        try {
        	RobotRun th3 = new RobotRun(de); 
        	th3.start();
        	
        }catch(Exception e) {
        	System.out.println("MotorTh error");
        }
        
	}

}
