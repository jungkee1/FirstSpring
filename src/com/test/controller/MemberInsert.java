package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.member.model.MemberDAOImpl;
import com.member.model.MemberDTO;

public class MemberInsert extends AbstractController{
	private MemberDAOImpl dao;
	//setter
	public void setDao(MemberDAOImpl dao) {
		this.dao = dao;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		MemberDTO user = new MemberDTO();
		user.setId(req.getParameter("id"));
		user.setPass(req.getParameter("pass"));
		user.setName(req.getParameter("name"));
		user.setMemo(req.getParameter("memo"));
		user.setAddr(req.getParameter("addr"));
		dao.insert(user);
		return new ModelAndView("redirect:member_list.do"); //redirect�� ���谡 �������� �Ű�(forward�� ���� �����ϴ°�)
		// �� ���踦 ���� ���ΰ�ħ�ؼ� �߰��� ������ ��񿡼� ���� �ۼ� �޴´�. forward�� ���踦 �����ϱ� ������ ���� ���� ���� �ݿ��� �ȵȴ�
		
	}

}
