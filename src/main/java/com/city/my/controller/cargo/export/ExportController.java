package com.city.my.controller.cargo.export;

import javax.annotation.Resource;

import com.city.my.controller.BaseController;
import com.city.my.domain.Contract;
import com.city.my.domain.Export;
import com.city.my.service.ContractService;
import com.city.my.service.ExportService;
import com.city.my.vo.ContractVO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.List;

@Controller
public class ExportController extends BaseController{
	
	@Resource
	ExportService exportService;
	@Resource
	ContractService contractService;
	
	@RequestMapping("/cargo/export/list.action")
	public String list(Model model){
		List<Export> dataList = exportService.find(null);
		model.addAttribute("dataList", dataList);
		
		return "/cargo/export/jExportList.jsp";
	}
	
	//������ͬ��ѯ�б�
	@RequestMapping("/cargo/export/contractList.action")
	public String contractList(Model model){
		List<Contract> dataList = exportService.getContractList();
		model.addAttribute("dataList", dataList);
		
		return "/cargo/export/jContractList.jsp";		//����Ŀ¼�µ��ù�����ͬ�б�
	}
	
	//����������ֱ�ӽ��к�̨����
	@RequestMapping("/cargo/export/insert.action")
	public String insert(@RequestParam("id")String[] contractIds){			//��ͬ��id����
		exportService.insert(contractIds);
		
		return "redirect:/cargo/export/list.action";
	}
	
	@RequestMapping("/cargo/export/toupdate.action")
	public String toupdate(String id, Model model){
		Export obj = exportService.get(id);
		model.addAttribute("obj", obj);
		
		//׼�������޸Ŀؼ�������mrecord
		model.addAttribute("mRecordData", exportService.getMrecordData(id));
		System.out.println("���ԣ�to����+"+exportService.getMrecordData(id));
		return "/cargo/export/jExportUpdate.jsp";
	}
	
	@RequestMapping("/cargo/export/update.action")
	public String update(Export export,
				String[] mr_id,
				Integer[] mr_orderNo,
				Integer[] mr_cnumber,
				Double[] mr_grossWeight,
				Double[] mr_netWeight,
				Double[] mr_sizeLength,
				Double[] mr_sizeWidth,
				Double[] mr_sizeHeight,
				Double[] mr_exPrice,
				Double[] mr_tax,
				Integer[] mr_changed
			){
		exportService.update(export,
				mr_id,
				mr_orderNo,
				mr_cnumber,
				mr_grossWeight,
				mr_netWeight,
				mr_sizeLength,
				mr_sizeWidth,
				mr_sizeHeight,
				mr_exPrice,
				mr_tax,
				mr_changed
			);
		System.out.println("����dsfdsfs��csd����+"+	mr_grossWeight+"bh");
		return "redirect:/cargo/export/list.action";
	}
	
	@RequestMapping("/cargo/export/toview.action")
	public String toview(String id, Model model){
		Export obj = exportService.get(id);
		model.addAttribute("obj", obj);
		
		return "/cargo/export/jExportView.jsp";
	}
	//����ɾ��
		@RequestMapping("/cargo/export/delete.action")
		public String deleteBatch(@RequestParam("id")String[] ids){
			//Serializable[] ids = {id};
			//exportService.delete(id.split(","));
			exportService.delete(ids);
			return "redirect:/cargo/export/list.action";
		}
	
}
