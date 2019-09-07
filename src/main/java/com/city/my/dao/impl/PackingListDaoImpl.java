package com.city.my.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.city.my.dao.PackingListDao;
import com.city.my.domain.PackingList;

@Repository
public class PackingListDaoImpl extends BaseDaoImpl<PackingList> implements PackingListDao{
	public PackingListDaoImpl() {
		//…Ë÷√√¸√˚ø’º‰
		super.setNs("com.city.my.mapper.PackingListMapper");
	}

	public void updateState(Map map) {
		super.getSqlSession().update(super.getNs()+".updateState", map);
	}
}

