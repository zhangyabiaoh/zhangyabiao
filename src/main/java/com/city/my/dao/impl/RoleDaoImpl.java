package com.city.my.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.city.my.dao.RoleDao;
import com.city.my.domain.Role;
@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao{

	public RoleDaoImpl() {
		//…Ë÷√√¸√˚ø’º‰
		super.setNs("com.city.my.mapper.RoleMapper");
	}
	public void updateState(Map map) {
		// TODO Auto-generated method stub
		super.getSqlSession().update(super.getNs()+".updateState", map);
	}


}
