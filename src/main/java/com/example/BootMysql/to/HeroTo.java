package com.example.BootMysql.to;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;

import com.example.BootMysql.model.Note;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HeroTo implements Serializable{

	 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@NotNull
		@JsonProperty("id")
		private Long id;
		@NotNull
		@JsonProperty("firstName")
	    private String firstName;
		@NotNull
		@JsonProperty("lastName")
	    private String lastName;
		//@JsonProperty("good")
	    //private boolean good;		
		@JsonProperty("createdAt")
	    private Date createdAt;
		@NotNull
		@JsonProperty("note")
		private Note note;
	    public HeroTo() {
	    	
	    }
	    @JsonCreator
		public HeroTo(@JsonProperty("id") Long id,
					  @JsonProperty("first_name")String firstName,
					  @JsonProperty("last_name")String lastName,
					  @JsonProperty("note")Note note) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.note = note;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		/*public boolean isGood() {
			return good;
		}
		public void setGood(boolean good) {
			this.good = good;
		}
		*/
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public Note getNote() {
			return note;
		}
		public void setNote(Note note) {
			this.note = note;
		}
	    
	    
}
