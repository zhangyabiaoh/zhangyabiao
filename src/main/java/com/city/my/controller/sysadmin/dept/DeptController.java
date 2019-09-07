package com.city.my.controller.sysadmin.dept;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.city.my.controller.BaseController;
import com.city.my.domain.Dept;
import com.city.my.domain.User;
import com.city.my.service.DeptService;
import com.city.my.service.UserService;
@Controller
public class DeptController  extends BaseController{

	@Resource
	DeptService deptservice;
	
	//列表
		@RequestMapping("/sysadmin/dept/list.action")
		public String list(Model model) {
			List<Dept> dataList=deptservice.find(null);
			//System.out.println("测试"+dataList.get(0).getFactoryName());
			model.addAttribute("dataList", dataList);
			return "/sysadmin/dept/deptList.jsp";
		}
		//转向新增页面
		@RequestMapping("/sysadmin/dept/tocreate.action")
		public String tocreate() {		
			return "/sysadmin/dept/deptCreate.jsp";
		}
		//新增
		@RequestMapping("/sysadmin/dept/insert.action")
		public String insert(Dept dept) {
			deptservice.insert(dept);
			return "redirect:/sysadmin/dept/list.action";
		}
		//删除
		@RequestMapping("/sysadmin/dept/deleteById.action")
		public String deleteById(String id) {
			deptservice.deleteById(id);
			return "redirect:/sysadmin/dept/list.action";
		}
			
		//删除多个
		@RequestMapping("/sysadmin/dept/delete.action")
		public String delete(@RequestParam("id")String[] ids) {
			deptservice.delete(ids);
			return "redirect:/sysadmin/dept/list.action";
		}
		//查看
		@RequestMapping("/sysadmin/dept/toview.action")
		public String toview(String id, Model model){
			Dept obj = deptservice.get(id);
			model.addAttribute("obj", obj);
			return "/sysadmin/dept/deptView.jsp";
		}
}
