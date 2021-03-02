package web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main.naver")
public class MainServlet extends HttpServlet {

    public MainServlet() {
        super();
        System.out.println("생성자 호출됨");
    }

	public void init() throws ServletException {
		System.out.println("init 호출됨");
	}

	public void destroy() {
		System.out.println("destroy 호출됨");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service 호출됨");
		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 호출됨");
		PrintWriter out = response.getWriter();
		out.append(getServletName());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 호출됨");
	}

}
