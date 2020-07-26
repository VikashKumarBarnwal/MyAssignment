/**
 * 
 */
package com.vks.xebia.app.exception;

/**
 * @author Admin
 *
 */
public class ArticleNotFoundException extends Exception {
	
	private Integer id;
	
	private String message;
	
    public ArticleNotFoundException() {}
    public ArticleNotFoundException(Integer id,String errorMessage) {
    	this.id= id;
    	this.message= errorMessage;
    }
	public Integer getId() {
		return id;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
    
    
}
