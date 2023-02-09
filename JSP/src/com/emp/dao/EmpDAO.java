package com.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.emp.vo.EmpVO;

public class EmpDAO {
	
	private EmpDAO() {
		
	}
	private static EmpDAO instance = new EmpDAO();
	
	public static EmpDAO getInstance() {
		return instance;
	}
	public Connection getConnection() throws Exception{
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();
		
		return conn;
	}
	 
	public int userCheck(String id, String pw, String lv) {
		 int result=0; // 결과값 저장
		 
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 
		 String sql= "select*from emp where id=?";
		 
		 try {
			 conn = getConnection();
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setString(1, id);
			 
			 rs= pstmt.executeQuery(); // executeQuery로 쿼리 실행 시킨 후 rs라는 객체에 저장 
			 
			 if(rs.next()) {
				 if(pw.equals(rs.getString("pw"))) {
					 //아이디도 일치, 비밀번호도 일치
					 if(lv.equals(rs.getString("lv"))) {
						 // 아이디도 일치, 비번도 일치, 권한 일치
						 if(lv.equals("A"))
							 result =2; // 권한이 관리자 
						 else 
							 result =3; // 권한이 일반사원
					 } else {
						 // 아이디와 비번은 일치하는데 권한이 일치하지않음
						 result=1;
					 }
				 }else {
					 // 아이디는 일치하는데 비번이 일치하지않음
					 result=0;
				 }
			 }else {
				 result = -1; // 아이디가 틀림
			 }
		 } catch(Exception e) {
			e.printStackTrace();
		 } finally {
			 try {
				 rs.close();
				 pstmt.close();
				 conn.close();
			 } catch(Exception e) {
				 e.printStackTrace();
			 }
		 }
		return result;
	}

	public EmpVO getEmp(String id) {
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 
		 EmpVO vo =null;
		 
		 String sql= "select*from emp where id=?";
		 
		 try {
			 conn = getConnection();
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setString(1, id);
			 
			 rs= pstmt.executeQuery(); // executeQuery로 쿼리 실행 시킨 후 rs라는 객체에 저장 
			 
			 if(rs.next()) {
				 vo = new EmpVO();
				 
				 vo.setId(rs.getString("id"));
				 vo.setPw(rs.getString("pw"));
				 vo.setName(rs.getString("name"));
				 vo.setLv(rs.getString("lv"));
				 vo.setEnter(rs.getDate("enter"));
				 vo.setGender(rs.getString("gender"));
				 vo.setPhone(rs.getString("phone"));
			 }
		     } catch(Exception e) {
				e.printStackTrace();
			 } finally {
				 try {
					 rs.close();
					 pstmt.close();
					 conn.close();
				 } catch(Exception e) {
					 e.printStackTrace();
				 }
			 }
			return vo;
		}
}
