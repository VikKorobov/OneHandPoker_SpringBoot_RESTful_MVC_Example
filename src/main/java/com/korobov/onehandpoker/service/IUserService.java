package com.korobov.onehandpoker.service;

import com.korobov.onehandpoker.utilities.Result;
import com.korobov.onehandpoker.utilities.IError;

/**
 * Defines the contract for communication with the external User service.
 *
 * <p>
 * This interface abstracts the underlying communication mechanism
 * and allows application components to verify the existence of
 * users without depending on implementation-specific details
 * of the external service.
 * </p>
 */
public interface IUserService {
    
    /**
     * Checks whether a user exists.
     *
     * @param userId the positive user ID.
     * @return true if the user exists, false if not, or an error
     *         if verification fails.
     */
    Result<Boolean, IError> exists(Long userId);
}