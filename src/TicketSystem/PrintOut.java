package TicketSystem;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * PrintOut : 사용자의 선택을 한국어로 변환하고, 티켓 폼 안에 출력 
 */
public class PrintOut {
	static Main main = new Main();
	static UserValues users = new UserValues();
	public void printResult() throws IOException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
		DecimalFormat df = new DecimalFormat("###,###,###,###,###,###");
		
		//(1) 이용권 종류, 나이분류, 우대사항 분류
		String ticketType = users.ticketType;
		String AgeSort = users.AgeSort;
		String prioritySort= users.prioritySort;
		//(2) 티켓 가격, 티켓 구매수량, 총 가격
		int ticketPrice = users.ticketPrice;
		int ticketQuantity = users.quantity;
		int totalPrice = users.totalPrice;
		
		String ticketTypeKor = "";
		String AgeSortKor = ""; 
		String prioritySortKor = ""; 
		//이용권 종류 (한국어로 바꾸기)
		if (ticketType.equals("day")) {
			ticketTypeKor = "주간권";
		}
		else if (ticketType.contains("night")) {
			ticketTypeKor = "야간권";
		}

		//나이(한국어로 바꾸기)
		if(AgeSort.equals("senior")) {
			AgeSortKor = "경로";
		}
		else if(AgeSort.equals("adult")) {
			AgeSortKor = "어른";
		}
		else if(AgeSort.equals("student")) {
			AgeSortKor = "청소년";
		}
		else if(AgeSort.equals("child")) {
			AgeSortKor = "소인";
		}

		// 우대사항 (한국어로 바꾸기)
		if(prioritySort.contains("normal")) {
			prioritySortKor = "일반";
		}
		else if(prioritySort.contains("handicap")) {
			prioritySortKor = "장애인 우대";
		}
		else if(prioritySort.contains("honor")) {
			prioritySortKor = "국가유공자 우대";
		}
		else if(prioritySort.contains("3kidsfamily")) {
			prioritySortKor = "다자녀 가정 우대";
		}
		else if(prioritySort.contains("pregnant")) {
			prioritySortKor = "임신부 우대";
		}

		users.ticketTypeKor =ticketTypeKor;
		users.AgeSortKor = AgeSortKor;
		users.prioritySortKor = prioritySortKor;
		
		//티켓 출력 폼
		System.out.printf("=============-=========[예약내역]=========================\n");
		System.out.printf("선택하신 이용권 : %s %s %s %s원\n",prioritySortKor,AgeSortKor,ticketTypeKor,df.format(ticketPrice) );
		System.out.printf("구매 개수 : %s개\n", df.format(ticketQuantity));
		System.out.printf("총 금액 : %s원\n", df.format(totalPrice));
		System.out.printf("우대 할인 내역  : %s \n", prioritySortKor);		
		System.out.printf("티켓 예약 날짜 : %s \n",sdf.format(date) );				
		System.out.printf("==========================================================\n");
		
	}

}
