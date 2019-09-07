package com.city.my.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.city.my.domain.Contract;
import com.city.my.domain.Export;
import com.city.my.pagination.Page;

public interface ExportService {
	public List<Export> findPage(Page page);	//��ҳ��ѯ
	public List<Export> find(Map paraMap);		//��������ѯ����������Ϊnull����û������������list���󼯺�
	public Export get(String id);				//ֻ��ѯһ�����������޸�
	
	public void insert(String[] contractIds);	//���룬��ʵ����Ϊ����
	public void update(Export export,			//�޸ģ���ʵ����Ϊ����
			String[] mr_id,
			Integer[] mr_orderNo,
			Integer[] mr_cnumber,
			Double[] mr_grossWeight,
			Double[] mr_netWeight,
			Double[] mr_sizeLength,
			Double[] mr_sizeWidth,
			Double[] mr_sizeHeight,
			Double[] mr_exPrice,
			Double[] mr_tax,
			Integer[] mr_changed
		);
	public void deleteById(Serializable id);	//��idɾ����ɾ��һ����֧�������ͺ��ַ�������ID
	public void delete(Serializable[] ids);		//����ɾ����֧�������ͺ��ַ�������ID
	
	public void submit(Serializable[] ids);		//�ϱ�
	public void cancel(Serializable[] ids);		//ȡ��
	
	public List<Contract> getContractList();	//��ȡ������ͬ�б����ϱ���
	public String getMrecordData(String exportId);		//ƴ��js��
}
