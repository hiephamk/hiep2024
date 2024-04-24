package lejosev3_team8;

import java.io.BufferedReader;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.*;
import lejos.hardware.port.MotorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.utility.Delay;
import lejos.utility.Stopwatch;
	

public class RobotRun extends Thread {
	UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
	UnregulatedMotor motorD = new UnregulatedMotor(MotorPort.D);
	EV3ColorSensor cs;
	EV3UltrasonicSensor us;
	DataExchange de;
	RobotDirection direction;
	RobotSpeed speed;
	
	private Stopwatch sw;

	public RobotRun(DataExchange de, Stopwatch sw) {
		this.de = de;
		//this.sw = sw;
	}

	public void run() {
		
		while(true) {
		
			if(de.getDirection()==0) {
				if(de.getCmd()==1) {
					//follow the line
					if(de.getAct().equalsIgnoreCase("R")){	
						motorA.setPower(de.getSpeed()/10);
						motorD.setPower(de.getSpeed());
						//Delay.msDelay(500);
					}else if(de.getAct().equalsIgnoreCase("L")){
						
						motorA.setPower(de.getSpeed());
						motorD.setPower(de.getSpeed()/8);
						
					}
						else if(de.getAct().equalsIgnoreCase("G")){
							motorA.setPower(de.getSpeed());
							motorD.setPower(de.getSpeed());
						}
					//avoid the obstacle
				} else if(de.getCmd()==0) {
					
						motorA.setPower((de.getSpeed())/5);
						motorD.setPower(de.getSpeed());
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
					}
				}
				//manual setting
			}else if(de.getDirection()==1) {//go straight
					motorA.setPower(de.getSpeed());
					motorD.setPower(de.getSpeed());
				}else if(de.getDirection()==2) {//turn left
					motorA.setPower(de.getSpeed());
					motorD.setPower((de.getSpeed())/5);
				}else if(de.getDirection()==3) {//turn right
					motorA.setPower((de.getSpeed())/5);
					motorD.setPower(de.getSpeed());
				}else if(de.getDirection()==4) {//go back
					motorA.setPower(-(de.getSpeed()));
					motorD.setPower(-(de.getSpeed()));
				}else if(de.getDirection()==5) {//stop
					motorA.setPower(1);
					motorD.setPower(1);
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("running time: "+sw);
					System.exit(60000);
					
				}
				
			}						
	}	
}

	

