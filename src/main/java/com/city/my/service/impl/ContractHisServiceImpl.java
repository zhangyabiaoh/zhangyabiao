package com.city.my.service.impl;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.city.common.springdao.SqlDao;
import com.city.my.dao.ContractHisDao;
import com.city.my.domain.Contract;
import com.city.my.pagination.Page;
import com.city.my.service.ContractHisService;
import com.city.my.vo.ContractVO;
import com.city.util.UtilFuns;
@Service
public class ContractHisServiceImpl implements ContractHisService {

	@Resource
	ContractHisDao contractHisDao;
	//@Resource
	SqlDao sqlDao;

	public void pigeinhole(String[] contractIds) {
		sqlDao.batchSQL(this.doData(contractIds, "", "_his"));		//����ִ��
	}

	public void pigeouthole(String[] contractIds) {
		sqlDao.batchSQL(this.doData(contractIds, "_his", ""));
	}
	
	//�������ݣ���Դ����Ŀ��������ݣ���Դ������ɾ��
	public String[] doData(String[] contractIds, String source, String target){
		StringBuffer sBuf = new StringBuffer();
		String inStr = UtilFuns.joinStr(contractIds, "'", "'", ",");			//��ͬ��id�� x,y �������in�Ӳ�ѯ�� 'x','y'
		
		sBuf.append("insert into contract").append(target).append("_c (select * from contract").append(source).append("_c where contract_id in (").append(inStr).append("));");
		sBuf.append("insert into contract_product").append(target).append("_c (select * from contract_product").append(source).append("_c where contract_id in (").append(inStr).append("));");
		sBuf.append("insert into ext_cproduct").append(target).append("_c (select * from ext_cproduct").append(source).append("_c where contract_product_id in (select contract_product_id from contract_product").append(source).append("_c where contract_id in (").append(inStr).append(")));");
		
		sBuf.append("delete from ext_cproduct").append(source).append("_c where contract_product_id in (select contract_product_id from contract_product").append(source).append("_c where contract_id in (").append(inStr).append("));");
		sBuf.append("delete from contract_product").append(source).append("_c where contract_id in (").append(inStr).append(");");
		sBuf.append("delete from contract").append(source).append("_c where contract_id in (").append(inStr).append(");");
		
		return sBuf.toString().split(";");
	}

	public List<Contract> findPage(Page page) {
		return contractHisDao.findPage(page);
	}

	public List<Contract> find(Map paraMap) {
		return contractHisDao.find(paraMap);
	}

	public ContractVO view(String contractId) {
		return contractHisDao.view(contractId);
	}

}
