package study.oopstudy.game;

import org.junit.jupiter.api.Test;
import study.oopstudy.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

  Scanner sc = new Scanner(System.in);

  @Test
  void start() {
//    String inputName = "awhefuawem, weaf, aewf"; // 이름 길이 초과 테스트 통과
//    String inputName = ""; // 공백 테스트 통과
      String inputName = "aaa, bbb, ccc, ddd";

    if (inputName == "") {
      assertThrows(IllegalArgumentException.class, () -> {
        System.out.println("공백 정상 오류 발생");
      });
    }

    String[] nameSplit = inputName.split(",");

    if (Arrays.stream(nameSplit).anyMatch(name -> name.length() > 5)) {
      assertThrows(IllegalArgumentException.class, () -> {
        System.out.println("이름 길이 초과 정상 오류 발생");
      });
    }

//    int round = 20; // 라운드 초과 테스트 통과
//    int round = 0; //라운드 미만 테스트 통과
    int round = 5;

    if (round < 1 || round > 11) {
      assertThrows(IllegalArgumentException.class, () -> {
        System.out.println("라운드 정상 오류 발생");
      });
    }

    List<Player> players = setPlayers(nameSplit);

    System.out.println("게임 진행 결과");

    for (int i = 0; i < round; i++) {
      for (Player player : players) {
        player.updateMovingPoint();
        printGameBroadCast(player);
      }
    }

    printWinnerPlayer(players);
  }

  private void printWinnerPlayer(List<Player> players) {
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

    System.out.println("최종 우승자 : ");

    for (String name : winners) {

      if (count == winners.size() - 1) {
        System.out.printf(name);

        break;
      }

      System.out.printf(name + ", ");
    }
  }

  private void printGameBroadCast(Player player) {
    System.out.printf(player.getName() + " : ");
    IntStream.range(0, player.getTotalMovingPoint())
            .forEach(p -> {
              System.out.printf("-");
            });
    System.out.println();
  }

  private List<Player> setPlayers(String[] nameSplit) {
    List<Player> players = new ArrayList<>();

    for (String name : nameSplit) {
      players.add(new Player(name));
    }

    return players;
  }
}