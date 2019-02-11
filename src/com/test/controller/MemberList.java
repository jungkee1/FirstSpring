package com.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.member.model.MemberDAOImpl;
import com.member.model.MemberDTO;

public class MemberList extends AbstractController{
	private MemberDAOImpl dao;

	public void setDao(MemberDAOImpl dao) {
		this.dao = dao;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		List<MemberDTO> userList = dao.getMemberList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("userList",userList);
		mv.setViewName("WEB-INF/jsp/list.jsp");
		return mv;
	}

}
