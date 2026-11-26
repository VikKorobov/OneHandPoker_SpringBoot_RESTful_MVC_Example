package com.korobov.onehandpoker;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.provider.Arguments;

import com.korobov.onehandpoker.model.components.CardRecord;
import com.korobov.onehandpoker.model.components.ECardRank;
import com.korobov.onehandpoker.model.components.ECardSuit;
import com.korobov.onehandpoker.model.components.EGameResult;

class GameStateModelTests {

    private static final Map<String, CardRecord> CARDS = new HashMap<>();

    static {

        for (var suit : ECardSuit.values()) {

            for (var rank : ECardRank.values()) {

                CARDS.put(
                    rank.name() + "_OF_" + suit.name(),
                    new CardRecord(suit, rank)
                );
            }
        }
    }

    private static final Long[] INVALID_PLAYER_IDS = { null, 0L, -1L, Long.MIN_VALUE };
    private static final EGameResult[] INVALID_GAME_RESULTS = { null };

    private static final BigDecimal[] INVALID_PLAYER_BETS = {
        null,
        BigDecimal.ZERO,
        new BigDecimal("0.00"),
        new BigDecimal("-0.01"),
        new BigDecimal("-1.00"),
        new BigDecimal("-999999999999999999999999.99"),
        new BigDecimal("1.999")
    };

    private static final BigDecimal[] INVALID_WIN_MULTIPLIERS = {
        null,
        new BigDecimal("-0.01"),
        new BigDecimal("-1.00"),
        new BigDecimal("-999999999999999999999999.99")
    };

    private static final BigDecimal[] INVALID_PLAYER_WINNINGS = {
        null,
        new BigDecimal("-0.01"),
        new BigDecimal("-1.00"),
        new BigDecimal("-999999999999999999999999.99"),
        new BigDecimal("1.999")
    };

    private static final CardRecord[][] INVALID_PLAYER_CARDS = {
        null,
        new CardRecord[0],
        new CardRecord[5],
        {
            CARDS.get("TEN_OF_HEARTS"),
            CARDS.get("JACK_OF_HEARTS"),
            CARDS.get("QUEEN_OF_HEARTS"),
            CARDS.get("KING_OF_HEARTS"),
            null
        },
        {
            CARDS.get("TEN_OF_HEARTS"),
            CARDS.get("JACK_OF_HEARTS"),
            CARDS.get("QUEEN_OF_HEARTS"),
            CARDS.get("KING_OF_HEARTS")
        },
        {
            CARDS.get("TEN_OF_HEARTS"),
            CARDS.get("JACK_OF_HEARTS"),
            CARDS.get("QUEEN_OF_HEARTS"),
            CARDS.get("KING_OF_HEARTS"),
            CARDS.get("ACE_OF_HEARTS"),
            CARDS.get("ACE_OF_SPADES")
        }
    };

    private static final CardRecord[][] DUPLICATE_PLAYER_CARDS = {
        {
            CARDS.get("TEN_OF_HEARTS"),
            CARDS.get("JACK_OF_HEARTS"),
            CARDS.get("QUEEN_OF_HEARTS"),
            CARDS.get("KING_OF_HEARTS"),
            CARDS.get("KING_OF_HEARTS")
        },
        {
            CARDS.get("TEN_OF_HEARTS"),
            CARDS.get("TEN_OF_HEARTS"),
            CARDS.get("QUEEN_OF_HEARTS"),
            CARDS.get("KING_OF_HEARTS"),
            CARDS.get("KING_OF_HEARTS")
        },
        {
            CARDS.get("ACE_OF_HEARTS"),
            CARDS.get("ACE_OF_HEARTS"),
            CARDS.get("ACE_OF_HEARTS"),
            CARDS.get("ACE_OF_HEARTS"),
            CARDS.get("ACE_OF_HEARTS")
        }
    };

