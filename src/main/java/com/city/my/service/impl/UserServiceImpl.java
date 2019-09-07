package com.city.my.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.city.my.dao.FactoryDao;
import com.city.my.dao.UserDao;
import com.city.my.domain.User;
import com.city.my.pagination.Page;
import com.city.my.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	@Resource
	UserDao userDao;
	
	public List<User> findPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> find(Map map) {
		// TODO Auto-generated method stub
		return userDao.find(map);
	}

	public User get(Serializable id) {
		// TODO Auto-generated method stub
		return userDao.get(id);
	}

	public void insert(User user) {
		// TODO Auto-generated method stub
		user.setId(UUID.randomUUID().toString());
		userDao.insert(user);
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		userDao.deleteById(id);
		
	}

	public void delete(Serializable[] ids) {
		// TODO Auto-generated method stub
		userDao.delete(ids);
		
	}

	public void start(Serializable[] ids) {
		// TODO Auto-generated method stub
		
	}

	public void stop(Serializable[] ids) {
		// TODO Auto-generated method stub
		
	}

	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

}
