package com.city.my.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.city.my.domain.Factory;
import com.city.my.pagination.Page;

public interface FactoryService {
	public List<Factory> findPage(Page page);//��ҳ��ѯ
	public List<Factory> find(Map map);//��������ѯ����������Ϊnull����û������������list���󼯺�
	public Factory get(Serializable id);//ֻ��ѯһ�����������޸�
	public void insert(Factory factory);//���룬��ʵ����Ϊ����
	public void update(Factory factory);//�޸ģ���ʵ����Ϊ����
	public void deleteById(Serializable id);//��idɾ����ɾ��һ����֧�������ͺ��ַ�������ID
	public void delete(Serializable[] ids);//����ɾ����֧�������ͺ��ַ�������ID
	public void start(Serializable[] ids);			//����
	public void stop(Serializable[] ids);			//ͣ��
	
	public List<Factory> getFactoryList();			//��ȡ���������б�
}
