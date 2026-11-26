package com.korobov.onehandpoker.model;

import java.math.BigDecimal;

import com.korobov.onehandpoker.model.components.CardRecord;
import com.korobov.onehandpoker.model.components.EGameResult;
import com.korobov.onehandpoker.utilities.IError;
import com.korobov.onehandpoker.utilities.Result;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity //NOTE: This annotation marks the class as a JPA entity.
public class GameStateModel implements IGameStateModel{

    @Id //NOTE: This annotation marks the field as the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;

    private Long playerId;
    private CardRecord[] playerCards;
    private EGameResult gameResult;
    private BigDecimal playerBet;
    private BigDecimal winMultiplier;
    private BigDecimal playerWinnings;

    //NOTE: A protected empty constructor is required by JPA.
    protected GameStateModel(){

    }

    private GameStateModel(
        Long playerId,
        CardRecord[] playerCards,
        EGameResult gameResult,
        BigDecimal playerBet,
        BigDecimal winMultiplier,
        BigDecimal playerWinnings
    ){

        this.playerId = playerId;
        this.playerCards = playerCards;
        this.gameResult = gameResult;
        this.playerBet = playerBet;
        this.winMultiplier = winMultiplier;
        this.playerWinnings = playerWinnings;
    }

    //NOTE: A static factory method to create a valid instance of GameStateModel and ensure domain integrity.
    public static Result<GameStateModel, IError> create(
        Long playerId,
        CardRecord[] playerCards,
        EGameResult gameResult,
        BigDecimal playerBet,
        BigDecimal winMultiplier,
        BigDecimal playerWinnings
    ){

        //TODO: Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGameId'");
    }

    @Override
    public Long getGameId() {
        //TODO: Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGameId'");
    }

    @Override
    public Long getPlayerId() {
        //TODO: Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPlayerId'");
    }

    @Override
    public Iterable<CardRecord> getPlayerCards() {
        //TODO: Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPlayerCards'");
    }

    @Override
    public EGameResult getGameResult() {
        //TODO: Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGameResult'");
    }

    @Override
    public BigDecimal getPlayerBet() {
        //TODO: Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPlayerBet'");
    }

    @Override
    public BigDecimal getWinMultiplier() {
        //TODO: Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getWinMultiplier'");
    }

    @Override
    public BigDecimal getPlayerWinnings() {
        //TODO: Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPlayerWinnings'");
    }
}
