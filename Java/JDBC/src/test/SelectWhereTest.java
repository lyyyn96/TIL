package test;

import java.sql.*;

public class SelectWhereTest {
	
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		// 1. driver 등록
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver ok");
			
		// 2. 연결
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
				"Shop", "1234");
		System.out.println("con ok");
		
		// 3. Statement 생성
		stmt = con.createStatement();
		
		// 4. SQL 전송
		rs = stmt.executeQuery("select * from membertbl "
				+ "where memberaddress LIKE '%"+args[0]+"%'");
		
		// 5. SQL문의 결과 얻기
		while(rs.next()) {
			String id = rs.getString("memberid");
			String name = rs.getString("membername");
			String addr = rs.getString(3);
			System.out.println(id+":"+name+":"+addr);
		}
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
