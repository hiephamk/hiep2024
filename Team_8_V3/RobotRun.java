package Team_8_V3;

import java.io.File;

import lejos.hardware.Sound;

import lejos.hardware.motor.*;
import lejos.hardware.port.MotorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.utility.Delay;
import lejos.utility.Stopwatch;
	

public class RobotRun extends Thread {
	UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
	UnregulatedMotor motorD = new UnregulatedMotor(MotorPort.D);
	EV3ColorSensor cs;
	EV3UltrasonicSensor us;
	DataExchange de;
	Stopwatch sw = new Stopwatch();
	
	public RobotRun(DataExchange de) {
		this.de = de;
		
	}
	
	public static void music() {
	    Sound.playTone(262, 200);  // C4
	    Sound.playTone(262, 200);  // C4
	    Sound.playTone(262, 400);  // C4
	    Sound.playTone(262, 200);  // C4
	    Sound.playTone(262, 200);  // C4
	    Sound.playTone(262, 400);  // C4
	    Sound.playTone(262, 200);  // C4
	    Sound.playTone(294, 200);  // D4
	    Sound.playTone(330, 400);  // E4
	    Sound.playTone(262, 400);  // C4
	    Sound.playTone(262, 400);  // C4
	    Sound.playTone(294, 400);  // D4
	    Sound.playTone(330, 400);  // E4
	    Sound.playTone(262, 400);  // C4
	    Sound.playTone(294, 400);  // D4
	    Sound.playTone(330, 400);  // E4
	    Sound.playTone(349, 400);  // F4
	    Sound.playTone(349, 400);  // F4
	    Sound.playTone(349, 400);  // F4
	    Sound.playTone(349, 400);  // F4
	    Sound.playTone(330, 400);  // E4
	    Sound.playTone(330, 400);  // E4
	    Sound.playTone(330, 400);  // E4
	    Sound.playTone(294, 400);  // D4
	    Sound.playTone(294, 400);  // D4
	    Sound.playTone(262, 400);  // C4
	
	}
	public void ObstacleAndStop() {	
		if(de.getCount()<2) {
			motorA.setPower(20);
			motorD.setPower(45);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Delay.msDelay(1500);
//			motorA.setPower(40);
//			motorD.setPower(30);
			
	}else {
			motorA.stop();
			motorD.stop();
			System.out.println("Total time: " + sw.elapsed()/1000);
			Delay.msDelay(2000);
			motorA.close(); 
			motorD.close();

			//Sound.playSample(new File("Jinglebells.wav"), Sound.VOL_MAX);
			music();
			System.out.println("Robot stopped");
			System.exit(500);
		}
		}

	public void run() {
		while(true) {
			if(de.getCmd()==1) {
				if(de.getAct().equalsIgnoreCase("R")){	
					motorA.setPower(15);
					motorD.setPower(55);
					//Delay.msDelay(500);
				}else if(de.getAct().equalsIgnoreCase("L")){
					
					motorA.setPower(39);
					motorD.setPower(24);
					//Delay.msDelay(500);
				}else if(de.getAct().equalsIgnoreCase("G")){
					motorA.setPower(60);
					motorD.setPower(60);
					}
			}else if(de.getCmd()==0) {
				if(de.getCount()<2) {
					motorA.setPower(20);
					motorD.setPower(45);
					Delay.msDelay(MAX_PRIORITY);
//					motorA.setPower(40);
//					motorD.setPower(30);
					
				}else {
					motorA.stop();
					motorD.stop();
					System.out.println("Total time: " + sw.elapsed()/1000);
					Delay.msDelay(2000);
					motorA.close(); 
					motorD.close();

					//Sound.playSample(new File("Jinglebells.wav"), Sound.VOL_MAX);
					music();
					System.out.println("Robot stopped");
					System.exit(500);
				}
			}
		}
	}
}

	

