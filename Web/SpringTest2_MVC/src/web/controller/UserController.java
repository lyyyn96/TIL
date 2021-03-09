package web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController{
	
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception{

		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		mav.addObject("id", id);
		mav.addObject("pw", pw);
		mav.addObject("name", name);
		mav.addObject("email", email);
		
		mav.setViewName("memberInfo"); // test/memberInfo.jsp로 감
		
		return mav;
	}
	
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String userID = "";
		String passwd = "";
		String viewName = getViewName(request);
		
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		userID = request.getParameter("userID");
		passwd = request.getParameter("passwd");
		
		mav.addObject("userID", userID);
		mav.addObject("passwd", passwd);
		
		mav.setViewName(viewName);
		System.out.println("viewName:"+viewName);
		//mav.setViewName("result"); // test/result.jsp로 감
		
		return mav;
	}
	
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if(uri==null || uri.trim().equals("")){
			uri = request.getRequestURI();
		}
		
		int begin = 0;
		if(!((contextPath==null)||("".equals(contextPath)))) {
			begin = contextPath.length(); // 전체 요청명 의 길이를 구함
		}
		
		int end;
		if(uri.indexOf(";")!=-1){
	         end=uri.indexOf(";");  //요청 uri에 ';'가 있을 경우 ';'문자 위치를 구함
	    }else if(uri.indexOf("?")!=-1){
	         end=uri.indexOf("?");   //요청 uri에 '?'가 있을 경우 '?' 문자 위치를 구함
	    }else{
	         end=uri.length();
	    }

	      //http://localhost:7777/member/listMember.do로 요청시
		  //먼저 '.do'를 제거한 http://localhost:7777/member/listMember를 구한 후,
	      //다시 http://localhost:7777/member/listMember에서
		  //역순으로 첫번째 '/' 위치를 구한 후, 그 뒤의 listMember를 구한다.
	      String fileName=uri.substring(begin,end);
	      if(fileName.indexOf(".")!=-1){
	         fileName=fileName.substring(0,fileName.lastIndexOf("."));  //요청명에서 역순으로 최초 '.'의 위치를 구한후, '.do' 앞에까지의 문자열을 구함
	      }
	      if(fileName.lastIndexOf("/")!=-1){
	         fileName=fileName.substring(fileName.lastIndexOf("/"),fileName.length()); //요청명에서 역순으로 최초 '/'의 위치를 구한후, '/' 다음부터의 문자열을 구함  
	      }
	      return fileName;
	}
}
