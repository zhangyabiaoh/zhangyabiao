package com.city.my.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.city.my.dao.ExportDao;
import com.city.my.domain.Export;
@Repository
public class ExportDaoImpl extends BaseDaoImpl<Export> implements ExportDao{
	
	public ExportDaoImpl() {
		//���������ռ�
		super.setNs("com.city.my.mapper.ExportMapper");
	}

	public void updateState(Map map) {
		// TODO Auto-generated method stub
		super.getSqlSession().update(super.getNs()+".updateState", map);
	}

}
