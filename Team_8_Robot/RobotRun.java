package Team_8_Robot;

import java.io.File;

import lejos.hardware.Sound;
import lejos.hardware.motor.*;
import lejos.hardware.port.MotorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.utility.Delay;
	

public class RobotRun {
	private EV3ColorSensor cs;
	private EV3UltrasonicSensor us;
	UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
	UnregulatedMotor motorD = new UnregulatedMotor(MotorPort.D);

	public void goStraight() {
        motorA.setPower(50);
        motorD.setPower(50);
        System.out.println("Robot is running");

    }
	public void goBack() {
        motorA.setPower(-50);
        motorD.setPower(-50);
        System.out.println("Robot is running");

    }
	public void playMusic() {
		Sound.playNote(Sound.PIANO, 1000, 5000);
        

    }
	
	public void turn(String direction, int deg) {
		if(direction.equalsIgnoreCase("L")) {
			switch (deg) {
			case 15:
				motorA.setPower(40);
				motorD.setPower(30);
				break;
			case 30:
				motorA.setPower(40);
				motorD.setPower(20);
				break;
			case 45:
				motorA.setPower(40);
				motorD.setPower(10);
				break;
			case 60:
				motorA.setPower(50);
				motorD.setPower(30);
				break;
			case 75:
				motorA.setPower(50);
				motorD.setPower(10);
				break;
			case 90:
				motorA.setPower(50);
				motorD.setPower(-10);
				break;
			default:
				motorA.setPower(-50);
				motorD.setPower(-50);
				break;
		}
			

		}else if(direction.equalsIgnoreCase("R")) {
			switch (deg) {
			case 15:
				motorD.setPower(40);
				motorA.setPower(30);
				break;
			case 30:
				motorD.setPower(50);
				motorA.setPower(40);
				break;
			case 45:
				motorD.setPower(50);
				motorA.setPower(30);
				break;
			case 60:
				motorD.setPower(40);
				motorA.setPower(20);
				break;
			case 75:
				motorD.setPower(40);
				motorA.setPower(10);
				break;
			case 90:
				motorD.setPower(50);
				motorA.setPower(0);
				break;
			default:
				motorA.setPower(50);
				motorD.setPower(0);
				break;
		}

		}
	}

	public void MotorStop() {

		motorA.close(); 
		motorD.close();
		cs.close();
		us.close();
		
		Sound.beepSequence();
		System.out.println("Robot was stopped");

	}
}
