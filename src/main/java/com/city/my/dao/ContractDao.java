package com.city.my.dao;

import java.util.Map;

import com.city.my.domain.Contract;
import com.city.my.vo.ContractVO;

public interface ContractDao extends BaseDao<Contract>{

	public void updateState(Map map);			//修改状态
	public ContractVO view(String contractId);	//查询某个合同
}
