package TicketSystem;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * Processing Class : 사용자의 선택을 받아와서 데이터 가공을 함. 
 * 					  (처리된 데이터는 UserVlaues Class에 저장.)
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
	/**1.이용권 종류를 받아 처리하기 **/
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
	/**2.주민번호를 받아 처리하기 
	 * @throws IOException **/
	public void calAge() throws ParseException, IOException {

		Date date = new Date();
		SimpleDateFormat thisyearformat = new SimpleDateFormat("yyyy");
		SimpleDateFormat todayformat= new SimpleDateFormat("MMdd");

		String identification = users.identification; //주민등록번호 가지고 와서 
		if (identification.contains("-")) {
			identification=identification.replaceAll("-", "");
		}
		String birthYear = identification.substring(0,2); //년도를 자르고
		String birthDay = identification.substring(2,6); //생일을 자르고 
		String judgeCentury = identification.substring(6); //태어난 세기를 알 수 있는 7번째 숫자를 자르기
		
		int judgeCenturyConvert = Integer.parseInt(judgeCentury);
		
		if (judgeCentury.equals("3")||judgeCentury.equals("4") ) {
			birthYear = "20"+birthYear;
		}else if (judgeCentury.equals("1")||judgeCentury.equals("2") ) {
			birthYear= "19"+birthYear;
		} 

		String thisYear = thisyearformat.format(date); //시스템에서 받아온 올해
		String today = todayformat.format(date); //시스템에서 받아온 오늘 날짜 		

		int thisYearConvert = Integer.parseInt(thisYear);
		int birthYearConvert = Integer.parseInt(birthYear);
		int judgeAge =  thisYearConvert - birthYearConvert ;//나이계산

		int birthDayConvert= Integer.parseInt(birthDay);
		int todayConvert= Integer.parseInt(today);
		int judgeMinusOne = todayConvert - birthDayConvert; //생일 지났나 안 지났나 체크
		
		//**만일 생일이라면 생일축하 문구를 넣을 수도 있음.
		if (judgeMinusOne == 0) { //생일
		//	System.out.println("birthday");
			judgeAge = judgeAge;
		}else if (judgeMinusOne > 0) { //생일 지났음
			//System.out.println("already past");
			judgeAge = judgeAge;
		}else {//생일이 아직 안 지났음 (1살을 빼줌)
			judgeAge = judgeAge-1; 
			//System.out.println("not yet"); 
		}		

		//최종 나이 분류
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

	/**3.티켓 구매 개수 처리 **/
	public void calQuant() {
		quantity = users.quantity;
		
	}
	/**4.우대사항 처리 **/
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
	/**5.위에서 받은 사용자의 선택을 종합 **/
	public void calTotal() throws ParseException {

		String tmpItemName = "";
		int indexForPrice =0;
		for (int i = 0; i<34; i++) //배열에 넣어둔 티켓 이름 중 사용자가 선택한 모두를 포함한 것을 찾기
		if	(con.ticket_type[i].contains(ticketType) && con.ticket_type[i].contains(AgeSort) && con.ticket_type[i].contains(prioritySort)) {
			tmpItemName = con.ticket_type[i];
			indexForPrice=i ; 
		}
		int ticketPrice = con.ticket_price[indexForPrice]; //이름에 해당하는 그 인덱스의 가격을 가져오기
		int quantity = users.quantity;
		int totalPrice  = ticketPrice*quantity; 
		users.ticketPrice = ticketPrice;
		users.totalPrice = totalPrice;

	}
	
}
