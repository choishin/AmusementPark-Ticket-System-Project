package Ticketing;

import java.util.Scanner;

import com.sun.tools.javac.Main;
/*
 * InputConsole Class : ������� ������ �޾Ƽ� Main���� ���� �ϴ� Ŭ����
 */
public class InputConsole {

	static UserValues users = new UserValues();
	static Scanner scanner = new Scanner(System.in);
	static Main main = new Main();

	//1.����ڷκ��� �̿�� ������ ���ù���.
	public int getType () throws Exception {
		while(true) {
			System.out.println("��ǰ�� �������ּ���");
			System.out.println("1. �ְ���");
			System.out.println("2. �߰���");
			System.out.println("3. ����");
			int type = scanner.nextInt();
			if (type == 1 || type ==2 || type == 3) {
				return type;
			}
		}

	}
	//2.����ڷκ��� �ֹε�Ϲ�ȣ�� �Է¹���.
	public String getAge() {
		while(true) {
			System.out.println("�ֹε�Ϲ�ȣ�� �Է����ּ��� ��)9000101123456");
			String identification = scanner.next();
			if (identification.length()>7 && identification.length() <14) {
				if (identification.substring(6).contains("1")|| 
						identification.substring(6).contains("2")||
						identification.substring(6).contains("3")||
						identification.substring(6).contains("4")) {
					return identification;

				}
			}
		}
	}
	//3.����ڷκ��� ���� ������ �Է¹���.
	public int  getQuant() {
		while(true) {
			System.out.println("������ �Է����ּ��� (�ִ� ���ż��� 99��, ��ü ���� 000-0000-0000)");
			int quantity = scanner.nextInt();	
			if (quantity <100) {
				return quantity;
			}
		}
	}
	//4.����ڷκ��� ��� ���� ������ �Է� ����
	public int getPrioirity() {
		while(true) {
		System.out.println("�������� �������ּ���");
		System.out.println("�ؿ��ɿ� ���� ���� �ڵ� ����");
		System.out.println("0.�ش� ���� ����");
		System.out.println("1.����� ���");
		System.out.println("2.���� ������ ���");
		System.out.println("3.���ڳ� ���� ���");
		System.out.println("4.�ӽźο��");
		int priority = scanner.nextInt();
		if (priority == 0||priority == 1 || priority == 2 || priority == 3 || priority == 4)
		return priority;
		}
	}
}
