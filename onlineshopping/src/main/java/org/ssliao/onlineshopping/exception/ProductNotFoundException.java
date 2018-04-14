package org.ssliao.onlineshopping.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable {
    private String message;
    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return message;
    }

    public ProductNotFoundException() {
        this("Product is not available!");
    }

    public ProductNotFoundException(String message) {
        this.message = System.currentTimeMillis() + ": " + message;
    }

}
