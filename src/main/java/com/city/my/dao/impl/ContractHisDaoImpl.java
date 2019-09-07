package com.city.my.dao.impl;
import org.springframework.stereotype.Repository;

import com.city.my.dao.ContractHisDao;
import com.city.my.domain.Contract;
import com.city.my.vo.ContractVO;

@Repository
public class ContractHisDaoImpl extends BaseDaoImpl<Contract> implements ContractHisDao{

	public ContractHisDaoImpl() {
		//…Ë÷√√¸√˚ø’º‰
		super.setNs("com.city.my.mapper.ContractHisMapper");
	}

	public ContractVO view(String contractId) {
		return super.getSqlSession().selectOne(super.getNs()+".view", contractId);
	}

}
