package com.city.my.dao;

import java.io.Serializable;

import com.city.my.domain.ExtCproduct;

public interface ExtCproductDao extends BaseDao<ExtCproduct>{
	public void deleteByContractProductById(Serializable[] ids);
	public void deleteByContractId(Serializable[] contractIds);
}
