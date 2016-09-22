package com.comall.requestautotest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;  

import com.comall.requestautotest.service.TestsuiteService;

@Controller
public class TestSuiteController{
	
	@Autowired
	private TestsuiteService testsuiteService;

	
	@RequestMapping(value = "/index.html")
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mView = new ModelAndView();
		String id = arg0.getParameter("testsuiteid");
		System.out.println(id);
		mView.setViewName("index");
		return mView;
	}

	@RequestMapping(value = "/runtestsuite")
	public ModelAndView runTestsuite(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mView = new ModelAndView();
		String id = arg0.getParameter("testsuiteid");
		System.out.println(id);
		mView.setViewName("index");
		return mView;
	}
	

}
