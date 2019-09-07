package com.city.my.dao;

import java.util.Map;

import com.city.my.domain.Contract;
import com.city.my.vo.ContractVO;

public interface ContractDao extends BaseDao<Contract>{

	public void updateState(Map map);			//�޸�״̬
	public ContractVO view(String contractId);	//��ѯĳ����ͬ
}
