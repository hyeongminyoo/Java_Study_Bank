package com.iu.start.test;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.iu.start.bankBook.BankBookDAO;
import com.iu.start.bankBook.BankBookDTO;

public class BankBookTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
		GregorianCalendar ca = new GregorianCalendar();
		BankBookDAO bankBookDAO = new BankBookDAO();
		BankBookDTO bankBookDTO = new BankBookDTO();
//		bankBookDTO.setBooknum(ca.getTimeInMillis());
//		bankBookDTO.setBookname("저축통장3");
//		bankBookDTO.setBookrate(2.56);
//		bankBookDTO.setBooksale(1);
		try {
//			int result = bankBookDAO.setBankBook(bankBookDTO);
//			System.out.println(result);
			ar = bankBookDAO.getList();
//			for(BankBookDTO bDTO : ar) {
//				System.out.println(bDTO.getBooknum());
//				System.out.println(bDTO.getBookname());
//				System.out.println(bDTO.getBookrate());
//				System.out.println(bDTO.getBooksale());
//			}

			System.out.println("booksale 수정할 일련번호 입력");
			long select = sc.nextLong();
			for(BankBookDTO bDTO:ar) {
				if(select == bDTO.getBookNum()) {
					bankBookDTO.setBookNum(select);
				}
			}
			
			
			if(bankBookDTO.getBookNum() != null) {
				System.out.println("1 or 0");
				int num = sc.nextInt();
				bankBookDTO.setBookSale(num);
				int result = bankBookDAO.setChangeSale(bankBookDTO);
				System.out.println(result);
			}else {
				System.out.println("x");
			}
			
			
//			System.out.println("찾을 일련번호 입력");
//			long select = sc.nextLong();
//			
//			for(BankBookDTO bDTO : ar) {
//				if(select == bDTO.getBooknum()) {
//					bankBookDTO.setBooknum(bDTO.getBooknum());
//				}
//			}
//			
//			if(bankBookDTO.getBooknum() != null) {
//				bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
//				System.out.println(bankBookDTO.getBooknum());
//				System.out.println(bankBookDTO.getBookname());
//				System.out.println(bankBookDTO.getBookrate());
//				System.out.println(bankBookDTO.getBooksale());
//				System.out.println(bankBookDTO != null);
//			}else {
//				System.out.println("x");
//			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
