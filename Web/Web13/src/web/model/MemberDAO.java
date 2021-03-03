package web.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import web.util.Member;
import web.util.MyException;

public class MemberDAO {
	
	public MemberDAO() throws MyException {
		// 1. 드라이버 등록
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); //개발시점을 위해서. 실행시점엔 지워야 함
			throw new MyException("드라이버 등록 오류");
		}
	}
	
	public void memberInsert(Member m) throws MyException {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			// 2. Connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "cafe", "1234");
			
			// 3. Statement
			stmt = con.prepareStatement("insert into member(memid,memname,subject,pw) values(?,?,?,?)");
			
			// 4. SQL 전송
			stmt.setString(1, m.getId());
			stmt.setString(2, m.getName());
			String subject = "";
			for(String s:m.all_subject) {
				subject += s + ",";
			}
			stmt.setString(3, subject); // ex. java,c,python,
			stmt.setString(4, m.getPw());
			int i = stmt.executeUpdate();
			
			// 5. 결과 확인
			System.out.println(i+"행이 insert되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MyException("회원 가입 오류");
		} finally {
			// 6. 종료(자원 닫기)
			try {
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Member> listMembers() throws MyException{
		List<Member> list = new ArrayList<Member>();
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// 2. Connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "cafe", "1234");
			
			// 3. Statement
			stmt = con.prepareStatement("select * from member");
			
			// 4. SQL 전송
			rs = stmt.executeQuery();
			// 5. SQL의 결과 얻기
			while(rs.next()) {
				String id = rs.getString("memid");
				String name = rs.getString("memname");
				String pw = rs.getString("pw");
				Member m = new Member(id,pw,name);
				list.add(m);
			}
			return list;
		} catch(SQLException e) {
			e.printStackTrace();
			throw new MyException("모든 고객 조회 실패");
		} finally {
			// 6. 종료(자원 닫기)
			try {
				if(rs!=null) rs.close();
				if (stmt != null) stmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {

			}
		}
	}

	public String login(String id, String pw) throws MyException {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			// 2. Connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "cafe", "1234");

			// 3. Statement
			stmt = con.prepareStatement("select * from member where memid=? and pw=?");
			stmt.setString(1, id);
			stmt.setString(2, pw);
			
			// 4. SQL 전송
			rs = stmt.executeQuery();
			// 5. SQL의 결과 얻기
			if (rs.next()) {
				String name = rs.getString("memname");
				return name;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MyException("로그인 실패");
		} finally {
			// 6. 종료(자원 닫기)
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {

			}
		}
	}
}
