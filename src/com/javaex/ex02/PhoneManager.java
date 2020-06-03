package com.javaex.ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PhoneManager {

	private List<Person> pList;
	private Scanner sc;

	public PhoneManager() {
		sc = new Scanner(System.in);
		pList = new ArrayList<Person>();

	}

	// 시작준비 (시작화면 출려과 리스트 가져온다)
	public void showTitle() throws IOException {
		System.out.println("******************************************");
		System.out.println("*         전화번호 관리 프로그램         *");
		System.out.println("******************************************");
		
		pList = getList();
	}

	// 메뉴 출력과 입력을 받는다.
	public int showMenu() {
		System.out.println("                                          ");
		System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
		System.out.println("---------------------------------------");
		System.out.print(">메뉴번호:");
		int i = sc.nextInt();
		return i;
	}

	// 1.리스트선택시
	public void showList() {
		System.out.println("<1.리스트>");

		for (Person p : pList) {
			int count = pList.indexOf(p) + 1;
			System.out.print(count + ". ");
			p.showInfo();
		}
	}

	// 2.등록선택시
	public void showAdd() throws FileNotFoundException, IOException {
		OutputStream out = new FileOutputStream("C:\\javaStudy\\workspace\\minipro\\PhoneDB.txt", true);
		OutputStreamWriter ow = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bw = new BufferedWriter(ow);

		System.out.println("<2.등록>");
		System.out.print(">이름:");
		String name = sc.next();
		System.out.print(">휴대전화");
		String hp = sc.next();
		System.out.print(">회사전화");
		String company = sc.next();

		// 리스트
		Person pp = new Person(name, hp, company);
		pList.add(pp);
		// 파일
		bw.write(name + "," + hp + "," + company);
		bw.newLine();
		System.out.println("[등록되었습니다.]");

		bw.close();

	}

	// 3.삭제선택시
	public void showRemove() throws IOException {
		OutputStream out3 = new FileOutputStream("C:\\javaStudy\\workspace\\minipro\\PhoneDB.txt");
		OutputStreamWriter ow3 = new OutputStreamWriter(out3, "UTF-8");
		BufferedWriter bw3 = new BufferedWriter(ow3);

		System.out.println("<3.삭제>");
		System.out.print(">번호:");

		// 리스트
		int remoN = sc.nextInt() - 1;
		pList.remove(remoN);
		// 파일

		for (Person p : pList) {
			bw3.write(p.getName() + "," + p.getHp() + "," + p.getCompany());
			bw3.newLine();
		}

		System.out.println("[삭제되었습니다.]");

		bw3.close();

	}

	// 4.검색선택시
	public void showSearch() {
		System.out.println("<4.검색>");
		  System.out.print(">이름:");
		  String sh = sc.next();
		  
		  for(Person p2 : pList) {
			  String ppp = p2.getName();
			  if(ppp.contains(sh)) {
				  int idnum = pList.indexOf(p2)+1;
				  System.out.print(idnum);
				  p2.showInfo();
			  }
		  }
	}

	// 5.종료시
	public void showEnd() {
		System.out.println("******************************************");
		System.out.println("*                감사합니다              *");
		System.out.println("******************************************");

	}

	// 메뉴번호를 잘못 입력시 안내문구를 출력하는 메소드
	public void showEtc() {
		System.out.println("[다시 입력해주세요.]");
		
	}

	// 파일을 읽어 리스트에 담아 전달한다.
	
	private List<Person> getList() throws IOException {
		InputStream in = new FileInputStream("C:\\javaStudy\\workspace\\minipro\\PhoneDB.txt");
		InputStreamReader isr = new InputStreamReader(in, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		List<Person> pList = new ArrayList<>();
		
		while (true) {
			String str = br.readLine();
			if (str == null) {
				break;
			}

			String[] splitInfo = str.split(",");

			Person person = new Person(splitInfo[0], splitInfo[1], splitInfo[2]);
			pList.add(person);
		}
	
		br.close();
		return pList;
	}
	

//	// 리스트를 파일에 저장한다.
//	private void saveList() {
//		
//		
//		
//
//	}

}
