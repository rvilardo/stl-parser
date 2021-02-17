package com.rvilardo.exception;

public class NotVertexException extends Exception {
	
    /**
	 *  @see java.io.Serializable
	 */
	private static final long serialVersionUID = -9103262373379791179L;

	public NotVertexException(String errorMessage) {
        super(errorMessage);
    }
}
