package poi;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;


public class Test1HFFS {
	@Test
	public void rule() throws FileNotFoundException, IOException{
		String xlsFile = "c:/poiHFFS.xls";
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(xlsFile));
		
		System.out.println("������������ʽ\t"+wb.getNumCellStyles());
		System.out.println("��������������\t"+wb.getNumberOfFonts());
		
		HSSFSheet sheet = wb.getSheetAt(0);
		
		System.out.println("�����ٺϲ���Ԫ��\t"+sheet.getNumMergedRegions());
		System.out.println("��ʼ����\t"+sheet.getFirstRowNum());
		System.out.println("��������\t"+sheet.getLastRowNum()+1);
		
	}
	
	@Test
	public void print() throws Exception{
		String xlsFile = "c:/poiHFFS.xls";
		
		//STEP 1:��excel�ļ�
		HSSFWorkbook wb = new HSSFWorkbook();									//����excel�ļ�
		//HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(xlsFile));		//���Ѵ��ڵ�excel�ļ�

		//STEP 2:�򿪵�ǰ������
		HSSFSheet sheet = wb.createSheet("�ҵĵ�һ��������");		//�����µ�sheet����
		//HSSFSheet sheet = wb.getSheetAt(0);						//ѡ���һ��������
		//wb.setSheetName(0, "�ҵĵ�һ��������");					//���ù�����������

		HSSFRow nRow = null;
		HSSFCell nCell   = null;
		
		//STEP 3:�����ж���
		nRow = sheet.createRow((short)1);						//��2��

		//STEP 4:ָ���� ������Ԫ�����
		nCell = nRow.createCell((short)(2));					//��3��
		
		//STEP 5:ָ���� ������Ԫ�����
		nCell.setCellValue("���ǵ�Ԫ��");
		
		//STEP 6:������ʽ
		nCell.setCellStyle(leftStyle(wb));

		//STEP 7:�رձ���excel�ļ�
		FileOutputStream fOut = new FileOutputStream(xlsFile);
		wb.write(fOut);
		fOut.flush();
		fOut.close();

		System.out.println("finish.");
	}	
	
	
	//���õ�Ԫ����ʽ
	private HSSFCellStyle leftStyle(HSSFWorkbook wb){
		HSSFCellStyle curStyle = wb.createCellStyle();
		HSSFFont curFont = wb.createFont();								//��������
		//curFont.setFontName("Times New Roman");						//����Ӣ������
		curFont.setFontName("΢���ź�");								//����Ӣ������
		curFont.setCharSet(HSSFFont.DEFAULT_CHARSET);					//�����������壬�Ǳ��뻹Ҫ�ٶԵ�Ԫ����б�������
		curFont.setFontHeightInPoints((short)10);						//�����С
		curStyle.setFont(curFont);
		
		curStyle.setBorderTop(HSSFCellStyle.BORDER_THICK);				//��ʵ��
		curStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);			//ʵ��
		curStyle.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);			//�Ƚϴ�ʵ��
		curStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);				//ʵ��
		
		curStyle.setWrapText(true);  									//����   
		curStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);				//������Ҷ���
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);	//��Ԫ��ֱ����
		
		return curStyle;
	}
	
}
