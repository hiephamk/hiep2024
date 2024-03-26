package TestColorLine;

import Team_8_Robot.DataExchange;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;


public class TestColorLine {
	@SuppressWarnings("resource")
	public static void main(String [] args) {
		
		
        System.out.println("Press any key to start");
        Button.LEDPattern(4);     // flash green led and
        Sound.beepSequenceUp(); 
       // make sound when ready.
        Button.waitForAnyPress();
        LCD.clear();
		EV3ColorSensor cs = new EV3ColorSensor(SensorPort.S2);
		SampleProvider sp = cs.getRedMode();
		int colorValue = 0;
        
		while (true)
        {
			
            float [] sample = new float[sp.sampleSize()];
			sp.fetchSample(sample, 0);
	        colorValue = (int)(sample[0]*100);
	        System.out.println("ColorID: "+ colorValue);

        }
	}

}