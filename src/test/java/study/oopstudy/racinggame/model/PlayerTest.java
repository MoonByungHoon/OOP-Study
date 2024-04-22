package study.oopstudy.racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerTest {

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

  @Test
  @DisplayName("플레이어_생성_공백에러")
  void 플레이어_생성_공백에러() {
    //    given
    //    when
    //    then
    assertThrows(IllegalArgumentException.class, () -> new Player(""))
            .equals("이름을 입력하지 않았습니다.");
  }

  @Test
  @DisplayName("플레이어_생성_이름_길이_초과에러")
  void 플레이어_생성_이름_길이_초과에러() {
    //    given
    //    when
    //    then
    assertThrows(IllegalArgumentException.class, () -> new Player("다섯글자를넘김"))
            .equals("이름의 길이가 5보다 큽니다.");
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
