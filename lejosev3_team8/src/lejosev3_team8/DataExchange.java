package lejosev3_team8;

public class DataExchange {

	private int cmd = 1;
	private String act = "G";
	private int count = 0;
	private int speed;
	private int direction = 0;

	public DataExchange() {
		
	}
	public int getCmd() {
		synchronized(this) {
			return cmd;
		}

	}
	public void setCmd(int cmd) {
		synchronized(this) {
			this.cmd = cmd;
		}
			
	}
	public String getAct() {
		synchronized(this) {
			return act;
		}
			
	}
	public void setAct(String act) {
		synchronized(this) {
			this.act = act;
		}
	}
	public int getCount() {
		synchronized(this) {
			return count;
		}
		
	}
	public void setCount(int count) {
		synchronized(this) {
			this.count = count;
		}
		
	}
	public int getSpeed() {
		synchronized(this) {
			return speed;
		}
		
	}
	public void setSpeed(int speed) {
		synchronized(this) {
			this.speed = speed;
		}
		
	}
	public int getDirection() {
		synchronized(this) {
			return direction;
		}
		
	}
	public void setDirection(int direction) {
		synchronized(this) {
			this.direction = direction;
		}
		
	}
	
	
	
}
