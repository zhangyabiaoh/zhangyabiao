package com.city.my.service.impl;

import org.springframework.stereotype.Service;

import com.city.my.dao.ContractDao;
import com.city.my.dao.ExportDao;
import com.city.my.dao.ExportProductDao;
import com.city.my.dao.ExtEproductDao;
import com.city.my.domain.Contract;
import com.city.my.domain.Export;
import com.city.my.domain.ExportProduct;
import com.city.my.domain.ExtEproduct;
import com.city.my.pagination.Page;
import com.city.my.service.ExportService;
import com.city.my.vo.ContractProductVO;
import com.city.my.vo.ContractVO;
import com.city.my.vo.ExtCproductVO;
import com.city.util.UtilFuns;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@WebService
public class ExportServiceImpl implements ExportService{
	@Resource
	ExportDao exportDao;
	@Resource
	ExportProductDao exportProductDao;
	@Resource
	ExtEproductDao extEproductDao;
	@Resource
	ContractDao contractDao;
	
	//����set��������cxf��ע��dao������cxf��WebService�ſ��Բ�ѯ����ϵͳ������
		@WebMethod(exclude=true)
		public void setExportDao(ExportDao exportDao) {
			this.exportDao = exportDao;
		}

		@WebMethod(exclude=true)
		public List<Export> findPage(Page page) {
			return exportDao.findPage(page);
		}

		@WebMethod(exclude=true)
		public List<Export> find(Map paraMap) {
			return exportDao.find(paraMap);
		}

		public Export get(String id) {
			return exportDao.get(id);
		}

		@WebMethod(exclude=true)
		public void insert(String[] contractIds) {
			/*
			 * ���裺
			 * 1�����ݺ�ͬid��ú�ͬ���󣬻�ȡ��ͬ��
			 * 2������ͬ�µĻ�����Ϣ��ҵ������µĻ������
			 * 3������ͬ�µĸ�����Ϣ��ҵ������µĸ�������
			 */
			
			//ƴ�Ӻ�ͬ�ţ����˺�
			String contractNos = "";
			for(int i=0;i<contractIds.length;i++){
				ContractVO contract = contractDao.view(contractIds[i]);
				contractNos += contract.getContract_num() + " ";				//�Կո���Ϊ�ָ���
			}
			contractNos = UtilFuns.delLastChar(contractNos);				//�����࣬ɾ�����һ���ַ�
			
			Export export = new Export();
			export.setId(UUID.randomUUID().toString());
			
			//x,y
			export.setContractIds(UtilFuns.joinStr(contractIds, ","));		//�����࣬ƴ��
			export.setCustomerContract(contractNos);
			
			export.setState(0);												//0�ݸ�
			
			exportDao.insert(export);
			
			//���������Ϣ
			for(int i=0;i<contractIds.length;i++){
				ContractVO contract = contractDao.view(contractIds[i]);
				
				for(ContractProductVO cp : contract.getContractProducts()){
				
					ExportProduct ep = new ExportProduct();
					ep.setId(UUID.randomUUID().toString());
					ep.setExportId(export.getId());					//�����
					
					//���ݰ�ң�����ͬ�µĶ�Ӧ�Ļ�����Ϣд�뵽�����µĻ�����Ϣ��
					ep.setFactoryId(cp.getFactory().getId());
					ep.setFactoryName(cp.getFactory().getFactoryName());
					ep.setProductNo(cp.getProduct_num());
					ep.setPackingUnit(cp.getPack_unit());
					ep.setCnumber(cp.getProduct_number());
					ep.setBoxNum(cp.getBoxs_num());
					ep.setPrice(cp.getProduct_price());
					
					exportProductDao.insert(ep);
					
					//��������Ϣ
					for(ExtCproductVO extcp : cp.getExtCproducts()){
						ExtEproduct extep = new ExtEproduct();
						
						//copyProperties spring
						BeanUtils.copyProperties(extcp, extep);		//spring�����࣬���ݵĿ���
						
						extep.setId(UUID.randomUUID().toString());
						extep.setExportProductId(ep.getId());		//�����
						
						extep.setFactoryId(extcp.getFactory().getId());
						extep.setFactoryName(extcp.getFactory().getFactoryName());
						
						extEproductDao.insert(extep);
					}
				}
			}
		}

