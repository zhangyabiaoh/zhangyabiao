package com.city.my.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.city.my.dao.DeptDao;
import com.city.my.domain.Dept;
import com.city.my.pagination.Page;
import com.city.my.service.DeptService;
@Service
public class DeptServiceImpl implements DeptService{
	
	  @Resource
	  DeptDao deptDao;

	public List<Dept> findPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Dept> find(Map map) {
		// TODO Auto-generated method stub
		return deptDao.find(map);
	}

	public Dept get(Serializable id) {
		// TODO Auto-generated method stub
		return deptDao.get(id);
	}

	public void insert(Dept dept) {
		// TODO Auto-generated method stub
		dept.setId(UUID.randomUUID().toString());
		deptDao.insert(dept);
		
	}

	public void update(Dept dept) {
		// TODO Auto-generated method stub
		
	}

	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		deptDao.deleteById(id);
	}

	public void delete(Serializable[] ids) {
		// TODO Auto-generated method stub
		deptDao.delete(ids);
	}

	public void start(Serializable[] ids) {
		// TODO Auto-generated method stub
		
	}

	public void stop(Serializable[] ids) {
		// TODO Auto-generated method stub
		
	}

	public List<Dept> getDeptList() {
		// TODO Auto-generated method stub
		return null;
	}

}
