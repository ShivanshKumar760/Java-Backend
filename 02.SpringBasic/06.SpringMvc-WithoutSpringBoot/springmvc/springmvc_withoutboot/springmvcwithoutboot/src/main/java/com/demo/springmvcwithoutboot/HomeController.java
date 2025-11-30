package com.demo.springmvcwithoutboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@PostMapping("/add")
	public ModelAndView add(@RequestParam("num1") int num1,@RequestParam("num2") int num2,ModelAndView mv) {
	
		int result=num1+num2;
		mv.addObject("result",result);
		mv.setViewName("addResult");
		return mv;
		
	}
	
	@PostMapping("/addAlien")
	public String addAlien(@ModelAttribute Alien alien) {
		return "result";
	}
	

}
