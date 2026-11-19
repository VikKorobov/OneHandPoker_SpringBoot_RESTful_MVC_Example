package com.korobov.onehandpoker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.korobov.onehandpoker.controller.requests.PlayRequest;
import com.korobov.onehandpoker.controller.views.FullGameView;
import com.korobov.onehandpoker.controller.views.QuickGameView;
import com.korobov.onehandpoker.controller.views.StatsView;

@RequestMapping("casino/onehandpoker/api/")
public interface IGameController {
    
    @PostMapping("play")
    ResponseEntity<QuickGameView> play(@RequestBody PlayRequest request);

    @GetMapping("game/{id}")
    ResponseEntity<FullGameView> getGame(@PathVariable Long id);

    @GetMapping("games")
    ResponseEntity<Iterable<FullGameView>> getGames();

    @GetMapping("player/{id}")
    ResponseEntity<FullGameView> getPlayer(@PathVariable Long id);

    @GetMapping("player/{id}/games")
    ResponseEntity<Iterable<FullGameView>> getPlayerGames(@PathVariable Long id);

    @GetMapping("stats")
    ResponseEntity<StatsView> getStats();

    //NOTE: The following two endpoints will serve static markdown files that are stored in the resources folder. 
    @GetMapping(value = "rules", produces = "text/markdown")
    ResponseEntity<String> getRules();

    @GetMapping(value = "chances", produces = "text/markdown")
    ResponseEntity<String> getChances();
}
