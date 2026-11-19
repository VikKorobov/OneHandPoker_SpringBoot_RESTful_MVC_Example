# One-Hand Poker — Game Rules

## Overview

One-Hand Poker is a simplified, single-round, five-card casino game. The player places one bet, the game deals five cards from a standard 52-card deck, and the result is evaluated immediately. There is **no draw, card replacement, dealer hand, or second betting phase**.

Each round is independent and can be completed with a single stateless REST request. The game does not need to remember a hand between requests. If the application maintains a chip balance, however, balance changes and duplicate-request protection must be handled safely by the surrounding account system.

## How to play

1. The player chooses a valid stake in chips.
2. The server accepts the bet and randomly selects five **distinct** cards from a standard 52-card deck (no jokers).
3. The server identifies the **highest-ranking applicable** poker hand.
4. The server applies the corresponding payout multiplier.
5. The round ends immediately; the server returns the cards, result, and payout.

Aces can be high or low in a straight: `A-2-3-4-5` and `10-J-Q-K-A` are valid, but `Q-K-A-2-3` is not.

## Hand rankings and payouts

| Hand | Definition | Total payout multiplier |
|---|---|---:|
| Royal Flush | A, K, Q, J, 10 of the same suit | 4000× |
| Straight Flush | Five consecutive ranks of the same suit, excluding Royal Flush | 500× |
| Four of a Kind | Four cards of the same rank | 150× |
| Full House | Three cards of one rank and two of another | 40× |
| Flush | Five cards of the same suit, excluding straight flushes | 20× |
| Straight | Five consecutive ranks, not all of the same suit | 12× |
| Three of a Kind | Exactly three cards of the same rank, without a pair | 7× |
| Two Pair | Two distinct pairs and one other card | 3.5× |
| Jacks or Better | Exactly one pair of Jacks, Queens, Kings, or Aces | 1.5× |
| Low Pair | Exactly one pair of 2s through 10s | 1× |
| High Card | No pair, straight, flush, or stronger hand | 0× |

Multipliers represent the total amount returned, including the original stake. A `1×` payout on a 100-chip bet returns 100 chips (break-even). A `1.5×` payout returns 150 chips (50 chips net profit). A `0×` payout returns nothing (100 chips net loss).

These are game-specific payout rules, not the standard payouts of traditional video poker. The categories are mutually exclusive: always classify a hand by its highest applicable ranking. A low pair is a refund, not a net win.

For an exact payout with 1.5× or 3.5×, use a bet that is divisible by 2 chips, or define a smaller integer accounting unit. Never silently round payouts without recalculating the RTP.

## Example

- **Stake:** 100 chips
- **Cards:** `5♠ 5♥ 5♦ 2♣ 2♥`
- **Result:** Full House
- **Multiplier:** 40×
- **Total payout:** 4,000 chips
- **Net profit:** 3,900 chips


The server, not the client, must determine the dealt cards and the payout. Use a secure, unbiased random-number generator and sample without replacement. Validate stakes, use exact decimal or integer minor-unit arithmetic for fractional multipliers (or restrict bets to multiples of 2), and handle retries safely if real balances are involved.

## Game characteristics

- Five cards from one standard 52-card deck
- Exactly one bet and one automatic evaluation
- No player decisions after placing the bet
- One request can finish a round
- No session-specific game state required
- Theoretical return to player (RTP): 99.498876%
- Theoretical house edge: 0.501124%

See http://localhost:8080/casino/onehandpoker/api/chances for the exact probabilities and gambling-risk explanation.
