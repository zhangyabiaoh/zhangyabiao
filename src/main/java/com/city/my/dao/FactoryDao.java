package com.city.my.dao;

import java.util.Map;

import com.city.my.domain.Factory;

public interface FactoryDao extends BaseDao<Factory>{
	public void updateState(Map map);
}
