/**
 * Liz Hinton
 * CIS175 - Fall 2023
 * Feb 5, 2024
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")

public class book {
	//variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String author;
	//constructors
	public book(){
		title = "The Hunger Games";
		author = "Suzanne Collins";
	}
	
	public book(String t, String a){
		title = t;
		author = a;
	}
	
	//getters
	public String getTitle(){
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getId() {
		return id;
	}
	
	//setters
	public void setTitle(String t) {
		title = t;
	}
	
	public void setAuthor(String a) {
		author = a;
	}
	
	//methods
	public String printBookDetails(){
		return this.title + "by " + this.author;
	}
}
