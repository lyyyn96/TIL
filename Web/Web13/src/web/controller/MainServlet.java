package web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.model.MemberDAO;
import web.util.Member;
import web.util.MyException;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

	MemberDAO mDao;

	// 한번만 실행
	@Override
	public void init() throws ServletException {
		super.init();

		try {
			mDao = new MemberDAO();
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			String sign = request.getParameter("sign");
			if (sign == null) {
				return;
			} else if (sign.equals("login")) {
				// 로그인 처리
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				/*
				response.setContentType("text/html;charset=utf-8"); PrintWriter out =
				response.getWriter();
				*/

				String name = mDao.login(id, pw);

				if (name != null) {
					// login ok
					// jsp에서 request, response 객체 사용 가능
					RequestDispatcher disp = request.getRequestDispatcher("login_ok.jsp");
					request.setAttribute("name", name); // jsp에 이름 name, 값 name 넘김
					disp.forward(request, response);

					// out.write(name+"님 환영합니다.");
				} else {
					// login fail
					RequestDispatcher disp = request.getRequestDispatcher("login_fail.jsp");
					disp.forward(request, response);

					// out.write("다시 로그인 해주세요.<br><a href='login.html'>다시 로그인 하기</a>");
				}

			} else if (sign.equals("memberInsert")) {
				// 회원 가입 처리
				// response.setContentType("text/html;charset=utf-8");
				// PrintWriter out = response.getWriter();

				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				String name = request.getParameter("name");
				String[] all_subject = request.getParameterValues("subject");

				/*
				for(String s:all_subject) { 
					"\t"은 불가하고 "&nbsp"가 띄어쓰기임
					out.write(s+"&nbsp;");
				}
				 */

				Member m = new Member(id, pw, name, all_subject);

				mDao.memberInsert(m);
				RequestDispatcher disp = request.getRequestDispatcher("memberInsert_ok.jsp");
				disp.forward(request, response);

				// out.write("회원가입 되셨습니다.");

			} else if (sign.equals("listMembers")) {
				// 모든 회원 보기 처리

				List<Member> list = mDao.listMembers();
				// ok
				// response.setContentType("text/html;charset=utf-8");
				// PrintWriter out = response.getWriter();
				
				RequestDispatcher disp = request.getRequestDispatcher("listMembers_ok.jsp");
				request.setAttribute("list", list);
				disp.forward(request, response);

				/*
				out.append("<form action='main'>");
				out.append("<input type='hidden' name='sign' value='memberDelete'>");
				out.append("<input name='id'><input type='submit' value='회원 삭제'></form>");
				out.append("<table border='1'>"); out.append("<tr><th>id</th><th>name</th>");
				for(Member m:list) {
				out.append("<tr><td>"+m.getId()+"</td><td>"+m.getName()+"</td></tr>"); }
				out.append("</table>");
				*/

			} else if (sign.equals("memberDelete")) {
				String id = request.getParameter("id");

				// response.setContentType("text/html;charset=utf-8");
				// PrintWriter out = response.getWriter();

				mDao.deleteMember(id);
				RequestDispatcher disp = request.getRequestDispatcher("memberDelete_ok.jsp");
				request.setAttribute("id", id);
				disp.forward(request, response);

				// out.append(id+"님을 삭제했습니다.<br><a href='index.html'>첫 화면으로 가기</a>");
			}
		} catch (MyException e) {
			RequestDispatcher disp = request.getRequestDispatcher("error.jsp");
			disp.forward(request, response);
			
			//out.write(e.getMessage());
		}
	}
}
