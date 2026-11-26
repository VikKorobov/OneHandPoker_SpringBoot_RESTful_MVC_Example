package com.korobov.onehandpoker.controller.requests;

import java.math.BigDecimal;

public record PlayRequest(Long playerId, BigDecimal playerBet) {
    
}
