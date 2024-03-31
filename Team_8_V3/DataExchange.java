package Team_8_V3;

public class DataExchange {

	private int cmd = 1;
	private String act = "G";
	private int count = 0;

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

	
	
}
