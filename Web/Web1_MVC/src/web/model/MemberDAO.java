package web.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.*;
import javax.sql.DataSource;

import web.util.Member;
import web.util.MyException;

public class MemberDAO {
	DataSource dbcp;

	public MemberDAO() throws MyException {
		try {
			Context ic = new InitialContext();
			Context ic2 = (Context) ic.lookup("java:comp/env");
			dbcp = (DataSource) ic2.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
			throw new MyException("connection pool 찾기 오류");
		}
	}

	public String login(String id, String pw) throws MyException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = dbcp.getConnection();
			stmt = con.prepareStatement("select memname from member where memid=? and pw=?");
			stmt.setString(1, id);
			stmt.setString(2, pw);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
			return null;
		}catch(SQLException e) {
			e.printStackTrace();
			throw new MyException("로그인 처리 실패");
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {

			}
		}
	}// end login

	public List<Member> memberList() throws MyException {
		List<Member> list = new ArrayList<Member>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = dbcp.getConnection();
			stmt = con.prepareStatement("select * from member");
			rs = stmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("memid");
				String pw = rs.getString("pw");
				String name = rs.getString("memname");
				
				Member m = new Member(id, pw, name);
				list.add(m);
			}
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
			throw new MyException("모든 회원 보기 실패");
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {

			}
		}
	}

	public void memberInsert(Member m) throws MyException {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = dbcp.getConnection();
			stmt = con.prepareStatement("insert into member(memid,pw,memname) values(?,?,?)");
			stmt.setString(1, m.getId());
			stmt.setString(2, m.getPw());
			stmt.setString(3, m.getName());
			int i = stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new MyException("회원가입 실패");
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {

			}
		}
	}

	public void memberDelete(String id) throws MyException {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = dbcp.getConnection();
			stmt = con.prepareStatement("delete from member where memid=?");
			stmt.setString(1, id);
			stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new MyException("회원 삭제 실패");
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {

			}
		}
	}
	
}// end class
