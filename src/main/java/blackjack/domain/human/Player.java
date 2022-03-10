package blackjack.domain.human;

import blackjack.domain.Result;
import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;

public class Player extends Human {
    private final int BLACKJACK_NUMBER = 21;
    private final Name name;
    private final Cards cards;
    private Result result;

    private Player(Name name) {
        this.name = name;
        this.cards = Cards.of();
    }

    public static Player of(Name name) {
        return new Player(name);
    }

    public void calculateResult(final int dealerPoint) {
        int point = getPoint();
        if (dealerPoint > BLACKJACK_NUMBER) {
            if (point <= BLACKJACK_NUMBER) {
                this.result = Result.WIN;
                return;
            }
            this.result = Result.LOSE;
            return;
        }
        if (point > BLACKJACK_NUMBER || dealerPoint > point) {
            this.result = Result.LOSE;
            return;
        }
        if (dealerPoint == point) {
            this.result = Result.DRAW;
            return;
        }
        this.result = Result.WIN;
    }

    public Result getResult() {
        return result;
    }

    @Override
    public boolean isOneMoreCard() {
        return cards.getPoint() < BLACKJACK_NUMBER;
    }

    @Override
    public String getName() {
        return name.get();
    }

    @Override
    public Cards getCards() {
        return cards;
    }

    @Override
    public void addCard(final Card card) {
        cards.add(card);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name=" + name +
                ", cards=" + cards +
                ", result=" + result +
                '}';
    }
}
