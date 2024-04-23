package study.oopstudy.racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerTest {
  private static final String NAME_NOT_MATCH = "이름 입력이 잘못되었습니다.";

  @Test
  @DisplayName("플레이어 정상 생성 확인")
  void 플레이어_정상_생성() {
//    given
    Player player = new Player("Test");

//    when
//    then
    assertEquals(player.getName(), "Test");
    assertEquals(player.getMove(), 0);
  }

  @ParameterizedTest
  @ValueSource(strings = {"", "MaxOutLength"})
  @DisplayName("플레이어 생성 에러에 대한 여러 테스트")
  void 플레이어_생성_공백에러() {
    //    given
    //    when
    //    then
    assertThrows(IllegalArgumentException.class, () -> new Player(""))
            .getMessage().equals(NAME_NOT_MATCH);
  }

  @Test
  @DisplayName("플레이어_move_변화_확인")
  void 플레이어_move_변화_확인() {
    //    given
    Player player = new Player("test");

    //    when
    while (player.getMove() == 0) {
      player.move();
    }

    //    then
    assertEquals(player.getMove(), 1);
  }
}
