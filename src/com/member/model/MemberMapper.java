package com.member.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MemberMapper implements RowMapper<MemberDTO>{

	@Override
	public MemberDTO mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		MemberDTO user = new MemberDTO();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPass(rs.getString("pass"));
		user.setMemo(rs.getString("memo"));
		user.setAddr(rs.getString("addr"));
		user.setReg_date(rs.getString("reg_date"));
		return user;
	}

}
