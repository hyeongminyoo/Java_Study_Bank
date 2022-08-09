package com.iu.start.bankMembers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/member/*")
//이 클래스는 Controller 역할 
//Container(생명주기 관리자, 객체 생성 및 소멸 관리)에게 이 클래스의 객체를 생성을 위임 
public class MemberController {
	
	//annotation
	// @ : 설명+실행
	
	
	// /member/login
	@RequestMapping(value = "login")
	public String login() {
		System.out.println("로그인 실행");
		
		return "member/login";
		
	}
	
	//join /member/join get
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() {
		System.out.println("가입 get 실행");
		
		return "member/join";
		
	}
	
	//Post
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO) throws Exception {
		System.out.println("가입 post 실행");
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
//		BankMembersDTO bankMembersDTO = new BankMembersDTO();
//		bankMembersDTO.setUsername(username);
//		bankMembersDTO.setPassword(password);
//		bankMembersDTO.setName(name);
//		bankMembersDTO.setEmail(email);
//		bankMembersDTO.setPhone(phone);
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		System.out.println(result==1);
		return "member/join";
		
	}

	

}
