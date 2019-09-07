package com.city.my.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.city.my.domain.Contract;
import com.city.my.pagination.Page;
import com.city.my.vo.ContractVO;

public interface ContractService {
	public List<Contract> findPage(Page page);		//��ҳ��ѯ
	public List<Contract> find(Map paraMap);		//��������ѯ����������Ϊnull����û������������list���󼯺�
	public Contract get(Serializable id);			//ֻ��ѯһ�����������޸�
	public ContractVO view(String contractId);		//��������Ĳ�ѯһ��
	
	public void insert(Contract contract);			//���룬��ʵ����Ϊ����
	public void update(Contract contract);			//�޸ģ���ʵ����Ϊ����
	public void deleteById(Serializable id);		//��idɾ����ɾ��һ����֧�������ͺ��ַ�������ID
	public void delete(Serializable[] ids);			//����ɾ����֧�������ͺ��ַ�������ID
	
	public void submit(Serializable[] ids);			//�ϱ�
	public void cancel(Serializable[] ids);			//ȡ��
}
