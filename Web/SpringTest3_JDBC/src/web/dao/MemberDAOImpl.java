package web.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import web.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO{

	private JdbcTemplate jdbcTemplate; // Spring에 있는 것. new로 객체화하여 사용
	
	// dbcp
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<MemberVO> selectAllMembers() {
		// DB 연동
		String sql="select * from member order by memdate desc";
		
		// RowMapper()를 anonymous inner class 형식으로 만듦
		List<MemberVO> list = jdbcTemplate.query(sql, new RowMapper<MemberVO>(){

			@Override
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				String id = rs.getString("memid");
				String name = rs.getString("memname");
				Date date = rs.getDate("memdate");
				String pw = rs.getString("pw");
				
				// 받아온 데이터를 MemberVO에 담음
				// date가 auto-casting됨
				MemberVO m = new MemberVO(id,pw,name,date);
				System.out.println(rowNum+":"+m);
				
				return m;
			}
			
		});
		
		return list;
	}
	
}
