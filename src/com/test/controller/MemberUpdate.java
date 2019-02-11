package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.member.model.MemberDAOImpl;
import com.member.model.MemberDTO;

public class MemberUpdate extends AbstractController{
	MemberDAOImpl dao;
	public void setDao(MemberDAOImpl dao) {
		this.dao = dao;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		MemberDTO dto = new MemberDTO();
		dto.setId(req.getParameter("id"));
		dto.setPass(req.getParameter("pass"));
		dto.setName(req.getParameter("name"));
		dto.setAddr(req.getParameter("addr"));
		dto.setMemo(req.getParameter("memo"));
		dao.update(dto);
		return new ModelAndView("redirect:member_list.do");
	}

}
