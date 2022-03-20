package blackjack.domain.participant.human;

import blackjack.domain.cards.CardDeck;
import blackjack.domain.cards.card.Card;
import blackjack.domain.participant.human.name.Name;
import blackjack.domain.result.BetAmount;
import blackjack.domain.state.finished.Finished;
import java.util.List;

public final class Player extends Human {

    private final BetAmount betAmount;

    public Player(final Name name, final int betting, final List<Card> cards) {
        super(cards, name);
        this.betAmount = new BetAmount(betting);
    }

    public boolean hasCardSizeOf(final int size) {
        return getCards().size() == size;
    }

    public int getProfit(Dealer dealer) {
        return state.profit(getBetAmount(), (Finished) dealer.getState());
    }

    public void draw(CardDeck cardDeck, boolean isHit) {
        if (isHit) {
            addCard(cardDeck.pop());
            return;
        }
        setStay();
    }

    public int getBetAmount() {
        return betAmount.get();
    }
}
