package web.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import web.vo.MemberVO;

public class MemberDAO {
	
	// ovrride한 init() 안의 내용으로 인해 Singleton Pattern 객체가 됨
	SqlSessionFactory sqlMapper;
	
	public MemberDAO() {
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("mybatis/SqlMapConfig.xml");
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<MemberVO> selectAllMemberList() {
		SqlSession session = sqlMapper.openSession();
		List<MemberVO> list = session.selectList("mapper.member.selectAllMemberList");
		
		return list;
	}
	
	public String login(MemberVO m) {
		SqlSession session = sqlMapper.openSession();
		String name = (String) session.selectOne("mapper.member.login", m);
		
		return name;
	}

	public MemberVO selectMemberById(String id) {
		SqlSession session = sqlMapper.openSession();
		MemberVO m = (MemberVO) session.selectOne("mapper.member.selectMemberById", id);
		
		return m;
	}

	public MemberVO selectMemberByPw(String pw) {
		SqlSession session = sqlMapper.openSession();
		MemberVO m = (MemberVO) session.selectOne("mapper.member.selectMemberByPw", pw);
		
		return m;
	}

	public void memberInsert(MemberVO m) {
		SqlSession session = sqlMapper.openSession();
		session.insert("mapper.member.memberInsert", m);
		session.commit(); // 수동 커밋이므로 커밋을 해줘야 DB에 들어감
	}
	
	public void updateMember(MemberVO m) {
		SqlSession session = sqlMapper.openSession();
		session.insert("mapper.member.updateMember", m);
		session.commit(); // 수동 커밋이므로 커밋을 해줘야 DB에 들어감
	}
	
}
