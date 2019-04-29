package com.example.BootMysql.common;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

/**
 * Instanciate the MessageSource class then
 * create the accessor via the messageSource object
 * 
 * @author sandro
 * @see String
 * @since 11-08-2018
 */
@Component
public class Message {
	
	@Autowired
	MessageSource messageSource;
	
	MessageSourceAccessor accessor;
	
	/**
	 * method to be executed after the constructor
	 * which instantiate the accessor
	  */
    @PostConstruct
	public void init() {
		accessor = new MessageSourceAccessor(messageSource);		
	}
    /**
     * @param code a key to search it in the message source file
     * @return the correspondent string value
     */
	public String get(String code) {
		return accessor.getMessage(code);
	}
}