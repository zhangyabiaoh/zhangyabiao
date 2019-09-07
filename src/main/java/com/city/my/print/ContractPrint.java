package com.city.my.print;

import com.city.util.DownloadUtil;
import com.city.util.UtilFuns;
import com.city.util.file.PoiUtil;
import com.city.my.vo.ContractProductVO;
import com.city.my.vo.ContractVO;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
public class ContractPrint {

	public void print(ContractVO contract,String path, HttpServletResponse response) throws Exception{
		//��ͬ���ҵ���Ϣһ���ӡ
		List<ContractProductVO> oList = contract.getContractProducts();
		UtilFuns utilFuns = new UtilFuns();
		String tempXlsFile = path + "make/xlsprint/tCONTRACT.xls";		//��ȡģ���ļ�
		
		//��дÿҳ�����ݣ�֮����ѭ��ÿҳ��ȡ��ӡ
		Map<String,String> pageMap = null;
		List<Map> pageList = new ArrayList();			//��ӡҳ
		
		ContractProductVO oProduct = null;
		String stars = "";
		for(int j=0;j<contract.getImportance_num();j++){		//��Ҫ�̶�
			stars += "��";
		}
		
		String oldFactory = "";
		for(int i=0;i<oList.size();i++){
			oProduct = oList.get(i);	//��û���
			pageMap = new HashMap();	//ÿҳ������
			
			pageMap.put("Offeror", "�� �� ����" + contract.getC_offer());
			pageMap.put("Factory", "����������" + oProduct.getFactory().getFactoryName());
			pageMap.put("ContractNo", "�� ͬ �ţ�" + contract.getContract_num());
			pageMap.put("Contacts", "�� ϵ �ˣ�" + oProduct.getFactory().getContacts());
			pageMap.put("SigningDate", "ǩ�����ڣ�"+UtilFuns.formatDateTimeCN(UtilFuns.dateTimeFormat(contract.getSign_date())));
			System.out.println("��ϵ�绰1��    "+oProduct.getFactory().getPhone()+"   dedede");
			pageMap.put("Phone", "��    ����" + UtilFuns.convertNull(oProduct.getFactory().getPhone()));
			System.out.println("yidongg�绰1��    "+oProduct.getFactory().getMobile()+"   dedede");
			pageMap.put("InputBy", "�Ƶ���" + contract.getCinput_by());
			pageMap.put("CheckBy", "�󵥣�"+ utilFuns.fixSpaceStr(contract.getChecked_by(),26)+"���Ա��"+utilFuns.convertNull(contract.getInspector()));
			pageMap.put("Remark", "  "+UtilFuns.convertNull(contract.getAccountfor()));
			pageMap.put("Crequest", "  "+UtilFuns.convertNull(contract.getCrequests()));
			
			pageMap.put("ProductImage", oProduct.getProduct_img()+".png");
			pageMap.put("ProductDesc", oProduct.getProduct_description());
			pageMap.put("Cnumber", String.valueOf(oProduct.getProduct_number().doubleValue()));
			if(oProduct.getPack_unit().equals("PCS")){
				pageMap.put("PackingUnit", "ֻ");
			}else if(oProduct.getPack_unit().equals("SETS")){
				pageMap.put("PackingUnit", "��");
			}
			pageMap.put("Price", String.valueOf(oProduct.getProduct_price().doubleValue()));
			pageMap.put("ProductNo", oProduct.getProduct_num());
			
			oldFactory = oProduct.getFactory().getFactoryName();
			
			if(contract.getPrint_style().equals("2")){
				i++;	//��ȡ�ڶ���������Ϣ
				if(i<oList.size()){
					oProduct = oList.get(i);
					
					if(oProduct.getFactory().getFactoryName().equals(oldFactory)){	//���Ҳ�ͬ������ҳ��ӡ����ȥ��һ�εıȽ�
						
						pageMap.put("ProductImage2", oProduct.getProduct_img());
						pageMap.put("ProductDesc2", oProduct.getProduct_description());
						pageMap.put("Cnumber2", String.valueOf(oProduct.getProduct_number().doubleValue()));
						if(oProduct.getPack_unit().equals("PCS")){
							pageMap.put("PackingUnit2", "ֻ");
						}else if(oProduct.getPack_unit().equals("SETS")){
							pageMap.put("PackingUnit2", "��");
						}						
						pageMap.put("Price2", String.valueOf(oProduct.getProduct_price().doubleValue()));
						//pageMap.put("Amount2", String.valueOf(oProduct.getAmount().doubleValue()));			//��excel�н����ù�ʽ����������׼������
						pageMap.put("ProductNo2", oProduct.getProduct_num());
					}else{
						i--;	//tip:list�˻�
					}
				}else{
					pageMap.put("ProductNo2", null);	//�������ݴ��ж��Ƿ��еڶ�������
				}
			}
			
			pageMap.put("ContractDesc", stars+" ��������");			//��Ҫ�̶� + ��������
			
			pageList.add(pageMap);
		}
		
		int cellHeight = 96;	//һ������ĸ߶�			�û�����һ�����ﰴ192�߶ȴ�ӡ�����������ѿ�����ӡ�߶Ⱥ�2��߶�һ����
//		if(contract.getPrintStyle().equals("2")){
//			cellHeight = 96;	//��������ĸ߶�
//		}
		
		PoiUtil poiUtil = new PoiUtil();
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(tempXlsFile));	//��excel�ļ�
		HSSFFont defaultFont10 = poiUtil.defaultFont10(wb);		//��������
		HSSFFont defaultFont12 = poiUtil.defaultFont12(wb);		//��������
		HSSFFont blackFont = poiUtil.blackFont12(wb);			//��������
		Short rmb2Format = poiUtil.rmb2Format(wb);				//���ø�ʽ
		Short rmb4Format = poiUtil.rmb4Format(wb);				//���ø�ʽ
		

