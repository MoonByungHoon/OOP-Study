package study.oopstudy.racinggame.broadcast;

import study.oopstudy.racinggame.Create;
import study.oopstudy.racinggame.model.Player;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BroadCaster {
  private static final int MIN_ROUND = 1;
  private static final int MAX_ROUND = 10;
  private static final Scanner sc = new Scanner(System.in);
  private static final String INPUT_ROUND_MESSAGE = "진행할 경주 회차를 입력해주세요."
          + System.lineSeparator()
          + "최대 경주 횟수는 10회 입니다."
          + System.lineSeparator()
          + "입력 : ";
  private static final String ILLEGALARGUMENT_ROUND_MESSAGE = "잘못 입력하였습니다.";

  private final Progress progress = new Progress();
  private final Create create = new Create();

  public void broadCast() {

    List<Player> players = create.createPlayer();

    System.out.printf(INPUT_ROUND_MESSAGE);

    int round = sc.nextInt();

    validateRound(round);

    System.out.println("라운드별 진행 결과");

    for (int i = 0; i < round; i++) {
      progress.gameProgress(players);

      roundBroadCast(players);
    }

    winnersBroadCast(progress.gameWinner(players));
  }

  private void roundBroadCast(List<Player> players) {

    for (Player player : players) {
      System.out.printf(player.getName() + " : ");
      playerMovePrint(player.getMove());
      System.out.println();
    }
  }

  private void winnersBroadCast(List<String> winners) {
    int count = 0;

    for (String name : winners) {
      System.out.printf(name);

      if (count == winners.size() - 1) {
        break;
      }

      System.out.printf(", ");

      count++;
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