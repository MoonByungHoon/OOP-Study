package study.oopstudy.racinggame.model;

public class Player{
  private String name;
  private int move;

  public Player(String name) {
    this.name = name;
    this.move = 0;
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
