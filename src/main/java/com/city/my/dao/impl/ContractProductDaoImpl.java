package com.city.my.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;

import com.city.my.dao.ContractProductDao;
import com.city.my.domain.ContractProduct;
@Repository
public class ContractProductDaoImpl extends BaseDaoImpl<ContractProduct> implements ContractProductDao{

	public ContractProductDaoImpl() {
		//…Ë÷√√¸√˚ø’º‰
		super.setNs("com.city.my.mapper.ContractProductMapper");
	}

	public void deleteByContractProductById(Serializable[] ids) {
		super.getSqlSession().delete(super.getNs()+".deleteByContractProductById", ids);
	}
	
	public void deleteByContractId(Serializable[] ids){
		super.getSqlSession().delete(super.getNs()+".deleteByContractId", ids);
	}

}
