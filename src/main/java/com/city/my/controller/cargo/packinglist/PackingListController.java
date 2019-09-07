package com.city.my.controller.cargo.packinglist;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.city.my.controller.BaseController;
import com.city.my.domain.PackingList;
import com.city.my.service.PackingListService;
@Controller
public class PackingListController extends BaseController{
	@Resource
	PackingListService packingListService;
	
	@RequestMapping("/cargo/packinglist/list.action")
	public String list(Model model){
		List<PackingList> dataList = packingListService.find(null);
		model.addAttribute("dataList", dataList);
		
		return "/cargo/packinglist/jPackingListList.jsp";
	}
	
	@RequestMapping("/cargo/packinglist/tocreate.action")
	public String tocreate(String[] id, Model model){			//���ڱ��˵�id����
		//Я�����ڱ��˵�id����	//��ʾװ��ͱ��˵Ĺ�ϵ
		model.addAttribute("divData", packingListService.getDivDataCreate(id));					
		
		return "/cargo/packinglist/jPackingListCreate.jsp";
	}
	
	@RequestMapping("/cargo/packinglist/insert.action")
	public String insert(PackingList packingList){
		packingListService.insert(packingList);
		
		return "redirect:/cargo/packinglist/list.action";
	}
	
	@RequestMapping("/cargo/packinglist/toupdate.action")
	public String toupdate(String id, Model model){
		PackingList obj = packingListService.get(id);
		model.addAttribute("obj", obj);
		
		String _s = packingListService.getDivDataUpdate(obj.getExportIds().split("\\|"), obj.getExportNos().split("\\|"));
		model.addAttribute("divData", _s);	
				
		return "/cargo/packinglist/jPackingListUpdate.jsp";
	}
	
	@RequestMapping("/cargo/packinglist/update.action")
	public String update(PackingList packingList){
		packingListService.update(packingList);
		
		return "redirect:/cargo/packinglist/list.action";
	}
	
	@RequestMapping("/cargo/packinglist/toview.action")
	public String toview(String id, Model model){
		PackingList obj = packingListService.get(id);
		model.addAttribute("obj", obj);
		
		model.addAttribute("divData", packingListService.getDivDataView(obj.getExportNos().split("\\|")));
		
		return "/cargo/packinglist/jPackingListView.jsp";
	}
}
