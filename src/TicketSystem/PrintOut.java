package TicketSystem;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * PrintOut : ������� ������ �ѱ���� ��ȯ�ϰ�, Ƽ�� �� �ȿ� ��� 
 */
public class PrintOut {
	static Main main = new Main();
	static UserValues users = new UserValues();
	public void printResult() throws IOException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� HH:mm:ss");
		DecimalFormat df = new DecimalFormat("###,###,###,###,###,###");
		
		//(1) �̿�� ����, ���̺з�, ������ �з�
		String ticketType = users.ticketType;
		String AgeSort = users.AgeSort;
		String prioritySort= users.prioritySort;
		//(2) Ƽ�� ����, Ƽ�� ���ż���, �� ����
		int ticketPrice = users.ticketPrice;
		int ticketQuantity = users.quantity;
		int totalPrice = users.totalPrice;
		
		String ticketTypeKor = "";
		String AgeSortKor = ""; 
		String prioritySortKor = ""; 
		//�̿�� ���� (�ѱ���� �ٲٱ�)
		if (ticketType.equals("day")) {
			ticketTypeKor = "�ְ���";
		}
		else if (ticketType.contains("night")) {
			ticketTypeKor = "�߰���";
		}

		//����(�ѱ���� �ٲٱ�)
		if(AgeSort.equals("senior")) {
			AgeSortKor = "���";
		}
		else if(AgeSort.equals("adult")) {
			AgeSortKor = "�";
		}
		else if(AgeSort.equals("student")) {
			AgeSortKor = "û�ҳ�";
		}
		else if(AgeSort.equals("child")) {
			AgeSortKor = "����";
		}

		// ������ (�ѱ���� �ٲٱ�)
		if(prioritySort.contains("normal")) {
			prioritySortKor = "�Ϲ�";
		}
		else if(prioritySort.contains("handicap")) {
			prioritySortKor = "����� ���";
		}
		else if(prioritySort.contains("honor")) {
			prioritySortKor = "���������� ���";
		}
		else if(prioritySort.contains("3kidsfamily")) {
			prioritySortKor = "���ڳ� ���� ���";
		}
		else if(prioritySort.contains("pregnant")) {
			prioritySortKor = "�ӽź� ���";
		}

		users.ticketTypeKor =ticketTypeKor;
		users.AgeSortKor = AgeSortKor;
		users.prioritySortKor = prioritySortKor;
		
		//Ƽ�� ��� ��
		System.out.printf("=============-=========[���೻��]=========================\n");
		System.out.printf("�����Ͻ� �̿�� : %s %s %s %s��\n",prioritySortKor,AgeSortKor,ticketTypeKor,df.format(ticketPrice) );
		System.out.printf("���� ���� : %s��\n", df.format(ticketQuantity));
		System.out.printf("�� �ݾ� : %s��\n", df.format(totalPrice));
		System.out.printf("��� ���� ����  : %s \n", prioritySortKor);		
		System.out.printf("Ƽ�� ���� ��¥ : %s \n",sdf.format(date) );				
		System.out.printf("==========================================================\n");
		
	}

}
