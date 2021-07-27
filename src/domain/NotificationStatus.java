package domain;
import java.util.Arrays;

public enum NotificationStatus {


	

		PENDING(1), 
		IN_PROGRESS(2), 
		SUCCESS(3), 
		ERROIR(4);

		private int id;

		private NotificationStatus(int id) {
			this.id = id;
		}

		public static NotificationStatus from(int id) throws Exception {

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


