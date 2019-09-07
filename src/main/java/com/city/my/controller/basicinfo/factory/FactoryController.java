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
	
	//�б�
	@RequestMapping("/basicinfo/factory/list.action")
	public String list(Model model) {
		List<Factory> dataList=factoryservice.find(null);
		//System.out.println("����"+dataList.get(0).getFactoryName());
		model.addAttribute("dataList", dataList);
		return "/basicinfo/factory/jFactoryList.jsp";
	}
	//ת������ҳ��
	@RequestMapping("/basicinfo/factory/tocreate.action")
	public String tocreate() {
		
		return "/basicinfo/factory/jFactoryCreate.jsp";
	}
	//����
	@RequestMapping("/basicinfo/factory/insert.action")
	public String insert(Factory factory) {
		factoryservice.insert(factory);
		return "redirect:/basicinfo/factory/list.action";
	}
	//ת���޸�ҳ��
	@RequestMapping("/basicinfo/factory/toupdate.action")
	public String toupdate(String id,Model model) {
		Factory obj=factoryservice.get(id);
		model.addAttribute("obj", obj);
		return "/basicinfo/factory/jFactoryUpdate.jsp";
	}
	//�޸�
	@RequestMapping("/basicinfo/factory/update.action")
	public String update(Factory factory) {
		factoryservice.update(factory);
		return "redirect:/basicinfo/factory/list.action";
	}
	//ɾ��
	@RequestMapping("/basicinfo/factory/deleteById.action")
	public String deleteById(String id) {
		factoryservice.deleteById(id);
		return "redirect:/basicinfo/factory/list.action";
	}
	
	//ɾ�����
	@RequestMapping("/basicinfo/factory/delete.action")
	public String delete(@RequestParam("id")String[] ids) {
		factoryservice.delete(ids);
		return "redirect:/basicinfo/factory/list.action";
	}
	//�鿴
	@RequestMapping("/basicinfo/factory/toview.action")
	public String toview(String id, Model model){
		Factory obj = factoryservice.get(id);
		model.addAttribute("obj", obj);
		return "/basicinfo/factory/jFactoryView.jsp";
	}
	//��������
	@RequestMapping("/basicinfo/factory/start.action")
	public String start(@RequestParam("id")String[] ids){
		factoryservice.start(ids);
			
		return "redirect:/basicinfo/factory/list.action";
	}
		
	//����ͣ��
	@RequestMapping("/basicinfo/factory/stop.action")
	public String stop(@RequestParam("id")String[] ids){
		factoryservice.stop(ids);
			
		return "redirect:/basicinfo/factory/list.action";
	}
}
