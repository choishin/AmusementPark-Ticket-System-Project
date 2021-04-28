package TicketSystem;

import java.io.IOException;
import java.text.ParseException;
/*
 * Main : 	InputConsole 에서 사용자의 선택을 받아 Processing으로 전달하고,
 * 			Processing,Print, FileWrtie 로  데이터 처리 순서를 등록.
 * 			메뉴판을 보여줌.
 */
public class Main {
	static InputConsole input = new InputConsole(); 
	static UserValues users = new UserValues();
	static Processing processing = new Processing();
	static PrintOut print = new PrintOut();
	static FileWrite file = new FileWrite();

	public static void main(String[] args) throws ParseException, IOException {
		// TODO Auto-generated method stub
		file.headwrite();
		showMenu();
		while(true) {
			int type = input.getType();
			if (type ==3 ) {
				break;
			}
			if (type != 1 && type != 2 && type !=3) {
				main(null);
			}
			users.type = type;
			String identification = input.getAge();
			users.identification = identification;
			int quantity = input.getQuant();
			users.quantity = quantity;
			int priority = input.getPrioirity();
			users.priority = priority;

			processing.calType();
			processing.calAge();
			processing.calQuant();
			processing.calPriority();
			processing.calTotal();
			print.printResult();
			file.filewrite();
		}
		file.fileclose();

	}

	static void showMenu() {

		System.out.println("**************************************************************");
		System.out.printf("%s\n","이용권 가격 안내 ");
		System.out.printf("%s\n","주간권 : 5,6000원(대인)  4,7000원(청소년) 4,4000원(소인,경로 )");
		System.out.printf("%s\n","야간권 : 4,6000원(대인)  4,0000원(청소년) 3,7000원(소인,경로 )");
		System.out.printf("%s\n","※야간권 (16시~) ");
		System.out.println("**************************************************************");
		System.out.printf("%s\n","우대 정보 ");
		System.out.printf("%s\n","(1) 연령에 따른 우대  ");
		System.out.printf("%s\n","▶경로 : 만 65세~ ");
		System.out.printf("%s\n","▶청소년 : 만 13세~ 18세");
		System.out.printf("%s\n","▶소인 : 만 36개월 ~ 만 12세");
		System.out.printf("%s\n","※36개월 미만 : 무료이용 가능 (유료시설의 경우 이용권 별도 구매 필요)");
		System.out.printf("%s\n","※유아이용권 : 5,000원 (붕붕카, 자동차왕국 모두 이용 가능)");
		System.out.printf("%s\n","(2) 장애인 우대 ");
		System.out.printf("%s\n","▶장애의 정도가 심한 장애인의 경우 : 본인 포함 동반인 최대 1명 우대 할인 적용");
		System.out.printf("%s\n","▶장애의 정도가 심하지 않은 장애인의 경우 : 본인 우대 할인 적용");
		System.out.printf("%s\n","(3)국가유공자 우대");
		System.out.printf("%s\n","▶본인 포함 동반 1인 50% 우대가로 구입 가능");
		System.out.printf("%s\n","(4)다자녀 가정 우대");
		System.out.printf("%s\n","▶우대 대상 : 막내 자녀가 만 15세 이하인 3명 이상의 다자녀 가정의 부부와 직계자녀 ");
		System.out.printf("%s\n","▶해당 가정 내 일부가족만 이용시에도 혜택 적용");
		System.out.printf("%s\n","(5)임신부 우대");
		System.out.printf("%s\n","▶임신부 본인 우대가로 구입 가능");
		System.out.println("**************************************************************");


	}

}
