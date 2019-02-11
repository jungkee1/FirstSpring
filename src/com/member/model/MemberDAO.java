package com.member.model;

import java.util.List;

public interface MemberDAO {
	//��ü����
	//�󼼺���
	//�߰�
	//����
	//����
	
	public List<MemberDTO> getMemberList();
	public MemberDTO findById(String id);
	public void insert(MemberDTO user);
	public void update(MemberDTO user);
	public void delete(String id);

}
