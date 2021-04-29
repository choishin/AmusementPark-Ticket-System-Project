package TicketSystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * FileWrite Class : Processing과 PrintOut에서 가공된 데이터를 UserValues에서 불러와
 * 					 티켓의 종류, 가격 등 csv 파일로 저장 
 * 개선해야 할 점 (1) : 종료를 누르기 전까지는 입력된 파일을 볼 수 없음.
 */
public class FileWrite {
		private BufferedWriter bfw;
		private boolean isFileExist;
		
		public FileWrite() {
			try {
				File file = new File("amusementpark.csv");
				if(file.exists() == false) {
					isFileExist = false;
				} else {
					isFileExist = true;
				}
				bfw =new BufferedWriter(new FileWriter(file, true));					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void headwrite() throws IOException {				
			
			if(isFileExist == false) {
				String head = "Date," + "TicketType," +"Priority Level,"+ "TicketPrice," + "Quantity," + "TotalPrice," + "\n";
				bfw.write(head);
			}
		}

		public void filewrite() throws IOException {

			Date date = new Date(); 
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			UserValues users = new UserValues();
			//1.날짜
			String dateNow = format.format(date);
			System.out.println(dateNow +" 예약이 완료되었습니다. 감사합니다.");
			System.out.println();
			bfw.append(dateNow+",");
			//2.티켓 타입,  우대할인 내역
			String ticketTypeKor = users.ticketTypeKor;
			String AgeSortKor = users.AgeSortKor;
			String  prioritySortKor = users.prioritySortKor;
			bfw.append(AgeSortKor+ticketTypeKor+",");
			bfw.append(prioritySortKor+",");
			//3.금액 
			int  ticketPrice = users.ticketPrice;
			int quantity = users.quantity;
			int totalPrice = users.totalPrice;
			bfw.append(ticketPrice+"원,");
			bfw.append(quantity +"개,");
			bfw.append(totalPrice +"원,");
			bfw.newLine();

		}
		
		public void fileclose() {
			try {
				bfw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
}
