package study.oopstudy.racinggame.gi;

import study.oopstudy.player.Player;

import java.util.List;

public interface GameBroadCast {
  void printWinnerPlayer(List<Player> players);

  void printGameBroadCast(Player player);
}
