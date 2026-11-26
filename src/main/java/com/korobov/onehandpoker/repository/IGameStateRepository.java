package com.korobov.onehandpoker.repository;

import com.korobov.onehandpoker.model.IGameStateModel;
import com.korobov.onehandpoker.utilities.IError;
import com.korobov.onehandpoker.utilities.Result;

public interface IGameStateRepository {

    Result<IGameStateModel, IError> save(IGameStateModel model);

    Result<IGameStateModel, IError> findById(Long id);

    Result<Iterable<IGameStateModel>, IError> findAll();

    Result<Iterable<IGameStateModel>, IError> findAllByPlayerId(Long playerId);
}