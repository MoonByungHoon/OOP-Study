package study.oopstudy.racinggame;

import study.oopstudy.racinggame.model.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Create {
  private List<Player> players;

  public Create(String playerNames) {
    players = new ArrayList<>();

    Arrays.stream(playerNames.split(","))
            .map(name -> new Player(name))
            .forEach(player -> this.players.add(player));
  }

  public List<Player> getPlayers() {
    return players;
  }
}
