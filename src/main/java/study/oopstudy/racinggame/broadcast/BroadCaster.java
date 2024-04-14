package study.oopstudy.racinggame.broadcast;

import study.oopstudy.racinggame.Create;
import study.oopstudy.racinggame.model.Player;

import java.util.List;
import java.util.Scanner;

public class BroadCaster {
  private static final int MIN_ROUND = 1;
  private static final int MAX_ROUND = 10;
  private static final Scanner sc = new Scanner(System.in);
  private static final String INPUT_ROUND_MESSAGE = "진행할 경주 회차를 입력해주세요."
          + System.lineSeparator()
          + "최대 경주 횟수는 10회 입니다."
          + System.lineSeparator()
          + "입력 : ";
  private static final String ILLEGALARGUMENT_ROUND_MESSAGE = "라운드 입력 범위를 벗어났습니다.";
  private static final String CREATE_PLAYER_MESSAGE = "참가자 이름을 입력해주세요."
          + System.lineSeparator()
          + "다수가 참가할 경우 ,로 구분해주세요."
          + System.lineSeparator()
          + "입력 : ";

  public void broadCast() {
    System.out.printf(CREATE_PLAYER_MESSAGE);
    String playerNames = sc.next();
    Create create = new Create(playerNames);
    List<Player> players = create.getPlayers();


    System.out.printf(INPUT_ROUND_MESSAGE);
    int round = sc.nextInt();

    validateRound(round);

    for (int i = 0; i < round; i++) {
      System.out.println("라운드 진행 결과");

      Progress progress = new Progress(players);

      roundBroadCast(players);

      if (round == (i + 1)) winnersBroadCast(progress.gameWinner(players));
    }

  }

  private void roundBroadCast(List<Player> players) {

    for (Player player : players) {
      System.out.printf(player.getName() + " : ");
      playerMovePrint(player.getMove());
      System.out.println();
    }
  }

  private void winnersBroadCast(List<String> winners) {
    int indexCount = 0;

    System.out.println("우승자 발표");

    for (String name : winners) {
      indexCount++;

      System.out.printf(name);

      if (indexCount == winners.size()) break;

      System.out.printf(", ");
    }
  }

  private void playerMovePrint(int move) {
    for (int i = 0; i < move; i++) {
      System.out.printf("-");
    }

    System.out.println();
  }

  public void validateRound(int round) {
    // 불리언 값일 때는 메서드 prefix에 is, has, contains, can
    // getName -> name. getXXX -> XXX
    // isXXX -> XXX에 대한 boolean
    // validateXXX -> xxx에 대한 검증(예외를 던진다)
    if (round < MIN_ROUND || round > MAX_ROUND) {
      throw new IllegalArgumentException(ILLEGALARGUMENT_ROUND_MESSAGE);
    }
  }
}