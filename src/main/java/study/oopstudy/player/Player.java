package study.oopstudy.player;

public class Player extends Move{
  private String name;

  public Player(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
