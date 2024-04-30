package study.oopstudy.racinggame.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
  private final List<Player> players;
  private final Random random;

  public Players(String playerInput) {
    random = new RandomGenerator();
    this.players = Arrays.stream(playerInput.split(","))
            .map(name -> new Player(name, random))
            .toList();
  }

  public List<Player> getPlayers() {
    return players;
  }

  public Players(List<Player> players) {
    random = new RandomGenerator();
    this.players = players;
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
