package Team_8_Robot;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import lejos.utility.Stopwatch;


class ColorSensor extends Thread{
		
		private EV3ColorSensor cs = new EV3ColorSensor(SensorPort.S2);
		private SampleProvider sp = cs.getRedMode();
		private RobotRun myRun = new RobotRun();
		Stopwatch sw = new Stopwatch();
		DataExchange de = new DataExchange();
		int lowvalue; 
		int highvalue;

		public ColorSensor(DataExchange de, int lowvalue, int highvalue) {
			super();
			this.de = de;
			this.lowvalue = lowvalue;
			this.highvalue = highvalue;
		}


		@Override
		public void run() {
			int colorValue=0;
			int r = 0;
			while(r<2) {
				float [] sample = new float[sp.sampleSize()];
				sp.fetchSample(sample, 0);
		        colorValue = (int)(sample[0]*100);
		        //System.out.println("ColorID: "+ colorValue);
		        //Delay.msDelay(500);
  
		        if(de.getCmd()==1) {
		        	
					if(colorValue > highvalue) {
		        		myRun.turn("R",15);
		        	}else if (colorValue < lowvalue) {
		        		myRun.turn("L",15);
		        	}
		        	else {
		        		myRun.goStraight();
		        	}
//		        	switch (colorValue) {
//					case colorRange:
//						myRun.goStraight();;
//						break;
//					case (colorRange+1):
//						myRun.turn("L",30);
//						break;
//					case (colorRange+2):
//						myRun.turn("L",45);
//						break;
//					case (colorRange+3):
//						myRun.turn("L",60);
//						break;
//					case (colorRange-1):
//						myRun.turn("R",30);
//						break;
//					case (colorRange-2):
//						myRun.turn("R",45);
//						break;
//					case (colorRange-3):
//						myRun.turn("R",60);
//						break;
//					default:
//						myRun.goBack();
//		        	}
		        }else{		   
		        	r +=1;
		        	myRun.MotorStop(r);
		        	Delay.msDelay(1500);
		        }
		        
		        	
			}
		}
	}

