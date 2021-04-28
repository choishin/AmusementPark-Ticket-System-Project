package TicketSystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * FileWrite : Ƽ���� ������ ��¥�� ����ڰ� ������ Ƽ���� ����, ���� �� csv ���Ϸ� ���� 
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
			//1.��¥
			String dateNow = format.format(date);
			System.out.println(dateNow +" ����Ϸ�");
			bfw.append(dateNow+",");
			//2.Ƽ�� Ÿ��,  ������� ����
			String ticketTypeKor = users.ticketTypeKor;
			String AgeSortKor = users.AgeSortKor;
			String  prioritySortKor = users.prioritySortKor;
			bfw.append(AgeSortKor+ticketTypeKor+",");
			bfw.append(prioritySortKor+",");
			//3.�ݾ� 
			int  ticketPrice = users.ticketPrice;
			int quantity = users.quantity;
			int totalPrice = users.totalPrice;
			bfw.append(ticketPrice+"��,");
			bfw.append(quantity +"��,");
			bfw.append(totalPrice +"��,");
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
