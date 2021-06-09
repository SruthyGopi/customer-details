package com.example.customer.details.handler;

public class RecordNotFoundException extends RuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 8908349136467468443L;
	private String message;

    public RecordNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
