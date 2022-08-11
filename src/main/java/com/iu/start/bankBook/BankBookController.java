package com.iu.start.bankBook;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {
	
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		//ModelAndView mv = new ModelAndView();
		System.out.println("list 실행");
		BankBookDAO bankBookDAO = new BankBookDAO();
		ArrayList<BankBookDTO> ar = bankBookDAO.getList();
		model.addAttribute("list", ar);
		return "bankbook/list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("detail");
		System.out.println("booknum:"+ bankBookDTO.getBooknum());
		BankBookDAO bankBookDAO = new BankBookDAO();
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		//return "bankbook/detail";
		mv.setViewName("bankbook/detail");
		mv.addObject("detail", bankBookDTO);
		
		return mv;
	}
	
	// /WEB-INF/views/bankbook/add.jsp
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws Exception {
		System.out.println("add get 실행");
		//return "bankbook/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO,ModelAndView mv) throws Exception {
		System.out.println("Add post 실행");
		BankBookDAO bankBookDAO = new BankBookDAO();

		int result = bankBookDAO.setBankBook(bankBookDTO);
		System.out.println(result==1);
		
		mv.setViewName("redirect:./list");
		//등록 후 list 페이지로 이동
		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO,Model model) throws Exception {
		System.out.println("Update 폼");
		BankBookDAO bankBookDAO = new BankBookDAO();
		System.out.println("번호:"+bankBookDTO.getBooknum());
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		model.addAttribute("update", bankBookDTO);

	}
	
	@RequestMapping(value = "update" , method = RequestMethod.POST)
	public ModelAndView update(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception {
		System.out.println("Update 전송");
		BankBookDAO bankBookDAO = new BankBookDAO();
		int result = bankBookDAO.setUpdate(bankBookDTO);
		System.out.println(result==1);

		mv.setViewName("redirect:./detail?booknum="+bankBookDTO.getBooknum());
		
		return mv;
	}
	
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public String delete(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("삭제");
		BankBookDAO bankBookDAO = new BankBookDAO();
		int result = bankBookDAO.setDelete(bankBookDTO);
		System.out.println(result==1);
		
		return "redirect:./list";
		
	}
	
	
}
