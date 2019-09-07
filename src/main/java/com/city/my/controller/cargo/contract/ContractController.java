package com.city.my.controller.cargo.contract;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.city.my.controller.BaseController;
import com.city.my.domain.Contract;
import com.city.my.print.ContractPrint;
import com.city.my.service.ContractService;
import com.city.my.vo.ContractVO;
@Controller
public class ContractController  extends BaseController{
	@Resource
	ContractService contractService;
	@RequestMapping("/cargo/contract/list.action")
	public String list(Model model){
		List<Contract> dataList = contractService.find(null);
		model.addAttribute("dataList", dataList);
		
		return "/cargo/contract/jContractList.jsp";
	}
	
	@RequestMapping("/cargo/contract/tocreate.action")
	public String tocreate(){
		return "/cargo/contract/jContractCreate.jsp";
	}
	
	@RequestMapping("/cargo/contract/insert.action")
	public String insert(Contract contract){
		contractService.insert(contract);
		
		return "redirect:/cargo/contract/list.action";
	}
	
	@RequestMapping("/cargo/contract/toupdate.action")
	public String toupdate(String id, Model model){
		Contract obj = contractService.get(id);   
		model.addAttribute("obj", obj);
		
		return "/cargo/contract/jContractUpdate.jsp";
	}
	
	@RequestMapping("/cargo/contract/update.action")
	public String update(Contract contract){
		contractService.update(contract);
		
		return "redirect:/cargo/contract/list.action";
	}
	
	@RequestMapping("/cargo/contract/delete.action")
	public String delete(String[] id){
		contractService.delete(id);
		
		return "redirect:/cargo/contract/list.action";
	}
	
	@RequestMapping("/cargo/contract/toview.action")
	public String toview(String id, Model model){
		ContractVO obj = contractService.view(id);
		model.addAttribute("obj", obj);
		
		return "/cargo/contract/jContractView.jsp";
	}

	//上报
	@RequestMapping("/cargo/contract/submit.action")
	public String submit(String[] id){
		contractService.submit(id);
		
		return "redirect:/cargo/contract/list.action";
	}
	
	//取消
	@RequestMapping("/cargo/contract/cancel.action")
	public String cancel(String[] id){
		contractService.cancel(id);
		
		return "redirect:/cargo/contract/list.action";
	}
	
	//打印
	@RequestMapping("/cargo/contract/print.action")
	public void print(String id, HttpServletRequest request, HttpServletResponse response) throws Exception{
		ContractPrint cp = new ContractPrint();
		
		ContractVO obj = contractService.view(id);
		cp.print(obj, request.getSession().getServletContext().getRealPath("/"), response);
	}

}
