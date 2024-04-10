package study.oopstudy;

import study.oopstudy.racinggame.Game;

import java.util.Scanner;

public class OopStudyApplication {
		private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Game game = new Game();

		game.start();
	}
}
