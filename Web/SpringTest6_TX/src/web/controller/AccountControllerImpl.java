package web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import web.service.AccountService;

@Controller("accountController")
@RequestMapping("/account")
public class AccountControllerImpl extends MultiActionController implements AccountController{
	
	@Autowired
	AccountService accountService;

	/*
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	*/
	
	@Override
	@RequestMapping(value="/sendMoney.do", method=RequestMethod.GET)
	public ModelAndView sendMoney(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("result"); // WEB-INF/views/account/result.jsp로 감
		accountService.sendMoney();
		
		return mav;
	}
}
