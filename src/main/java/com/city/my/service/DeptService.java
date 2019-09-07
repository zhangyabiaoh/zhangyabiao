package com.city.my.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.city.my.domain.Dept;
import com.city.my.pagination.Page;

public interface DeptService {
	public List<Dept> findPage(Page page);//��ҳ��ѯ
	public List<Dept> find(Map map);//��������ѯ����������Ϊnull����û������������list���󼯺�
	public Dept get(Serializable id);//ֻ��ѯһ�����������޸�
	public void insert(Dept dept);//���룬��ʵ����Ϊ����
	public void update(Dept dept);//�޸ģ���ʵ����Ϊ����
	public void deleteById(Serializable id);//��idɾ����ɾ��һ����֧�������ͺ��ַ�������ID
	public void delete(Serializable[] ids);//����ɾ����֧�������ͺ��ַ�������ID
	public void start(Serializable[] ids);			//����
	public void stop(Serializable[] ids);			//ͣ��
	
	public List<Dept> getDeptList();			//��ȡ���������б�
}
