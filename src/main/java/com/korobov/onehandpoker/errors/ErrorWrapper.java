
package com.korobov.onehandpoker.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Represents an error with an associated message and HTTP status code.
 *
 * <p>
 * This record encapsulates the information required to describe an error
 * and provides a method to convert it into an HTTP response.
 * </p>
 *
 * @param message the error message.
 * @param status  the associated HTTP status code.
 *
 * @see HttpStatus
 * @see ResponseEntity
 *
 * @author Korobov Viktor
 * @version 1.0
 */
public record ErrorWrapper(String message, HttpStatus status) {

    /**
     * Converts this {@code ErrorWrapper} into an HTTP response.
     *
     * <p>
     * The response contains the associated HTTP status code and uses
     * the error message as its body.
     * </p>
     *
     * @return a {@code ResponseEntity} containing the error message
     *         and the associated HTTP status code.
     */
    public ResponseEntity<String> toResponseEntity() {
        
        return ResponseEntity.status(status).body(message);
    }
}
