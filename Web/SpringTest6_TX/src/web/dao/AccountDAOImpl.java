package web.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

	@Autowired
	SqlSession sqlSession;
	
	/*
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	*/

	@Override
	public void updateBalance1() {
		sqlSession.update("mapper.account.updateBalance1");
	}

	@Override
	public void updateBalance2() {
		sqlSession.update("mapper.account.updateBalance2");
	}

}
