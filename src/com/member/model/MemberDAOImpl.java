package com.member.model;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class MemberDAOImpl implements MemberDAO{
	private JdbcTemplate template;
	
	//setter
	public void setTemplate(JdbcTemplate template) {
		this.template = template; //template�� new�ؼ� ����� �ƴ϶� xml�� ������ ���⿡ "����"�Ͽ��� 
	}
	
	
//��ü����
	@Override
	public List<MemberDTO> getMemberList() {
		// TODO Auto-generated method stub
		String sql = "select * from springmember";
		List<MemberDTO> userList = template.query(sql, new MemberMapper()); //ResultSet���ص� query�� ����ϸ� �˾Ƽ� List������ ��ȯ ������
		return userList;
	}



	//�󼼺���
	@Override
	public MemberDTO findById(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from springmember where id = ?";
		MemberDTO user = template.queryForObject(sql, new Object[] {id}, new MemberMapper());
		return user;
	}

//�߰�
	@Override
	public void insert(MemberDTO user) {
		// TODO Auto-generated method stub
	String sql ="insert into springmember values(?,?,?,?,?,sysdate)";
	Object[] param = new Object[] { //�ֻ��� object�׳� ����
		user.getId(),user.getPass(),user.getName(),user.getAddr(),user.getMemo() //����ǥ ������ ���缭
	};
	template.update(sql,param);
		
	}

//����
	@Override
	public void update(MemberDTO dto) {
		// TODO Auto-generated method stub
		String sql = "update springmember set pass=?, name=?, addr=?, memo=? where id = ?";
		Object[] param = new Object[] {
				dto.getPass(),dto.getName(),dto.getAddr(),dto.getMemo(),dto.getId()
		};
		template.update(sql,param);
		
	}

//����
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from springmember where id = '" + id + "'";
		template.update(sql);
		//template.update(sql,id) �������� id ���  ? ���� �̷��� �ᵵ ���� ���� ^
		//Ȥ�� (sql, id) ���� id �ڸ��� new Object[] {id} �̷��Ե� ����
		
	}

}
