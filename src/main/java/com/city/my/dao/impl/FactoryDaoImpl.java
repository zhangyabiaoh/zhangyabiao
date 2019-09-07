package com.city.my.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.city.my.dao.FactoryDao;
import com.city.my.domain.Factory;

@Repository
public class FactoryDaoImpl extends BaseDaoImpl<Factory> implements FactoryDao{
	public FactoryDaoImpl() {
		//…Ë÷√√¸√˚ø’º‰
		super.setNs("com.city.my.mapper.FactoryMapper");
	}

	public void updateState(Map map) {
		// TODO Auto-generated method stub
		super.getSqlSession().update(super.getNs()+".updateState", map);
		
	}

}
