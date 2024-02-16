package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class listDetails {
	@Id
	@GeneratedValue
	//variables
	private int id;
	private String listName;
	@ManyToOne
	private reader reader;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<book> listOfBooks;
	
	//constructors
	public listDetails() {
		super();
	}
	
	public listDetails(int id, String listName, reader reader, List<book> listOfBooks) {
		super();
		this.id = id;
		this.listName = listName;
		this.reader = reader;
		this.listOfBooks = listOfBooks;
	}
	
	public listDetails(String listName, reader reader, List<book> listOfBooks) {
		super();
		this.listName = listName;
		this.reader = reader;
		this.listOfBooks = listOfBooks;
	}
	
	public listDetails(String listName, reader reader) {
		super();
		this.listName = listName;
		this.reader = reader;
	}
	
	//getters
	public int getId(){
		return id;
	}
	
	public String getListName(){
		return listName;
	}
	
	public reader getReader(){
		return reader;
	}
	
	public List<book> getListOfBooks(){
		return listOfBooks;
	}
	
	//setters
	public void setId(int i) {
		id = i;
	}
	
	public void setListName(String l) {
		listName = l;
	}
	
	public void setReader(reader r) {
		reader = r;
	}
	
	public void setListofBooks(List<book> b) {
		listOfBooks = b;
	}
	
	//methods
	@Override
	public String toString() {
	return "List: " + listName + " Id: " + id + "Reader: " + reader + "Books: " + listOfBooks;
	}
}
