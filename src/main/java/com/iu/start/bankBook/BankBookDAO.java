package com.iu.start.bankBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import com.iu.start.util.DBConnector;

public class BankBookDAO implements BookDAO {

	@Override
	//BANKBOOK 테이블에 인서트 
	//BOOKNUM은 현재 시간을 밀리세컨즈로 변환하여 입력
	//BOOKSALE은 처음엔 무조건 1로 입력
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {
		
		GregorianCalendar ca = new GregorianCalendar();
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		//2. Query문 작성
		String sql = "INSERT INTO BANKBOOK VALUES(?,?,?,?)";
		//3. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		//?값 세팅
		st.setLong(1, ca.getTimeInMillis());
		st.setString(2, bankBookDTO.getBookname());
		st.setDouble(3, bankBookDTO.getBookrate());
		st.setInt(4, 1);
		
		//5. 최종 전송 후 결과처리
		int result = st.executeUpdate();
		
		//6. 종료
		DBConnector.disConnect(st, con);
		
		return result;
	}
	
	//BankBook 모든 데이터를 조회
	//최신 순으로(
	@Override
	public ArrayList<BankBookDTO> getList() throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM BANKBOOK ORDER BY BOOKNUM ASC";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
		
		while(rs.next()) {
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBooknum(rs.getLong("BOOKNUM"));
			bankBookDTO.setBookname(rs.getString("BOOKNAME"));
			bankBookDTO.setBookrate(rs.getDouble("BOOKRATE"));
			bankBookDTO.setBooksale(rs.getInt("BOOKSALE"));
			ar.add(bankBookDTO);
		}
		
		DBConnector.disConnect(rs, st, con);
		
		
		return ar;
	}
	
	//BOOKSALE의 값을 수정
	@Override
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		
		String sql = "UPDATE BANKBOOK SET BOOKSALE = ? WHERE BOOKNUM = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, bankBookDTO.getBooksale());
		st.setLong(2, bankBookDTO.getBooknum());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		
		return result;
	}
	
	//BookNum의 값으로 조회
	@Override
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		
		BankBookDTO bankBookDTO2 = null;
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUM = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, bankBookDTO.getBooknum());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			bankBookDTO2 = new BankBookDTO();
			bankBookDTO2.setBooknum(rs.getLong("BOOKNUM"));
			bankBookDTO2.setBookname(rs.getString("BOOKNAME"));
			bankBookDTO2.setBookrate(rs.getDouble("BOOKRATE"));
			bankBookDTO2.setBooksale(rs.getInt("BOOKSALE"));
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return bankBookDTO2;
	}
	

}
