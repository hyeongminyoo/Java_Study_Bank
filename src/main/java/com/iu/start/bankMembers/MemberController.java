package com.iu.start.bankMembers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/member/*")
//이 클래스는 Controller 역할 
//Container(생명주기 관리자, 객체 생성 및 소멸 관리)에게 이 클래스의 객체를 생성을 위임 
public class MemberController {
	
	//annotation
	// @ : 설명+실행
	
	
	// /member/login
	@RequestMapping(value = "login.iu", method = RequestMethod.GET)
	public String login() {
		System.out.println("로그인 페이지");
		
		return "member/login";
		
	}
	
	@RequestMapping(value = "login.iu", method = RequestMethod.POST)
	public String login(HttpSession session,BankMembersDTO bankMembersDTO, Model model) throws Exception {
		System.out.println("DB에 로그인 실행");
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		bankMembersDTO = bankMembersDAO.getLogin(bankMembersDTO);
		model.addAttribute("member", bankMembersDTO);
		System.out.println(bankMembersDTO);
		//HttpSession session = request.getSession();
		session.setAttribute("member", bankMembersDTO);
		
		// "redirect:다시 접속할 URL 주소를 적어줌(절대경로, 상대경로)"
		return "redirect:../";
		
		
	}
	
	@RequestMapping(value = "logout.iu", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:../";
	}
	
	
	//join /member/join get
	@RequestMapping(value = "join.iu", method = RequestMethod.GET)
	public String join() {
		System.out.println("가입 get 실행");
		
		return "member/join";
		
	}
	
	//Post
	@RequestMapping(value = "join.iu", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO) throws Exception {
		System.out.println("가입 post 실행");
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
//		BankMembersDTO bankMembersDTO = new BankMembersDTO();
//		bankMembersDTO.setUsername(userName);
//		bankMembersDTO.setPassword(password);
//		bankMembersDTO.setName(name);
//		bankMembersDTO.setEmail(email);
//		bankMembersDTO.setPhone(phone);
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		System.out.println(result==1);
		return "redirect:./login.iu";
		
	}

	@RequestMapping(value = "search.iu", method = RequestMethod.GET)
	public void getSearchByID() {
		//ModelAndView mv = new ModelAndView();
		//return mv;
		//return "member/search";
		System.out.println("Search 페이지");
	}
	@RequestMapping(value ="search.iu", method = RequestMethod.POST)
	public ModelAndView getSearchByID(ModelAndView mv,String userName) throws Exception {
		System.out.println("Search 실행");
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		ArrayList<BankMembersDTO> ar =bankMembersDAO.getSearchByID(userName);
		mv.setViewName("member/list");
		mv.addObject("list", ar);
		
		return mv;
		
	}

}
