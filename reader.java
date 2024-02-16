package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reader")
public class reader {
	@Id
	@GeneratedValue
	//variables
	private int id;
	private String readerName;
	
	//constructors
	public reader() {
	super();
	// TODO Auto-generated constructor stub
	}
	
	public reader(int id, String readerName) {
	super();
	this.id = id;
	this.readerName = readerName;
	}
	
	public reader(String readerName) {
	super();
	this.readerName = readerName;
	}
	
	//gets and sets
	public int getId() {
	return id;
	}
	public void setId(int id) {
	this.id = id;
	}
	public String getReaderName() {
	return readerName;
	}
	public void setReaderName(String readerName) {
	this.readerName = readerName;
	}
	
	//methods
	@Override
	public String toString() {
	return "Reader [id=" + id + ", readerName=" +
	readerName + "]";
	}
}