		HSSFSheet sheet = wb.getSheetAt(0);				//ѡ���һ��������
		wb.setSheetName(0, "������ͬ");					//���ù�����������


		//sheet.setDefaultColumnWidth((short) 20); 		// ����ÿ��Ĭ�Ͽ��
		
//		POI��ҳ����BUG��������ģ���ļ��в���һ����ҳ����Ȼ���ٴ˴�ɾ��Ԥ��ķ�ҳ��������������������÷�ҳ����
//		sheet.setAutobreaks(false);
//		int iRowBreaks[] = sheet.getRowBreaks();
//		sheet.removeRowBreak(3);
//		sheet.removeRowBreak(4);
//		sheet.removeRowBreak(5);
//		sheet.removeRowBreak(6);
		
		CellRangeAddress region = null;
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();		//add picture

		HSSFRow nRow = null;
		HSSFCell nCell   = null;
		int curRow = 0;
		
		//��ӡÿҳ
		Map<String,String> printMap = null;
		for(int p=0;p<pageList.size();p++){
			printMap = pageList.get(p);
			
			if(p>0){
				sheet.setRowBreak(curRow++);	//�ڵ�startRow�����÷�ҳ��
			}
			
			
			//����logoͼƬ
			poiUtil.setPicture(wb, patriarch, path+"make/xlsprint/logo.jpg", curRow, 2, curRow+4, 2);
			
			//header
			nRow = sheet.createRow(curRow++);
			nRow.setHeightInPoints(21);
			
			nCell   = nRow.createCell((3));
			nCell.setCellValue("DALIAN");
			nCell.setCellStyle(headStyle(wb));

			//header
			nRow = sheet.createRow(curRow++);
			nRow.setHeightInPoints(41);
			
			nCell   = nRow.createCell((3));
			nCell.setCellValue("     CY INTERNATIONAL ");
			nCell.setCellStyle(tipStyle(wb));

			curRow++;
			
			//header
			nRow = sheet.createRow(curRow++);
			nRow.setHeightInPoints(20);
			
			nCell   = nRow.createCell((1));
			nCell.setCellValue("                 ������������ɽ��·31�Ŵ�������ѧ����ѧԺ");
			nCell.setCellStyle(addressStyle(wb));
			
			//header
			nCell   = nRow.createCell((6));
			nCell.setCellValue(" CO., LTD.");
			nCell.setCellStyle(ltdStyle(wb));

			//header
			nRow = sheet.createRow(curRow++);
			nRow.setHeightInPoints(15);
			
			nCell   = nRow.createCell((1));
			nCell.setCellValue("                   TEL: 0411-82171459  FAX: 0411-82171569               E-MAIL: city@dlut.edu.cn");
			nCell.setCellStyle(telStyle(wb));
			
			//line
			nRow = sheet.createRow(curRow++);
			nRow.setHeightInPoints(7);
			
			poiUtil.setLine(wb, patriarch, curRow, 2, curRow, 8);	//draw line

			//header
			nRow = sheet.createRow(curRow++);
			nRow.setHeightInPoints(30);
			
			nCell   = nRow.createCell((4));
			nCell.setCellValue("    ��   ��   ��   ͬ");
			nCell.setCellStyle(titleStyle(wb));
			
			//Offeror
			nRow = sheet.createRow(curRow++);
			nRow.setHeightInPoints(20);
			
			nCell   = nRow.createCell((1));
			nCell.setCellValue(printMap.get("Offeror"));
			nCell.setCellStyle(poiUtil.titlev12(wb, blackFont));

			//Facotry
			nCell   = nRow.createCell((5));
			nCell.setCellValue(printMap.get("Factory"));
			nCell.setCellStyle(poiUtil.titlev12(wb, blackFont));
			
			//ContractNo
			nRow = sheet.createRow(curRow++);
			nRow.setHeightInPoints(20);
			
			nCell   = nRow.createCell(1);
			nCell.setCellValue(printMap.get("ContractNo"));
			nCell.setCellStyle(poiUtil.titlev12(wb, blackFont));
			
			//Contacts
			nCell  = nRow.createCell(5);
			nCell.setCellValue(printMap.get("Contacts"));
			System.out.println("��ϵ��"+printMap.get("Contacts"));
			nCell.setCellStyle(poiUtil.titlev12(wb, blackFont));
			
			//SigningDate
			nRow = sheet.createRow(curRow++);
			nRow.setHeightInPoints(20);
			
			nCell = nRow.createCell(1);
			nCell.setCellValue(printMap.get("SigningDate"));
			nCell.setCellStyle(poiUtil.titlev12(wb, blackFont));
			
			//Phone
			nCell = nRow.createCell(5);
			nCell.setCellValue(printMap.get("Phone"));
			System.out.println("��ϵ�绰"+printMap.get("Phone"));
			nCell.setCellStyle(poiUtil.titlev12(wb, blackFont));
			
			//importNum
			nRow = sheet.createRow(curRow++);
			nRow.setHeightInPoints(24);
			
			region = new CellRangeAddress(curRow-1, curRow-1, 1, 3);	//����ϲ���Ԫ�� 
			sheet.addMergedRegion(region);
			
			nCell = nRow.createCell(1);
			nCell.setCellValue("��Ʒ");
			nCell.setCellStyle(thStyle(wb));		
			
			nCell = nRow.createCell(2);
			nCell.setCellStyle(poiUtil.notehv10_BorderThin(wb, defaultFont10));
			
			nCell = nRow.createCell(3);
			nCell.setCellStyle(poiUtil.notehv10_BorderThin(wb, defaultFont10));
			
			nCell = nRow.createCell(4);
			nCell.setCellValue(printMap.get("ContractDesc"));
			nCell.setCellStyle(thStyle(wb));	
			
			region = new CellRangeAddress(curRow-1, curRow-1, 5, 6);	//����ϲ���Ԫ�� 
			sheet.addMergedRegion(region);
			
			nCell = nRow.createCell(5);
			nCell.setCellValue("����");
			nCell.setCellStyle(thStyle(wb));	
			
			nCell = nRow.createCell(6);
			nCell.setCellStyle(poiUtil.notehv10_BorderThin(wb, defaultFont10));			
			
			nCell = nRow.createCell(7);
			nCell.setCellValue("����");
			nCell.setCellStyle(thStyle(wb));						
			
			nCell = nRow.createCell(8);
			nCell.setCellValue("�ܽ��");
			nCell.setCellStyle(thStyle(wb));						


			nRow = sheet.createRow(curRow++);
			nRow.setHeightInPoints(96);
			
			region = new CellRangeAddress(curRow-1, curRow-1, 1, 3);	//����ϲ���Ԫ�� 
			sheet.addMergedRegion(region);
			
			//�����ƷͼƬ
			if(UtilFuns.isNotEmpty(printMap.get("ProductImage"))){
				System.out.println(printMap.get("ProductImage"));
				poiUtil.setPicture(wb, patriarch, path+"ufiles/jquery/"+printMap.get("ProductImage"), curRow-1, 1, curRow, 3);
			}
			
			nCell = nRow.createCell(2);
			nCell.setCellStyle(poiUtil.notehv10_BorderThin(wb, defaultFont10));
			
			nCell = nRow.createCell(3);
			nCell.setCellStyle(poiUtil.notehv10_BorderThin(wb, defaultFont10));
			
			//ProductDesc
			region = new CellRangeAddress(curRow-1, curRow, 4, 4);	//����ϲ���Ԫ�� 
			sheet.addMergedRegion(region);
			
			nCell = nRow.createCell(4);
			nCell.setCellValue(printMap.get("ProductDesc"));
			nCell.setCellStyle(poiUtil.notehv10_BorderThin(wb, defaultFont10));		
			
			//Cnumber
			region = new CellRangeAddress(curRow-1, curRow, 5, 5);	//����ϲ���Ԫ�� 
			sheet.addMergedRegion(region);
			
			nCell = nRow.createCell(5);
			nCell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			nCell.setCellValue(Double.parseDouble(printMap.get("Cnumber")));
			nCell.setCellStyle(poiUtil.numberrv10_BorderThin(wb, defaultFont10));	
			
			//Unit
			region = new CellRangeAddress(curRow-1, curRow, 6, 6);	//����ϲ���Ԫ�� 
			sheet.addMergedRegion(region);
			
			nCell = nRow.createCell(6);
			nCell.setCellValue(printMap.get("PackingUnit"));
			nCell.setCellStyle(poiUtil.moneyrv10_BorderThin(wb, defaultFont10, rmb4Format));	
			
			//Price
			region = new CellRangeAddress(curRow-1, curRow, 7, 7);	//����ϲ���Ԫ�� 
			sheet.addMergedRegion(region);
			
			nCell = nRow.createCell(7);
			nCell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			nCell.setCellValue(Double.parseDouble(printMap.get("Price")));
			nCell.setCellStyle(poiUtil.moneyrv10_BorderThin(wb, defaultFont10, rmb4Format));
			
			
			//Amount
			region = new CellRangeAddress(curRow-1, curRow, 8, 8);	//����ϲ���Ԫ�� 
			sheet.addMergedRegion(region);
			
			nCell = nRow.createCell(8);
			if(UtilFuns.isNotEmpty(printMap.get("Cnumber")) && UtilFuns.isNotEmpty(printMap.get("Price"))){
				nCell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
				nCell.setCellFormula("F"+String.valueOf(curRow)+"*H"+String.valueOf(curRow));
			}
			nCell.setCellStyle(poiUtil.moneyrv10_BorderThin(wb, defaultFont10, rmb4Format));			

			curRow++;
			
			region = new CellRangeAddress(curRow-1, curRow-1, 1, 3);	//����ϲ���Ԫ�� 
			sheet.addMergedRegion(region);
			
			//ProductNo
			nRow = sheet.createRow(curRow-1);
			nRow.setHeightInPoints(24);
			
			nCell = nRow.createCell(1);
			nCell.setCellValue(printMap.get("ProductNo"));
			nCell.setCellStyle(poiUtil.notecv10_BorderThin(wb, defaultFont10));
			
			for(int j=2;j<9;j++){
				nCell = nRow.createCell(j);
				nCell.setCellStyle(poiUtil.notehv10_BorderThin(wb, defaultFont10));
			}
			
			
			
			if(contract.getPrint_style().equals("2") && UtilFuns.isNotEmpty(printMap.get("ProductNo2"))){
				nRow = sheet.createRow(curRow++);
				nRow.setHeightInPoints(96);
				
				region = new CellRangeAddress(curRow-1, curRow-1, 1, 3);	//����ϲ���Ԫ�� 
				sheet.addMergedRegion(region);
				
				//�����ƷͼƬ
				if(UtilFuns.isNotEmpty(printMap.get("ProductImage2"))){
					System.out.println(printMap.get("ProductImage2"));
					poiUtil.setPicture(wb, patriarch, path+"ufiles/jquery/"+printMap.get("ProductImage2"), curRow-1, 1, curRow, 3);
				}
				
				//ProductDesc
				region = new CellRangeAddress(curRow-1, curRow, 4, 4);	//����ϲ���Ԫ�� 
				sheet.addMergedRegion(region);
				
				nCell = nRow.createCell(4);
				nCell.setCellValue(printMap.get("ProductDesc2"));
				nCell.setCellStyle(poiUtil.notehv10_BorderThin(wb, defaultFont10));		
				
				//Cnumber
				region = new CellRangeAddress(curRow-1, curRow, 5, 5);	//����ϲ���Ԫ�� 
				sheet.addMergedRegion(region);
				
				nCell = nRow.createCell(5);
				nCell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				nCell.setCellValue(Double.parseDouble(printMap.get("Cnumber2")));
				nCell.setCellStyle(poiUtil.numberrv10_BorderThin(wb, defaultFont10));	
				
				//Unit
				region = new CellRangeAddress(curRow-1, curRow, 6, 6);	//����ϲ���Ԫ�� 
				sheet.addMergedRegion(region);
				
				nCell = nRow.createCell(6);
				nCell.setCellValue(printMap.get("PackingUnit2"));
				nCell.setCellStyle(poiUtil.moneyrv10_BorderThin(wb, defaultFont10, rmb4Format));	
				
				//Price
				region = new CellRangeAddress(curRow-1, curRow, 7, 7);	//����ϲ���Ԫ�� 
				sheet.addMergedRegion(region);
				
				nCell = nRow.createCell(7);
				nCell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				nCell.setCellValue(Double.parseDouble(printMap.get("Price2")));
				nCell.setCellStyle(poiUtil.moneyrv10_BorderThin(wb, defaultFont10, rmb4Format));
				
				
				//Amount
				region = new CellRangeAddress(curRow-1, curRow, 8, 8);	//����ϲ���Ԫ�� 
				sheet.addMergedRegion(region);
				
				nCell = nRow.createCell(8);
				if(UtilFuns.isNotEmpty(printMap.get("Cnumber2")) && UtilFuns.isNotEmpty(printMap.get("Price2"))){
					nCell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
					nCell.setCellFormula("F"+String.valueOf(curRow)+"*H"+String.valueOf(curRow));
				}
				nCell.setCellStyle(poiUtil.moneyrv10_BorderThin(wb, defaultFont10, rmb4Format));		
				
				curRow++;
				
				region = new CellRangeAddress(curRow-1, curRow-1, 1, 3);	//����ϲ���Ԫ��
				sheet.addMergedRegion(region);
				
				nRow = sheet.createRow(curRow-1);
				nRow.setHeightInPoints(24);
				
				nCell = nRow.createCell(1);
				nCell.setCellValue(printMap.get("ProductNo2"));
				nCell.setCellStyle(poiUtil.notecv10_BorderThin(wb, defaultFont10));			
				
				//�ϲ���Ԫ����
				for(int j=2;j<9;j++){
					nCell = nRow.createCell(j);
					nCell.setCellStyle(poiUtil.notehv10_BorderThin(wb, defaultFont10));
				}				
			}
			
			
			//InputBy
			nRow = sheet.createRow(curRow++);
			nRow.setHeightInPoints(24);
			
			nCell = nRow.createCell(1);
			nCell.setCellValue(printMap.get("InputBy"));
			nCell.setCellStyle(poiUtil.bnormalv12(wb,defaultFont12));
			
			//CheckBy+inspector
			
			nCell = nRow.createCell(4);
			nCell.setCellValue(printMap.get("CheckBy"));
			nCell.setCellStyle(poiUtil.bnormalv12(wb,defaultFont12));
			
			//if(contract.getPrintStyle().equals("2") && UtilFuns.isNotEmpty(printMap.get("ProductNo2"))){
				
				nCell = nRow.createCell(7);
				nCell.setCellValue("�ܽ�");
				nCell.setCellStyle(bcv12(wb));
				
				//TotalAmount
				nRow = sheet.createRow(curRow-1);
				nRow.setHeightInPoints(24);
				if(UtilFuns.isNotEmpty(printMap.get("Cnumber"))&&UtilFuns.isNotEmpty(printMap.get("Price"))){
					nCell  = nRow.createCell(8);
					nCell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
					nCell.setCellFormula("SUM(I"+String.valueOf(curRow-4)+":I"+String.valueOf(curRow-1)+")");
					nCell.setCellStyle(poiUtil.moneyrv12_BorderThin(wb,defaultFont12,rmb2Format));		
				}
			//}
			
			
			//note
			nRow = sheet.createRow(curRow++);
			nRow.setHeightInPoints(21);
			
			nCell = nRow.createCell(2);
			nCell.setCellValue(printMap.get("Remark"));
			nCell.setCellStyle(noteStyle(wb));			
			
			//Crequest
			region = new CellRangeAddress(curRow, curRow, 1, 8);	//ָ���ϲ����� 
			sheet.addMergedRegion(region);
			
			nRow = sheet.createRow(curRow++);
			float height = poiUtil.getCellAutoHeight(printMap.get("Crequest"), 12f);		//�Զ��߶�
			nRow.setHeightInPoints(height);
			
			nCell = nRow.createCell(1);
			nCell.setCellValue(printMap.get("Crequest"));
			nCell.setCellStyle(requestStyle(wb));
			
			//space line
			nRow = sheet.createRow(curRow++);
			nRow.setHeightInPoints(20);
			
			//duty
			nRow = sheet.createRow(curRow++);
			nRow.setHeightInPoints(32);
			
			nCell = nRow.createCell(1);
			nCell.setCellValue("δ������Ҫ����������¿������⣬�ɹ����е���");
			nCell.setCellStyle(dutyStyle(wb));	
			
			//space line
			nRow = sheet.createRow(curRow++);
			nRow.setHeightInPoints(32);
			
			//buyer
			nRow = sheet.createRow(curRow++);
			nRow.setHeightInPoints(25);
			
			nCell = nRow.createCell(1);
			nCell.setCellValue("    �չ��������ˣ�");
			nCell.setCellStyle(dutyStyle(wb));				
			
			//seller
			nCell = nRow.createCell(5);
			nCell.setCellValue("���������ˣ�");
			nCell.setCellStyle(dutyStyle(wb));	
			
			curRow++;

		}

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();			//����������
		wb.write(byteArrayOutputStream);													//��excelд����

