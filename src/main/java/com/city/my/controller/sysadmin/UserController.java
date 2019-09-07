package com.city.my.controller.sysadmin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.city.my.controller.BaseController;
import com.city.my.domain.Factory;
import com.city.my.domain.User;
import com.city.my.service.UserService;

@Controller
public class UserController extends BaseController{

	@Resource
	UserService userservice;
	//列表
	@RequestMapping("/sysadmin/list.action")
	public String list(Model model) {
		List<User> dataList=userservice.find(null);
		//System.out.println("测试"+dataList.get(0).getFactoryName());
		model.addAttribute("dataList", dataList);
		return "/sysadmin/user/userList.jsp";
	}
	//转向新增页面
	@RequestMapping("/sysadmin/tocreate.action")
	public String tocreate() {		
		return "/sysadmin/user/userCreate.jsp";
	}
	//新增
	@RequestMapping("/sysadmin/insert.action")
	public String insert(User user) {
		userservice.insert(user);
		return "redirect:/sysadmin/list.action";
	}
	//删除
	@RequestMapping("/sysadmin/deleteById.action")
	public String deleteById(String id) {
		userservice.deleteById(id);
		return "redirect:/sysadmin/list.action";
	}
		
	//删除多个
	@RequestMapping("/sysadmin/delete.action")
	public String delete(@RequestParam("id")String[] ids) {
		userservice.delete(ids);
		return "redirect:/sysadmin/list.action";
	}
	//查看
	@RequestMapping("/sysadmin/toview.action")
	public String toview(String id, Model model){
		User obj = userservice.get(id);
		model.addAttribute("obj", obj);
		return "/sysadmin/user/userView.jsp";
	}
}
