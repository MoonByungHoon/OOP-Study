package study.oopstudy.racinggame.broadcast;

import study.oopstudy.racinggame.model.Player;
import study.oopstudy.racinggame.validate.Validate;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BroadCaster {

  final Progress progress = new Progress();
  final Validate validate = new Validate();
  Scanner sc = new Scanner(System.in);

  public void broadCast() {
    System.out.println("참가할 플레이어의 이름을 일력해주세요.");
    System.out.println("다수가 참가할 경우 ,로 구분해주세요.");
    System.out.printf("입력 : ");

    String inputPlayerName = sc.next();

    List<Player> players = validate.validatePlayer(inputPlayerName);

    System.out.println("진행할 경주 회차를 입력해주세요.");
    System.out.println("최대 경주 횟수는 10회 입니다.");
    System.out.printf("입력 : ");

    int round = sc.nextInt();

    boolean vali = validate.validateRound(round);

    if (vali == false) {
      throw new IllegalArgumentException("잘못 입력하였습니다. 프로그램을 종료합니다.");
    }

    IntStream.range(0, round)
            .mapToObj(i -> players)
            .forEach(progress::gameProgress);

    progress.gameWinner(players);
  }
}
