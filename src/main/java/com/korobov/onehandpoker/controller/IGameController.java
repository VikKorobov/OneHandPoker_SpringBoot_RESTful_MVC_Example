package com.korobov.onehandpoker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

import com.korobov.onehandpoker.controller.requests.PlayRequest;

@RequestMapping("casino/onehandpoker/api/")
public interface IGameController {

    @PostMapping("play")
    ResponseEntity<?> play(@Valid @RequestBody PlayRequest request);

    @GetMapping("game/{id}")
    ResponseEntity<?> getGame(@Positive @PathVariable Long id);

    @GetMapping("games")
    ResponseEntity<?> getGames();

    @GetMapping("games/player/{id}")
    ResponseEntity<?> getPlayerGames(@Positive @PathVariable Long id);

    @GetMapping("stats")
    ResponseEntity<?> getStats();

    @GetMapping("stats/player/{id}")
    ResponseEntity<?> getPlayerStats(@Positive @PathVariable Long id);

    //NOTE: The following two endpoints will serve static markdown files that are stored in the resources folder.
    @GetMapping(value = "info/rules", produces = "text/markdown")
    ResponseEntity<String> getRules();

    @GetMapping(value = "info/chances", produces = "text/markdown")
    ResponseEntity<String> getChances();
}
