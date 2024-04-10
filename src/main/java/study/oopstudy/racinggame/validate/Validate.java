package study.oopstudy.racinggame.validate;

import study.oopstudy.racinggame.model.Player;
import study.oopstudy.racinggame.Create;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Validate {
  Scanner sc = new Scanner(System.in);
  Create create = new Create();

  public List<Player> validatePlayer(String playerNames) {

//    입력 안했을 경우에 대한 검증
    if (playerNames == "") {
      throw new IllegalArgumentException("잘못 입력하였습니다. 게임을 종료합니다.");
    }

//    참가자 이름을 ,를 기준으로 자르기.
    String[] nameSplit = playerNames.split(",");

//    참가자 이름이 5글자를 넘기는지 확인.
    if (Arrays.stream(nameSplit).anyMatch(name -> name.length() > 5)) {
      throw new IllegalArgumentException("잘못 입력하였습니다. 게임을 종료합니다.");
    }

    return create.createPlayer(nameSplit);
  }

  public boolean validateRound(int round) {

    return round >= 1 && round <= 10;
  }
}
