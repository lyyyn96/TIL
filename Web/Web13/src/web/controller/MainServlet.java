package web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

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
		String sign = request.getParameter("sign");
		if(sign==null) {
			return ;
		}else if(sign.equals("login")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			PrintWriter out = response.getWriter();
			out.write(id+":"+pw);
		}else if(sign.equals("memberInsert")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String[] all_subject = request.getParameterValues("subject");
			PrintWriter out = response.getWriter();
			out.write(id+":"+pw+":"+name+"<br>");
			for(String s:all_subject) {
				//"\t"은 불가하고 "&nbsp"가 띄어쓰기임
				out.write(s+"&nbsp;");
			}
		}else if(sign.equals("memberInsert2")) {
			Enumeration totalNames = request.getParameterNames();
			while(totalNames.hasMoreElements()) {
				String name = (String)totalNames.nextElement();
				String[] values = request.getParameterValues(name);
				//MIME-TYPE 설정
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				for(String value:values) {
					//values출력하면 주소 값이 나옴
					out.append(name+":"+value+"<br>");
				}
			}
		}
	}

}
