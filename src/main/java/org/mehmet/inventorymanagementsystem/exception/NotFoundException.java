package org.mehmet.inventorymanagementsystem.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);  // Mesaj ve nedeni ile exception'ı başlatır
    }
}
