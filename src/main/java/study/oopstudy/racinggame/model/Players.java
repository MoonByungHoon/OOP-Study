package study.oopstudy.racinggame.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
  private final List<Player> players;

  public Players(String playerInput) {
    this.players = Arrays.stream(playerInput.split(","))
            .map(Player::new)
            .toList();
  }

  public void move() {
    players.forEach(Player::move);
  }

  public void location() {
    players.forEach(Player::showData);
  }

  public String getWinners() {
    int max = players.stream()
            .mapToInt(Player::getMove)
            .max()
            .orElse(0);

    return players.stream()
            .filter(player -> player.is(max))
            .map(Player::getName)
            .collect(Collectors.joining(","));
  }
}
