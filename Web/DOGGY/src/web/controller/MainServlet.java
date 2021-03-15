package web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.model.MemberDAO;
import web.util.Member;
import web.util.MyException;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

	MemberDAO mDao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		try {
			mDao = new MemberDAO();
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			String sign = request.getParameter("sign");
			
			if(sign==null) {
				throw new MyException("요청을 구별할 수 없습니다.");
			}else if(sign.equals("login")) {
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				String name = mDao.login(id,pw);
				if(name!=null) {
					//세션 설정
					HttpSession session = request.getSession(true);
					session.setAttribute("login_name", name);
					
					RequestDispatcher disp = request.getRequestDispatcher("login_ok.jsp");
					request.setAttribute("name", name);
					disp.forward(request, response);
				}else {
					RequestDispatcher disp = request.getRequestDispatcher("login_fail.jsp");
					disp.forward(request, response);
				}
			}else if(sign.equals("memberList")) {
				List<Member> list = mDao.memberList();
				RequestDispatcher disp = request.getRequestDispatcher("memberList_ok.jsp");
				request.setAttribute("list", list);
				disp.forward(request, response);
			}else if(sign.equals("memberInsert")) {
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				String name = request.getParameter("name");
				
				System.out.println(id+":"+pw+":"+name);
				Member m = new Member(id, pw, name);
				mDao.memberInsert(m);
				RequestDispatcher disp = request.getRequestDispatcher("memberInsert_ok.jsp");
				disp.forward(request, response);
			}else if(sign.equals("memberDelete")) {
				String id = request.getParameter("id");
				
				mDao.memberDelete(id);
				RequestDispatcher disp = request.getRequestDispatcher("memberDelete_ok.jsp");
				disp.forward(request, response);
			}else if(sign.equals("basketInsert")) {
				//장바구니에 상품 넣기 처리
				//request로 부터 로그인을 했을 때만 session을 줌
				HttpSession session = request.getSession(false);
				if(session==null) {
					RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
					disp.forward(request, response);
				}else {
					String name = (String)session.getAttribute("login_name");
					if(name==null) {
						RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
						disp.forward(request, response);
					}else {
						//세션도 있고 name도 있는 로그인 정상 상태
						//냉장고, TV, 세탁기가 모두 product면 안되므로
						//basket의 이름, 주소의 값을 주어 ArrayList를 만듦
						//String product = request.getParameter("product");
						ArrayList<String> list = (ArrayList<String>)session.getAttribute("basket");
						if(list==null) {
							list = new ArrayList<String>();
							session.setAttribute("basket", list); //최초 장바구니 세팅
						}
						String product = request.getParameter("product");
						list.add(product);
						RequestDispatcher disp = request.getRequestDispatcher("basketInsert_ok.jsp");
						disp.forward(request, response);
					}
				}
			}
		}catch(MyException e) {
			RequestDispatcher disp = request.getRequestDispatcher("error.jsp");
			disp.forward(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}


