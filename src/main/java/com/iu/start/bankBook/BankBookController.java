package com.iu.start.bankBook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {
	
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list() {
		System.out.println("list 실행");
		return "bankbook/list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(Long booknum) {
		System.out.println("detail");
		System.out.println("booknum:"+booknum);
		return "bankbook/detail";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() {
		System.out.println("add");
		return "bankbook/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("Add post 실행");
		BankBookDAO bankBookDAO = new BankBookDAO();

		int result = bankBookDAO.setBankBook(bankBookDTO);
		System.out.println(result==1);
		return "bankbook/add";
	}
		
	
	
	
}
