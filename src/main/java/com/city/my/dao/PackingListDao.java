package com.city.my.dao;

import java.util.Map;

import com.city.my.domain.PackingList;

public interface PackingListDao  extends BaseDao<PackingList>{
	public void updateState(Map map);			//ÐÞ¸Ä×´Ì¬
}
