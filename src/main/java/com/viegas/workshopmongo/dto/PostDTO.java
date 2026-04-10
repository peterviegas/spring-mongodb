package com.viegas.workshopmongo.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class PostDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private LocalDate date;
	private String title;
	private String body;
	private AuthorDTO author;
	
	public PostDTO() {
	}

	

	public PostDTO(String id, LocalDate date, String title, String body, AuthorDTO author) {
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = author;
	}



	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the author
	 */
	public AuthorDTO getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	
	

}
