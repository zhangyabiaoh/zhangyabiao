package com.city.my.dao.impl;

import org.springframework.stereotype.Repository;

import com.city.my.dao.ExportProductDao;
import com.city.my.domain.ExportProduct;
@Repository
public class ExportProductDaoImpl extends BaseDaoImpl<ExportProduct> implements ExportProductDao{
	public ExportProductDaoImpl() {
		//…Ë÷√√¸√˚ø’º‰
		super.setNs("com.city.my.mapper.ExportProductMapper");
	}
}
