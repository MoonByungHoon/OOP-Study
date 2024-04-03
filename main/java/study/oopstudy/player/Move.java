package study.oopstudy.player;

import java.util.Random;

public class Move {
  private int movingPoint;

  Move() {
    this.movingPoint = 0;
  }

  public int getTotalMovingPoint() {
    return movingPoint;
  }

  public void updateMovingPoint() {

    Random random = new Random();

    if (random.nextInt(10) > 3) {
      this.movingPoint++;
    }
  }
}
