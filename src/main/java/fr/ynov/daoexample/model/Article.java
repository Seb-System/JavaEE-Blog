package fr.ynov.daoexample.model;

import java.sql.Date;

public class Article {
	
	private int id;
	private String title;
	private String auteur;
	private String description;
	private Date date;
	private String text;
	
	public Article(int id,String auteur,String title,String description,String text,Date date) {
        this.id = id;
        this.auteur = auteur;
        this.title = title;
        this.description = description;
        this.text = text;
        this.date = date;
    }
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return "["+ id +"] ";
	}
	
	

}
