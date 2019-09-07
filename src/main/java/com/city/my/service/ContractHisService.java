package com.city.my.service;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.city.my.domain.Contract;
import com.city.my.pagination.Page;
import com.city.my.vo.ContractVO;

public interface ContractHisService {
	public List<Contract> findPage(Page page);		//��ҳ��ѯ
	public List<Contract> find(Map paraMap);		//��������ѯ����������Ϊnull����û������������list���󼯺�
	public ContractVO view(String contractId);		//��������Ĳ�ѯһ��
	
	public void pigeinhole(String[] contractIds);		//�鵵
	public void pigeouthole(String[] contractIds);		//ȡ���鵵
}
