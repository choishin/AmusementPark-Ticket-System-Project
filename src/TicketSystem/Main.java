package TicketSystem;

import java.io.IOException;
import java.text.ParseException;
import java.util.InputMismatchException;

/*
 * Main Class:   데이터 처리 순서를 등록.
 * 				 메뉴판을 보여주고, InputConsole 에서 사용자의 선택 내용을 return받아 Processing으로 전달.
 * 				 이후 Processing 과정이 끝나면, Print Class , FileWrite Class로 흐름을 이동 시킴.
 * 개선해야 할 점 (1) : int 입력부분에 문자가 들어가는 경우, 예외 처리를 적용해야 함.
 * 개선해야 할 점 (2) : 주민등록번호 예외처리
 */
public class Main {
	static InputConsole input = new InputConsole(); 
	static UserValues users = new UserValues();
	static Processing processing = new Processing();
	static PrintOut print = new PrintOut();
	static FileWrite file = new FileWrite();

	public static void main(String[] args) throws ParseException, IOException {
		// TODO Auto-generated method stub
		showMenu(); //프로그램 시작과 동시에 안내사항을 보여주고
		file.headwrite(); 
			while(true) { 
				//1.이용권 종류로 입력받은 값의 예외 처리
				int type = input.getType();
				if (type != 1 && type != 2 && type !=3) { //만일 선택지에 없는 숫자를 누른다면 다시 메인으로 돌아감
					main(null);
				}
				if (type ==3 ) { //3번 '종료'를 누르면 티켓 구매 종료
					System.out.println("티켓 발권을 종료합니다. 이용해 주셔서 감사합니다.");
					break;
				}
				users.type = type;
				//2.주민등록번호의 예외처리
				String identification = input.getAge();
				users.identification = identification;
				
				//3. 구매개수에 대한 예외처리
				int quantity = input.getQuant();
				users.quantity = quantity;
				//4.우대사항에 대한 예외처리
				int priority = input.getPrioirity();
				//만일 선택지에 없는 숫자를 누른다면 다시 메인으로 돌아감
				if (priority!= 0 && priority!= 1 && priority!= 2 && priority!= 3 && priority!= 4) { 
					priority = input.getPrioirity();
				}
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
