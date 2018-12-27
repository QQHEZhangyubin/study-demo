package com.zhang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequeryController {
	@RequestMapping("/requery")
	
	public String requery(ModelMap map) {
		map.addAttribute("message", "11254");
		return "requery";
	}

}
