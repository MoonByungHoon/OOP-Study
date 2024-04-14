package study.oopstudy.racinggame.broadcast;

import study.oopstudy.racinggame.model.Player;

import java.util.List;
import java.util.stream.Collectors;

public class BroadCaster {
  public void broadCast(List<Player> players, final int round) {

    for (int i = 0; i < round; i++) {
      System.out.println("라운드 진행 결과");

      roundBroadCast(players);

      if (round == (i + 1)) winnerAward(players);
    }
  }

  private void roundBroadCast(List<Player> players) {
    players.forEach(player -> player.move());

    for (Player player : players) {
      System.out.printf(player.getName() + " : ");
      playerMovePrint(player.getMove());
      System.out.println();
    }
  }

  private void winnerAward(List<Player> players) {

    int maxMove = players.stream()
            .mapToInt(player -> player.getMove())
            .max()
            .orElse(0);

    List<String> winners = players.stream()
            .filter(player -> player.getMove() == maxMove)
            .map(Player::getName)
            .toList();

    System.out.println("우승자 발표");

    String result = winners.stream()
            .collect(Collectors.joining(", "));

    System.out.println(result);
  }

  private void playerMovePrint(int move) {
    for (int i = 0; i < move; i++) {
      System.out.printf("-");
    }

    System.out.println();
  }
}