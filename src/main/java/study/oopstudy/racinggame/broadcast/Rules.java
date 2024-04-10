package study.oopstudy.racinggame.broadcast;

import study.oopstudy.racinggame.model.Player;

import java.util.Random;

public class Rules {
  private static final int MIN_NUM = 3;
  private static final int MAX_NUM = 10;
  private static final Random random = new Random();

  public void gameRule(Player player) {
    if (random.nextInt(MAX_NUM) > MIN_NUM) {
      player.addOneMove(); //랜덤 범위 적용될 경우 1칸 이동.
    }
  }
}
