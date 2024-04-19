package study.oopstudy.racinggame.broadcast;

import study.oopstudy.racinggame.model.Player;

import java.util.List;

public class BroadCaster {
  public void broadCast(List<Player> players, final int round) {

    for (int i = 0; i < round; i++) {
      showInformation(players);
    }

    Player.showWinner(players);
  }

  private void showInformation(List<Player> players) {
    players.forEach(player -> player.move());

    System.out.println("라운드 진행 결과");

    players.forEach(player -> player.showData());
  }
}
