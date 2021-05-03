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
		//�ְ��� ���� ����
		for (int i =1; i<arr2.length; i++) {
			String quantity = arr2[i][4].replaceAll("��","");
			String price = arr2[i][5].replaceAll("��","");
			if (arr2[i][1].contains("�ְ���")) {
				day_ticket_count = day_ticket_count + Integer.parseInt(quantity);
				day_ticket_priceSum = day_ticket_priceSum + Integer.parseInt(price);
				if(arr2[i][1].contains("����")) {
					day_child_ticket_count =day_child_ticket_count+Integer.parseInt(quantity);
					day_child_ticket_priceSum =day_child_ticket_priceSum+Integer.parseInt(price);
				}else if (arr2[i][1].contains("û�ҳ�")) {
					day_student_ticket_count =day_student_ticket_count+Integer.parseInt(quantity);
					day_student_ticket_priceSum =day_student_ticket_priceSum+Integer.parseInt(price);
				}
				else if (arr2[i][1].contains("�")) {
					day_adult_ticket_count=day_adult_ticket_count+Integer.parseInt(quantity);
					day_adult_ticket_priceSum=day_adult_ticket_priceSum+Integer.parseInt(price);
				}			
				else if (arr2[i][1].contains("���")) {
					day_senior_ticket_count=day_senior_ticket_count+Integer.parseInt(quantity);
					day_senior_ticket_priceSum=day_senior_ticket_count+Integer.parseInt(price);
				}
			}
			// �߰��� ���� ����
			else if (arr2[i][1].contains("�߰���")) {
				night_ticket_count =night_ticket_count+Integer.parseInt(quantity);
				night_ticket_priceSum =night_ticket_priceSum+Integer.parseInt(price);
				if(arr2[i][1].contains("����")) {
					night_child_ticket_count =night_child_ticket_count+Integer.parseInt(quantity);
					night_child_ticket_priceSum =night_child_ticket_priceSum+Integer.parseInt(price);
				}else if (arr2[i][1].contains("û�ҳ�")) {
					night_student_ticket_count =night_student_ticket_count+Integer.parseInt(quantity);
					night_student_ticket_priceSum =night_student_ticket_priceSum+Integer.parseInt(price);
				}
				else if (arr2[i][1].contains("�")) {
					night_adult_ticket_count =night_adult_ticket_count+Integer.parseInt(quantity);
					night_adult_ticket_priceSum =night_adult_ticket_priceSum+Integer.parseInt(price);
				}			
				else if (arr2[i][1].contains("���")) {
					night_senior_ticket_count =night_senior_ticket_count+Integer.parseInt(quantity);
					night_senior_ticket_priceSum =night_senior_ticket_priceSum+Integer.parseInt(price);
				}
			}
		}

		System.out.println("=====================[�������Ǹ���Ȳ]===========================");
		System.out.printf("���ְ��� �Ǹ� �� %d��\n",day_ticket_count);
		System.out.printf("��� �� %d��, û�ҳ� �� %d��,� �� %d��, ���� �� %d��\n",
				day_child_ticket_count,day_student_ticket_count,day_adult_ticket_count,day_senior_ticket_count);
		System.out.println();
		System.out.printf("�ְ��� �� ���� %d��\n",day_ticket_priceSum);
		System.out.printf("��� �� ���� %d��\n",day_child_ticket_priceSum);
		System.out.printf("û�ҳ� �� ���� %d��\n",day_student_ticket_priceSum);
		System.out.printf("� �� ���� %d��\n",day_adult_ticket_priceSum);
		System.out.printf("���� �� ���� %d��\n",day_senior_ticket_priceSum);
		System.out.println();
		System.out.printf("���߰��� �Ǹ� �� %d��\n",night_ticket_count);
		System.out.printf("��� �� %d��, û�ҳ� �� %d��,� �� %d��, ���� �� %d��\n", night_child_ticket_count,
				night_student_ticket_count,night_adult_ticket_count,night_senior_ticket_count);
		System.out.println();
		System.out.printf("�߰��� �� ���� %d��\n",night_ticket_priceSum);
		System.out.printf("��� �� ���� %d��\n",night_child_ticket_priceSum);
		System.out.printf("û�ҳ� �� ���� %d��\n",night_student_ticket_priceSum);
		System.out.printf("� �� ���� %d��\n",night_adult_ticket_priceSum);
		System.out.printf("���� �� ���� %d��\n",night_senior_ticket_priceSum);

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
				String tmp = arr2[i][5].replaceAll("��","");
				dailyPrices[j] = dailyPrices[j] +Integer.parseInt(tmp);
			}//if
			}//for
		}//for
	//Ȯ��->	System.out.println(Arrays.toString(dailyPrices));
		Collections.sort(dates);
			System.out.println("=======================[�Ϻ��Ǹ���Ȳ]=============================");
			for (int i=0; i<dates.size(); i++) {
				System.out.printf("%s : �� ���� %d��\n",dates.get(i),dailyPrices[i]);
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
		String tmp = arr2[i][4].replaceAll("��","");
		total_ticket = total_ticket + Integer.parseInt(tmp);
		if (arr2[i][2].contains("�Ϲ�")) {
			normal_ticket++;
		}else if (arr2[i][2].contains("�����")) {
			hadicap_ticket++;
		}else if (arr2[i][2].contains("����������")) {
			honor_ticket++;
		}else if (arr2[i][2].contains("���ڳ�")) {
			kidsfamily_ticket++;
		}else if (arr2[i][2].contains("�ӽź�")) {
			pregnant_ticket++;
		}
		}
		System.out.println("=====================[�����Ǹ���Ȳ]=============================");
		System.out.printf("�� �Ǹ� Ƽ�� �� :%d��\n",total_ticket);
		System.out.printf("�Ϲ� :%d��\n",normal_ticket);
		System.out.printf("����� ��� :%d��\n",hadicap_ticket);
		System.out.printf("���������� ��� :%d��\n",honor_ticket);
		System.out.printf("���ڳ� ��� :%d��\n",kidsfamily_ticket);
		System.out.printf("�ӽź� ��� :%d��\n",pregnant_ticket);
		System.out.println();
		System.out.println("===================================================================");

	}
}

