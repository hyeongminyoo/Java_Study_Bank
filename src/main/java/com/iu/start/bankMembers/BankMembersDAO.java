package com.iu.start.bankMembers;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.start.util.DBConnector;

public class BankMembersDAO implements MembersDAO{
	

	@Override
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "SELECT USERNAME,NAME FROM BANKMEMBERS WHERE USERNAME = ? and PASSWORD = ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, bankMembersDTO.getUsername());
		st.setString(2, bankMembersDTO.getPassword());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			bankMembersDTO = new BankMembersDTO();
			bankMembersDTO.setUsername(rs.getString("USERNAME"));
			bankMembersDTO.setName(rs.getString("NAME"));
		}else {
			bankMembersDTO = null;
		}
		
		return bankMembersDTO;
	}


	@Override
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		
		//1. DB연결
		Connection con = DBConnector.getConnection();
		
		//2. Query문 작성
		String sql = "INSERT INTO BankMembers(UserName,Password, Name, Email, Phone) "
				+ "VALUES (?,?,?,?,?)";
		//3. 미리전송
		PreparedStatement st = con.prepareStatement(sql);

		//4. ?값 세팅
		st.setString(1, bankMembersDTO.getUsername());
		st.setString(2, bankMembersDTO.getPassword());
		st.setString(3, bankMembersDTO.getName());
		st.setString(4, bankMembersDTO.getEmail());
		st.setString(5, bankMembersDTO.getPhone());

		//5. 최종 전송 후 결과처리
		int result = st.executeUpdate();

		
		//6. 자원해제
		DBConnector.disConnect(st, con);

		return result;
	}
	
	
	@Override
	public ArrayList<BankMembersDTO> getSearchByID(String search) throws Exception {
		
		//1.DB 연결
		Connection con = DBConnector.getConnection();
		
		//2. Query문 작성
		String sql = "SELECT * FROM BANKMEMBERS "
				+ "WHERE USERNAME LIKE ? "
				+ "ORDER BY USERNAME ASC";
		
//		String sql = "SELECT USERNAME FROM BANKMEMBERS WHERE USERNAME LIKE '%'||?||'%' ORDER BY USERNAME ASC";
		
		//3. 미리전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값 세팅
		st.setString(1, "%"+search+"%");
		
		//5. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		
		ArrayList<BankMembersDTO> ar = new ArrayList();
		
		while(rs.next()) {
			BankMembersDTO bankMembersDTO = new BankMembersDTO();
			bankMembersDTO.setUsername(rs.getString("USERNAME"));
			bankMembersDTO.setName(rs.getString("NAME"));
			bankMembersDTO.setEmail(rs.getString("EMAIL"));
			bankMembersDTO.setPhone(rs.getString("PHONE"));
			ar.add(bankMembersDTO);
		}
		
		//6.연결 종료 후 리턴
		DBConnector.disConnect(rs, st, con);
		
		return ar;
	}
	
}
