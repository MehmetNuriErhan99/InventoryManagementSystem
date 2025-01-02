package org.mehmet.inventorymanagementsystem.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);  // Mesajla birlikte exception'ı başlatır
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);  // Mesaj ve nedeni ile exception'ı başlatır
    }
}
