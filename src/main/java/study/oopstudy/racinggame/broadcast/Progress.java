package study.oopstudy.racinggame.broadcast;

import study.oopstudy.racinggame.model.Player;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Progress {
  private int move;

  public Progress(List<Player> players) {
    players.forEach(player -> player.move());
  }

  public List<String> gameWinner(List<Player> players) {

    /**
     * Collectors.groupingBy에 대한 동작 방식
     * Player::getMove의 값을 기준으로 collect를 그룹화.
     * TreeMap::new를 통하여 그룹화 된 결과를 저장할 맵을 새로 생성한다.
     * Collectors.toList() 수집하는 방법을 정한 것이다. 각 그룹의 요소들을 리스트로 수집 및 반환.
     */


    return players.stream()
            .collect(Collectors
                    .groupingBy(Player::getMove, TreeMap::new, Collectors.toList()))
            .lastEntry() //위의 방식으로 정리된 리스트에서 가장 큰 move값을 가진 엔트리를 가져옴.
            .getValue() //해당 move값과 같은 값을 가진 플레이어 목록을 가져옴
            .stream() //해당 목록을 stream으로 변환 후 돌림.
            .map(Player::getName) //각 플레이어의 이름으로 새로 매핑함.
            .toList(); //리스트로 수집 및 반호나.

//    추가 학습 필요.
//    List<String> winners = new ArrayList<>();
//
//    move = 0;
//
//    for (Player player : players) {
//      if (player.isMoveEquals(move)) {
//        winners.add(player.getName());
//      }
//
//      if (move < player.getMove()) {
//        move = player.getMove();
//        winners.clear();
//        winners.add(player.getName());
//      }
//    }
//
//    return winners;
  }
}
