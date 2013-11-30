package com.jackge.domain;

public class PayInfo {

	private int id;
	private String title;
	private String content;
	private String linkman;
	private String tel;
	private java.sql.Date date;
	private int keepDays;
	private short checkState;
	private short typeId;
	
	public PayInfo(){
		
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public java.sql.Date getDate() {
		return date;
	}
	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	public int getKeepDays() {
		return keepDays;
	}
	public void setKeepDays(int keepDays) {
		this.keepDays = keepDays;
	}
	public short getCheckState() {
		return checkState;
	}
	public void setCheckState(short checkState) {
		this.checkState = checkState;
	}
	public short getTypeId() {
		return typeId;
	}
	public void setTypeId(short typeId) {
		this.typeId = typeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
