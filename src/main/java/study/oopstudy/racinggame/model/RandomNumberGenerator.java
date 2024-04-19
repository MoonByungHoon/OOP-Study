package study.oopstudy.racinggame.model;

import java.util.Random;

final class RandomNumberGenerator {
  private static final Random random = new Random();

  private static final int MAX_BOUND = 10;

  public static int generate() {
    return random.nextInt(MAX_BOUND);
  }
}
