package blackjack.domain.players.participant;

import blackjack.domain.cards.Cards;
import blackjack.domain.cards.card.Card;
import blackjack.domain.players.participant.name.Name;
import blackjack.domain.state.State;
import blackjack.domain.state.running.Ready;
import java.util.List;

public abstract class Participant {
    private static final int INIT_CARD_SIZE = 2;

    protected final Name name;
    protected State state;


    protected Participant(List<Card> cards, Name name) {
        this.name = name;
        this.state = getInitState(cards);
    }

    private State getInitState(List<Card> cards) {
        State state = new Ready();
        for (Card card : cards) {
            state = state.draw(card);
        }
        return state;
    }

    public void addCard(final Card card) {
        state = state.draw(card);
    }

    public boolean isInitState() {
        return getCards().isSizeOf(INIT_CARD_SIZE);
    }

    public void stay() {
        state = state.stay();
    }

    public State getState() {
        return state;
    }

    public int getPoint() {
        return getCards().getPoint();
    }

    public String getName() {
        return name.get();
    }

    public List<Card> getRawCards() {
        return getCards().getCopy();
    }

    protected Cards getCards() {
        return state.cards();
    }
}
