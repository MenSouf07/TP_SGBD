package Buffer_manager;

import java.time.LocalTime;

public class Frame {
	private String page;
	private LocalTime heureChargement;//Pour FIFO heure à laquelle le bloc a été chargé
	private int flag;	//Pour Clock Algorithm
						
	
	public Frame(String p) {
		page = p;
        LocalTime heureChargement = LocalTime.now();
		flag = 1;
	}
	
		@Override
	public String toString() {
		return page + "["+flag+" / "+ heureChargement + "]";
	}
		
	public static void main() {
		Frame f = new Frame("P1");
		System.out.println(f);
		
	}
}
