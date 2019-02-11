package com.member.model;

import java.util.List;

public interface MemberDAO {
	//전체보기
	//상세보기
	//추가
	//수정
	//삭제
	
	public List<MemberDTO> getMemberList();
	public MemberDTO findById(String id);
	public void insert(MemberDTO user);
	public void update(MemberDTO user);
	public void delete(String id);

}
