package TicketSystem;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * Processing Class : ������� ������ �޾ƿͼ� ������ ������ ��. 
 * 					  (ó���� �����ʹ� UserVlaues Class�� ����.)
 */
public class Processing {
	static String ticketType;
	static String AgeSort;
	static String prioritySort;
	static int quantity;
	
	static ConstantValue con = new ConstantValue();
	static UserValues users = new UserValues();
	static Main main = new Main();
	static InputConsole input = new InputConsole();
	/**1.�̿�� ������ �޾� ó���ϱ� **/
	public void calType() throws ParseException, IOException {
		int type = users.type;
		if (type == 1) {
			ticketType = "day";
		}
		else if  (type ==2) {
			ticketType = "night";
		}
		else {
			main.main(null);
		}
		users.ticketType=ticketType;
	}
	/**2.�ֹι�ȣ�� �޾� ó���ϱ� 
	 * @throws IOException **/
	public void calAge() throws ParseException, IOException {

		Date date = new Date();
		SimpleDateFormat thisyearformat = new SimpleDateFormat("yyyy");
		SimpleDateFormat todayformat= new SimpleDateFormat("MMdd");

		String identification = users.identification; //�ֹε�Ϲ�ȣ ������ �ͼ� 
		if (identification.contains("-")) {
			identification=identification.replaceAll("-", "");
		}
		String birthYear = identification.substring(0,2); //�⵵�� �ڸ���
		String birthDay = identification.substring(2,6); //������ �ڸ��� 
		String judgeCentury = identification.substring(6); //�¾ ���⸦ �� �� �ִ� 7��° ���ڸ� �ڸ���
		
		int judgeCenturyConvert = Integer.parseInt(judgeCentury);
		
		if (judgeCentury.equals("3")||judgeCentury.equals("4") ) {
			birthYear = "20"+birthYear;
		}else if (judgeCentury.equals("1")||judgeCentury.equals("2") ) {
			birthYear= "19"+birthYear;
		} 

		String thisYear = thisyearformat.format(date); //�ý��ۿ��� �޾ƿ� ����
		String today = todayformat.format(date); //�ý��ۿ��� �޾ƿ� ���� ��¥ 		

		int thisYearConvert = Integer.parseInt(thisYear);
		int birthYearConvert = Integer.parseInt(birthYear);
		int judgeAge =  thisYearConvert - birthYearConvert ;//���̰��

		int birthDayConvert= Integer.parseInt(birthDay);
		int todayConvert= Integer.parseInt(today);
		int judgeMinusOne = todayConvert - birthDayConvert; //���� ������ �� ������ üũ
		
		//**���� �����̶�� �������� ������ ���� ���� ����.
		if (judgeMinusOne == 0) { //����
		//	System.out.println("birthday");
			judgeAge = judgeAge;
		}else if (judgeMinusOne > 0) { //���� ������
			//System.out.println("already past");
			judgeAge = judgeAge;
		}else {//������ ���� �� ������ (1���� ����)
			judgeAge = judgeAge-1; 
			//System.out.println("not yet"); 
		}		

		//���� ���� �з�
		if (judgeAge > 65) {
			AgeSort = "senior";
		}else if (judgeAge >20) {
			AgeSort = "adult";
		}else if (judgeAge >12) {
			AgeSort = "student";
		}else if (judgeAge>=3) {
			AgeSort = "child";
		}else {
			AgeSort = "error";
			Main.main(null);
		}
		
		users.AgeSort = AgeSort;
		
	}

	/**3.Ƽ�� ���� ���� ó�� **/
	public void calQuant() {
		quantity = users.quantity;
		
	}
	/**4.������ ó�� **/
	public void calPriority() throws ParseException {
		int priority = users.priority;
		
		if (priority == 0) {
			prioritySort = "normal";
		}
		else if (priority == 1) {
			prioritySort = "handicap";
		}
		else if (priority == 2) {
			prioritySort = "honor";
		}
		else if (priority == 3) {
			prioritySort = "3kidsfamily";
		}		
		else if (priority == 4) {
			prioritySort = "pregnant";
		}
		else  {
			input.getPrioirity();
		}
		users.prioritySort = prioritySort;
	
	}
	/**5.������ ���� ������� ������ ���� **/
	public void calTotal() throws ParseException {

		String tmpItemName = "";
		int indexForPrice =0;
		for (int i = 0; i<34; i++) //�迭�� �־�� Ƽ�� �̸� �� ����ڰ� ������ ��θ� ������ ���� ã��
		if	(con.ticket_type[i].contains(ticketType) && con.ticket_type[i].contains(AgeSort) && con.ticket_type[i].contains(prioritySort)) {
			tmpItemName = con.ticket_type[i];
			indexForPrice=i ; 
		}
		int ticketPrice = con.ticket_price[indexForPrice]; //�̸��� �ش��ϴ� �� �ε����� ������ ��������
		int quantity = users.quantity;
		int totalPrice  = ticketPrice*quantity; 
		users.ticketPrice = ticketPrice;
		users.totalPrice = totalPrice;

	}
	
}
