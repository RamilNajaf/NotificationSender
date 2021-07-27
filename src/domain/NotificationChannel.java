package domain;

import java.util.Arrays;

public enum NotificationChannel {

	EMAIL(1), 
	SMS(2), 
	TELEGRAM(3), 
	WHATSAPP(4);

	private int id;

	private NotificationChannel(int id) {
		this.id = id;
	}

	public static NotificationChannel from(int id) throws Exception {
		return 	Arrays.stream(values()).
				filter(e -> e.id == id).findFirst()
				.orElseThrow(() -> new IllegalArgumentException());

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
