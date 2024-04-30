package study.oopstudy.racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PlayerTest {
  private static final String NAME_NOT_MATCH = "이름 입력이 잘못되었습니다.";
  private final Random random = new RandomGenerator();

  @Test
  @DisplayName("player create test")
  void 플레이어_정상_생성() {
//    given
    Player player = new Player("Test", random);

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
  void 플레이어_생성_에러(String name) {
    //    given
    //    when
    //    then
    assertThrows(IllegalArgumentException.class, () -> new Player(name, random))
            .getMessage().equals(NAME_NOT_MATCH);
  }

  @Test
  @DisplayName("player move change test")
  void 플레이어_move_변화_확인() {
    //    given
    Random mockRandom = mock(Random.class);
    Player player = new Player("test", mockRandom);
    int beforeMove = player.getMove();

    //    when
    when(mockRandom.generate()).thenReturn(4);
    player.move();
    int afterMove = player.getMove();

    //    then
    assertTrue(afterMove == beforeMove + 1);
  }
}
