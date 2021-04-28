package TicketSystem;

import java.util.Scanner;
/*
 * InputConsole : 사용자의 선택을 받아서 Main으로 전달 하는 클래스
 */
public class InputConsole {
	
	static UserValues users = new UserValues();
	static Scanner scanner = new Scanner(System.in);
	public int getType () {
		System.out.println("상품을 선택해주세요");
		System.out.println("1. 주간권");
		System.out.println("2. 야간권");
		System.out.println("3. 뒤로가기");
		
		int type = scanner.nextInt();
		return type;
	}
	
	public String getAge() {
		System.out.println("주민등록번호를 입력해주세요");
		String identification = scanner.next();
		if (identification.length() < 7) {
			identification = "";
			getAge();
		}
		return identification;
	}
	
	public int  getQuant() {
		System.out.println("수량을 입력해주세요");
		int quantity = scanner.nextInt();		
		users.quantity = quantity;
		return quantity;
	}
	
	public int getPrioirity() {
		System.out.println("우대사항을 선택해주세요");
		System.out.println("※연령에 따른 우대는 자동 적용");
		System.out.println("0.해당 사항 없음");
		System.out.println("1.장애인 우대");
		System.out.println("2.국가 유공자 우대");
		System.out.println("3.다자녀 가정 우대");
		System.out.println("4.임신부우대");
		int priority = scanner.nextInt();
		return priority;
	}
}
