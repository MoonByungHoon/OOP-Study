package study.oopstudy.game.gi;

import study.oopstudy.player.Player;

import java.util.List;

public interface GameSetting {
  List<Player> setPlayers(String[] nameSplit);
}
