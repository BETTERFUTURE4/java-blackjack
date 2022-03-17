package blackjack.domain.human;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.cards.Cards;
import blackjack.domain.card.element.Denomination;
import blackjack.domain.card.element.Suit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HumanTest {

    @Test
    @DisplayName("카드 추가 기능 테스트")
    void addCard() {
        // given
        Human human = Player.from("test");
        Card card = Card.of(Denomination.from("10"), Suit.SPADE);

        // when
        human.addCard(card);

        // then
        assertThat(human.getCards().size())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("버스트 여부 확인 기능 true 테스트")
    public void isBustTest() {
        // given
        Human human = Player.from("test");
        Card card = Card.of(Denomination.from("10"), Suit.SPADE);
        Card card2 = Card.of(Denomination.from("10"), Suit.SPADE);

        // when
        human.addCard(card);
        human.addCard(card2);
        human.addCard(card2);

        // then
        assertThat(human.isBust())
                .isTrue();
    }

    @Test
    @DisplayName("첫 카드 한장 리턴하는 기능 테스트")
    void getInitCardTest() {
        // given
        Human human = Player.from("test");
        Card card = Card.of(Denomination.from("10"), Suit.SPADE);
        Card card2 = Card.of(Denomination.from("2"), Suit.SPADE);

        // when
        human.addCard(card);
        human.addCard(card2);

        // then
        assertThat(human.getInitCard())
                .isEqualTo(Card.of(Denomination.TEN, Suit.SPADE));
    }

    @Test
    @DisplayName("버스트 여부 확인 기능 false 테스트")
    public void isBustFalseTest() {
        // given
        Human human = Player.from("test");
        Card card = Card.of(Denomination.from("10"), Suit.SPADE);
        Card card2 = Card.of(Denomination.from("10"), Suit.SPADE);

        // when
        human.addCard(card);
        human.addCard(card2);

        // then
        assertThat(human.isBust())
                .isFalse();
    }

    @Test
    @DisplayName("득점한 포인트 리턴 기능 테스트")
    void getPointTest() {
        // given
        Human human = Player.from("test");
        Card card = Card.of(Denomination.from("5"), Suit.SPADE);
        Card card2 = Card.of(Denomination.from("A"), Suit.SPADE);

        // when
        human.addCard(card);
        human.addCard(card2);

        // then
        assertThat(human.getPoint())
                .isEqualTo(16);
    }

    @Test
    @DisplayName("이름 리턴 기능 테스트")
    void getName() {
        Human human = Player.from("test");
        assertThat(human.getName())
                .isEqualTo("test");
    }

    @Test
    @DisplayName("보유카드 리턴 기능 테스트")
    void getCards() {
        // given
        Cards cards = new Cards();
        Human human = Player.from("test");
        Card card = Card.of(Denomination.from("5"), Suit.SPADE);
        Card card2 = Card.of(Denomination.from("A"), Suit.SPADE);

        // when
        human.addCard(card);
        human.addCard(card2);

        cards.add(card);
        cards.add(card2);

        // then
        assertThat(human.getCards())
                .isEqualTo(cards);
    }
}
