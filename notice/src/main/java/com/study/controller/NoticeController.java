package com.study.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.model.NoticeDTO;
import com.study.model.NoticeServiceImpl;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeServiceImpl service;
	
	@GetMapping("create")
	public String create() {
		return "/create";
	}
	
	@PostMapping("create")
	public String create(NoticeDTO dto) {
		
		if(service.create(dto)==1){
			return "redirect:list";
		}else {
			return "/error";
		}
		
	}
	
	@RequestMapping("list")
	public String list(HttpServletRequest request) {
		//검색 관련 --------------------
		String col = Utility.checkNull(request.getParameter("col"));
		String word = Utility.checkNull(request.getParameter("word"));
		
		if(col.equals("total")) {
			word="";
		}
		
		//
		
		
	}
	
	@GetMapping
	public String home(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("severTime", formattedDate);
		
		return "/home";
		
		
	}
	

	

}
