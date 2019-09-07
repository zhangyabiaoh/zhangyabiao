package com.city.my.dao;

import java.util.Map;
import com.city.my.domain.User;

public interface UserDao extends BaseDao<User>{
	public void updateState(Map map);
}
