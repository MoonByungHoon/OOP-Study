package study.oopstudy.racinggame.model;

import java.util.Arrays;

public class Player{
  private static final int MAX_NANE_LENGTH = 5;
  private static final String INVALID_NAME_LENGTH = "이름의 길이가 5보다 큽니다.";
  private static final String NOT_INPUT_NAME = "이름을 입력하지 않았습니다.";

  private String name;
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

    // 5자가 안넘는지 검증
    if (name.length() > MAX_NANE_LENGTH) {
      throw new IllegalArgumentException(INVALID_NAME_LENGTH);
    }
  }

  public boolean isMoveEquals(int move) {
    return this.move == move;
  }

  public String getName() {
    return name;
  }

  public int getMove() {
    return move;
  }

  public void addOneMove() {
    this.move++;
  }
}