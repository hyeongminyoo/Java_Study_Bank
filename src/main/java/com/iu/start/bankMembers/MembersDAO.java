package com.iu.start.bankMembers;

import java.util.ArrayList;

public interface MembersDAO {
	
	//bankMembers 회원가입 (Insert) (아이디, 패스워드, 이름, 이메일, 전화번호) (1이면성공, 0(Exception)이면 실패)
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception;
	
	//검색어를 입력해서 ID를 찾기 (ex. abc가 포함된 id) abc 순으로
	public ArrayList<BankMembersDTO> getSearchByID(String search) throws Exception;
	
	
}
