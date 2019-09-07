package com.city.my.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.city.my.dao.SysCodeDao;
import com.city.my.domain.SysCode;
import com.city.my.service.SysCodeService;

@Service
public class SysCodeServiceImpl implements SysCodeService {

	@Resource
	SysCodeDao sysCodeDao;

	public List<SysCode> find(Map paraMap) {
		// TODO Auto-generated method stub
		return sysCodeDao.find(paraMap);
	}
}
