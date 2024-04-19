package study.oopstudy.racinggame;

import study.oopstudy.racinggame.broadcast.BroadCaster;
import study.oopstudy.racinggame.model.Players;

import java.util.Scanner;

public class Game {
  private static final Scanner sc = new Scanner(System.in);

  private static final int MIN_ROUND = 1;
  private static final int MAX_ROUND = 10;

  private static final String CREATE_PLAYER_REQUEST = """
          참가자 이름을 입력해주세요.
          다수가 참가할 경우 ,로 구분해주세요.
          입력 : 
          """;
  private static final String INPUT_ROUND_REQUEST = """
          진행할 경주 회차를 입력해주세요.
          최대 경주 횟수는 10회 입니다.
          입력 : 
          """;
  private static final String ROUND_OUT_RANGE = "라운드 입력 범위를 벗어났습니다.";

  public void start() {
    var players = enrollPlayers();
    BroadCaster broadCaster = new BroadCaster(players);

    int round = setRound();
    broadCaster.start(round);
  }

  private Players enrollPlayers() {
    System.out.printf(CREATE_PLAYER_REQUEST);
    return new Players(sc.next());
  }

  private int setRound() {
    System.out.printf(INPUT_ROUND_REQUEST);
    int round = sc.nextInt();

    validateRound(round);

    return round;
  }

  private void validateRound(int round) {
    if (round < MIN_ROUND || round > MAX_ROUND) {
      throw new IllegalArgumentException(ROUND_OUT_RANGE);
    }
  }
}
