package web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//sign의 값이 memberInsert인지 login인지로 회원가입과 로그인을 나눔
		String sign = request.getParameter("sign");
		if(sign==null) {
			System.out.println("sign 값이 들어오지 않았습니다.");
			return; //더이상 밑으로 내려가지 않고 끝남
		}else if(sign.equals("memberInsert")){
			//회원가입
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String pw = request.getParameter("pw");
			String pw2 = request.getParameter("pw2");
			String mobile = request.getParameter("mobile");
			String tel = request.getParameter("tel");
			String agree = request.getParameter("agree");
			
			System.out.println(name+"\n"+email+"\n"+pw+"\n"+pw2+"\n"+mobile+"\n"+tel+"\n"+agree);
			
			RequestDispatcher rd = request.getRequestDispatcher("memberInsert_ok.jsp");
			request.setAttribute("name", name);
			rd.forward(request, response);
		}else if(sign.equals("login")) {
			//로그인
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			System.out.println(id+"\n"+pw);
			
			RequestDispatcher rd = request.getRequestDispatcher("login_ok.jsp");
			request.setAttribute("id", id);
			rd.forward(request, response);
		}
	}
}
