package com.city.my.dao.impl;

import org.springframework.stereotype.Repository;

import com.city.my.dao.SysCodeDao;
import com.city.my.domain.SysCode;

@Repository
public class SysCodeDaoImpl extends BaseDaoImpl<SysCode> implements SysCodeDao{

	public SysCodeDaoImpl() {
		//…Ë÷√√¸√˚ø’º‰
		super.setNs("com.city.my.mapper.SysCodeMapper");
	}
}
