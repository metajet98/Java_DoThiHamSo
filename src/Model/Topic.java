package Model;

import java.io.Serializable;

import com.google.cloud.firestore.Firestore;

public class Topic implements Serializable {
	private String noiDung;
	private String askedName;
	private String tag;
	private String id;
	private String time;
	private int luotXem;
	private int luotCmt;
	private String tieuDe;
	
	Firestore db;
	
	
	
	
	public Topic(String noiDung, String askedName, String tag, String id, String time, int luotXem, int luotCmt, String tieuDe,Firestore db) {
		super();
		this.noiDung = noiDung;
		this.askedName = askedName;
		this.tag = tag;
		this.id = id;
		this.time = time;
		this.luotXem = luotXem;
		this.luotCmt = luotCmt;
		this.tieuDe= tieuDe;
		this.db=db;
	}
	
	
	public Firestore getDb() {
		return db;
	}


	public void setDb(Firestore db) {
		this.db = db;
	}


	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getAskedName() {
		return askedName;
	}
	public void setAskedName(String askedName) {
		this.askedName = askedName;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getLuotXem() {
		return luotXem;
	}
	public void setLuotXem(int luotXem) {
		this.luotXem = luotXem;
	}
	public int getLuotCmt() {
		return luotCmt;
	}
	public void setLuotCmt(int luotCmt) {
		this.luotCmt = luotCmt;
	}


	public String getTieuDe() {
		return tieuDe;
	}


	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}
	
	
	
}
