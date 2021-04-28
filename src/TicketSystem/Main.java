package TicketSystem;

import java.io.IOException;
import java.text.ParseException;
/*
 * Main : 	InputConsole ���� ������� ������ �޾� Processing���� �����ϰ�,
 * 			Processing,Print, FileWrtie ��  ������ ó�� ������ ���.
 * 			�޴����� ������.
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
		System.out.printf("%s\n","�̿�� ���� �ȳ� ");
		System.out.printf("%s\n","�ְ��� : 5,6000��(����)  4,7000��(û�ҳ�) 4,4000��(����,��� )");
		System.out.printf("%s\n","�߰��� : 4,6000��(����)  4,0000��(û�ҳ�) 3,7000��(����,��� )");
		System.out.printf("%s\n","�ؾ߰��� (16��~) ");
		System.out.println("**************************************************************");
		System.out.printf("%s\n","��� ���� ");
		System.out.printf("%s\n","(1) ���ɿ� ���� ���  ");
		System.out.printf("%s\n","����� : �� 65��~ ");
		System.out.printf("%s\n","��û�ҳ� : �� 13��~ 18��");
		System.out.printf("%s\n","������ : �� 36���� ~ �� 12��");
		System.out.printf("%s\n","��36���� �̸� : �����̿� ���� (����ü��� ��� �̿�� ���� ���� �ʿ�)");
		System.out.printf("%s\n","�������̿�� : 5,000�� (�غ�ī, �ڵ����ձ� ��� �̿� ����)");
		System.out.printf("%s\n","(2) ����� ��� ");
		System.out.printf("%s\n","������� ������ ���� ������� ��� : ���� ���� ������ �ִ� 1�� ��� ���� ����");
		System.out.printf("%s\n","������� ������ ������ ���� ������� ��� : ���� ��� ���� ����");
		System.out.printf("%s\n","(3)���������� ���");
		System.out.printf("%s\n","������ ���� ���� 1�� 50% ��밡�� ���� ����");
		System.out.printf("%s\n","(4)���ڳ� ���� ���");
		System.out.printf("%s\n","����� ��� : ���� �ڳడ �� 15�� ������ 3�� �̻��� ���ڳ� ������ �κο� �����ڳ� ");
		System.out.printf("%s\n","���ش� ���� �� �Ϻΰ����� �̿�ÿ��� ���� ����");
		System.out.printf("%s\n","(5)�ӽź� ���");
		System.out.printf("%s\n","���ӽź� ���� ��밡�� ���� ����");
		System.out.println("**************************************************************");


	}

}
