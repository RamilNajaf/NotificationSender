package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import UTIL.DatabaseUtil;
import domain.Notification;
import domain.NotificationChannel;
import domain.NotificationStatus;

public class NonificationRepository {
	
	
	public static List<Notification> findNotifications(NotificationStatus status) {

		List<Notification> notifs = new ArrayList<>();

		String sql = " select q.id,q.notif_channel_id,q.n_status,sender,receiver,body,subject,insert_date,process_date,log_data from \"notification\".\"Notification_queue\" q \n"
				+ "join  \"notification\".\"Notification_channel\" c on q.notif_channel_id=c.id \n"
				+ "join  \"notification\".\"Notification_status\" s on  q.n_status=s.id\n"
				+ "where n_status = ? ";
		
		Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;

		try {
			connection = DatabaseUtil.connect();
			stm = connection.prepareStatement(sql);
			stm.setInt(1, status.getId());
			rs = stm.executeQuery();
				
				
				
			
			
			;

			while (rs.next()) {
				Notification notif = new Notification();
				notif.setId(rs.getLong("id"));
				notif.setStatus(NotificationStatus.from(rs.getInt("n_status")));
				notif.setChanell(NotificationChannel.from(rs.getInt("notif_channel_id")));
				notif.setSender(rs.getString("sender"));
				notif.setReceiver(rs.getString("receiver"));
				notif.setBody(rs.getString("body"));
				notif.setSubject(rs.getString("subject"));
				notif.setInsertDate(rs.getTimestamp("insert_date").toLocalDateTime());
				if (rs.getTimestamp("process_date") != null) {
					notif.setProgresDate(rs.getTimestamp("process_date").toLocalDateTime());
				}
				notifs.add(notif);

			}

		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		} finally {
			
			try {
				rs.close();
				stm.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return notifs;

	}
	
	
	public static void update(Notification notification) {
		String sql =" update \"notification\".\"Notification_queue\" \n"
				+ " set n_status=?,\n"
				+ "	notif_channel_id=?,\n"
				+ "	sender=?,\n"
				+ "	receiver=?,\n"
				+ "	body=?,\n"
				+ "	subject=?,\n"
				+ "	process_date=?,\n"
				+ "	log_data=?\n"
				+ "where id=?; " ;
		
		Connection connection = null;
		PreparedStatement stm = null;
		

		try {
			connection = DatabaseUtil.connect();
			stm = connection.prepareCall(sql);
			stm.setInt(1, notification.getStatus().getId());
			stm.setInt(2, notification.getChanell().getId());
			stm.setString(3, notification.getSender());
			stm.setString(4, notification.getReceiver());
			stm.setString(5, notification.getBody());
			stm.setString(6, notification.getSubject());
			stm.setTimestamp(7, Timestamp.valueOf(notification.getProgresDate()));
			stm.setString(8, notification.getLogData());	
			stm.setLong(9, notification.getId());
			
			if (stm.executeUpdate() > 0)
				connection.commit();
			
			

		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
	
		} finally {
			
			try {
				
				stm.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		
	}

}
