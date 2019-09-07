package com.city.my.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.city.my.dao.ExtCproductDao;
import com.city.my.domain.ExtCproduct;
@Repository
public class ExtCproductDaoImpl extends BaseDaoImpl<ExtCproduct> implements ExtCproductDao{
	
	public ExtCproductDaoImpl() {
		//…Ë÷√√¸√˚ø’º‰
		super.setNs("com.city.my.mapper.ExtCproductMapper");
	}

	public void deleteByContractProductById(Serializable[] ids) {
		// TODO Auto-generated method stub
		super.getSqlSession().delete(super.getNs()+".deleteByContractProductById", ids);
		
	}

	public void deleteByContractId(Serializable[] contractIds) {
		// TODO Auto-generated method stub
		super.getSqlSession().delete(super.getNs()+".deleteByContractId", contractIds);
		
	}

}
