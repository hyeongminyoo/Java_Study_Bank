package com.iu.start.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.iu.start.bankMembers.BankMembersDAO;
import com.iu.start.bankMembers.BankMembersDTO;

public class BankMembersTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
//		BankMembersDTO bankMembersDTO = new BankMembersDTO();
//		bankMembersDTO.setUsername("id4");
//		bankMembersDTO.setPassword("pw4");
//		bankMembersDTO.setName("name4");
//		bankMembersDTO.setEmail("Email4");
//		bankMembersDTO.setPhone("phone4");

		try {
//			int result = bankMembersDAO.setJoin(bankMembersDTO);
//			System.out.println(result);
			
//			System.out.println("검색할 id 입력");
//			String search = sc.next();
//			ArrayList<BankMembersDTO> ar = bankMembersDAO.getSearchByID(search);
//			System.out.println(ar.size()>0);
//			for(BankMembersDTO bmDTO : ar) {
//				System.out.println(bmDTO.getUsername());
//			}
			BankMembersDTO bankMembersDTO = new BankMembersDTO();
			bankMembersDTO.setUserName("id7");
			bankMembersDTO.setPassword("pw7");
			bankMembersDTO = bankMembersDAO.getLogin(bankMembersDTO);
			System.out.println(bankMembersDTO.getUserName());
			System.out.println(bankMembersDTO.getName());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
