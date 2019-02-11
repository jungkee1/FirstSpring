package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.member.model.MemberDAOImpl;
import com.member.model.MemberDTO;

public class MemberDetail extends AbstractController{
	MemberDAOImpl dao;
	public void setDao(MemberDAOImpl dao) {
		this.dao = dao;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		MemberDTO user = dao.findById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("WEB-INF/jsp/detail.jsp"); //ModelAndView의 mv 이름을 정해주고
		return mv; //실질적으로 return 해서 mv로 돌아감 (즉 실제적으로 이동 실행이 일어나는 곳이 여기)
	}

}
