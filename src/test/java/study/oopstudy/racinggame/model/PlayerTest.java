package study.oopstudy.racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
  private static final String NAME_NOT_MATCH = "이름 입력이 잘못되었습니다.";

  @Test
  @DisplayName("player create test")
  void 플레이어_정상_생성() {
//    given
    Player player = new Player("Test");

//    when
//    then
    assertAll(
            () -> assertEquals(player.getName(), "Test"),
            () -> assertEquals(player.getMove(), 0)
    );

  }

  @ParameterizedTest
  @ValueSource(strings = {"", "MaxOutLength"})
  @DisplayName("player create errors test")
  void 플레이어_생성_에러() {
    //    given
    //    when
    //    then
    assertThrows(IllegalArgumentException.class, () -> new Player(""))
            .getMessage().equals(NAME_NOT_MATCH);
  }

  @Test
  @DisplayName("player move change test")
  void 플레이어_move_변화_확인() {
    //    given
    Player player = new Player("test");
    int beforeMove = player.getMove();

    //    when
    while (player.getMove() == beforeMove) {
      player.move();
    }

    int afterMove = player.getMove();

    //    then
    assertTrue(afterMove == beforeMove + 1);
  }
}