		//�����࣬��װ�������ؿ�		
		String outFile = "������ͬ.xls";
		DownloadUtil down = new DownloadUtil();
		down.download(byteArrayOutputStream, response, outFile);

	}
	
	private HSSFCellStyle leftStyle(HSSFWorkbook wb){
		HSSFCellStyle curStyle = wb.createCellStyle();
		curStyle.setWrapText(true);  						//����   
		HSSFFont curFont = wb.createFont();					//��������
		curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);		//�����������壬�Ǳ��뻹Ҫ�ٶԵ�Ԫ����б�������
		//fTitle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);	//�Ӵ�
		curFont.setFontHeightInPoints((short)10);
		curStyle.setFont(curFont);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);		//��Ԫ��ֱ����
		
		curStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);				//ʵ���ұ߿�
		curStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);				//ʵ���ұ߿�
		
		return curStyle;
	}  
	
	private HSSFCellStyle headStyle(HSSFWorkbook wb){
		HSSFCellStyle curStyle = wb.createCellStyle();
		HSSFFont curFont = wb.createFont();					//��������
		curFont.setFontName("Comic Sans MS");
		curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);		//�����������壬�Ǳ��뻹Ҫ�ٶԵ�Ԫ����б�������
		
		curFont.setItalic(true);
		curFont.setFontHeightInPoints((short)16);
		curStyle.setFont(curFont);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);		//��Ԫ��ֱ����
		
		return curStyle;
	}  
	
	private HSSFCellStyle tipStyle(HSSFWorkbook wb){
		HSSFCellStyle curStyle = wb.createCellStyle();
		HSSFFont curFont = wb.createFont();					//��������
		curFont.setFontName("Georgia");
		curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);		//�����������壬�Ǳ��뻹Ҫ�ٶԵ�Ԫ����б�������
		
		curFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);	//�Ӵ�
		curFont.setFontHeightInPoints((short)28);
		curStyle.setFont(curFont);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);		//��Ԫ��ֱ����
		
		return curStyle;
	}  
	
	private HSSFCellStyle addressStyle(HSSFWorkbook wb){
		HSSFCellStyle curStyle = wb.createCellStyle();
		HSSFFont curFont = wb.createFont();					//��������
		curFont.setFontName("����");
		curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);		//�����������壬�Ǳ��뻹Ҫ�ٶԵ�Ԫ����б�������
		
		//fTitle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);	//�Ӵ�
		curFont.setFontHeightInPoints((short)10);
		curStyle.setFont(curFont);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);		//��Ԫ��ֱ����
		
		return curStyle;
	}  
	
	private HSSFCellStyle ltdStyle(HSSFWorkbook wb){
		HSSFCellStyle curStyle = wb.createCellStyle();
		HSSFFont curFont = wb.createFont();					//��������
		curFont.setFontName("Times New Roman");
		curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);		//�����������壬�Ǳ��뻹Ҫ�ٶԵ�Ԫ����б�������
		
		curFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);	//�Ӵ�
		curFont.setItalic(true);
		curFont.setFontHeightInPoints((short)16);
		curStyle.setFont(curFont);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);		//��Ԫ��ֱ����
		
		return curStyle;
	} 	
	
	private HSSFCellStyle telStyle(HSSFWorkbook wb){
		HSSFCellStyle curStyle = wb.createCellStyle();
		HSSFFont curFont = wb.createFont();					//��������
		curFont.setFontName("����");
		curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);		//�����������壬�Ǳ��뻹Ҫ�ٶԵ�Ԫ����б�������
		
		//fTitle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);	//�Ӵ�
		curFont.setFontHeightInPoints((short)9);
		curStyle.setFont(curFont);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);		//��Ԫ��ֱ����
		
		return curStyle;
	} 	
	
	private HSSFCellStyle titleStyle(HSSFWorkbook wb){
		HSSFCellStyle curStyle = wb.createCellStyle();
		HSSFFont curFont = wb.createFont();					//��������
		curFont.setFontName("����");
		curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);		//�����������壬�Ǳ��뻹Ҫ�ٶԵ�Ԫ����б�������
		
		curFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);	//�Ӵ�
		curFont.setFontHeightInPoints((short)18);
		curStyle.setFont(curFont);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);		//��Ԫ��ֱ����
		
		return curStyle;
	} 	
	
	private HSSFCellStyle requestStyle(HSSFWorkbook wb){
		HSSFCellStyle curStyle = wb.createCellStyle();
		curStyle.setWrapText(true);  						//����   
		HSSFFont curFont = wb.createFont();					//��������
		curFont.setFontName("����");
		curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);		//�����������壬�Ǳ��뻹Ҫ�ٶԵ�Ԫ����б�������
		
		curFont.setFontHeightInPoints((short)10);
		curStyle.setFont(curFont);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);		//��Ԫ��ֱ����
		
		return curStyle;
	} 	
	
	private HSSFCellStyle dutyStyle(HSSFWorkbook wb){
		HSSFCellStyle curStyle = wb.createCellStyle();
		HSSFFont curFont = wb.createFont();					//��������
		curFont.setFontName("����");
		curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);		//�����������壬�Ǳ��뻹Ҫ�ٶԵ�Ԫ����б�������
		
		curFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);	//�Ӵ�
		curFont.setFontHeightInPoints((short)16);
		curStyle.setFont(curFont);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);		//��Ԫ��ֱ����
		
		return curStyle;
	} 	
	
	private HSSFCellStyle noteStyle(HSSFWorkbook wb){
		HSSFCellStyle curStyle = wb.createCellStyle();
		HSSFFont curFont = wb.createFont();					//��������
		curFont.setFontName("����");
		curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);		//�����������壬�Ǳ��뻹Ҫ�ٶԵ�Ԫ����б�������
		
		curFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);	//�Ӵ�
		curFont.setFontHeightInPoints((short)12);
		curStyle.setFont(curFont);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);		//��Ԫ��ֱ����
		
		return curStyle;
	} 
	
	public HSSFCellStyle thStyle(HSSFWorkbook wb){
		HSSFCellStyle curStyle = wb.createCellStyle();
		HSSFFont curFont = wb.createFont();					//��������
		curFont.setFontName("����");
		curFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);	//�Ӵ�
		curFont.setFontHeightInPoints((short)12);
		curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);		//�����������壬�Ǳ��뻹Ҫ�ٶԵ�Ԫ����б�������
		
		curStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);				//ʵ���ұ߿�
		curStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);				//ʵ���ұ߿�
		curStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);			//ʵ���ұ߿�
		curStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);				//ʵ���ұ߿�
		
		curStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);		//��Ԫ��ֱ����
		
		return curStyle;
	}  
	
	public HSSFCellStyle bcv12(HSSFWorkbook wb){
		HSSFCellStyle curStyle = wb.createCellStyle();
		HSSFFont curFont = wb.createFont();						//��������
		curFont.setFontName("Times New Roman");
		curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);			//�����������壬�Ǳ��뻹Ҫ�ٶԵ�Ԫ����б�������
		
		curFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);		//�Ӵ�
		curFont.setFontHeightInPoints((short)12);
		curStyle.setFont(curFont);
		
		curStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);				//ʵ��
		curStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);			//��ʵ��
		curStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);			//ʵ��
		curStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);				//ʵ��
		
		curStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);		//��Ԫ��ֱ����
		
		return curStyle;
	}		
	
}
