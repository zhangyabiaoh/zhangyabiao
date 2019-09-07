package com.city.my.service;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.city.my.domain.PackingList;
import com.city.my.pagination.Page;

public interface PackingListService {
	public List<PackingList> findPage(Page page);	//��ҳ��ѯ
	public List<PackingList> find(Map paraMap);		//��������ѯ����������Ϊnull����û������������list���󼯺�
	public PackingList get(Serializable id);		//ֻ��ѯһ�����������޸�
	
	public void insert(PackingList packingList);	//���룬��ʵ����Ϊ����
	public void update(PackingList packingList);	//�޸ģ���ʵ����Ϊ����
	public void deleteById(Serializable id);		//��idɾ����ɾ��һ����֧�������ͺ��ַ�������ID
	public void delete(Serializable[] ids);			//����ɾ����֧�������ͺ��ַ�������ID
	
	public void submit(Serializable[] ids);			//�ϱ�
	public void cancel(Serializable[] ids);			//ȡ��
	
	public String getDivDataCreate(String[] exportIds);	//��ȡdiv������ҳ��չʾ����
	public String getDivDataUpdate(String[] exportIds, String[] exportNos);	//��ȡdiv���޸�ҳ��չʾ����
	public String getDivDataView(String[] exportNos);	//��ȡdiv�ڲ鿴ҳ��չʾ����
}
