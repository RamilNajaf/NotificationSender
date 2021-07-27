package domain;

import java.time.LocalDateTime;
import java.util.Scanner;

import repository.NonificationRepository;
import UTIL.MailUtil;

public class NotificationTask implements Runnable {

	private Notification notification;

	public NotificationTask(Notification notification) {
		this.notification = notification;
	}

	@Override
	public void run() {

		try {
				// 1 - set status to progress

			notification.setStatus(NotificationStatus.IN_PROGRESS);
			notification.setProgresDate(LocalDateTime.now());
			NonificationRepository.update(notification);

				// 2 - try to send 
			if (notification.getChanell() == NotificationChannel.EMAIL) {

				System.out.println("sending - " + notification);

				// do not forget set password of email instead of "xxxxxxxxx"

				MailUtil.send(notification.getSender(), "xxxxxxxxx", notification.getReceiver(),
						notification.getSubject(), notification.getBody());

				// 3 - if success change status to success

				notification.setStatus(NotificationStatus.SUCCESS);
				notification.setProgresDate(LocalDateTime.now());

				
			} else {
				/* to send wp or telegram message twillio accounts needed*/
				
				System.out.println("sending - " + notification);

				// 3 - if success change status to success
				notification.setStatus(NotificationStatus.SUCCESS);
				notification.setProgresDate(LocalDateTime.now());

			}

		} catch (Exception e) {
			// 4 - if error update log data

			notification.setStatus(NotificationStatus.ERROIR);
			notification.setProgresDate(LocalDateTime.now());
			notification.setLogData(e.getMessage());

		} finally {
			NonificationRepository.update(notification);
		}

	}

}
