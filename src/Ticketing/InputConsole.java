package Ticketing;

import java.util.Scanner;

import com.sun.tools.javac.Main;
/*
 * InputConsole Class : 사용자의 선택을 받아서 Main으로 전달 하는 클래스
 */
public class InputConsole {

	static UserValues users = new UserValues();
	static Scanner scanner = new Scanner(System.in);
	static Main main = new Main();

	//1.사용자로부터 이용권 종류를 선택받음.
	public int getType () throws Exception {
		while(true) {
			System.out.println("상품을 선택해주세요");
			System.out.println("1. 주간권");
			System.out.println("2. 야간권");
			System.out.println("3. 종료");
			int type = scanner.nextInt();
			if (type == 1 || type ==2 || type == 3) {
				return type;
			}
		}

	}
	//2.사용자로부터 주민등록번호를 입력받음.
	public String getAge() {
		while(true) {
			System.out.println("주민등록번호를 입력해주세요 예)9000101123456");
			String identification = scanner.next();
			if (identification.length()>7 && identification.length() <14) {
				if (identification.substring(6).contains("1")|| 
						identification.substring(6).contains("2")||
						identification.substring(6).contains("3")||
						identification.substring(6).contains("4")) {
					return identification;

				}
			}
		}
	}
	//3.사용자로부터 구매 개수를 입력받음.
	public int  getQuant() {
		while(true) {
			System.out.println("수량을 입력해주세요 (최대 구매수량 99개, 단체 문의 000-0000-0000)");
			int quantity = scanner.nextInt();	
			if (quantity <100) {
				return quantity;
			}
		}
	}
	//4.사용자로부터 우대 할인 조건을 입력 받음
	public int getPrioirity() {
		while(true) {
		System.out.println("우대사항을 선택해주세요");
		System.out.println("※연령에 따른 우대는 자동 적용");
		System.out.println("0.해당 사항 없음");
		System.out.println("1.장애인 우대");
		System.out.println("2.국가 유공자 우대");
		System.out.println("3.다자녀 가정 우대");
		System.out.println("4.임신부우대");
		int priority = scanner.nextInt();
		if (priority == 0||priority == 1 || priority == 2 || priority == 3 || priority == 4)
		return priority;
		}
	}
}
