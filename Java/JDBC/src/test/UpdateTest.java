package test;

import java.sql.*;

public class UpdateTest {
	
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
				"Shop", "1234");
		System.out.println("con ok");
		
		// 3. Statement 생성
		stmt = con.prepareStatement("update membertbl set memberaddress=? where memberid=?");
		stmt.setString(1, args[0]); //서울 구로구 대림동
		stmt.setString(2, args[1]); //Kim
		
		// 4. SQL 전송
		int i = stmt.executeUpdate();
		
		// 5. SQL문의 결과 얻기
		System.out.println(i+"행이 update되었습니다.");
		
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
