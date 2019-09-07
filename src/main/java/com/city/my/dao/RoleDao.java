package com.city.my.dao;

import java.util.Map;
import com.city.my.domain.Role;

public interface RoleDao extends BaseDao<Role>{
	public void updateState(Map map);
}