		@WebMethod(exclude=true)
		public void update(Export export,
				String[] mr_id,
				Integer[] mr_orderNo,
				Integer[] mr_cnumber,
				Double[] mr_grossWeight,
				Double[] mr_netWeight,
				Double[] mr_sizeLength,
				Double[] mr_sizeWidth,
				Double[] mr_sizeHeight,
				Double[] mr_exPrice,
				Double[] mr_tax,
				Integer[] mr_changed
			){
			exportDao.update(export);
			//�����޸Ļ�����Ϣ
			System.out.println("dsceshi����"+mr_changed);
			for(int i=0;i<mr_id.length;i++){
				if(mr_changed[i]!=null && mr_changed[i]==1){			//�޸ı�ʶ��ֻ���û��޸ĵ��вŽ��и���
					ExportProduct ep = exportProductDao.get(mr_id[i]);
					System.out.println("dsceshi����"+mr_changed);
					ep.setOrderNo(mr_orderNo[i]);
					ep.setCnumber(mr_cnumber[i]);
					ep.setGrossWeight(mr_grossWeight[i]);
					ep.setNetWeight(mr_netWeight[i]);
					ep.setSizeLength(mr_sizeLength[i]);
					ep.setSizeWidth(mr_sizeWidth[i]);
					ep.setSizeHeight(mr_sizeHeight[i]);
					ep.setExPrice(mr_exPrice[i]);
					ep.setTax(mr_tax[i]);
					
					exportProductDao.update(ep);
				}
			}
		}

		@WebMethod(exclude=true)
		public void deleteById(Serializable id) {
			exportDao.deleteById(id);
		}

		@WebMethod(exclude=true)
		public void delete(Serializable[] ids) {
			exportDao.delete(ids);
		}

		@WebMethod(exclude=true)
		public void submit(Serializable[] ids) {
			Map map = new HashMap();
			map.put("state", 1);				//1���ϱ�
			map.put("ids", ids);
			
			exportDao.updateState(map);
		}

		@WebMethod(exclude=true)
		public void cancel(Serializable[] ids) {
			Map map = new HashMap();
			map.put("state", 0);				//0�ݸ�
			map.put("ids", ids);
			
			exportDao.updateState(map);
		}

		@WebMethod(exclude=true)
		public List<Contract> getContractList() {
			Map paraMap = new HashMap();
			paraMap.put("state", 1);			//1���ϱ�
			
			return contractDao.find(paraMap);
		}
		
		//ƴ��JS��
		//function addTRRecord(objId, id, productNo, cnumber, grossWeight, netWeight, sizeLength, sizeWidth, sizeHeight, exPrice, tax)
		@WebMethod(exclude=true)
		public String getMrecordData(String exportId){
			Map paraMap = new HashMap();
			paraMap.put("exportId", exportId);
			
			List<ExportProduct> oList = exportProductDao.find(paraMap );
			
			StringBuffer sBuf = new StringBuffer();
			for(ExportProduct ep : oList){
				sBuf.append("addTRRecord(\"mRecordTable\", \"").append(ep.getId()).append("\", \"").append(ep.getProductNo()).append("\", \"").append(ep.getCnumber()).append("\", \"").append(ep.getGrossWeight()).append("\", \"").append(UtilFuns.convertNull(ep.getNetWeight())).append("\", \"").append(UtilFuns.convertNull(ep.getSizeLength())).append("\", \"").append(UtilFuns.convertNull(ep.getSizeWidth())).append("\", \"").append(UtilFuns.convertNull(ep.getSizeHeight())).append("\", \"").append(UtilFuns.convertNull(ep.getExPrice())).append("\", \"").append(UtilFuns.convertNull(ep.getTax())).append("\");");
			}
			
			return sBuf.toString();
		}
	
	
	
}
