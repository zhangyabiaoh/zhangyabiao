package com.city.my.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.city.my.domain.Dept;
import com.city.my.pagination.Page;

public interface DeptService {
	public List<Dept> findPage(Page page);//分页查询
	public List<Dept> find(Map map);//带条件查询，条件可以为null，既没有条件；返回list对象集合
	public Dept get(Serializable id);//只查询一个，常用于修改
	public void insert(Dept dept);//插入，用实体作为参数
	public void update(Dept dept);//修改，用实体作为参数
	public void deleteById(Serializable id);//按id删除，删除一条；支持整数型和字符串类型ID
	public void delete(Serializable[] ids);//批量删除；支持整数型和字符串类型ID
	public void start(Serializable[] ids);			//启用
	public void stop(Serializable[] ids);			//停用
	
	public List<Dept> getDeptList();			//获取生产厂家列表
}
