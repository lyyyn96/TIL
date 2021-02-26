package web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

    public MainServlet() {
        System.out.println("MainServlet 객체 생성");
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출됨");
	}

	public void destroy() {
		System.out.println("destroy() 호출됨");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 호출됨");
		//해야 doGet()이나 doPost()실행 가능
		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출됨");
		login(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 호출됨");
		login(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		RequestDispatcher rd = request.getRequestDispatcher("blog.jsp");
		request.setAttribute("id", id);
		rd.forward(request, response);
		
		//model에게 id, pw를 넘기면서 로그인 처리를 요청
		
		/*//service의 실행 흐름이 .jsp로 넘어감
		//parameter table이 유지된 채로 넘어감
		RequestDispatcher rd = request.getRequestDispatcher("login_ok.jsp");
		request.setAttribute("id", id);
		request.setAttribute("pw", pw);
		rd.forward(request, response);*/
		
		/*
		//.jsp로 흐름을 넘길 것이니 필요가 없어짐
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.append("id="+id+" pw="+pw);
		out.append("<br><a href='index.html'>이전으로 가기</a>");
		out.append("<br><img src='java_duke.png'>");
		out.close();*/
	}
	
}
