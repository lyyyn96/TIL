package web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import web.service.MemberService;
import web.vo.MemberVO;

// methodNameResolver에 해당하는 set method를 만들지 않아도 됨
// MultiActionController에 있기 때문
public class MemberControllerImpl extends MultiActionController implements MemberController{
	
	MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView("listMembers"); // WEB-INF/views/member/listMembers.jsp로 가기
		
		List<MemberVO> list = memberService.listMembers();
		mav.addObject("memberList", list);
		
		return mav;
	}
	
	@Override
	public ModelAndView removeMember(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView("removeMember"); // WEB-INF/views/member/removeMember.jsp로 가기
		
		String id = request.getParameter("id");
		memberService.removeMember(id);
		
		return mav;
	}
}
