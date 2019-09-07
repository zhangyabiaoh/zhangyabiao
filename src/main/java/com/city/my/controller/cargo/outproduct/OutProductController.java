package com.city.my.controller.cargo.outproduct;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.city.my.controller.BaseController;
import com.city.my.service.OutProductService;
import com.city.my.vo.OutProductVO;
import com.city.util.DownloadUtil;
@Controller
public class OutProductController  extends BaseController{

	@Resource
	OutProductService outProductService;
	//ת��༭ҳ��
		@RequestMapping("/cargo/outproduct/toedit.action")
		public String toedit(){
			return "/cargo/outproduct/jOutProduct.jsp";
		}
		
		
		@RequestMapping("/cargo/outproduct/printNotemplate.action")
		public void printNotemplate(String inputDate) throws IOException{
			
			/*
			 * POIʵ��excel��ӡ
			 * 1������⣬�ϲ���Ԫ��
			 * 2�����⣬����
			 * 3�����ݣ�����
			 * 
			 */
			
			Workbook wb = new HSSFWorkbook();		//����һ��������
			Sheet sheet = wb.createSheet();			//����һ��������
			Row nRow = null;
			Cell nCell = null;
			int rowNo = 0;							//�к�
			int colNo = 1;							//�к�
			
			//������ʽ���������
			CellStyle curStyle = wb.createCellStyle();
			Font curFont = wb.createFont();
			
			sheet.setColumnWidth(0, 1*278);				//�����п� 256��BUG�����Ȳ��������ǲ�һ��
			sheet.setColumnWidth(1, 26*278);
					
			
			//��������	sheet.addMergedRegion(new CellRangeAddress(��ʼ�У������У���ʼ�У�������));
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 8));		//�ϲ���Ԫ��
			nRow = sheet.createRow(rowNo++);
			nRow.setHeightInPoints(36);
			
			nCell = nRow.createCell(1);
			nCell.setCellStyle(bigTitleStyle(wb));
			
			nCell.setCellValue(inputDate.replaceFirst("-0", "-").replaceFirst("-", "��") + "�·ݳ�����");		//yyyy-MM
			
			//�������
			String[] title = new String[]{"�ͻ�","������","����","����","����","��������","����","ó������"};	//��������
			nRow = sheet.createRow(rowNo++);
			nRow.setHeightInPoints(26);
			
			for(int i=0;i<title.length;i++){
				nCell = nRow.createCell(i+1);
				nCell.setCellValue(title[i]);
				nCell.setCellStyle(this.titleStyle(wb));
			}
			
			//��������
			List<OutProductVO> dataList = outProductService.find(inputDate);
			for(int j=0;j<dataList.size();j++){
				colNo = 1;				//��ʼ��
				OutProductVO op = dataList.get(j);
				
				nRow = sheet.createRow(rowNo++);
				nRow.setHeightInPoints(24);
				
				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getCustomName());
				nCell.setCellStyle(this.textStyle(wb, curStyle, curFont));
				
				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getContractNo());
				nCell.setCellStyle(this.textStyle(wb, curStyle, curFont));
				
				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getProductNo());
				nCell.setCellStyle(this.textStyle(wb, curStyle, curFont));
				
				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getCnumber());
				nCell.setCellStyle(this.textStyle(wb, curStyle, curFont));
				
				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getFactoryName());
				nCell.setCellStyle(this.textStyle(wb, curStyle, curFont));
				
				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getDeliveryPeriod());
				nCell.setCellStyle(this.textStyle(wb, curStyle, curFont));
				
				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getShipTime());
				nCell.setCellStyle(this.textStyle(wb, curStyle, curFont));
				
				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getTradeTerms());
				nCell.setCellStyle(this.textStyle(wb, curStyle, curFont));
			}
			
			OutputStream os = new FileOutputStream("c:\\outproduct.xls");
			wb.write(os);
			
			os.flush();
			os.close();
		}
		
		//ģ�忪��
		@RequestMapping("/cargo/outproduct/printHSSF.action")
		public void printHSSF(String inputDate, HttpServletRequest request, HttpServletResponse response) throws IOException{
			//linux��jdk1.8 ������ȡʱ������ƴ���Լ�д��Ŀ¼ 
			String path = request.getSession().getServletContext().getRealPath("/") + "/make/xlsprint/";
			InputStream is = new FileInputStream(new File(path + "tOUTPRODUCT.xls"));
			
			Workbook wb = new HSSFWorkbook(is);		//��һ��ģ���ļ���������
			Sheet sheet = wb.getSheetAt(0);			//��ȡ����һ��������
			
			Row nRow = null;
			Cell nCell = null;
			int rowNo = 0;							//�к�
			int colNo = 1;							//�к�
			
			//��ȡģ���ϵĵ�Ԫ����ʽ
			nRow = sheet.getRow(2);
			
			//�ͻ�����ʽ
			nCell = nRow.getCell(1);
			CellStyle customStyle = nCell.getCellStyle();		
			
			//�����ŵ���ʽ
			nCell = nRow.getCell(2);
			CellStyle contractNoStyle = nCell.getCellStyle();		
			
			//���ŵ���ʽ
			nCell = nRow.getCell(3);
			CellStyle productNoStyle = nCell.getCellStyle();		
			
			//��������ʽ
			nCell = nRow.getCell(4);
			CellStyle numStyle = nCell.getCellStyle();		
			
			//�������ҵ���ʽ
			nCell = nRow.getCell(5);
			CellStyle factoryStyle = nCell.getCellStyle();		
			
			//���ڵ���ʽ
			nCell = nRow.getCell(6);
			CellStyle dateStyle = nCell.getCellStyle();		
			
			//ó���������ʽ
			nCell = nRow.getCell(8);
			CellStyle tradeStyle = nCell.getCellStyle();		
					
			
			//��������
			nRow = sheet.getRow(rowNo++);			//��ȡһ���ж���
			nCell = nRow.getCell(colNo);			//��ȡһ����Ԫ�����
			nCell.setCellValue(inputDate.replaceFirst("-0", "-").replaceFirst("-", "��") + "�·ݳ�����");		//yyyy-MM
			
			rowNo++;								//������̬���ͷ
			
			//��������
			List<OutProductVO> dataList = outProductService.find(inputDate);
			for(int j=0;j<dataList.size();j++){
				colNo = 1;				//��ʼ��
				OutProductVO op = dataList.get(j);
				
				nRow = sheet.createRow(rowNo++);
				nRow.setHeightInPoints(24);
				
				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getCustomName());
				nCell.setCellStyle(customStyle);
				
				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getContractNo());
				nCell.setCellStyle(contractNoStyle);
				
				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getProductNo());
				nCell.setCellStyle(productNoStyle);
				
				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getCnumber());
				nCell.setCellStyle(numStyle);
				
				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getFactoryName());
				nCell.setCellStyle(factoryStyle);
				
				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getDeliveryPeriod());
				nCell.setCellStyle(dateStyle);
				
				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getShipTime());
				nCell.setCellStyle(dateStyle);
				
				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getTradeTerms());
				nCell.setCellStyle(tradeStyle);
			}
			
