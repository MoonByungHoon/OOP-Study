package study.oopstudy;


import java.util.Scanner;

public class OopStudyApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("게임을 시작하시겠습니까?");
		System.out.println("예 : 1 / 아니오 : 2");
		System.out.printf("입력 : ");
		int choice = sc.nextInt();

		if (choice < 1 || choice > 2) {
			throw new IllegalArgumentException("잘못 입력하였습니다. 게임을 종료합니다.");
		}

		if(choice)

			System.out.println("게임을 종료합니다.");
	}
}
