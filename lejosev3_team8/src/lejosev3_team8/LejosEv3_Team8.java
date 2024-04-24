package lejosev3_team8;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.Enumeration;

//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.Entity;
//import javax.ws.rs.client.Invocation.Builder;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.MediaType;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.utility.Stopwatch;

public class LejosEv3_Team8 {

	public static void main(String[] args) {
        System.out.println("Press any key to start");      
        Button.waitForAnyPress();
        DataExchange de = new DataExchange();
        Stopwatch sw = new Stopwatch();
        try {
        	RobotDirection direction = new RobotDirection(de);
            direction.start();
            try {
    			Thread.sleep(1000);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
		} catch (Exception e) {
			System.out.println("direction err");
		}
        //getspeed
        
        try {
        	RobotSpeed speed = new RobotSpeed(de);
            speed.start();
            try {
    			Thread.sleep(1000);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
		} catch (Exception e) {
			System.out.println("speed err");
		}
        //ultrasonicsensor run
        try {
        	AvoidObject th1 = new AvoidObject(de, 20);
            th1.start();
            try {
    			Thread.sleep(1000);
    		} catch (InterruptedException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
		} catch (Exception e) {
			System.out.println("ultrasound err");
		}
        //Colorsensor run
        
        try {
        	ColorSensor th2 = new ColorSensor(de, 14, 16);
            th2.start();
            try {
    			Thread.sleep(1000);
    		} catch (InterruptedException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
		} catch (Exception e) {
			System.out.println("Colorsensor err");
		}

        try {
        	RobotRun run = new RobotRun(de,sw);
            run.start();
            sw.reset();
            try {
    			Thread.sleep(1000);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
		} catch (Exception e) {
			System.out.println("run err");
		}
        System.out.println("press any key to stop");
        Button.waitForAnyEvent();
        //

	}

}