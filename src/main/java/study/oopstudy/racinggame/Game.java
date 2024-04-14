package study.oopstudy.racinggame;

import study.oopstudy.racinggame.broadcast.BroadCaster;
import study.oopstudy.racinggame.model.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
  private static final Scanner sc = new Scanner(System.in);
  private static final int MIN_ROUND = 1;
  private static final int MAX_ROUND = 10;
  private static final String CREATE_PLAYER_REQUEST =
          """
                  참가자 이름을 입력해주세요.
                  다수가 참가할 경우 ,로 구분해주세요.
                  입력 : """;
  private static final String INPUT_REQUEST_ROUND =
          """
                  진행할 경주 회차를 입력해주세요.
                  최대 경주 횟수는 10회 입니다.
                  입력 : """;
  private static final String ROUND_RANGE_OVER = "라운드 입력 범위를 벗어났습니다.";


  private BroadCaster broadCaster = new BroadCaster();

  public void start() {
    List<Player> players = playerSetting();
    int round = roundSetting();

    broadCaster.broadCast(players, round);
  }

  private int roundSetting() {
    System.out.printf(INPUT_REQUEST_ROUND);
    int round = sc.nextInt();

    validateRound(round);

    return round;
  }

  public void validateRound(int round) {
    // 불리언 값일 때는 메서드 prefix에 is, has, contains, can
    // getName -> name. getXXX -> XXX
    // isXXX -> XXX에 대한 boolean
    // validateXXX -> xxx에 대한 검증(예외를 던진다)
    if (round < MIN_ROUND || round > MAX_ROUND) {
      throw new IllegalArgumentException(ROUND_RANGE_OVER);
    }
  }

  public List<Player> playerSetting() {
    System.out.printf(CREATE_PLAYER_REQUEST);
    String playerNames = sc.next();

    List<Player> players = new ArrayList<>();

    Arrays.stream(playerNames.split(","))
            .map(name -> new Player(name))
            .forEach(player -> players.add(player));

    return players;
  }
}
