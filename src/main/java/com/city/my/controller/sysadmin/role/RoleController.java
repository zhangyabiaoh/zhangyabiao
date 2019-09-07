package com.city.my.controller.sysadmin.role;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.city.my.controller.BaseController;
import com.city.my.domain.Role;
import com.city.my.service.RoleService;

@Controller
public class RoleController extends BaseController{
	@Resource
	RoleService roleservice;
	
	//列表
		@RequestMapping("/sysadmin/role/list.action")
		public String list(Model model) {
			List<Role> dataList=roleservice.find(null);
			//System.out.println("测试"+dataList.get(0).getFactoryName());
			model.addAttribute("dataList", dataList);
			return "/sysadmin/role/roleList.jsp";
		}
		//转向新增页面
		@RequestMapping("/sysadmin/role/tocreate.action")
		public String tocreate() {		
			return "/sysadmin/role/roleCreate.jsp";
		}
		//新增
		@RequestMapping("/sysadmin/role/insert.action")
		public String insert(Role role) {
			roleservice.insert(role);
			return "redirect:/sysadmin/role/list.action";
		}
		//删除
		@RequestMapping("/sysadmin/role/deleteById.action")
		public String deleteById(String id) {
			roleservice.deleteById(id);
			return "redirect:/sysadmin/role/list.action";
		}
			
		//删除多个
		@RequestMapping("/sysadmin/role/delete.action")
		public String delete(@RequestParam("id")String[] ids) {
			roleservice.delete(ids);
			return "redirect:/sysadmin/role/list.action";
		}
		//查看
		@RequestMapping("/sysadmin/role/toview.action")
		public String toview(String id, Model model){
			Role obj = roleservice.get(id);
			model.addAttribute("obj", obj);
			return "/sysadmin/role/roleView.jsp";
		}
}
