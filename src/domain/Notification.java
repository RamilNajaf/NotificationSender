package domain;

import java.time.LocalDateTime;

public class Notification {
	private long id;
	private NotificationChannel chanell;
	private NotificationStatus status;
	private String sender;
	private String receiver;
	private String body;
	private String subject;
	private LocalDateTime insertDate;
	private LocalDateTime progresDate;
	private String LogData;
	
	
	
	
	@Override
	public String toString() {
		return "[id=" + id + ", chanell=" + chanell + ", status=" + status + ", sender=" + sender
				+ ", receiver=" + receiver + ", body=" + body + ", subject=" + subject + ", insertDate=" + insertDate
				+ ", progresDate=" + progresDate + ", LogData=" + LogData + "]";
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public NotificationChannel getChanell() {
		return chanell;
	}
	public void setChanell(NotificationChannel chanell) {
		this.chanell = chanell;
	}
	public NotificationStatus getStatus() {
		return status;
	}
	public void setStatus(NotificationStatus status) {
		this.status = status;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public LocalDateTime getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(LocalDateTime insertDate) {
		this.insertDate = insertDate;
	}
	public LocalDateTime getProgresDate() {
		return progresDate;
	}
	public void setProgresDate(LocalDateTime progresDate) {
		this.progresDate = progresDate;
	}
	public String getLogData() {
		return LogData;
	}
	public void setLogData(String logData) {
		LogData = logData;
	}
	
	
	
}
