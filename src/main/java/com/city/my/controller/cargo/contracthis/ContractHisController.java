package com.city.my.controller.cargo.contracthis;

import com.city.my.controller.BaseController;
import com.city.my.domain.Contract;
import com.city.my.service.ContractHisService;
import com.city.my.vo.ContractVO;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ContractHisController extends BaseController{
	@Resource
	ContractHisService contractHisService;
	
	//历史列表
	@RequestMapping("/cargo/contracthis/list.action")
	public String list(Model model){
		List<Contract> dataList = contractHisService.find(null);
		model.addAttribute("dataList", dataList);
		
		return "/cargo/contracthis/jContractHisList.jsp";
	}
	
	//归档
	@RequestMapping("/cargo/contracthis/pigeinhole.action")
	public String pigeinhole(String[] id){
		contractHisService.pigeinhole(id);
		
		return "redirect:/cargo/contracthis/list.action";
	}
	
	//取消归档
	@RequestMapping("/cargo/contracthis/pigeouthole.action")
	public String pigeouthole(String[] id){
		contractHisService.pigeouthole(id);
		
		return "redirect:/cargo/contracthis/list.action";
	}
	

	/*@RequestMapping("/cargo/contract/delete.action")
	public String delete(String[] id){
		contractHisService.delete(id);
		
		return "redirect:/cargo/contract/list.action";
	}*/
	/*@RequestMapping("/cargo/contract/toview.action")
	public String toview(String id, Model model){
		ContractVO obj = contractHisService.view(id);
		model.addAttribute("obj", obj);
		
		return "/cargo/contract/jContractView.jsp";
	}*/
}
