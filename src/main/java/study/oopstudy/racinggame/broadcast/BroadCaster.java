package study.oopstudy.racinggame.broadcast;

import study.oopstudy.racinggame.model.Player;

import java.util.List;

public class BroadCaster {

  private final Player player = new Player();

  public void broadCast(List<Player> players, final int round) {

    for (int i = 0; i < round; i++) {
      showInformation(players);
    }

    winnerAward(players);
  }

  private void showInformation(List<Player> players) {
    players.forEach(player -> player.move());

    System.out.println("라운드 진행 결과");

    players.forEach(player -> player.showData());
  }

  private void winnerAward(List<Player> players) {

    int maxMove = player.findMaxMove(players);

    player.showWinner(players, maxMove);


//    int findMaxMove = 0;
//
//    for (Player player : players) {
//      findMaxMove = player.compareMove(findMaxMove);
//    }
//
//    int maxMove = findMaxMove;
//
//
//    List<Player> listPlayer = players.stream()
//            .filter(player -> player.equalsMove(maxMove))
//            .toList();
//
//
//    for (Player player : listPlayer) {
//      player.showName();
//
//      if (listPlayer.indexOf(player) < listPlayer.size() - 1) {
//        System.out.printf(", ");
//      }
//    }
//    List<String> winners = players.stream()
//            .filter(player -> player.equals(maxMove))
//            .map(Player::toPassName)
//            .toList();
//
//    System.out.println("우승자 발표");
//
//    String result = winners.stream()
//            .collect(Collectors.joining(", "));
//
//    System.out.println(result);
  }
}
