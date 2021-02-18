package test;

import java.sql.*;

public class InsertTest {
	
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		//Statement stmt = null;
		ResultSet rs = null;
		
		// 1. driver 등록
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver ok");
			
		// 2. 연결
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
				"cafe", "1234");
		System.out.println("con ok");
		
		// 3. Statement 생성
		//stmt = con.createStatement();
		stmt = con.prepareStatement("insert into member (memid, memname, memdate, phone, point) values (?,?,?,?,?)");
		stmt.setString(1, args[0]);
		stmt.setString(2, args[1]);
		//java.sql에 있는 Date가 아니라 java.util에 있는 Date를 쓰려면
		//java.util.Date now = new java.util.Date();
		//하지만 ui가 아니라 sql을 수행하는 class 이므로 java.sql에 있는 것이 더 적합
		//그런데 java.sql에 있는 Date는 날짜를 계산하기 힘드므로
		//java.util에 있는 Date를 사용하여 시간을 long 값으로 받아서 활용
		java.util.Date today = new java.util.Date();
		Date now = new Date(today.getTime());
		stmt.setDate(3, now);
		stmt.setString(4, args[2]);
		stmt.setInt(5, 0);
		
		// 4. SQL 전송
		int i = stmt.executeUpdate();
		//int i=stmt.executeUpdate("insert into membertbl values('"+args[0]+"','"+args[1]+"','"+args[2]+"')");
		
		// 5. SQL문의 결과 얻기
		System.out.println(i+"행이 insert되었습니다.");
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 자원 종료
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch(SQLException e) {
				
			}
		}
	}

}
