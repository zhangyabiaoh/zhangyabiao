package com.city.my.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.city.my.dao.ContractDao;
import com.city.my.dao.ContractProductDao;
import com.city.my.dao.ExtCproductDao;
import com.city.my.domain.Contract;
import com.city.my.pagination.Page;
import com.city.my.service.ContractService;
import com.city.util.UtilFuns;
import com.city.my.vo.ContractVO;
@Service
public class ContractServiceImpl implements ContractService{

	@Resource
	ContractDao contractDao;
	@Resource
	ContractProductDao contractProductDao;
	@Resource
	ExtCproductDao extCproductDao;
	
	public List<Contract> findPage(Page page) {
		// TODO Auto-generated method stub
		return contractDao.findPage(page);
	}

	public List<Contract> find(Map paraMap) {
		// TODO Auto-generated method stub
		return contractDao.find(paraMap);
	}

	public Contract get(Serializable id) {
		// TODO Auto-generated method stub
		return contractDao.get(id);
	}

	public void insert(Contract contract) {
		// TODO Auto-generated method stub
		contract.setId(UUID.randomUUID().toString());
		contract.setC_state(0);					//0�ݸ�1���ϱ�
		contractDao.insert(contract);
		
	}

	public void update(Contract contract) {
		// TODO Auto-generated method stub
		contractDao.update(contract);
		
	}

	public void deleteById(Serializable id) {
		Serializable[] ids = {id};
		extCproductDao.deleteByContractId(ids);			//ɾ����ǰ��Щ��ͬ�µĸ�����Ϣ
		contractProductDao.deleteById(ids);		//ɾ����ǰ��Щ��ͬ�µĻ�����Ϣ
		contractDao.deleteById(id);
	}

	public void delete(Serializable[] ids) {
		extCproductDao.deleteByContractId(ids);			//ɾ����ǰ��Щ��ͬ�µĸ�����Ϣ
		contractProductDao.deleteByContractId(ids);		//ɾ����ǰ��Щ��ͬ�µĻ�����Ϣ
		contractDao.delete(ids);
	}

	public void submit(Serializable[] ids) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("c_state", 1);				//1���ϱ�
		map.put("ids", ids);
		
		contractDao.updateState(map);
		
	}

	public void cancel(Serializable[] ids) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("c_state", 0);				//0�ݸ�
		map.put("ids", ids);
		
		contractDao.updateState(map);
		
	}

	public ContractVO view(String contractId) {
		return contractDao.view(contractId);
	}

}
