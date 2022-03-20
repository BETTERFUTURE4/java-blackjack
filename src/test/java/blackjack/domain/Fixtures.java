package blackjack.domain;

import blackjack.domain.cards.card.Card;
import blackjack.domain.cards.card.denomination.Denomination;
import blackjack.domain.cards.card.denomination.Suit;
import blackjack.domain.participant.human.Player;
import java.util.ArrayList;

public class Fixtures {
    public static final Card ACE = Card.of(Denomination.ACE, Suit.CLOVER);
    public static final Card NINE = Card.of(Denomination.NINE, Suit.CLOVER);
    public static final Card TEN = Card.of(Denomination.TEN, Suit.CLOVER);
    public static final Card EIGHT = Card.of(Denomination.EIGHT, Suit.CLOVER);
    public static final Card TWO = Card.of(Denomination.TWO, Suit.CLOVER);
    public final Player POBI = new Player("pobi", 10000, new ArrayList<>());
    public final Player JASON = new Player("jason", 10000, new ArrayList<>());
    public final Player HUNCH = new Player("hunch", 10000, new ArrayList<>());

}
