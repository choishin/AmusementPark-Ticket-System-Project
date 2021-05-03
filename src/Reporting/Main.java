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

public class Main {
	static String[][] arr2;
	public static void main (String[] args) throws IOException {
		
		ArrayList<String> arr1 = new ArrayList<String>();
		String path = "amusementpark.csv";
		String line;
		BufferedReader reader = new BufferedReader(new FileReader(path));

		//1. 자료 한줄씩 받고 ArrayList에 넣기
		while ((line = reader.readLine()) != null) {
			String[] column = line.split(",");
			arr1.add(line);
		}

		//2. 한줄씩 되어있는 자료를 ,로 잘라서 String[][] 에 넣기
		arr2 = new String[arr1.size()][];

		for (int i = 1; i<arr1.size(); i++) {	
			arr2[i] = arr1.get(i).split(",");
		}
		
		/*3.각 분류된 필드 내용
		 * arr2[0][i] -> 필드이름 
		 * arr2[][0]-> 날짜, 
		 * arr2[][1]-> 이용권종류, 
		 * arr2[][2]->우대할인내역,
		 * arr2[][3]->가격,
		 * arr2[][4]->개수,
		 * arr2[][5]->총가격
		*/
		
		ResultCalculator result = new ResultCalculator();
		result.totalResult_ticketType(arr2);
		result.totalResult_daily(arr2);
		result.totalResult_PrioirityType(arr2);
		
	}

}

