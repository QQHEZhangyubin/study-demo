package com.zhang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequeryController {
	@RequestMapping("/requery")
	/**
	 * Spring MVC�ڵ��ô�����֮ǰ�ᴴ��һ��������ģ�Ͷ�����Ϊģ�����ݵĴ洢����
	 * ����������еĲ�����map����Modelmap,spring MVC�Ὣģ�����ݵ����ô��ݸ���Щ������
	 * �ڴ������ڲ��������߼ȿ���ͨ���ò�����ȡ���ݣ�Ҳ�����������
	 * @param map
	 * @return
	 */
	public String requery(ModelMap map) {
		map.addAttribute("message", "11254");
		return "requery";
	}

}
