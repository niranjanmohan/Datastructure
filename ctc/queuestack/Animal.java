package queuestack;

import java.util.Date;



public abstract class Animal {
	Date entrydate;
	String name;
	public Date getEntryDate() {
		return entrydate;
	}
	Animal(){
		entrydate = new Date();
	}
	public void setEntryDate(Date entrydate) {
		this.entrydate = entrydate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString(){
		return this.name;
	}
}

