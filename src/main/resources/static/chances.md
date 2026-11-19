# One-Hand Poker — Probabilities, House Edge, and Gambling Risks

## Important gambling warning

Gambling is not a way to make money. It is a risk to your financial security, mental health, relationships, and overall well-being.

Gambling can lead to addiction, overwhelming debt, anxiety, depression, social isolation, broken relationships, and the loss of homes, jobs, and livelihoods. In severe cases, gambling-related harm can contribute to suicidal thoughts and suicide.

The safest choice is not to gamble at all. Never gamble with money you cannot afford to lose.

Gambling is not a way to make money. It is a risk to your financial security, mental health, relationships, and overall well-being.

Gambling can lead to addiction, overwhelming debt, anxiety, depression, social isolation, broken relationships, and the loss of homes, jobs, and livelihoods. In severe cases, gambling-related harm can contribute to suicidal thoughts and suicide.

Never gamble with money you cannot afford to lose.

**The safest choice is not to gamble at all.**

### The Illusion of Winning

Casino games are carefully designed to make gambling feel more rewarding than it actually is.

Frequent small wins, exciting animations, near misses, and occasional large payouts create the impression that winning is achievable and that continuing to play might be worthwhile.

Even getting your original bet back can feel like a victory, despite earning nothing. Large advertised jackpots draw attention away from how unlikely they are.

A high RTP does not mean a game is safe or profitable. The longer and more frequently you gamble, the more money you risk losing. Over many bets, the casino's mathematical advantage works against you.

**Every game is designed to keep you playing, not to make you rich.**

### The Casino Has the Advantage

This game has a theoretical Return to Player (RTP) of approximately 99.5%. This does not mean you will get 99.5% of your money back.

The casino has a mathematical advantage over the player. While individual players may win, every game is designed to generate a profit for the casino over a sufficiently large number of bets.

Even a seemingly small house edge does not make gambling safe. You can lose your entire balance in a short period of time.

**Never chase losses.**
**Never borrow money to gamble.** 
**Never believe that a winning streak is guaranteed.**
**Never believe that previous losses make future wins more likely.**

### Gambling Addiction Is a Serious Health Risk

Gambling addiction can develop gradually, sometimes without the affected person recognizing it. What begins as entertainment can turn into compulsive behavior with devastating consequences for individuals and their families.

If you or someone you know is struggling with gambling, seek professional support.

Free gambling addiction information and support in Germany:

**You do not need to lose everything before asking for help.**

[Check dein Spiel](https://www.check-dein-spiel.de/) – Gambling Addiction Prevention and Support

## The House Always Wins — The Mathematics Behind Casino Games
Casino games are mathematically designed to favor the house. Through carefully calculated probabilities and payout structures, casinos ensure that every bet generates a small expected profit for the operator.

While individual players may win, the mathematics work against them in the long run. The more bets are placed, the more reliably the casino's statistical advantage emerges. The house doesn't need to win every game. It only needs you to keep playing.

This is demonstrated by example through this project. The concrete mathematics are layed out below.
The implemented game aims to be as fair and rewarding as possible to trick players into betting and demonstrate that the house wins regardless.

### Deck and counting assumptions

One round draws five different cards uniformly from a standard 52-card deck (13 ranks from 2 through Ace, four suits, no jokers). Cards are drawn without replacement. There are 2,598,960 distinct five-card hands (52 choose 5). All hands are equally likely, and each is counted in exactly one outcome category.

An Ace may be low in `A-2-3-4-5` or high in `10-J-Q-K-A`. It cannot wrap around: `Q-K-A-2-3` is not a straight. A royal flush is excluded from the straight-flush count, and straight flushes are excluded from ordinary straights and flushes.

### Exact probabilities and payout table

| Outcome | Number of hands | Probability | Total payout |
|---|---:|---:|---:|
| Royal Flush | 4 | 0.000154% | 4000× |
| Straight Flush (not royal) | 36 | 0.001385% | 500× |
| Four of a Kind | 624 | 0.024010% | 150× |
| Full House | 3,744 | 0.144058% | 40× |
| Flush (not straight flush) | 5,108 | 0.196540% | 20× |
| Straight (not straight flush) | 10,200 | 0.392465% | 12× |
| Three of a Kind | 54,912 | 2.112845% | 7× |
| Two Pair | 123,552 | 4.753902% | 3.5× |
| Jacks or Better (exactly one high pair) | 337,920 | 13.002124% | 1.5× |
| Low Pair (exactly one pair of 2s–10s) | 760,320 | 29.254779% | 1× |
| High Card (no pair or stronger hand) | 1,302,540 | 50.117739% | 0× |
| Total | 2,598,960 | 100% | — |

Percentages are rounded for display. All calculations below use exact hand counts. Total payout includes the original bet. For example, `1×` returns the original bet (no profit), `1.5×` returns the original bet plus 50% profit, and `0×` loses the entire bet.

### How often does the player win?

- Lose the full bet (high card): 1,302,540 hands, or 50.117739%.
- Break even (pair of 2s through 10s): 760,320 hands, or 29.254779%.
- Make a net profit (Jacks or Better and stronger): 536,100 hands, or 20.627482%.
- Receive any payout at all (including refunds): 1,296,420 hands, or 49.882261%.

Thus, roughly half of rounds return something, but only about one in five rounds yields an actual profit. Receiving a refund is not a win in financial terms.

### Return to player (RTP)

RTP is the expected total payout divided by the total amount wagered, expressed as a percentage. Compute it by multiplying the number of hands in each category by its total payout multiplier, adding those products, and dividing by 2,598,960.

```text
Total possible hands = 2,598,960
Weighted payout sum = 2,585,936
RTP (fraction) = 2,585,936 / 2,598,960 = 0.994988764737
RTP (percentage) = 99.498876%
```

### House edge

The house edge is the casino's expected share of wagers, not the percentage of rounds the casino wins.

```text
House edge = 100% - RTP
House edge = 100% - 99.498876% = 0.501124%
```

The game therefore targets approximately 0.5% house edge. The casino has a positive expected result on every bet, even though it can lose money on individual bets or entire sessions.

### Expected outcomes over many bets

| Total chips wagered | Expected player payout | Expected casino profit |
|---:|---:|---:|
| 1,000 | 994.99 | 5.01 |
| 100,000 | 99,498.88 | 501.12 |
| 1,000,000 | 994,988.76 | 5,011.24 |

These figures are mathematical expectations, not guarantees. The house edge is small, but payouts are highly variable. A royal flush pays 4000× and occurs in only 4 of 2,598,960 possible hands (approximately once per 649,740 hands on average). There is no guarantee of seeing one within that number of rounds.

### Why casinos tend to profit in the long run

Because the expected payout is slightly less than the bet, the casino expects to retain about 0.5011% of all money wagered. For a 100-chip bet, the expected casino profit is about 0.5011 chips. Repeated wagering increases the expected total loss in proportion to the total staked.

The casino does not always win: players can have winning rounds and profitable sessions, and a casino can experience losses over finite periods. The long-run mathematical advantage is not certainty. The rare, very large payouts also create substantial financial risk for an operator with insufficient reserves.
