package com.zhang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequeryController {
	@RequestMapping("/requery")
	/**
	 * Spring MVC在调用处理方法之前会创建一个隐含的模型对象，作为模型数据的存储容器
	 * 如果处理方法中的参数是map或者Modelmap,spring MVC会将模型数据的引用传递给这些参数。
	 * 在处理方法内部，开发者既可以通过该参数读取数据，也可以添加数据
	 * @param map
	 * @return
	 */
	public String requery(ModelMap map) {
		map.addAttribute("message", "11254");
		return "requery";
	}

}
