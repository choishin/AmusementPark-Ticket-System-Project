package TicketSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
/*
 * ResultCalculator Class : 매출분석 및 현황 표 출력을 하는 클라스. 
 * 							티켓 판매를 기록한 csv 파일을 불러와 파일을 재가공해서 권종별, 일별, 우대권 판매 현황을 보여줌.
 */
public class ResultCalculator {
	static String[][] arr2;

	public static void main(String[] args) throws IOException { //<-main 메소드 여기서부터 시작

		ArrayList<String> arr1 = new ArrayList<String>();
		//**amusement.csv 파일을 불러올 경로**// 
		String path = "amusementpark.csv";
		String line;
		BufferedReader reader = new BufferedReader(new FileReader(path));

		//1. 자료 한줄씩 받고 ArrayList에 넣기
		while ((line = reader.readLine()) != null) {
			String[] column = line.split(",");
			arr1.add(line);
		}
		//2. 한줄씩 되어있는 자료를 ,로 잘라서 String[][] 에 넣기
		/*arr2[0][i] -> 필드이름, 
		arr2[][0]-> 날짜
		arr2[][1]-> 이용권종류, 
		arr2[][2]->우대할인내역,
		arr2[][3]->가격,
		arr2[][4]->개수,
		arr2[][5]->총가격*/

		arr2 = new String[arr1.size()][];
		for (int i = 0; i<arr1.size(); i++) {	
			arr2[i] = arr1.get(i).split(",");
		}
		//3.티켓 타입과 우대사항 (한글로 되어있는 부분) 가공하기
		String[] convertTicketType = new String[arr2.length];
		for (int i =1; i<arr2.length; i++) {
			convertTicketType[i] = arr2[i][2];
		}
		String[] convertPriorityType = new String[arr2.length];
		for (int i =1; i<arr2.length; i++) {
			convertPriorityType[i] = arr2[i][3];
		}
		int cutBytes = 19; 
		for (int i = 0; i < arr2.length; i++) {
			String temp = convertTicketType [i] + "                   ";
			String temp2 = convertPriorityType [i] + "                   ";
			byte[] TicketTypebytes = temp.getBytes(); 
			byte[] Prioritybytes = temp2.getBytes(); 
			int cnt = 0;

			for(int j = 0; j < cutBytes; j++) {
				if(TicketTypebytes[j] < 0)
					cnt++;
			}
			if (cnt % 2 == 0) {
				convertTicketType [i] = new String(TicketTypebytes , 0, cutBytes) + " ";

			} else if (TicketTypebytes[19] < 0){
				convertTicketType[i] = new String(TicketTypebytes, 0, cutBytes-1) + "  ";

			} else {
				convertTicketType[i] = new String(TicketTypebytes , 0, cutBytes) + " ";
			}//else
			
			int cnt2 =0;
			for(int j = 0; j < cutBytes; j++) {
				if(Prioritybytes[j] < 0)
					cnt2++;
			}
			if (cnt2 % 2 == 0) {
				convertPriorityType [i] = new String(Prioritybytes, 0, cutBytes) + " ";

			} else if (Prioritybytes[19] < 0){
				convertPriorityType[i] = new String(Prioritybytes, 0, cutBytes-1) + "  ";

			} else {
				convertPriorityType[i] = new String(Prioritybytes , 0, cutBytes) + " ";
			}
		}//for


		//3. 판매현황 출력
		System.out.println("==========================[총 판매현황]============================================================================");
		System.out.printf("[%s]\t\t\t[%s]\t[%s]\t[%s]\t[%s]\t[%s]\n",
				arr2[0][0],arr2[0][1],arr2[0][2],arr2[0][3],arr2[0][4],arr2[0][5]);
		System.out.println("===================================================================================================================");
		for (int i=1; i<arr2.length;i++) {
			System.out.printf("%s%10s\t%10s\t%10s\t%2s\t%10s\n",
					arr2[i][0],arr2[i][1],convertTicketType [i],convertPriorityType[i],arr2[i][4],arr2[i][5]);
		}

		//***데이터 처리 순서**//
		totalResult_ticketType();
		totalResult_daily();
		totalResult_PrioirityType();

	}
	//(1).권종별 판매현황
	public static void totalResult_ticketType() {

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

		System.out.println("==========================[권종별판매현황]=========================================================================");
		System.out.printf("주간권 판매 총 %d매\n",day_ticket_count);
		System.out.printf("어린이 총 %d매, 청소년 총 %d매,어른 총 %d매, 노인 총 %d매\n",
				day_child_ticket_count,day_student_ticket_count,day_adult_ticket_count,day_senior_ticket_count);
		System.out.println();
		System.out.printf("주간권 총 매출 %d원\n",day_ticket_priceSum);
		System.out.printf("어린이 총 매출 %d원\n",day_child_ticket_priceSum);
		System.out.printf("청소년 총 매출 %d원\n",day_student_ticket_priceSum);
		System.out.printf("어른 총 매출 %d원\n",day_adult_ticket_priceSum);
		System.out.printf("노인 총 매출 %d원\n",day_senior_ticket_priceSum);
		System.out.println();
		System.out.printf("야간권 판매 총 %d매\n",night_ticket_count);
		System.out.printf("어린이 총 %d매, 청소년 총 %d매,어른 총 %d매, 노인 총 %d매\n", night_child_ticket_count,
				night_student_ticket_count,night_adult_ticket_count,night_senior_ticket_count);
		System.out.println();
		System.out.printf("야간권 총 매출 %d원\n",night_ticket_priceSum);
		System.out.printf("어린이 총 매출 %d원\n",night_child_ticket_priceSum);
		System.out.printf("청소년 총 매출 %d원\n",night_student_ticket_priceSum);
		System.out.printf("어른 총 매출 %d원\n",night_adult_ticket_priceSum);
		System.out.printf("노인 총 매출 %d원\n",night_senior_ticket_priceSum);

	}

	//(2). 일자별 판매현황
	public static void totalResult_daily() {
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
		//확인->System.out.println(Arrays.toString(dailyPrices));
		Collections.sort(dates);
		System.out.println("============================[일별판매현황]==================================");
		for (int i=0; i<dates.size(); i++) {
			System.out.printf("%s : 총 매출 %d원\n",dates.get(i),dailyPrices[i]);
		}


	}
	//(3).우대권 판매현황
	public static void totalResult_PrioirityType() {

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
		System.out.println("==========================[우대권판매현황]==================================");
		System.out.printf("총 판매 티켓 수 :%d매\n",total_ticket);
		System.out.printf("일반 :%d매\n",normal_ticket);
		System.out.printf("장애인 우대 :%d매\n",hadicap_ticket);
		System.out.printf("국가유공자 우대 :%d매\n",honor_ticket);
		System.out.printf("다자녀 우대 :%d매\n",kidsfamily_ticket);
		System.out.printf("임신부 우대 :%d매\n",pregnant_ticket);
		System.out.println();
		System.out.println("============================================================================");

	}
}

