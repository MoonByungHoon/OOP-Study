package study.oopstudy.racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayersTest {

  @Test
  @DisplayName("players name split test")
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
  @DisplayName("players winners test")
  void 우승자_선정() {
    //    given
    String playerNames = "test1,test2,test3";
    Players firstPlayers = new Players(playerNames);

    //    when
    String firstPlayersWinners = firstPlayers.getWinners();

    List<Player> secondPlayers = Arrays.stream(playerNames.split(","))
            .map(Player::new)
            .toList();

    int max = secondPlayers.stream()
            .mapToInt(Player::getMove)
            .max()
            .orElse(0);

    String secondPlayersWinners = secondPlayers.stream()
            .filter(player -> player.is(max))
            .map(Player::getName)
            .collect(Collectors.joining(","));

    //    then
    assertEquals(firstPlayersWinners.length(), 17);
    assertEquals(firstPlayersWinners, playerNames);
    assertEquals(firstPlayersWinners, secondPlayersWinners);
  }
}
