package com.city.my.service;

import java.util.List;

import com.city.my.vo.OutProductVO;

public interface OutProductService {

	public List<OutProductVO> find(String inputDate);		//��������ѯ����������Ϊnull����û������������list���󼯺�
}
