package study.oopstudy.racinggame;

import study.oopstudy.racinggame.model.Player;

import java.util.Arrays;
import java.util.List;

public class Create {

  public List<Player> createPlayer(String [] names) {
    return Arrays.stream(names)
            .map(Player::new)
            .toList();
  }
}
