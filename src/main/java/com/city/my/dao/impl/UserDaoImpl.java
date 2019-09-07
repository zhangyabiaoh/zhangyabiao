package com.city.my.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;
import com.city.my.dao.UserDao;
import com.city.my.domain.User;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	public UserDaoImpl() {
		//ÉèÖÃÃüÃû¿Õ¼ä
		super.setNs("com.city.my.mapper.UserMapper");
	}
	public void updateState(Map map) {
		// TODO Auto-generated method stub
		super.getSqlSession().update(super.getNs()+".updateState", map);
	}

}
