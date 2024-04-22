package study.oopstudy.racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayersTest {

  @Test
  @DisplayName("플레이어_생성_분할_확인")
  void 플레이어_생성_분할_확인() {
    //    given
    String PlayerNames = "test1,test2,test3";

    //    when
    Players players = new Players(PlayerNames);

    //    then
    assertEquals(players.getPlayers().size(), 3);
  }

  @Test
  @DisplayName("우승자_선정")
  void 우승자_선정() {
    //    given
    String playerNames = "test1,test2,test3";

    //    when
    Players players = new Players(playerNames);
    String winners = players.getWinners();

    //    then
    assertEquals(winners.length(), 17);
    assertEquals(winners, playerNames);
  }
}
