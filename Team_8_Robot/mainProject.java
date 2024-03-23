package Team_8_Robot;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

class ColorSensor extends Thread{
	
	private EV3ColorSensor cs = new EV3ColorSensor(SensorPort.S2);
	private SampleProvider sp = cs.getColorIDMode();
	private RobotRun myRun = new RobotRun();
	
	DataExchange de = new DataExchange();
	
	final int colorRange = 7;
	
	
	public ColorSensor(DataExchange de, int colorRange) {
		super();
		this.de = de;
		//this.colorRange = colorRange;
	}
	
	@Override
	public void run() {
		int colorValue = 7;
		while(true) {
			float [] sample = new float[sp.sampleSize()];
			sp.fetchSample(sample, 0);
	        colorValue = (int)(sample[0]);
	        System.out.println("ColorID: "+ colorValue);
	        //Delay.msDelay(500);
	        
	        if(de.getCmd()==1) {
	        	switch (colorValue) {
				case colorRange:
					myRun.goStraight();;
					break;
				case (colorRange+1):
					myRun.turn("L",30);
					break;
				case (colorRange+2):
					myRun.turn("L",45);
					break;
				case (colorRange+3):
					myRun.turn("L",60);
					break;
				case (colorRange-1):
					myRun.turn("R",30);
					break;
				case (colorRange-2):
					myRun.turn("L",45);
					break;
				case (colorRange-3):
					myRun.turn("L",60);
					break;
				default:
					myRun.goBack();
	        	}
	        }else {
	        	myRun.goBack();
	        	Delay.msDelay(500);
	        	myRun.turn("L", 90);
	        	

	        }
		}
	}
}

class AvoidObject extends Thread{
	
	private EV3UltrasonicSensor us = new EV3UltrasonicSensor(SensorPort.S4);

	private SampleProvider sp = us.getDistanceMode();
	//private RobotRun myRun = new RobotRun();
	private int distanceRange;
	DataExchange de = new DataExchange();

	
	public  AvoidObject(DataExchange de, int distanceRange){
		this.de = de;
		this.distanceRange = distanceRange;
		
		
	}
	
	@Override
	
	public void run() {
		int distanceValue = 0;
		while(true) {
			float [] sample = new float[sp.sampleSize()];
		    sp.fetchSample(sample, 0);
		    distanceValue = (int)(sample[0]*100);
		    System.out.println("Distance: "+ distanceValue);
		    //Delay.msDelay(1000);
		    if(distanceValue > distanceRange) {
		    	de.setCmd(1);
		    }else {
		    	de.setCmd(0);
		    }
		}
	}

}

public class mainProject {
	

	public static void main(String[] args) {

		
		DataExchange de = new DataExchange();
        System.out.println("Press any key to start");

        Button.LEDPattern(4);     // flash green led and
        Sound.beepSequenceUp(); 
       // make sound when ready.
		
        Button.waitForAnyPress();
        ColorSensor th1 = new ColorSensor(de,7);       
        th1.start();

        AvoidObject th2 = new AvoidObject(de,20);
        th2.start();

        	//check color of the line before set colorID
//        TestColorLine test = new TestColorLine();
//        test.run();
//		
}
}
