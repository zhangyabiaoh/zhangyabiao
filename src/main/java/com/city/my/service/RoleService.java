package com.city.my.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.city.my.domain.Role;
import com.city.my.domain.User;
import com.city.my.pagination.Page;

public interface RoleService {
	public List<Role> findPage(Page page);//��ҳ��ѯ
	public List<Role> find(Map map);//��������ѯ����������Ϊnull����û������������list���󼯺�
	public Role get(Serializable id);//ֻ��ѯһ�����������޸�
	public void insert(Role role);//���룬��ʵ����Ϊ����
	public void update(Role role);//�޸ģ���ʵ����Ϊ����
	public void deleteById(Serializable id);//��idɾ����ɾ��һ����֧�������ͺ��ַ�������ID
	public void delete(Serializable[] ids);//����ɾ����֧�������ͺ��ַ�������ID
	public void start(Serializable[] ids);			//����
	public void stop(Serializable[] ids);			//ͣ��
	
	public List<Role> getUserList();			//��ȡ���������б�
}
