package com.example.BootMysql.common;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * this class construct response to be returned
 * in the httpResponse of a controller
 * @author sandro
 * @see String
 * @see Integer
 * @see Object
 */
public class Response {
	
	@NotNull
	@JsonProperty("status")
	private String status;
	@NotNull
	@JsonProperty("code")
	private int code;
	@JsonProperty("message")
	private String message;
	@JsonProperty("totalElements")
	private int totalElements;
	@JsonProperty("body")
	private Object body;
	/**
	 * default constructor	 * 
	 */
	public Response() {
		
	}
	
	/**
	 * constructor to create a response with two parameters
	 * @param status
	 * @param code
	 */
	public Response(@JsonProperty("status") final String status, @JsonProperty("code") final int code) {
        this.status = status;
        this.code = code;
        this.message = "";
    }
	/**
	 * 
	 * @param status
	 * @param code
	 * @param message
	 * @param totalElements
	 * @param body
	 */
	/*@JsonCreator
	public Response(@JsonProperty("status") String status,
					@JsonProperty("code") int code,
					@JsonProperty("message")String message,
					@JsonProperty("totalElements")int totalElements,
					@JsonProperty("body")Object body) {
		this.status = status;
		this.code = code;
		this.message = message;
		this.totalElements = totalElements;
		this.body = body;
	}*/
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}

	public int getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}
	

}
