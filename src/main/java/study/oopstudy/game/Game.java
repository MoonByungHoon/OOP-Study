package study.oopstudy.game;

import study.oopstudy.game.gi.GameBroadCast;
import study.oopstudy.game.gi.GameSetting;
import study.oopstudy.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Game implements GameBroadCast, GameSetting {
  Scanner sc = new Scanner(System.in);
  public void start() {
    System.out.println("게임에 참가할 자동차의 이름을 입력해주세요.");
    System.out.println("다수가 참가한다면 이름 사이에 , 를 추가해주세요.");
    System.out.println("각 자동차 이름의 최대 길이는 5글자 입니다.");
    System.out.printf("입력 : ");

    String inputName = sc.next();

    sc.reset();

    if (inputName == "") {
      throw new IllegalArgumentException("잘못 입력하였습니다. 게임을 종료합니다.");
    }

    String[] nameSplit = inputName.split(",");

    if (Arrays.stream(nameSplit).anyMatch(name -> name.length() > 5)) {
      throw new IllegalArgumentException("잘못 입력하였습니다. 게임을 종료합니다.");
    }

    System.out.println("진행할 경주 회차를 입력해주세요.");
    System.out.println("최대 경주 횟수는 10회 입니다.");
    System.out.printf("입력 : ");

    int round = sc.nextInt();

    if (round < 1 || round > 11) {
      throw new IllegalArgumentException("잘못 입력하였습니다. 게임을 종료합니다.");
    }

    List<Player> players = setPlayers(nameSplit);

    System.out.println("게임 진행 결과");

    for (int i = 0; i < round; i++) {
      for (Player player : players) {
        player.updateMovingPoint();
        printGameBroadCast(player);
      }
        System.out.println();
    }

    printWinnerPlayer(players);

  }

  @Override
  public void printWinnerPlayer(List<Player> players) {
    List<String> winners = new ArrayList<>();

    int score = 0;

    for (Player player : players) {
      if (player.getTotalMovingPoint() == score) {
        winners.add(player.getName());
      }

      if (player.getTotalMovingPoint() > score) {
        winners.clear();
        winners.add(player.getName());
        score = player.getTotalMovingPoint();
      }
    }

    int count = 0;

    System.out.printf("최종 우승자 : ");

    for (String name : winners) {

      if (count == winners.size() - 1) {
        System.out.printf(name);

        break;
      }

      System.out.printf(name + ", ");
    }

    System.out.println();
  }

  @Override
  public void printGameBroadCast(Player player) {

      System.out.printf(player.getName() + " : ");
      IntStream.range(0, player.getTotalMovingPoint())
              .forEach(p -> {
                System.out.printf("-");
              });
      System.out.println();
    }

  @Override
  public List<Player> setPlayers(String[] nameSplit) {
    List<Player> players = new ArrayList<>();

    for (String name : nameSplit) {
      players.add(new Player(name));
    }

    return players;
  }

  void exit() {
    System.out.println("정말로 게임을 종료하시겠습니까?");
    System.out.println("예 : 1 / 아니오 : 2");
    System.out.printf("입력 : ");

    int choice = sc.nextInt();

    if (choice == 1) {
      System.out.println("게임을 종료합니다.");
      System.exit(0);
    }
  }
}
