package com.city.my.dao;

import java.io.Serializable;
import java.util.Map;
import com.city.my.domain.ContractProduct;

public interface ContractProductDao extends BaseDao<ContractProduct>{

	public void deleteByContractProductById(Serializable[] ids);
	public void deleteByContractId(Serializable[] ids);
}
