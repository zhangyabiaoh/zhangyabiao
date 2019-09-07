package com.city.my.dao.impl;

import org.springframework.stereotype.Repository;

import com.city.my.dao.OutProductDao;
import com.city.my.vo.OutProductVO;
@Repository
public class OutProductDaoImpl extends BaseDaoImpl<OutProductVO> implements OutProductDao{

	public OutProductDaoImpl() {
		//…Ë÷√√¸√˚ø’º‰
		super.setNs("com.city.my.mapper.OutProductMapper");
	}
}
