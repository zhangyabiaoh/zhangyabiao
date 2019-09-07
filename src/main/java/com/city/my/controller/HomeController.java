package com.city.my.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.city.my.domain.User;
import com.city.my.service.UserService;

@Controller
public class HomeController {

	@Resource
	UserService userservice;
	@RequestMapping(value={"/home.action"})		
	public String login(){
		
		return "/index.jsp";			
	}
	
	@RequestMapping(value="/fmain.action")
	public String fmain(String login_name,String login_password){
		//User user=userservice.
		System.out.println("µÇÂ¼ÕË»§"+login_name);
		System.out.println("µÇÂ¼ÃÜÂë"+login_password);
		return "/home/fmain.jsp";
	}
	
	@RequestMapping(value="/title.action")
	public String title(){
		return "/home/title.jsp";
	}
	
	@RequestMapping(value="/left.action")
	public String left(){
		return "/home/left.jsp";
	}
	
	@RequestMapping(value="/main.action")
	public String main(){
		return "/home/olmsgList.jsp";			
	}
	

	
	@RequestMapping("/sysadminMain.action")
	public String sysadminMain(){
		return "/sysadmin/main.jsp";
	}
	
	@RequestMapping("/sysadminLeft.action")
	public String sysadminLeft(){
		return "/sysadmin/left.jsp";
	}

	
	
	
	@RequestMapping("/baseinfoMain.action")
	public String baseinfoMain(){
		return "/baseinfo/main.jsp";
	}
	
	@RequestMapping("/baseinfoLeft.action")
	public String baseinfoLeft(){
		return "/baseinfo/left.jsp";
	}
	
	
	
	
	@RequestMapping("/statMain.action")
	public String statMain(){
		return "/stat/main.jsp";
	}
	
	@RequestMapping("/statLeft.action")
	public String statLeft(){
		return "/stat/left.jsp";
	}
	
	
	
	@RequestMapping("/cargoMain.action")
	public String cargoMain(){
		return "/cargo/main.jsp";
	}
	
	@RequestMapping("/cargoLeft.action")
	public String cargoLeft(){
		return "/cargo/left.jsp";
	}
	
	
}
