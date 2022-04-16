
package com.lsacad.bean;

public class Classes {
	private int id;
	private int section;
	private String teacher;
	private String subject;
	private String time;
	

	public Classes() {
		
	}


	public Classes(int section, String teacher, String subject, String time) {
		super();
		this.section = section;
		this.teacher = teacher;
		this.subject = subject;
		this.time = time;
	}


	public Classes(int id, int section, String teacher, String subject, String time) {
		super();
		this.id = id;
		this.section = section;
		this.teacher = teacher;
		this.subject = subject;
		this.time = time;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSection() {
		return section;
	}
	public void setSection(int section) {
		this.section = section;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}


	@Override
	public String toString() {
		return "Classes [id=" + id + ", section=" + section + ", teacher=" + teacher + ", subject=" + subject
				+ ", time=" + time + "]";
	}
	
}
