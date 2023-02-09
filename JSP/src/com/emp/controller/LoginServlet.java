package com.emp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.dao.EmpDAO;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String lv = request.getParameter("lv");
	
	EmpDAO dao = EmpDAO.getInstance();
	
	// 아이디, 비번, 레벨 체크하는 메서드 호출
	// 아이디틀렸을때 -1, 비번틀렸을 때 0, 권한 틀렸을 때 1
	// 관리자로그인:2 일반사원로그인:3
	int result = dao.userCheck(id, pw, lv);
	
	if(result==2||result==3) {
		//로그인 성공처리
	} else {
		if(result==1) {
			request.setAttribute("msg", "권한이 일치하지 않습니다.");
		}else if(result==0) {
			request.setAttribute("msg", "비밀번호가 일치하지 않습니다.");
		} else {
			request.setAttribute("msg", "아이디가 존재하지 않습니다.");
			}
		
		}
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
}
