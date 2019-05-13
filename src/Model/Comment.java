package Model;

import java.io.Serializable;

public class Comment implements Serializable {
	
	private String comment;
	private String time;
	private String cmtUserName;
	
	
	
	
	public Comment(String comment, String time, String cmtUserName) {
		super();
		this.comment = comment;
		this.time = time;
		this.cmtUserName = cmtUserName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCmtUserName() {
		return cmtUserName;
	}
	public void setCmtUserName(String cmtUserName) {
		this.cmtUserName = cmtUserName;
	}
	
	
	

}
