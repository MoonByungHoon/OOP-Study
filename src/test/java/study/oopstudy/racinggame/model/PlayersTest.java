package study.oopstudy.racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayersTest {

  @Test
  @DisplayName("플레이어_생성_분할_확인")
  void 플레이어_생성_분할_확인() {
    //    given
    String playerNames = "test1,test2,test3";
    List<Player> playerList = Arrays.stream(playerNames.split(","))
            .map(Player::new)
            .toList();

    //    when
    Players players = new Players(playerNames);
    Players testPlayers = new Players(playerList);

    //    then

    assertEquals(players, testPlayers);
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
