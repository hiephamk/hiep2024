package Team_8_V3;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

class AvoidObject extends Thread{
	private EV3UltrasonicSensor us = new EV3UltrasonicSensor(SensorPort.S4);

	private SampleProvider sp = us.getDistanceMode();
	DataExchange de;
	private int distanceRange;
	int Value = 0;
	
	public AvoidObject(DataExchange de, int distanceRange){
		
		this.de = de;
		this.distanceRange = distanceRange;

	}
	@Override
	public void run() {
		int count = 0;
		while(true) {
			float [] sample = new float[sp.sampleSize()];
		    sp.fetchSample(sample, 0);
		    Value = (int)(sample[0]*100);
		    //System.out.println("Distance: "+distanceValue);
		    if(Value > distanceRange) {
		    	de.setCmd(1);
		    	//Delay.msDelay(1000);
		    }else {	
		    	de.setCmd(0);
		    	Delay.msDelay(1000);
		    	count += 1;
		    	de.setCount(count);
		    	Delay.msDelay(2000);
		    }
		}
	}
}

