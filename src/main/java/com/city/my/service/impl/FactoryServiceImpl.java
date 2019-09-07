package com.city.my.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.city.my.dao.FactoryDao;
import com.city.my.domain.Factory;
import com.city.my.pagination.Page;
import com.city.my.service.FactoryService;

@Service
public class FactoryServiceImpl implements FactoryService{

	@Resource
	FactoryDao factoryDao;
	
	public List<Factory> findPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Factory> find(Map map) {
		// TODO Auto-generated method stub
		return factoryDao.find(map);
	}

	public Factory get(Serializable id) {
		// TODO Auto-generated method stub
		return factoryDao.get(id);
	}

	public void insert(Factory factory) {
		// TODO Auto-generated method stub
		factory.setId(UUID.randomUUID().toString());
		factory.setState("1");//默认启用状态
		factoryDao.insert(factory);
		
	}

	public void update(Factory factory) {
		// TODO Auto-generated method stub
		factoryDao.update(factory);
		
	}

	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		factoryDao.deleteById(id);
		
	}

	public void delete(Serializable[] ids) {
		// TODO Auto-generated method stub
		factoryDao.delete(ids);
	}

	public void start(Serializable[] ids) {
		Map map = new HashMap();
		map.put("state", 1);				//1启用
		map.put("ids", ids);
		factoryDao.updateState(map);
	}
	public void stop(Serializable[] ids) {
		Map map = new HashMap();
		map.put("state", 0);				//0停用
		map.put("ids", ids);
		
		factoryDao.updateState(map);
		
	}

	public List<Factory> getFactoryList() {
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("state", 1);	
		return factoryDao.find(paraMap);
	}
	

}
