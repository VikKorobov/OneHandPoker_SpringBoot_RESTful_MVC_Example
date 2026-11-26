package com.korobov.onehandpoker.service;

import com.korobov.onehandpoker.utilities.Result;
import com.korobov.onehandpoker.utilities.IError;

public interface IUserService {

    Result<Boolean, IError> exists(Long userId);
}