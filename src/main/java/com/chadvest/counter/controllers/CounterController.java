package com.chadvest.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")
public class CounterController {
	
	@RequestMapping("")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 1);			
		}
		else {
			
			session.setAttribute("count", (Integer) session.getAttribute("count")+1);
		}
		return "index";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("currentCount", currentCount);
		return "counter";
	}
	
	@RequestMapping("/clear")
	public String clear(HttpSession session) {
		session.setAttribute("count", 0);
		return "redirect:/your_server/counter";
	}
	
}
