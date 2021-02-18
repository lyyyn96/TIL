package test;

import java.sql.*;

public class CreateTest {
	
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
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
		stmt = con.prepareStatement("create table product(pno integer, pname varchar2(20), price integer)");

		// 4. SQL 전송
		int i = stmt.executeUpdate(); //DDL은 0 return
		
		// 5. SQL문의 결과 얻기
		System.out.println("table이 create되었습니다.");
		
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
