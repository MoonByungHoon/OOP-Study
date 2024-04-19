package study.oopstudy.racinggame.broadcast;

import study.oopstudy.racinggame.model.Players;

public class BroadCaster {
  private final Players players;

  public BroadCaster(Players players) {
    this.players = players;
  }

  public void start(final int round) {
    for (int i = 0; i < round; i++) {
      run();
    }

    System.out.println("우승자 발표");
    System.out.println(players.getWinners());
  }

  private void run() {
    players.move();
    System.out.println("라운드 진행 결과");
    players.location();
  }
}
