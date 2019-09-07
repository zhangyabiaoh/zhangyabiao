package com.city.my.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.city.my.dao.ContractProductDao;
import com.city.my.dao.ExtCproductDao;
import com.city.my.domain.ContractProduct;
import com.city.my.pagination.Page;
import com.city.my.service.ContractProductService;
import com.city.util.UtilFuns;
@Service
public class ContractProductServiceImpl implements ContractProductService{

	@Resource
	ContractProductDao contractProductDao;
	@Resource
	ExtCproductDao extCproductDao;
	public List<ContractProduct> findPage(Page page) {
		// TODO Auto-generated method stub
		return contractProductDao.findPage(page);
	}

	public List<ContractProduct> find(Map paraMap) {
		// TODO Auto-generated method stub
		return contractProductDao.find(paraMap);
	}

	public ContractProduct get(Serializable id) {
		// TODO Auto-generated method stub
		return contractProductDao.get(id);
	}

	public void insert(ContractProduct contractProduct) {
		// TODO Auto-generated method stub
		contractProduct.setId(UUID.randomUUID().toString());
		if(UtilFuns.isNotEmpty(contractProduct.getProduct_number())&& UtilFuns.isNotEmpty(contractProduct.getProduct_price())) {
			contractProduct.setProduct_amount(contractProduct.getProduct_number()*contractProduct.getProduct_price());
		}
		contractProductDao.insert(contractProduct);
		
	}

	public void update(ContractProduct contractProduct) {
		// TODO Auto-generated method stub
		if(UtilFuns.isNotEmpty(contractProduct.getProduct_number())&& UtilFuns.isNotEmpty(contractProduct.getProduct_price())) {
			contractProduct.setProduct_amount(contractProduct.getProduct_number()*contractProduct.getProduct_price());
		}
		contractProductDao.update(contractProduct);
		
	}

	public void deleteById(Serializable id) {
		Serializable[] ids = {id};
		extCproductDao.deleteByContractProductById(ids);		//删除当前这些货物下的所有附件
		contractProductDao.deleteById(id);
	}

	public void delete(Serializable[] ids) {
		extCproductDao.deleteByContractProductById(ids);		//删除当前这些货物下的所有附件
		contractProductDao.delete(ids);
		
	}

}
