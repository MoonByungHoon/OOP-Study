package study.oopstudy.racinggame.model;

class Player {
  private static final int MAX_NANE_LENGTH = 5;
  private static final int MOVE_BOUNDARY = 3;
  private static final String NAME_NOT_MATCH = "이름 입력이 잘못되었습니다.";

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
      throw new IllegalArgumentException(NAME_NOT_MATCH);
    }

    // 5자가 넘는지 검증
    if (name.length() > MAX_NANE_LENGTH) {
      throw new IllegalArgumentException(NAME_NOT_MATCH);
    }
  }

  public void move() {
    if (RandomNumberGenerator.generate() > MOVE_BOUNDARY) {
      this.move++;
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

  public boolean is(int move) {
    return this.move == move;
  }

  public String getName() {
    return this.name;
  }

  public int getMove() {
    return this.move;
  }
}
