package study.oopstudy.racinggame;

import study.oopstudy.racinggame.broadcast.BroadCaster;

public class Game {

  BroadCaster broadCaster = new BroadCaster();

  public void gameStart() {
    broadCaster.broadCast();
  }
}
