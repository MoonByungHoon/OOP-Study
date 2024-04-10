package study.oopstudy.racinggame.broadcast;

import study.oopstudy.racinggame.model.Player;

import java.util.ArrayList;
import java.util.List;

public class Progress {
  private final Rules rules = new Rules();

  private int move;

  public void gameProgress(List<Player> players) {
    players.forEach(rules::gameRule);
  }

  public List<String> gameWinner(List<Player> players) {
    List<String> winners = new ArrayList<>();

    move = 0;

    for (Player player : players) {
      if (player.isMoveEquals(move)) {
        winners.add(player.getName());
      }

      if (move < player.getMove()) {
        move = player.getMove();
        winners.clear();
        winners.add(player.getName());
      }
    }

    return winners;
  }
}
