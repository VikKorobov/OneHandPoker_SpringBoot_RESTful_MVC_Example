package com.korobov.onehandpoker.factory;

import com.korobov.onehandpoker.errors.ErrorRecord;
import com.korobov.onehandpoker.model.IGameStateModel;
import com.korobov.onehandpoker.utilities.Result;

public interface IGameStateFactory {
    
    Result<IGameStateModel, ErrorRecord> create();
}
