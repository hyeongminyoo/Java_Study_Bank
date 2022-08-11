package com.iu.start.bankBook;

import java.util.ArrayList;

public interface BookDAO {
	
	
	public int setDelete(BankBookDTO bankBookDTO) throws Exception;
	
	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception;
	
	//BANKBOOK 테이블에 인서트 
	//BOOKNUM은 현재 시간을 밀리세컨즈로 변환하여 입력
	//BOOKSALE은 처음엔 무조건 1로 입력
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception;
	
	//BankBook 모든 데이터를 조회
	//최신 순으로(
	public ArrayList<BankBookDTO> getList() throws Exception;
	
	//BOOKSALE의 값을 수정
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception;
	
	//BookNum의 값으로 조회
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception;
}
