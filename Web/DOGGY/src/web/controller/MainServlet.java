package web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
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

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import web.model.MemberDAO;
import web.model.MemberVO;
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
			
			/*
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			JSONObject resJson = new JSONObject();
			
			BufferedReader br = request.getReader();
			JSONObject reqJson = (JSONObject) JSONValue.parse(br);
			String sign = (String) reqJson.get("sign");
			*/
			
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
				List<MemberVO> list = mDao.memberList();
				RequestDispatcher disp = request.getRequestDispatcher("memberList_ok.jsp");
				request.setAttribute("list", list);
				disp.forward(request, response);
			}else if(sign.equals("memberInsert")) {
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				String name = request.getParameter("name");
				
				//System.out.println(id+":"+pw+":"+name);
				MemberVO m = new MemberVO(id, pw, name);
				mDao.memberInsert(m);
				
				RequestDispatcher disp = request.getRequestDispatcher("memberInsert_ok.jsp");
				request.setAttribute("name", name);
				disp.forward(request, response);
			}else if(sign.equals("memberDelete")) {
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				
				mDao.memberDelete(id, pw);
				RequestDispatcher disp = request.getRequestDispatcher("memberDelete_ok.jsp");
				request.setAttribute("id", id);
				disp.forward(request, response);
			}else if(sign.equals("basketInsert")) {
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
						ArrayList<String> list = (ArrayList<String>)session.getAttribute("basket");
						if(list==null) {
							list = new ArrayList<String>();
							session.setAttribute("basket", list);
						}
						String product = request.getParameter("product");
						list.add(product);
						RequestDispatcher disp = request.getRequestDispatcher("basketInsert_ok.jsp");
						disp.forward(request, response);
					}
				}
			}else if(sign.equals("logout")) {
				HttpSession session = request.getSession(false);
				if(session!=null) {
					session.invalidate();
					RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
					disp.forward(request, response);
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


