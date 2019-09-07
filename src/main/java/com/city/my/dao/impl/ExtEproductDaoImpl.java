package com.city.my.dao.impl;

import org.springframework.stereotype.Repository;

import com.city.my.dao.ExtEproductDao;
import com.city.my.domain.ExtEproduct;
@Repository
public class ExtEproductDaoImpl extends BaseDaoImpl<ExtEproduct> implements ExtEproductDao{
	public ExtEproductDaoImpl() {
		//…Ë÷√√¸√˚ø’º‰
		super.setNs("com.city.my.mapper.ExtEproductMapper");
	}
}
