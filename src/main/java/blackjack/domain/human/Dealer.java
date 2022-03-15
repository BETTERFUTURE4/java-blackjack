package blackjack.domain.human;

import blackjack.domain.card.Cards;

public final class Dealer extends Human {
    private static final int HIT_STANDARD_NUMBER = 16;
    
    private Dealer() {
        super(new Cards(), "딜러");
    }
    
    public static Dealer newInstance() {
        return new Dealer();
    }
    
    @Override
    public boolean isAbleToHit() {
        return cards.getPoint() <= HIT_STANDARD_NUMBER;
    }
}
