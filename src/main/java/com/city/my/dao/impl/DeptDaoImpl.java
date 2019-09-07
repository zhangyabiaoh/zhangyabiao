package com.city.my.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.city.my.dao.DeptDao;
import com.city.my.domain.Dept;
@Repository
public class DeptDaoImpl  extends BaseDaoImpl<Dept> implements DeptDao{
	public DeptDaoImpl() {
		//…Ë÷√√¸√˚ø’º‰
		super.setNs("com.city.my.mapper.DeptMapper");
	}
	public void updateState(Map map) {
		// TODO Auto-generated method stub
		super.getSqlSession().update(super.getNs()+".updateState", map);
	}


}
