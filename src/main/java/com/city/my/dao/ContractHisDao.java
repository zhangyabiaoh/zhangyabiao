package com.city.my.dao;

import com.city.my.domain.Contract;
import com.city.my.vo.ContractVO;

public interface ContractHisDao extends BaseDao<Contract>{
	public ContractVO view(String contractId);	//查询某个合同
}
