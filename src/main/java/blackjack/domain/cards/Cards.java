package blackjack.domain.cards;

import blackjack.domain.cards.card.Card;
import blackjack.domain.cards.card.denomination.Denomination;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Cards {
    private static final int BLACKJACK_NUMBER = 21;
    private static final int ACE_MINUS_NUMBER = 10;
    private static final int BLACKJACK_CARD_COUNT = 2;

    private final List<Card> value;

    public Cards() {
        this.value = new ArrayList<>();
    }

    public Cards(List<Card> value) {
        this.value = value;
    }

    public Cards add(final Card card) {
        value.add(card);
        return new Cards(value);
    }

    public int size() {
        return value.size();
    }

    public Card getFirstCard() {
        return value.get(0);
    }

    public int getPoint() {
        int point = getRawPoint();
        int aceCount = getAceCount();

        while (point > BLACKJACK_NUMBER && aceCount > 0) {
            point -= ACE_MINUS_NUMBER;
            aceCount--;
        }
        return point;
    }

    private int getRawPoint() {
        return value.stream()
                .mapToInt(Card::getPoint)
                .sum();
    }

    private int getAceCount() {
        return (int) value.stream()
                .filter(card -> card.isSameDenomination(Denomination.ACE))
                .count();
    }

    public boolean isBust() {
        return getPoint() > BLACKJACK_NUMBER;
    }

    public boolean isBlackjack() {
        return getPoint() == BLACKJACK_NUMBER && size() == BLACKJACK_CARD_COUNT;
    }

    public boolean hasMorePoint(final Cards cards) {
        return getPoint() > cards.getPoint();
    }

    public boolean hasSamePoint(final Cards cards) {
        return this.getPoint() == cards.getPoint();
    }

    public List<Card> getCopy() {
        return List.copyOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cards cards1 = (Cards) o;
        return Objects.equals(value, cards1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
