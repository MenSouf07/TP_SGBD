package Buffer_manager;

import java.time.LocalTime;

public abstract class BufferManagementStrategy {
	private Frame[] frames;
	
	public BufferManagementStrategy(int s) {
		frames = new Frame[s];
	}
	
		@Override
	public String toString() {
			String s = "";
			for (int i=0; i<frames.length ; i++) {
				s += frames[i];
			}
		return s;
	}
		

}

