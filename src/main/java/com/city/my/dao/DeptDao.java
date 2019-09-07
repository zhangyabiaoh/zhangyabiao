package com.city.my.dao;

import java.util.Map;

import com.city.my.domain.Dept;

public interface DeptDao extends BaseDao<Dept>{
	public void updateState(Map map);
}
