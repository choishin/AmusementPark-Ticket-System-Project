package Reporting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class ResultCalculator {
	

	public static void totalResult_ticketType(String[][]arr2) {

		int day_ticket_count =0;
		int night_ticket_count =0;
		int day_child_ticket_count =0;
		int day_student_ticket_count =0;
		int day_adult_ticket_count =0;
		int day_senior_ticket_count =0;
		int night_child_ticket_count =0;
		int night_student_ticket_count =0;
		int night_adult_ticket_count =0;
		int night_senior_ticket_count =0;
		int day_ticket_priceSum =0;
		int day_child_ticket_priceSum =0;
		int day_student_ticket_priceSum =0;
		int day_adult_ticket_priceSum =0;
		int day_senior_ticket_priceSum =0;
		int night_ticket_priceSum =0;
		int night_child_ticket_priceSum =0;
		int night_student_ticket_priceSum =0;
		int night_adult_ticket_priceSum =0;
		int night_senior_ticket_priceSum =0;
		int sum = 0;
		//주간권 개수 세기
		for (int i =1; i<arr2.length; i++) {
			String quantity = arr2[i][4].replaceAll("개","");
			String price = arr2[i][5].replaceAll("원","");
			if (arr2[i][1].contains("주간권")) {
				day_ticket_count = day_ticket_count + Integer.parseInt(quantity);
				day_ticket_priceSum = day_ticket_priceSum + Integer.parseInt(price);
				if(arr2[i][1].contains("소인")) {
					day_child_ticket_count =day_child_ticket_count+Integer.parseInt(quantity);
					day_child_ticket_priceSum =day_child_ticket_priceSum+Integer.parseInt(price);
				}else if (arr2[i][1].contains("청소년")) {
					day_student_ticket_count =day_student_ticket_count+Integer.parseInt(quantity);
					day_student_ticket_priceSum =day_student_ticket_priceSum+Integer.parseInt(price);
				}
				else if (arr2[i][1].contains("어른")) {
					day_adult_ticket_count=day_adult_ticket_count+Integer.parseInt(quantity);
					day_adult_ticket_priceSum=day_adult_ticket_priceSum+Integer.parseInt(price);
				}			
				else if (arr2[i][1].contains("경로")) {
					day_senior_ticket_count=day_senior_ticket_count+Integer.parseInt(quantity);
					day_senior_ticket_priceSum=day_senior_ticket_count+Integer.parseInt(price);
				}
			}
			// 야간권 개수 세기
			else if (arr2[i][1].contains("야간권")) {
				night_ticket_count =night_ticket_count+Integer.parseInt(quantity);
				night_ticket_priceSum =night_ticket_priceSum+Integer.parseInt(price);
				if(arr2[i][1].contains("소인")) {
					night_child_ticket_count =night_child_ticket_count+Integer.parseInt(quantity);
					night_child_ticket_priceSum =night_child_ticket_priceSum+Integer.parseInt(price);
				}else if (arr2[i][1].contains("청소년")) {
					night_student_ticket_count =night_student_ticket_count+Integer.parseInt(quantity);
					night_student_ticket_priceSum =night_student_ticket_priceSum+Integer.parseInt(price);
				}
				else if (arr2[i][1].contains("어른")) {
					night_adult_ticket_count =night_adult_ticket_count+Integer.parseInt(quantity);
					night_adult_ticket_priceSum =night_adult_ticket_priceSum+Integer.parseInt(price);
				}			
				else if (arr2[i][1].contains("경로")) {
					night_senior_ticket_count =night_senior_ticket_count+Integer.parseInt(quantity);
					night_senior_ticket_priceSum =night_senior_ticket_priceSum+Integer.parseInt(price);
				}
			}
		}

		System.out.println("=====================[권종별판매현황]===========================");
		System.out.printf("▷주간권 판매 총 %d매\n",day_ticket_count);
		System.out.printf("어린이 총 %d매, 청소년 총 %d매,어른 총 %d매, 노인 총 %d매\n",
				day_child_ticket_count,day_student_ticket_count,day_adult_ticket_count,day_senior_ticket_count);
		System.out.println();
		System.out.printf("주간권 총 매출 %d원\n",day_ticket_priceSum);
		System.out.printf("어린이 총 매출 %d원\n",day_child_ticket_priceSum);
		System.out.printf("청소년 총 매출 %d원\n",day_student_ticket_priceSum);
		System.out.printf("어른 총 매출 %d원\n",day_adult_ticket_priceSum);
		System.out.printf("노인 총 매출 %d원\n",day_senior_ticket_priceSum);
		System.out.println();
		System.out.printf("▷야간권 판매 총 %d매\n",night_ticket_count);
		System.out.printf("어린이 총 %d매, 청소년 총 %d매,어른 총 %d매, 노인 총 %d매\n", night_child_ticket_count,
				night_student_ticket_count,night_adult_ticket_count,night_senior_ticket_count);
		System.out.println();
		System.out.printf("야간권 총 매출 %d원\n",night_ticket_priceSum);
		System.out.printf("어린이 총 매출 %d원\n",night_child_ticket_priceSum);
		System.out.printf("청소년 총 매출 %d원\n",night_student_ticket_priceSum);
		System.out.printf("어른 총 매출 %d원\n",night_adult_ticket_priceSum);
		System.out.printf("노인 총 매출 %d원\n",night_senior_ticket_priceSum);

	}

	public static void totalResult_daily(String[][] arr2) {
		HashSet<String> dateSet = new HashSet<String>();

		for (int i=1; i<arr2.length; i++) {
			String date = arr2[i][0].substring(0,10);
			dateSet.add(date);
		}
		Iterator iter = dateSet.iterator();	
		while(iter.hasNext()) {
			//System.out.println(iter.next());
			iter.next();
		}
		ArrayList<String> dates = new ArrayList<String>(dateSet);
		int[] dailyPrices = new int[dates.size()];
		for(int i=0; i <dates.size(); i++) {
			dailyPrices[i] =0;
		}
		int dailySum =0;
		for(int i=1; i<arr2.length; i++) {
			for(int j=0; j<dates.size(); j++) {
			if(arr2[i][0].contains(dates.get(j))) {
				String tmp = arr2[i][5].replaceAll("원","");
				dailyPrices[j] = dailyPrices[j] +Integer.parseInt(tmp);
			}//if
			}//for
		}//for
	//확인->	System.out.println(Arrays.toString(dailyPrices));
		Collections.sort(dates);
			System.out.println("=======================[일별판매현황]=============================");
			for (int i=0; i<dates.size(); i++) {
				System.out.printf("%s : 총 매출 %d원\n",dates.get(i),dailyPrices[i]);
			}


}

	public static void totalResult_PrioirityType(String[][] arr2) {
		int total_ticket = 0;
		int normal_ticket = 0;
		int hadicap_ticket = 0;
		int honor_ticket =0;
		int kidsfamily_ticket =0;
		int pregnant_ticket = 0;
		for (int i=1; i<arr2.length; i++) {
		String tmp = arr2[i][4].replaceAll("개","");
		total_ticket = total_ticket + Integer.parseInt(tmp);
		if (arr2[i][2].contains("일반")) {
			normal_ticket++;
		}else if (arr2[i][2].contains("장애인")) {
			hadicap_ticket++;
		}else if (arr2[i][2].contains("국가유공자")) {
			honor_ticket++;
		}else if (arr2[i][2].contains("다자녀")) {
			kidsfamily_ticket++;
		}else if (arr2[i][2].contains("임신부")) {
			pregnant_ticket++;
		}
		}
		System.out.println("=====================[우대권판매현황]=============================");
		System.out.printf("총 판매 티켓 수 :%d매\n",total_ticket);
		System.out.printf("일반 :%d매\n",normal_ticket);
		System.out.printf("장애인 우대 :%d매\n",hadicap_ticket);
		System.out.printf("국가유공자 우대 :%d매\n",honor_ticket);
		System.out.printf("다자녀 우대 :%d매\n",kidsfamily_ticket);
		System.out.printf("임신부 우대 :%d매\n",pregnant_ticket);
		System.out.println();
		System.out.println("===================================================================");

	}
}

