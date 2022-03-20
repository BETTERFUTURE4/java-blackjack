package blackjack.domain.state.finished;

import static blackjack.domain.Fixtures.TEN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import blackjack.domain.cards.Cards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FinishedTest {
    Finished finished = new Finished(new Cards()) {
        @Override
        public double computedRate(Finished state) {
            return 1.0;
        }

        @Override
        public double earningRate() {
            return 1.0;
        }
    };

    @Test
    @DisplayName("stay 테스트")
    void stay() {
        assertThat(finished.stay())
                .isEqualTo(finished);

    }

    @Test
    @DisplayName("draw 예외출력 테스트")
    void draw() {
        assertThatThrownBy(() -> finished.draw(TEN))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("더 이상 카드를 받을 수 없습니다.");
    }

    @Test
    @DisplayName("isFinished true 반환 테스트")
    void isFinished() {
        assertThat(finished.isFinished())
                .isTrue();
    }

    @Test
    @DisplayName("이득 출력 테스트")
    void profit() {
        assertThat(finished.profit(10000, new Stay(new Cards())))
                .isEqualTo(10000);
    }

    @Test
    @DisplayName("배율 검증 테스트")
    void earningRate() {
        assertThat(finished.earningRate())
                .isEqualTo(1.0);
    }
}
