package study.oopstudy.racinggame;

import study.oopstudy.racinggame.broadcast.BroadCaster;

public class Game {

  private BroadCaster broadCaster = new BroadCaster();

  public void start() {
    broadCaster.broadCast();
  }
}
