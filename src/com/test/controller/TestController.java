package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class TestController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mv = new ModelAndView(); //ModelAndView 는 객체라고 생각 하면 되것다
		mv.addObject("data","controller에서 저장한 데이터");
		mv.setViewName("WEB-INF/jsp/result.jsp");
		return mv;
		
	}

}
