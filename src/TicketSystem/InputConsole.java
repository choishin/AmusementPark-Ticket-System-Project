package TicketSystem;

import java.util.Scanner;
/*
 * InputConsole Class : ������� ������ �޾Ƽ� Main���� ���� �ϴ� Ŭ����
 */
public class InputConsole {
	
	static UserValues users = new UserValues();
	static Scanner scanner = new Scanner(System.in);
	
	//1.����ڷκ��� �̿�� ������ ���ù���.
	public int getType () {
		System.out.println("��ǰ�� �������ּ���");
		System.out.println("1. �ְ���");
		System.out.println("2. �߰���");
		System.out.println("3. ����");
		
		int type = scanner.nextInt();
		return type;
	}
	//2.����ڷκ��� �ֹε�Ϲ�ȣ�� �Է¹���.
	public String getAge() {
		System.out.println("�ֹε�Ϲ�ȣ�� �Է����ּ���");
		String identification = scanner.next();
		return identification;
	}
	//3.����ڷκ��� ���� ������ �Է¹���.
	public int  getQuant() {
		System.out.println("������ �Է����ּ���");
		int quantity = scanner.nextInt();		
		users.quantity = quantity;
		return quantity;
	}
	//4.����ڷκ��� ��� ���� ������ �Է� ����
	public int getPrioirity() {
		System.out.println("�������� �������ּ���");
		System.out.println("�ؿ��ɿ� ���� ���� �ڵ� ����");
		System.out.println("0.�ش� ���� ����");
		System.out.println("1.����� ���");
		System.out.println("2.���� ������ ���");
		System.out.println("3.���ڳ� ���� ���");
		System.out.println("4.�ӽźο��");
		int priority = scanner.nextInt();
		return priority;
	}
}
