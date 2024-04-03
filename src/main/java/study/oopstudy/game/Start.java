package study.oopstudy.game;

import java.util.Scanner;

public class Start {
  Scanner sc = new Scanner(System.in);

  void choiceGame() {
    System.out.println("진행할 게임을 선택해주세요.");
    System.out.println("1. 자동차 경주 / 0. 게임 종료");
    System.out.printf("입력 : ");

    int choice = sc.nextInt();

    switch (choice) {
      case 0 :
        exitGame();
      case 1 :
        Game game = new Game();
        game.start();
        break;
      default:
        throw new IllegalArgumentException("잘못 입력하였습니다. 게임을 종료합니다.");
    }
  }

  private void exitGame() {
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
