package study.oopstudy.racinggame.model;

import java.util.Random;

public class Player {
  private static final int MAX_NANE_LENGTH = 5;
  private static final String INVALID_NAME_LENGTH = "이름의 길이가 5보다 큽니다.";
  private static final String NOT_INPUT_NAME = "이름을 입력하지 않았습니다.";
  private static final int MIN_NUM = 3;
  private static final int MAX_NUM = 10;
  private static final Random random = new Random();

  private final String name;
  private int move;

  public Player(String name) {
    validateName(name);
    this.name = name;
    this.move = 0;
  }

  private void validateName(String name) {
    // 빈값이 아닌지
    if (name.isEmpty()) {
      throw new IllegalArgumentException(NOT_INPUT_NAME);
    }

    // 5자가 넘는지 검증
    if (name.length() > MAX_NANE_LENGTH) {
      throw new IllegalArgumentException(INVALID_NAME_LENGTH);
    }
  }

  public void move() {
    if (random.nextInt(MAX_NUM) > MIN_NUM) {
      move++;
    }
  }

  public void showData() {
    System.out.printf(this.name);
    System.out.printf(" : ");

    for (int i = 0; i < this.move; i++) {
      System.out.printf("-");
    }

    System.out.println();
  }

  public void showName() {
    System.out.printf(this.name);
  }

  public int compareMove(int move) {
    if (this.move > move) {
      return this.move;
    }

    return move;
  }

  public boolean equalsMove(int move) {
    return this.move == move;
  }
}
