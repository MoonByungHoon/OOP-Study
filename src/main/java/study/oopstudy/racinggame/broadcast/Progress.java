package study.oopstudy.racinggame.broadcast;

import study.oopstudy.racinggame.model.Player;

import java.util.ArrayList;
import java.util.List;

public class Progress {
  final Rules rules = new Rules();

  public void gameProgress(List<Player> players) {

    System.out.println("게임 진행 결과");

    players.forEach(player -> {
      rules.gameRule(player);
      deliverGameProgress(player);
    });
  }

  public void deliverGameProgress(Player player) {

    int move = player.getMove();

    System.out.printf(player.getName() + " : ");
    for (int i = 0; i <= move; i++) {
      if (i == move) {
        System.out.println();

        break;
      }

      System.out.printf("-");
    }
  }

  public void gameWinner(List<Player> players) {
    List<String> winnersName = new ArrayList<>();
    int move = 0;

    System.out.println("게임 우승자");

    for (Player player : players) {
      if (move == player.getMove()) {
        winnersName.add(player.getName());
      }

      if (move < player.getMove()) {
        move = player.getMove();
        winnersName.clear();
        winnersName.add(player.getName());
      }
    }

    for (String name : winnersName) {
      System.out.printf(name);

      if (players.listIterator().hasNext()) {
        System.out.printf(", ");
      }
    }
  }
}
