package com.city.my.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.city.my.dao.OutProductDao;
import com.city.my.service.OutProductService;
import com.city.my.vo.OutProductVO;

@Service
public class OutProductServiceImpl implements OutProductService {
	@Resource
	OutProductDao outProductDao;

	public List<OutProductVO> find(String inputDate) {
		Map paraMap = new HashMap();
		paraMap.put("inputDate", inputDate);		//按条件查询，船期
		
		return outProductDao.find(paraMap);
	}
	
}

