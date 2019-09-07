package com.city.my.controller.cargo.contract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.city.my.controller.BaseController;
import com.city.my.domain.ExtCproduct;
import com.city.my.domain.Factory;
import com.city.my.domain.SysCode;
import com.city.my.service.ExtCproductService;
import com.city.my.service.FactoryService;

@Controller
public class ExtCproductController extends BaseController{
	@Resource
	ExtCproductService extCproductService;
	@Resource
	FactoryService factoryService;
	
	@RequestMapping("/cargo/extcproduct/tocreate.action")
	public String tocreate(String contractProductId, Model model){
		model.addAttribute("contractProductId", contractProductId);			//���������ID
		
		//ĳ�������µĸ�����Ϣ
		Map paraMap = new HashMap();
		paraMap.put("contractProductId", contractProductId);
		List<ExtCproduct> dataList = extCproductService.find(paraMap);
		model.addAttribute("dataList", dataList);
		
		//׼���������ҵ������б�
		List<Factory> factoryList = factoryService.getFactoryList();
		model.addAttribute("factoryList", factoryList);
		
		//׼�����������б�
		List<SysCode> ctypeList = extCproductService.getCtypeList();
		model.addAttribute("ctypeList", ctypeList);
		System.out.println("......"+ctypeList.isEmpty());
		
		return "/cargo/contract/jExtCproductCreate.jsp";
	}
	
	@RequestMapping("/cargo/extcproduct/insert.action")
	public String insert(ExtCproduct extCproduct, Model model){
		extCproductService.insert(extCproduct);
		model.addAttribute("contractProductId", extCproduct.getContractProductId());		//��������ID
		
		return "redirect:/cargo/extcproduct/tocreate.action";
	}
	
	@RequestMapping("/cargo/extcproduct/toupdate.action")
	public String toupdate(String id, Model model){
		ExtCproduct obj = extCproductService.get(id);
		model.addAttribute("obj", obj);
		
		//׼���������ҵ������б�
		List<Factory> factoryList = factoryService.getFactoryList();
		model.addAttribute("factoryList", factoryList);
		
		//׼�����������б�
		List<SysCode> ctypeList = extCproductService.getCtypeList();
		model.addAttribute("ctypeList", ctypeList);
		
		System.out.println("......"+ctypeList.get(1));
		return "/cargo/contract/jExtCproductUpdate.jsp";
	}
	
	@RequestMapping("/cargo/extcproduct/update.action")
	public String update(ExtCproduct extCproduct, Model model){
		extCproductService.update(extCproduct);
		model.addAttribute("contractProductId", extCproduct.getContractProductId());		//��������ID
		
		return "redirect:/cargo/extcproduct/tocreate.action";
	}
	
	@RequestMapping("/cargo/extcproduct/deleteById.action")
	public String deleteById(String id, String contractProductId, Model model){
		extCproductService.deleteById(id);
		model.addAttribute("contractProductId", contractProductId);		//��������ID
		
		return "redirect:/cargo/extcproduct/tocreate.action";
	}
	
}
