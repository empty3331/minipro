package com.javaex.ex03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class PhoneRepository {

	private List<Person> pList = new ArrayList<Person>();

	// phoneDB.txt 파일을 읽어 모든 전화번호(리스트)를 전달하는 메소드
	public List<Person> getList() throws IOException {
		InputStream in = new FileInputStream("C:\\javaStudy\\workspace\\minipro\\PhoneDB.txt");
		InputStreamReader isr = new InputStreamReader(in, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		List<Person> pList = new ArrayList<Person>();

		while (true) {
			String str = br.readLine();
			if (str == null) {
				break;
			}

			String[] splitInfo = str.split(",");

			Person person = new Person(splitInfo[0], splitInfo[1], splitInfo[2]);
			pList.add(person);
			pList = getList();
		}
		br.close();
		return pList;
	}

	// phoneDB.txt 에 모든 전화번호 리스트를 저장하는 메소드
	public void saveInfo(Person phoneVO) throws IOException {
		OutputStream out = new FileOutputStream("C:\\javaStudy\\workspace\\minipro\\PhoneDB.txt");
		OutputStreamWriter ow = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bw = new BufferedWriter(ow);

		for (Person p1 : pList) {
			bw.write(p1.getName() + "," + p1.getHp() + "," + p1.getCompany());
			bw.newLine();
		}

		bw.close();
	}

	// 기존데이터에 새로입력받은 데이터를 추가하여 모두저장하는 메소드
	public void addInfo(Person phoneVO) throws IOException {
		
	}

	// 선택한 번호의 데이터를 삭제하고 저장하는 메소드(모두 다시저장)
	public void delInfo(int num) throws IOException {
		
	

	}

}