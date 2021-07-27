import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import domain.Notification;
import domain.NotificationChannel;
import domain.NotificationStatus;
import domain.NotificationTask;
import repository.*;


public class Main {
	public static void main(String[] args) {

		List<Notification> notifs = NonificationRepository.findNotifications(NotificationStatus.PENDING);
		
		notifs.forEach(System.out::println);
		
		int core=Runtime.getRuntime().availableProcessors();
		
		ScheduledExecutorService getPendigs=Executors.newScheduledThreadPool(core/2);
		ScheduledExecutorService sendPendigs=Executors.newScheduledThreadPool(core/2);
		
		
		getPendigs.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {

				List<Notification> pendings = NonificationRepository.findNotifications(NotificationStatus.PENDING);
				pendings.forEach(notification -> {
					
					NotificationTask task = new NotificationTask(notification);
					sendPendigs.submit(task);
				});
			}

		}, 10, 30, TimeUnit.SECONDS);
		
		
		   

		
	}


}
