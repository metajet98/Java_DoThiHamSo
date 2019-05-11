package Model;

import java.io.Serializable;

public class ChatMessenge implements Serializable{
	private String text;
	private String time;
	private String userName;
	
	
	public ChatMessenge(String _userName, String _time, String _text) {
		userName=_userName;
		time=_time;
		text=_text;
	}
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