//			OutputStream os = new FileOutputStream("c:\\outproduct.xls");
//			wb.write(os);
//			
//			os.flush();
//			os.close();
			
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			wb.write(os);
			
			DownloadUtil downloadUtil = new DownloadUtil();				//ֱ�ӵ������ؿ��û����Դ򿪣����Ա���
			downloadUtil.download(os, response, "������.xls");
			
			os.flush();
			os.close();
		}
		//ģ�忪��XSSF
		@RequestMapping("/cargo/outproduct/print.action")
		public void print(String inputDate, HttpServletRequest request, HttpServletResponse response) throws IOException, InvalidFormatException{
			//linux��jdk1.8 ������ȡʱ������ƴ���Լ�д��Ŀ¼ 
			String path = request.getSession().getServletContext().getRealPath("/") + "/make/xlsprint/";
			InputStream is = new FileInputStream(new File(path + "tOUTPRODUCT.xlsx"));
			
			//Workbook wb = new XSSFWorkbook(is);		//��һ��ģ���ļ��������� 2007���ϰ汾
			 //Workbook wb = new HSSFWorkbook(is);
			Workbook wb;
			Sheet sheet;
			wb = WorkbookFactory.create(is);
			 //wb = new XSSFWorkbook(new BufferedInputStream(new FileInputStream(path + "tOUTPRODUCT.xlsx")));
			// wb = new XSSFWorkbook(is);
			sheet = wb.getSheetAt(0);			//��ȡ����һ��������
			
			
			Row nRow = null;
			Cell nCell = null;
			int rowNo = 0;							//�к�
			int colNo = 1;							//�к�
			
			//��ȡģ���ϵĵ�Ԫ����ʽ
			nRow = sheet.getRow(2);
			
			//�ͻ�����ʽ
			nCell = nRow.getCell(1);
			CellStyle customStyle = nCell.getCellStyle();		
			
			//�����ŵ���ʽ
			nCell = nRow.getCell(2);
			CellStyle contractNoStyle = nCell.getCellStyle();		
			
			//���ŵ���ʽ
			nCell = nRow.getCell(3);
			CellStyle productNoStyle = nCell.getCellStyle();		
			
			//��������ʽ
			nCell = nRow.getCell(4);
			CellStyle numStyle = nCell.getCellStyle();		
			
			//�������ҵ���ʽ
			nCell = nRow.getCell(5);
			CellStyle factoryStyle = nCell.getCellStyle();		
			
			//���ڵ���ʽ
			nCell = nRow.getCell(6);
			CellStyle dateStyle = nCell.getCellStyle();		
			
			//ó���������ʽ
			nCell = nRow.getCell(8);
			CellStyle tradeStyle = nCell.getCellStyle();		
			
			
			//��������
			nRow = sheet.getRow(rowNo++);			//��ȡһ���ж���
			nCell = nRow.getCell(colNo);			//��ȡһ����Ԫ�����
			nCell.setCellValue(inputDate.replaceFirst("-0", "-").replaceFirst("-", "��") + "�·ݳ�����");		//yyyy-MM
			
			rowNo++;								//������̬���ͷ
			
			//��������
			List<OutProductVO> dataList = outProductService.find(inputDate);
			for(int j=0;j<dataList.size();j++){
				colNo = 1;				//��ʼ��
				OutProductVO op = dataList.get(j);
				
				nRow = sheet.createRow(rowNo++);
				nRow.setHeightInPoints(24);
				
				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getCustomName());
				nCell.setCellStyle(customStyle);
				
				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getContractNo());
				nCell.setCellStyle(contractNoStyle);
				
				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getProductNo());
				nCell.setCellStyle(productNoStyle);
				
				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getCnumber());
				nCell.setCellStyle(numStyle);
				
				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getFactoryName());
				nCell.setCellStyle(factoryStyle);
				
				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getDeliveryPeriod());
				nCell.setCellStyle(dateStyle);
				
				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getShipTime());
				nCell.setCellStyle(dateStyle);
				
				nCell = nRow.createCell(colNo++);
				nCell.setCellValue(op.getTradeTerms());
				nCell.setCellStyle(tradeStyle);
			}
			
