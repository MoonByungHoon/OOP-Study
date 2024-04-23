package study.oopstudy.racinggame.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {
  private final List<Player> players;

  public Players(String playerInput) {
    this.players = Arrays.stream(playerInput.split(","))
            .map(Player::new)
            .toList();
  }

  public Players(List<Player> players) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Players players1 = (Players) o;
    return Objects.equals(players, players1.players);
  }

  @Override
  public int hashCode() {
    return Objects.hash(players);
  }
}
