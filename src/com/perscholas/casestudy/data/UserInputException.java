/**
 * 
 */
package com.perscholas.casestudy.data;

/**
 * @author rwilk
 *
 */
public class UserInputException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public UserInputException() {
		super();
	}
	
	/**
	 * @param message
	 */
	public UserInputException(String message) {
		super(message);
	}
}
