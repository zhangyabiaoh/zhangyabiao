package com.city.my.service;

import java.util.List;
import java.util.Map;

import com.city.my.domain.SysCode;

public interface SysCodeService {
	public List<SysCode> find(Map paraMap);			//带条件查询，条件可以为null，既没有条件；返回list对象集合
}
