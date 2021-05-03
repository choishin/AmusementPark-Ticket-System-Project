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

		//1. �ڷ� ���پ� �ް� ArrayList�� �ֱ�
		while ((line = reader.readLine()) != null) {
			String[] column = line.split(",");
			arr1.add(line);
		}

		//2. ���پ� �Ǿ��ִ� �ڷḦ ,�� �߶� String[][] �� �ֱ�
		arr2 = new String[arr1.size()][];

		for (int i = 1; i<arr1.size(); i++) {	
			arr2[i] = arr1.get(i).split(",");
		}
		
		/*3.�� �з��� �ʵ� ����
		 * arr2[0][i] -> �ʵ��̸� 
		 * arr2[][0]-> ��¥, 
		 * arr2[][1]-> �̿������, 
		 * arr2[][2]->������γ���,
		 * arr2[][3]->����,
		 * arr2[][4]->����,
		 * arr2[][5]->�Ѱ���
		*/
		
		ResultCalculator result = new ResultCalculator();
		result.totalResult_ticketType(arr2);
		result.totalResult_daily(arr2);
		result.totalResult_PrioirityType(arr2);
		
	}

}

