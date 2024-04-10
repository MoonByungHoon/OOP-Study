package study.oopstudy.racinggame;

import study.oopstudy.racinggame.model.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Create {
  private static final Scanner sc = new Scanner(System.in);
  private static final String CREATE_PLAYER_MESSAGE = "참가자 이름을 입력해주세요."
          + System.lineSeparator()
          + "다수가 참가할 경우 ,로 구분해주세요."
          + System.lineSeparator()
          + "입력 : ";

  public List<Player> createPlayer() {
    System.out.printf(CREATE_PLAYER_MESSAGE);

    String playerNames = sc.next();

    String[] nameSplit = playerNames.split(",");

    return Arrays.stream(nameSplit)
            .map(Player::new)
            .collect(Collectors.toList());
  }
}
