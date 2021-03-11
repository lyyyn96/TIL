package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import web.dao.AccountDAO;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountDAO accountDAO;
	
	/*
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	*/

	@Override
	public void sendMoney() {
		accountDAO.updateBalance1();
		accountDAO.updateBalance2();
	}

}