    // NOTE: Test values are picked so that domain specific edge cases like Ace-high
    // and Ace-low straights are covered.
    private static final Arguments[] INCONSISTENT_GAME_RESULTS = {
        Arguments.of(
            new CardRecord[] {
                CARDS.get("ACE_OF_HEARTS"),
                CARDS.get("TWO_OF_SPADES"),
                CARDS.get("THREE_OF_CLUBS"),
                CARDS.get("FOUR_OF_DIAMONDS"),
                CARDS.get("FIVE_OF_HEARTS")
            }, 
            EGameResult.HIGH_CARD
        ),
        Arguments.of(
            new CardRecord[] {
                CARDS.get("TEN_OF_HEARTS"),
                CARDS.get("JACK_OF_SPADES"),
                CARDS.get("QUEEN_OF_CLUBS"),
                CARDS.get("KING_OF_DIAMONDS"),
                CARDS.get("ACE_OF_HEARTS")
            }, 
            EGameResult.HIGH_CARD
        ),
        Arguments.of(
            new CardRecord[] {
                CARDS.get("QUEEN_OF_HEARTS"),
                CARDS.get("KING_OF_SPADES"),
                CARDS.get("ACE_OF_CLUBS"),
                CARDS.get("TWO_OF_DIAMONDS"),
                CARDS.get("THREE_OF_HEARTS")
            }, 
            EGameResult.STRAIGHT
        )
    };

    private static final Arguments[] INCONSISTENT_PLAYER_WINNINGS = {
        Arguments.of(
            new BigDecimal("10.00"),
            new BigDecimal("2"),
            new BigDecimal("19.99")
        ),
        Arguments.of(
            new BigDecimal("10.00"),
            new BigDecimal("2"),
            new BigDecimal("20.01")
        ),
        Arguments.of(
            new BigDecimal("10.00"),
            new BigDecimal("2"),
            BigDecimal.ZERO
        ),
        Arguments.of(
            new BigDecimal("10.00"),
            BigDecimal.ZERO,
            new BigDecimal("10.00")
        ),
        Arguments.of(
            new BigDecimal("10.50"),
            new BigDecimal("1.5"),
            new BigDecimal("15.76")
        )
    };

    private static final Long[] VALID_PLAYER_IDS = { 1L, 100L, Long.MAX_VALUE };

    private static final CardRecord[][] VALID_PLAYER_CARDS = {
        {
            CARDS.get("TEN_OF_HEARTS"),
            CARDS.get("JACK_OF_HEARTS"),
            CARDS.get("QUEEN_OF_HEARTS"),
            CARDS.get("KING_OF_HEARTS"),
            CARDS.get("ACE_OF_HEARTS")
        },
        {
            CARDS.get("TEN_OF_SPADES"),
            CARDS.get("JACK_OF_SPADES"),
            CARDS.get("QUEEN_OF_SPADES"),
            CARDS.get("KING_OF_SPADES"),
            CARDS.get("ACE_OF_SPADES")
        }
    };

    private static final BigDecimal[] VALID_PLAYER_BETS = {
        new BigDecimal("0.01"),
        BigDecimal.ONE,
        new BigDecimal("1.00"),
        new BigDecimal("10.50"),
        new BigDecimal("999999999999999999999999.99")
    };

    private static final BigDecimal[] VALID_PLAYER_WINNINGS = {
        BigDecimal.ZERO,
        new BigDecimal("0.00"),
        new BigDecimal("0.01"),
        BigDecimal.ONE,
        new BigDecimal("1.00"),
        new BigDecimal("10.50"),
        new BigDecimal("999999999999999999999999.99")
    };

    private static final BigDecimal[] VALID_WIN_MULTIPLIERS = {
        BigDecimal.ZERO,
        new BigDecimal("0.00"),
        new BigDecimal("0.01"),
        new BigDecimal("0.5"),
        BigDecimal.ONE,
        new BigDecimal("1.00"),
        new BigDecimal("1.50"),
        new BigDecimal("2.555"),
        new BigDecimal("250.00"),
        new BigDecimal("999999999999999999999999.99")
    };

