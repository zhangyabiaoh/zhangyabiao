package com.city.my.controller.basicinfo.factory;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.city.my.controller.BaseController;
import com.city.my.domain.Factory;
import com.city.my.service.FactoryService;

@Controller
public class FactoryController extends BaseController{

	@Resource
	FactoryService factoryservice;
	
	//列表
	@RequestMapping("/basicinfo/factory/list.action")
	public String list(Model model) {
		List<Factory> dataList=factoryservice.find(null);
		//System.out.println("测试"+dataList.get(0).getFactoryName());
		model.addAttribute("dataList", dataList);
		return "/basicinfo/factory/jFactoryList.jsp";
	}
	//转向新增页面
	@RequestMapping("/basicinfo/factory/tocreate.action")
	public String tocreate() {
		
		return "/basicinfo/factory/jFactoryCreate.jsp";
	}
	//新增
	@RequestMapping("/basicinfo/factory/insert.action")
	public String insert(Factory factory) {
		factoryservice.insert(factory);
		return "redirect:/basicinfo/factory/list.action";
	}
	//转向修改页面
	@RequestMapping("/basicinfo/factory/toupdate.action")
	public String toupdate(String id,Model model) {
		Factory obj=factoryservice.get(id);
		model.addAttribute("obj", obj);
		return "/basicinfo/factory/jFactoryUpdate.jsp";
	}
	//修改
	@RequestMapping("/basicinfo/factory/update.action")
	public String update(Factory factory) {
		factoryservice.update(factory);
		return "redirect:/basicinfo/factory/list.action";
	}
	//删除
	@RequestMapping("/basicinfo/factory/deleteById.action")
	public String deleteById(String id) {
		factoryservice.deleteById(id);
		return "redirect:/basicinfo/factory/list.action";
	}
	
	//删除多个
	@RequestMapping("/basicinfo/factory/delete.action")
	public String delete(@RequestParam("id")String[] ids) {
		factoryservice.delete(ids);
		return "redirect:/basicinfo/factory/list.action";
	}
	//查看
	@RequestMapping("/basicinfo/factory/toview.action")
	public String toview(String id, Model model){
		Factory obj = factoryservice.get(id);
		model.addAttribute("obj", obj);
		return "/basicinfo/factory/jFactoryView.jsp";
	}
	//批量启用
	@RequestMapping("/basicinfo/factory/start.action")
	public String start(@RequestParam("id")String[] ids){
		factoryservice.start(ids);
			
		return "redirect:/basicinfo/factory/list.action";
	}
		
	//批量停用
	@RequestMapping("/basicinfo/factory/stop.action")
	public String stop(@RequestParam("id")String[] ids){
		factoryservice.stop(ids);
			
		return "redirect:/basicinfo/factory/list.action";
	}
}
