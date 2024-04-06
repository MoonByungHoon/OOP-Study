package study.oopstudy.racinggame.gi;

import study.oopstudy.player.Player;

import java.util.List;

public interface GameSetting {
  List<Player> setPlayers(String[] nameSplit);
}