    private static final Arguments[] CONSISTENT_GAME_RESULTS = {
        Arguments.of(
            new CardRecord[] { // Royal flush
                CARDS.get("TEN_OF_HEARTS"),
                CARDS.get("JACK_OF_HEARTS"),
                CARDS.get("QUEEN_OF_HEARTS"),
                CARDS.get("KING_OF_HEARTS"),
                CARDS.get("ACE_OF_HEARTS")
            }, 
            EGameResult.ROYAL_FLUSH
        ),
        Arguments.of(
            new CardRecord[] { // Straight flush
                CARDS.get("FIVE_OF_SPADES"),
                CARDS.get("SIX_OF_SPADES"),
                CARDS.get("SEVEN_OF_SPADES"),
                CARDS.get("EIGHT_OF_SPADES"),
                CARDS.get("NINE_OF_SPADES")
            }, 
            EGameResult.STRAIGHT_FLUSH
        ),
        Arguments.of(
            new CardRecord[] { // Ace-low straight flush
                CARDS.get("ACE_OF_CLUBS"),
                CARDS.get("TWO_OF_CLUBS"),
                CARDS.get("THREE_OF_CLUBS"),
                CARDS.get("FOUR_OF_CLUBS"),
                CARDS.get("FIVE_OF_CLUBS")
            }, 
            EGameResult.STRAIGHT_FLUSH
        ),
        Arguments.of(
            new CardRecord[] { // Four of a kind
                CARDS.get("KING_OF_HEARTS"),
                CARDS.get("KING_OF_SPADES"),
                CARDS.get("KING_OF_CLUBS"),
                CARDS.get("KING_OF_DIAMONDS"),
                CARDS.get("TWO_OF_HEARTS")
            }, 
            EGameResult.FOUR_OF_A_KIND
        ),
        Arguments.of(
            new CardRecord[] { // Full house
                CARDS.get("QUEEN_OF_HEARTS"),
                CARDS.get("QUEEN_OF_SPADES"),
                CARDS.get("QUEEN_OF_CLUBS"),
                CARDS.get("SEVEN_OF_DIAMONDS"),
                CARDS.get("SEVEN_OF_HEARTS")
            }, 
            EGameResult.FULL_HOUSE
        ),
        Arguments.of(
            new CardRecord[] { // Flush
                CARDS.get("TWO_OF_DIAMONDS"),
                CARDS.get("FIVE_OF_DIAMONDS"),
                CARDS.get("SEVEN_OF_DIAMONDS"),
                CARDS.get("JACK_OF_DIAMONDS"),
                CARDS.get("ACE_OF_DIAMONDS")
            }, 
            EGameResult.FLUSH
        ),
        Arguments.of(
            new CardRecord[] { // Regular straight
                CARDS.get("SEVEN_OF_HEARTS"),
                CARDS.get("THREE_OF_SPADES"),
                CARDS.get("FIVE_OF_CLUBS"),
                CARDS.get("FOUR_OF_DIAMONDS"),
                CARDS.get("SIX_OF_HEARTS")
            }, 
            EGameResult.STRAIGHT
        ),
        Arguments.of(
            new CardRecord[] { // Ace-low straight
                CARDS.get("ACE_OF_HEARTS"),
                CARDS.get("TWO_OF_SPADES"),
                CARDS.get("THREE_OF_CLUBS"),
                CARDS.get("FOUR_OF_DIAMONDS"),
                CARDS.get("FIVE_OF_HEARTS")
            }, 
            EGameResult.STRAIGHT
        ),
        Arguments.of(
            new CardRecord[] { // Ace-high straight
                CARDS.get("TEN_OF_HEARTS"),
                CARDS.get("JACK_OF_SPADES"),
                CARDS.get("QUEEN_OF_CLUBS"),
                CARDS.get("KING_OF_DIAMONDS"),
                CARDS.get("ACE_OF_HEARTS")
            }, 
            EGameResult.STRAIGHT
        ),
        Arguments.of(
            new CardRecord[] { // Three of a kind
                CARDS.get("EIGHT_OF_HEARTS"),
                CARDS.get("EIGHT_OF_SPADES"),
                CARDS.get("EIGHT_OF_CLUBS"),
                CARDS.get("FOUR_OF_DIAMONDS"),
                CARDS.get("KING_OF_HEARTS")
            }, 
            EGameResult.THREE_OF_A_KIND
        ),
        Arguments.of(
            new CardRecord[] { // Two pair
                CARDS.get("KING_OF_HEARTS"),
                CARDS.get("KING_OF_SPADES"),
                CARDS.get("TEN_OF_CLUBS"),
                CARDS.get("TEN_OF_DIAMONDS"),
                CARDS.get("ACE_OF_HEARTS")
            }, 
            EGameResult.TWO_PAIR
        ),
        Arguments.of(
            new CardRecord[] { // Jacks or better - pair of jacks (lower boundary)
                CARDS.get("JACK_OF_HEARTS"),
                CARDS.get("JACK_OF_SPADES"),
                CARDS.get("THREE_OF_CLUBS"),
                CARDS.get("SEVEN_OF_DIAMONDS"),
                CARDS.get("NINE_OF_HEARTS")
            }, 
            EGameResult.JACKS_OR_BETTER
        ),
        Arguments.of(
            new CardRecord[] { // Jacks or better - pair of aces (upper boundary)
                CARDS.get("ACE_OF_HEARTS"),
                CARDS.get("ACE_OF_SPADES"),
                CARDS.get("THREE_OF_CLUBS"),
                CARDS.get("SEVEN_OF_DIAMONDS"),
                CARDS.get("NINE_OF_HEARTS")
            }, 
            EGameResult.JACKS_OR_BETTER
        ),
        Arguments.of(
            new CardRecord[] { // Low pair - pair of twos (lower boundary)
                CARDS.get("TWO_OF_HEARTS"),
                CARDS.get("TWO_OF_SPADES"),
                CARDS.get("FIVE_OF_CLUBS"),
                CARDS.get("SEVEN_OF_DIAMONDS"),
                CARDS.get("KING_OF_HEARTS")
            }, 
            EGameResult.LOW_PAIR
        ),
        Arguments.of(
            new CardRecord[] { // Low pair - pair of tens (upper boundary)
                CARDS.get("TEN_OF_HEARTS"),
                CARDS.get("TEN_OF_SPADES"),
                CARDS.get("THREE_OF_CLUBS"),
                CARDS.get("SEVEN_OF_DIAMONDS"),
                CARDS.get("KING_OF_HEARTS")
            }, 
            EGameResult.LOW_PAIR
        ),
        Arguments.of(
            new CardRecord[] { // High card
                CARDS.get("TWO_OF_HEARTS"),
                CARDS.get("FIVE_OF_SPADES"),
                CARDS.get("SEVEN_OF_CLUBS"),
                CARDS.get("NINE_OF_DIAMONDS"),
                CARDS.get("KING_OF_HEARTS")
            }, 
            EGameResult.HIGH_CARD
        ),
        Arguments.of(
            new CardRecord[] { // High card - invalid wraparound straight
                CARDS.get("QUEEN_OF_HEARTS"),
                CARDS.get("KING_OF_SPADES"),
                CARDS.get("ACE_OF_CLUBS"),
                CARDS.get("TWO_OF_DIAMONDS"),
                CARDS.get("THREE_OF_HEARTS")
            }, 
            EGameResult.HIGH_CARD
        )
    };

