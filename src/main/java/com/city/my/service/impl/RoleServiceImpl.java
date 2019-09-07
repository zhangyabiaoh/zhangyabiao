package com.city.my.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.city.my.dao.RoleDao;
import com.city.my.dao.UserDao;
import com.city.my.domain.Role;
import com.city.my.pagination.Page;
import com.city.my.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{

	@Resource
	RoleDao roleDao;
	public List<Role> findPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Role> find(Map map) {
		// TODO Auto-generated method stub
		return roleDao.find(map);
	}

	public Role get(Serializable id) {
		// TODO Auto-generated method stub
		return roleDao.get(id);
	}

	public void insert(Role role) {
		// TODO Auto-generated method stub
		role.setId(UUID.randomUUID().toString());;
		roleDao.insert(role);
	}

	public void update(Role role) {
		// TODO Auto-generated method stub
		
	}

	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		roleDao.deleteById(id);
	}

	public void delete(Serializable[] ids) {
		// TODO Auto-generated method stub
		roleDao.delete(ids);
	}

	public void start(Serializable[] ids) {
		// TODO Auto-generated method stub
		
	}

	public void stop(Serializable[] ids) {
		// TODO Auto-generated method stub
		
	}

	public List<Role> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

}
