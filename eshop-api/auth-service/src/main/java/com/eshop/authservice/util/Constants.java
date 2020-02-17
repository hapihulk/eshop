package com.eshop.authservice.util;

public enum Constants {

	NOOP_PASSWORD_ENCODE("{noop}");
	
	private final String value;

    private Constants (String value) {
            this.value = value;
    }
    
    @Override
    public String toString() {
        return value;
    }
}
