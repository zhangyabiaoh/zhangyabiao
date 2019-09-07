package com.city.my.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.city.my.domain.ContractProduct;
import com.city.my.pagination.Page;

public interface ContractProductService {
	public List<ContractProduct> findPage(Page page);		//��ҳ��ѯ
	public List<ContractProduct> find(Map paraMap);			//��������ѯ����������Ϊnull����û������������list���󼯺�
	public ContractProduct get(Serializable id);			//ֻ��ѯһ�����������޸�
	public void insert(ContractProduct contractProduct);	//���룬��ʵ����Ϊ����
	public void update(ContractProduct contractProduct);	//�޸ģ���ʵ����Ϊ����
	public void deleteById(Serializable id);				//��idɾ����ɾ��һ����֧�������ͺ��ַ�������ID
	public void delete(Serializable[] ids);					//����ɾ����֧�������ͺ��ַ�������ID
}