    private static final Arguments[] CONSISTENT_PLAYER_WINNINGS = {
        Arguments.of(
            new BigDecimal("10.00"),
            BigDecimal.ZERO,
            BigDecimal.ZERO
        ),
        Arguments.of(
            new BigDecimal("10.00"),
            new BigDecimal("0.5"),
            new BigDecimal("5.00")
        ),
        Arguments.of(
            new BigDecimal("10.00"),
            BigDecimal.ONE,
            new BigDecimal("10.00")
        ),
        Arguments.of(
            new BigDecimal("10.00"),
            new BigDecimal("2"),
            new BigDecimal("20.00")
        ),
        Arguments.of(
            new BigDecimal("10.50"),
            new BigDecimal("1.5"),
            new BigDecimal("15.75")
        ),
        Arguments.of(
            new BigDecimal("100.00"),
            new BigDecimal("1.125"),
            new BigDecimal("112.50")
        ),
        Arguments.of(
            new BigDecimal("0.01"),
            new BigDecimal("2"),
            new BigDecimal("0.02")
        ),
        Arguments.of(
            new BigDecimal("10.00"),
            new BigDecimal("2.00"),
            new BigDecimal("20")
        ),
        Arguments.of(
            new BigDecimal("999999999999999999999999.99"),
            new BigDecimal("2"),
            new BigDecimal("1999999999999999999999999.98")
        )
    };

}