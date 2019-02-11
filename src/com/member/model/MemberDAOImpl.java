package com.member.model;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class MemberDAOImpl implements MemberDAO{
	private JdbcTemplate template;
	
	//setter
	public void setTemplate(JdbcTemplate template) {
		this.template = template; //template를 new해서 만든게 아니라 xml에 적은걸 여기에 "주입"하였음 
	}
	
	
//전체보기
	@Override
	public List<MemberDTO> getMemberList() {
		// TODO Auto-generated method stub
		String sql = "select * from springmember";
		List<MemberDTO> userList = template.query(sql, new MemberMapper()); //ResultSet안해도 query를 사용하면 알아서 List형으로 반환 시켜줌
		return userList;
	}



	//상세보기
	@Override
	public MemberDTO findById(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from springmember where id = ?";
		MemberDTO user = template.queryForObject(sql, new Object[] {id}, new MemberMapper());
		return user;
	}

//추가
	@Override
	public void insert(MemberDTO user) {
		// TODO Auto-generated method stub
	String sql ="insert into springmember values(?,?,?,?,?,sysdate)";
	Object[] param = new Object[] { //최상위 object그냥 썻음
		user.getId(),user.getPass(),user.getName(),user.getAddr(),user.getMemo() //물음표 순서에 맞춰서
	};
	template.update(sql,param);
		
	}

//수정
	@Override
	public void update(MemberDTO dto) {
		// TODO Auto-generated method stub
		String sql = "update springmember set pass=?, name=?, addr=?, memo=? where id = ?";
		Object[] param = new Object[] {
				dto.getPass(),dto.getName(),dto.getAddr(),dto.getMemo(),dto.getId()
		};
		template.update(sql,param);
		
	}

//삭제
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from springmember where id = '" + id + "'";
		template.update(sql);
		//template.update(sql,id) 쿼리문에 id 대신  ? 쓰면 이렇게 써도 삭제 가능 ^
		//혹은 (sql, id) 에서 id 자리에 new Object[] {id} 이렇게도 가능
		
	}

}
