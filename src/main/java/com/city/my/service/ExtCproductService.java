package com.city.my.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.city.my.domain.ExtCproduct;
import com.city.my.domain.SysCode;
import com.city.my.pagination.Page;

public interface ExtCproductService {
	public List<ExtCproduct> findPage(Page page);		//��ҳ��ѯ
	public List<ExtCproduct> find(Map paraMap);			//��������ѯ����������Ϊnull����û������������list���󼯺�
	public ExtCproduct get(Serializable id);			//ֻ��ѯһ�����������޸�
	public void insert(ExtCproduct extCproduct);		//���룬��ʵ����Ϊ����
	public void update(ExtCproduct extCproduct);		//�޸ģ���ʵ����Ϊ����
	public void deleteById(Serializable id);			//��idɾ����ɾ��һ����֧�������ͺ��ַ�������ID
	public void delete(Serializable[] ids);				//����ɾ����֧�������ͺ��ַ�������ID
	
	public List<SysCode> getCtypeList();							//��ȡ�����б�
}
