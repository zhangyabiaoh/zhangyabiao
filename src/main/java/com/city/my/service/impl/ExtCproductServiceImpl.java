package com.city.my.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.city.my.dao.ExtCproductDao;
import com.city.my.dao.SysCodeDao;
import com.city.my.domain.ExtCproduct;
import com.city.my.domain.SysCode;
import com.city.my.pagination.Page;
import com.city.my.service.ExtCproductService;
import com.city.util.UtilFuns;
@Service
public class ExtCproductServiceImpl implements ExtCproductService{
	@Resource
	ExtCproductDao extCproductDao;
	@Resource
	SysCodeDao sysCodeDao;

	public List<ExtCproduct> findPage(Page page) {
		// TODO Auto-generated method stub
		return extCproductDao.findPage(page);
	}

	public List<ExtCproduct> find(Map paraMap) {
		// TODO Auto-generated method stub
		return extCproductDao.find(paraMap);
	}

	public ExtCproduct get(Serializable id) {
		// TODO Auto-generated method stub
		return extCproductDao.get(id);
	}

	public void insert(ExtCproduct extCproduct) {
		// TODO Auto-generated method stub
		extCproduct.setId(UUID.randomUUID().toString());
		//自动计算总金额=数量*单价		...修改，删除；同步合同总金额
		if(UtilFuns.isNotEmpty(extCproduct.getCnumber()) && UtilFuns.isNotEmpty(extCproduct.getPrice())){
			extCproduct.setAmount(extCproduct.getCnumber()*extCproduct.getPrice());
			System.out.println("总金额："+extCproduct.getCnumber()*extCproduct.getPrice());
		}
		
		extCproductDao.insert(extCproduct);
		
	}

	public void update(ExtCproduct extCproduct) {
		// TODO Auto-generated method stub
		if(UtilFuns.isNotEmpty(extCproduct.getCnumber()) && UtilFuns.isNotEmpty(extCproduct.getPrice())){
			extCproduct.setAmount(extCproduct.getCnumber()*extCproduct.getPrice());
			System.out.println("总金额："+extCproduct.getCnumber()*extCproduct.getPrice());
		}
		extCproductDao.update(extCproduct);
	}

	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		extCproductDao.deleteById(id);
	}

	public void delete(Serializable[] ids) {
		// TODO Auto-generated method stub
		extCproductDao.delete(ids);
	}

	public List<SysCode> getCtypeList() {
		//sysCodeDao.find(paraMap);
		Map paraMap = new HashMap();
		paraMap.put("parentId", "001");			//sys_code_b 0104附件分类
		return sysCodeDao.find(paraMap);
	}

}
