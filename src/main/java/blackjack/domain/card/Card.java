package blackjack.domain.card;

import blackjack.domain.card.element.Denomination;
import blackjack.domain.card.element.Suit;

public final class Card {
    private final Denomination denomination;
    private final Suit suit;
    
    private Card(final Denomination denomination, final Suit suit) {
        this.denomination = denomination;
        this.suit = suit;
    }
    
    public static Card of(final Denomination denomination, final Suit suit) {
        return new Card(denomination, suit);
    }
    
    public boolean isAce() {
        return denomination.equals(Denomination.ACE);
    }
    
    public Denomination getDenomination() {
        return denomination;
    }
    
    @Override
    public String toString() {
        return denomination.getInitial() + suit.getName();
    }
}
