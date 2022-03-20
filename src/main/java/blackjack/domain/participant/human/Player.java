package blackjack.domain.participant.human;

import blackjack.domain.cards.CardDeck;
import blackjack.domain.cards.card.Card;
import blackjack.domain.participant.human.name.Name;
import blackjack.domain.result.BetAmount;
import blackjack.domain.state.finished.Finished;
import java.util.List;

public final class Player extends Human {
    private static final int INIT_NUMBER = 2;

    private final BetAmount betAmount;

    public Player(final String name, final int betting, final List<Card> cards) {
        super(cards, new Name(name));
        this.betAmount = new BetAmount(betting);
    }

    public boolean isInitSize() {
        return getCards().size() == INIT_NUMBER;
    }


    public int getProfit(Dealer dealer) {
        return state.profit(betAmount.get(), (Finished) dealer.getState());
    }

    public void draw(CardDeck cardDeck, boolean isHit) {
        if (isHit) {
            addCard(cardDeck.pop());
            return;
        }
        setStay();
    }
}
