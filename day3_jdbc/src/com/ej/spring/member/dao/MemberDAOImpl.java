package com.ej.spring.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.taglibs.standard.tag.rt.sql.SetDataSourceTag;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ej.spring.member.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO{

	private JdbcTemplate jdbcTemplate;
	
	public MemberDAOImpl() {
		System.out.println("public MemberDAOImpl()");
		
	}
	
	public void SetDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<MemberVO> selectAllMembers() throws DataAccessException {
		String query="select id, pwd, name, email, joinDate from t_member "
				+ "order by joinDate desc ";
		
		List<MemberVO> membersList = new ArrayList<MemberVO>();
		membersList = this.jdbcTemplate.query(query, new RowMapper<MemberVO>() {
			//RowMapper class는 한행의 관련된 데이터들을 list 처럼 묶어주는 역할(하나의 레코드를 계속 맵핑시켜줌)
			// 한행을 묶어주기 위해 객체가 필요함 => MemberVO
			
			//mapRow:한줄 을 하나의 지정한 객체로 묶은다음 객체를 리턴
			// ResultSet갖고있는 데이터가 다 떨어질때까지
			
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				MemberVO memberVO = new MemberVO();
				
				memberVO.setId(rs.getString("id"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setJoinDate(rs.getString("joinDate"));
				
				return memberVO;
			}
			
		}); //query() END
		
		return membersList;
	}
	
	@Override
	public int addMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return 0;
	}
	 
	//private DataSource dataSource; => setter =>
		//public void setDataSource(DataSource dataSource) {~~}
	  public void setDataSource(DataSource dataSource){
	 	 this.jdbcTemplate = new JdbcTemplate(dataSource);
	 	 System.out.println("this.jdbcTemplate = new JdbcTemplate(dataSource);");
	}
}



/**
 * private JdbcTemplate jdbcTemplate;
 * 
 * private DataSource dataSource;   // dataSource 이름이 바꾸면 세터도 이름 바꿔야함.
 * 
 * public void setDataSource(DataSource dataSource){
 * 	 this.jdbcTemplate = new JdbcTemplate(dataSource);
 *	 System.out.println("this.jdbcTemplate = new JdbcTemplate(dataSource);");
 * 
 * } 
**/