//			OutputStream os = new FileOutputStream("c:\\outproduct.xls");
//			wb.write(os);
//			
//			os.flush();
//			os.close();
			
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			wb.write(os);
			
			DownloadUtil downloadUtil = new DownloadUtil();				//ֱ�ӵ������ؿ��û����Դ򿪣����Ա���
			downloadUtil.download(os, response, "������.xlsx");
			
			os.flush();
			os.close();
		}
		
		//�������ʽ
		private CellStyle bigTitleStyle(Workbook wb){
			CellStyle curStyle = wb.createCellStyle();
			Font curFont = wb.createFont();
			
			curFont.setFontName("����");
			curFont.setFontHeightInPoints((short)16);
			curFont.setBoldweight(Font.BOLDWEIGHT_BOLD);					//����Ӵ�
			
			curStyle.setFont(curFont);										//������
			
			curStyle.setAlignment(CellStyle.ALIGN_CENTER);					//�������
			curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//�������
			
			return curStyle;
		}
		
		//С������ʽ
		private CellStyle titleStyle(Workbook wb){
			CellStyle curStyle = wb.createCellStyle();
			Font curFont = wb.createFont();
			
			curFont.setFontName("����");
			curFont.setFontHeightInPoints((short)12);
			
			curStyle.setFont(curFont);										//������
			
			curStyle.setAlignment(CellStyle.ALIGN_CENTER);					//�������
			curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//�������
			
			
			curStyle.setBorderTop(CellStyle.BORDER_THIN);					//�������ܱ��ߣ�ϸ��
			curStyle.setBorderBottom(CellStyle.BORDER_THIN);
			curStyle.setBorderLeft(CellStyle.BORDER_THIN);
			curStyle.setBorderRight(CellStyle.BORDER_THIN);
			
			return curStyle;
		}
		
		//������ʽ
		private CellStyle textStyle(Workbook wb, CellStyle curStyle, Font curFont){
			
			curFont.setFontName("Times New Roman");
			curFont.setFontHeightInPoints((short)10);
			
			curStyle.setFont(curFont);										//������
			
			curStyle.setAlignment(CellStyle.ALIGN_LEFT);					//�������
			curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//�������
			
			
			curStyle.setBorderTop(CellStyle.BORDER_THIN);					//�������ܱ��ߣ�ϸ��
			curStyle.setBorderBottom(CellStyle.BORDER_THIN);
			curStyle.setBorderLeft(CellStyle.BORDER_THIN);
			curStyle.setBorderRight(CellStyle.BORDER_THIN);
			
			return curStyle;
		}
		
}
