package study.oopstudy.racinggame.broadcast;

import study.oopstudy.racinggame.model.Player;

import java.util.Random;

public class Rules {

  public void gameRule(Player player) {
    Random random = new Random();

    if (random.nextInt(10) > 3) {
      player.addOneMove(); //랜덤 범위 적용될 경우 1칸 이동.
    }
  }
}
