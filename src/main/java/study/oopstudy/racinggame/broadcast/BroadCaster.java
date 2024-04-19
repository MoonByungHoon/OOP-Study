package study.oopstudy.racinggame.broadcast;

import study.oopstudy.racinggame.model.Player;

import java.util.List;

public class BroadCaster {
  public void broadCast(List<Player> players, final int round) {

    for (int i = 0; i < round; i++) {
      showInformation(players);
    }

    winnerAward(players);
  }

  private void showInformation(List<Player> players) {
    players.forEach(Player::);

    System.out.println("라운드 진행 결과");

//    이전 메소드명인 printf가 아닌 show라는 명칭과
    players.forEach(player -> player.showData());
  }

  private void winnerAward(List<Player> players) {

//    BroadCast, winnverAward 둘 다
//    굳이 필요 없는 Player의 상태가 요청에 대한 행동과 책임 구조를
//    알 필요가 없다 생각함.
//    본인들이 원하는 정보만 알려주면 된다 생각하여 static으로 선언 후 요청함.
    int maxMove = Player.findMaxMove(players);

    Player.showWinner(players, maxMove);

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
