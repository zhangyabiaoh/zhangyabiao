package com.city.my.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.city.my.dao.ContractDao;
import com.city.my.domain.Contract;
import com.city.my.vo.ContractVO;
@Repository
public class ContractDaoImpl  extends BaseDaoImpl<Contract> implements ContractDao{

	public ContractDaoImpl() {
		//…Ë÷√√¸√˚ø’º‰
		super.setNs("com.city.my.mapper.ContractMapper");
	}
	
	public void updateState(Map map) {
		// TODO Auto-generated method stub
		super.getSqlSession().update(super.getNs()+".updateState", map);;
	}

	public ContractVO view(String contractId) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectOne(super.getNs()+".view", contractId);
	}

}
