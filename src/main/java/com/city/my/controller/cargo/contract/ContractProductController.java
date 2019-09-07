package com.city.my.controller.cargo.contract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.city.my.controller.BaseController;
import com.city.my.domain.ContractProduct;
import com.city.my.domain.Factory;
import com.city.my.service.ContractProductService;
import com.city.my.service.FactoryService;

@Controller
public class ContractProductController extends BaseController{

	@Resource
	ContractProductService contractProductService;
	@Resource
	FactoryService factoryService;
	//ת������ҳ��
		@RequestMapping("/cargo/contractproduct/tocreate.action")
		public String tocreate(String contract_id, Model model){		//���������ID
			model.addAttribute("contract_id", contract_id);
			
			//׼���������ҵ������б�
			List<Factory> factoryList = factoryService.getFactoryList();
			model.addAttribute("factoryList", factoryList);
			
			//ĳ����ͬ�µĻ����б�
			Map paraMap = new HashMap();
			paraMap.put("contract_id", contract_id);
			
			List<ContractProduct> dataList = contractProductService.find(paraMap);
			model.addAttribute("dataList", dataList);
			
			return "/cargo/contract/jContractProductCreate.jsp";	//���������ҳ��
		}
		
		//����
		@RequestMapping("/cargo/contractproduct/insert.action")
		public String insert(ContractProduct contractProduct, Model model){
			contractProductService.insert(contractProduct);
			
			model.addAttribute("contractId", contractProduct.getContract_id());		//���������ID
			
			return "redirect:/cargo/contractproduct/tocreate.action";	//������ת������ҳ��-��������
		}
		
		//ת���޸�ҳ��
		@RequestMapping("/cargo/contractproduct/toupdate.action")
		public String toupdate(String id, Model model){
			ContractProduct obj = contractProductService.get(id);
			model.addAttribute("obj", obj);
			
			//׼���������ҵ������б�
			List<Factory> factoryList = factoryService.getFactoryList();
			model.addAttribute("factoryList", factoryList);
			
			return "/cargo/contract/jContractProductUpdate.jsp";
		}
		
		//�޸ı���
		@RequestMapping("/cargo/contractproduct/update.action")
		public String update(ContractProduct contractProduct){
			contractProductService.update(contractProduct);
			
			return "redirect:/cargo/contractproduct/tocreate.action";
		}
		
		//ɾ��
		@RequestMapping("/cargo/contractproduct/deleteById.action")
		public String deleteById(String id, String contractId, Model model){
			contractProductService.deleteById(id);
			model.addAttribute("contractId", contractId);			//��������ID
			
			return "redirect:/cargo/contractproduct/tocreate.action";
		}
}
