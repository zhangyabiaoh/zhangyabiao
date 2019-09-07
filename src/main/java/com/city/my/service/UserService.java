package com.city.my.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import com.city.my.domain.User;
import com.city.my.pagination.Page;

public interface UserService {
	public List<User> findPage(Page page);//��ҳ��ѯ
	public List<User> find(Map map);//��������ѯ����������Ϊnull����û������������list���󼯺�
	public User get(Serializable id);//ֻ��ѯһ�����������޸�
	public void insert(User user);//���룬��ʵ����Ϊ����
	public void update(User user);//�޸ģ���ʵ����Ϊ����
	public void deleteById(Serializable id);//��idɾ����ɾ��һ����֧�������ͺ��ַ�������ID
	public void delete(Serializable[] ids);//����ɾ����֧�������ͺ��ַ�������ID
	public void start(Serializable[] ids);			//����
	public void stop(Serializable[] ids);			//ͣ��
	
	public List<User> getUserList();			//��ȡ���������б�
}
