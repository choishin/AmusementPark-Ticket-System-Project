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
 * ResultCalculator Class : ����м� �� ��Ȳ ǥ ����� �ϴ� Ŭ��. 
 * 							Ƽ�� �ǸŸ� ����� csv ������ �ҷ��� ������ �簡���ؼ� ������, �Ϻ�, ���� �Ǹ� ��Ȳ�� ������.
 */
public class ResultCalculator {
	static String[][] arr2;

	public static void main(String[] args) throws IOException { //<-main �޼ҵ� ���⼭���� ����

		ArrayList<String> arr1 = new ArrayList<String>();
		//**amusement.csv ������ �ҷ��� ���**// 
		String path = "amusementpark.csv";
		String line;
		BufferedReader reader = new BufferedReader(new FileReader(path));

		//1. �ڷ� ���پ� �ް� ArrayList�� �ֱ�
		while ((line = reader.readLine()) != null) {
			String[] column = line.split(",");
			arr1.add(line);
		}
		//2. ���پ� �Ǿ��ִ� �ڷḦ ,�� �߶� String[][] �� �ֱ�
		/*arr2[0][i] -> �ʵ��̸�, 
		arr2[][0]-> ��¥
		arr2[][1]-> �̿������, 
		arr2[][2]->������γ���,
		arr2[][3]->����,
		arr2[][4]->����,
		arr2[][5]->�Ѱ���*/

		arr2 = new String[arr1.size()][];
		for (int i = 0; i<arr1.size(); i++) {	
			arr2[i] = arr1.get(i).split(",");
		}
		//3.Ƽ�� Ÿ�԰� ������ (�ѱ۷� �Ǿ��ִ� �κ�) �����ϱ�
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


		//3. �Ǹ���Ȳ ���
		System.out.println("==========================[�� �Ǹ���Ȳ]============================================================================");
		System.out.printf("[%s]\t\t\t[%s]\t[%s]\t[%s]\t[%s]\t[%s]\n",
				arr2[0][0],arr2[0][1],arr2[0][2],arr2[0][3],arr2[0][4],arr2[0][5]);
		System.out.println("===================================================================================================================");
		for (int i=1; i<arr2.length;i++) {
			System.out.printf("%s%10s\t%10s\t%10s\t%2s\t%10s\n",
					arr2[i][0],arr2[i][1],convertTicketType [i],convertPriorityType[i],arr2[i][4],arr2[i][5]);
		}

		//***������ ó�� ����**//
		totalResult_ticketType();
		totalResult_daily();
		totalResult_PrioirityType();

	}
	//(1).������ �Ǹ���Ȳ
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

		System.out.println("==========================[�������Ǹ���Ȳ]=========================================================================");
		System.out.printf("�ְ��� �Ǹ� �� %d��\n",day_ticket_count);
		System.out.printf("��� �� %d��, û�ҳ� �� %d��,� �� %d��, ���� �� %d��\n",
				day_child_ticket_count,day_student_ticket_count,day_adult_ticket_count,day_senior_ticket_count);
		System.out.println();
		System.out.printf("�ְ��� �� ���� %d��\n",day_ticket_priceSum);
		System.out.printf("��� �� ���� %d��\n",day_child_ticket_priceSum);
		System.out.printf("û�ҳ� �� ���� %d��\n",day_student_ticket_priceSum);
		System.out.printf("� �� ���� %d��\n",day_adult_ticket_priceSum);
		System.out.printf("���� �� ���� %d��\n",day_senior_ticket_priceSum);
		System.out.println();
		System.out.printf("�߰��� �Ǹ� �� %d��\n",night_ticket_count);
		System.out.printf("��� �� %d��, û�ҳ� �� %d��,� �� %d��, ���� �� %d��\n", night_child_ticket_count,
				night_student_ticket_count,night_adult_ticket_count,night_senior_ticket_count);
		System.out.println();
		System.out.printf("�߰��� �� ���� %d��\n",night_ticket_priceSum);
		System.out.printf("��� �� ���� %d��\n",night_child_ticket_priceSum);
		System.out.printf("û�ҳ� �� ���� %d��\n",night_student_ticket_priceSum);
		System.out.printf("� �� ���� %d��\n",night_adult_ticket_priceSum);
		System.out.printf("���� �� ���� %d��\n",night_senior_ticket_priceSum);

	}

	//(2). ���ں� �Ǹ���Ȳ
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
					String tmp = arr2[i][5].replaceAll("��","");
					dailyPrices[j] = dailyPrices[j] +Integer.parseInt(tmp);
				}//if
			}//for
		}//for
		//Ȯ��->System.out.println(Arrays.toString(dailyPrices));
		Collections.sort(dates);
		System.out.println("============================[�Ϻ��Ǹ���Ȳ]==================================");
		for (int i=0; i<dates.size(); i++) {
			System.out.printf("%s : �� ���� %d��\n",dates.get(i),dailyPrices[i]);
		}


	}
	//(3).���� �Ǹ���Ȳ
	public static void totalResult_PrioirityType() {

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
		System.out.println("==========================[�����Ǹ���Ȳ]==================================");
		System.out.printf("�� �Ǹ� Ƽ�� �� :%d��\n",total_ticket);
		System.out.printf("�Ϲ� :%d��\n",normal_ticket);
		System.out.printf("����� ��� :%d��\n",hadicap_ticket);
		System.out.printf("���������� ��� :%d��\n",honor_ticket);
		System.out.printf("���ڳ� ��� :%d��\n",kidsfamily_ticket);
		System.out.printf("�ӽź� ��� :%d��\n",pregnant_ticket);
		System.out.println();
		System.out.println("============================================================================");

	}
}

