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
		return new ModelAndView("redirect:member_list.do"); //redirect는 관계가 끊어지는 거고(forward는 값을 유지하는것)
		// 즉 관계를 끊고 새로고침해서 추가된 정보를 디비에서 새로 퍼서 받는다. forward는 관계를 유지하기 때문에 새로 넣은 값이 반영이 안된다
		
	}

}
