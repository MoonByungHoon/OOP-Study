package study.oopstudy.racinggame.model;

final class RandomGenerator implements Random {
  private static java.util.Random random = new java.util.Random();

  private static final int MAX_BOUND = 10;

  public int generate() {
    return random.nextInt(MAX_BOUND);
  }
}
