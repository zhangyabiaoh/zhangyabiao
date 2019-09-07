package poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;


public class Test2XSSF {
	@Test
	public void rule() throws FileNotFoundException, IOException{
		String xlsFile = "c:/poiXFFS.xlsx";
		Workbook wb = new XSSFWorkbook(new FileInputStream(xlsFile));
		
		System.out.println("������������ʽ\t"+wb.getNumCellStyles());
		System.out.println("��������������\t"+wb.getNumberOfFonts());
		
		Sheet sheet = wb.getSheetAt(0);
		
		System.out.println("�����ٺϲ���Ԫ��\t"+sheet.getNumMergedRegions());
		System.out.println("��ʼ����\t"+sheet.getFirstRowNum());
		System.out.println("��������\t"+sheet.getLastRowNum()+1);
		
	}
	
	
	/*
	 * dom4j-1.6.1.jar
	 * poi-3.9-20121203.jar
	 * poi-ooxml-3.9-20121203.jar
	 * poi-ooxml-schemas-3.9-20121203.jar
	 * stax-api-1.0.1.jar
	 * xmlbeans-2.3.0.jar
	 */
	@Test	
	public void print() throws Exception{
		String xlsFile = "c:/clroleprice.xlsx";
		
		//STEP 1:��excel�ļ�
		Workbook wb = new XSSFWorkbook();									//����excel�ļ�
		//Workbook wb = new XSSFWorkbook(new FileInputStream(xlsFile));		//���Ѵ��ڵ�excel�ļ�

		//STEP 2:�򿪵�ǰ������
		Sheet sheet = wb.createSheet("�ҵĵ�һ��������");		//�����µ�sheet����
		//Sheet sheet = wb.getSheetAt(0);						//ѡ���һ��������
		//wb.setSheetName(0, "�ҵĵ�һ��������");					//���ù�����������

		Row nRow = null;
		Cell nCell   = null;
		
		//STEP 3:�����ж���
		nRow = sheet.createRow((short)1);						//��2��

		//STEP 4:ָ���� ������Ԫ�����
		nCell = nRow.createCell((short)(2));					//��3��
		
		//STEP 5:ָ���� ������Ԫ�����
		nCell.setCellValue("���ǵ�Ԫ���ǲ���");
		
		//STEP 6:������ʽ
		nCell.setCellStyle(leftStyle(wb));

		//STEP 7:�رձ���excel�ļ�
		FileOutputStream fOut = new FileOutputStream(xlsFile);
		wb.write(fOut);
		fOut.flush();
		fOut.close();

	}	
	
	@Test	
	public void testprint() throws Exception{
		String xlsFile = "c:/clroleprice.xlsx";
		
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("�ҵĵ�һ��������");
		
		Row nRow = null;
		Cell nCell   = null;
		
		
		for(int i=0;i<100000;i++){
			System.out.println(i);
			nRow = sheet.createRow(i);
			
			for(int j=0;j<20;j++){
				nCell = nRow.createCell(j);
				nCell.setCellValue("���ǵ�Ԫ���ǲ���");
			}
		}
		
		//STEP 6:������ʽ
		nCell.setCellStyle(leftStyle(wb));
		
		//STEP 7:�رձ���excel�ļ�
		FileOutputStream fOut = new FileOutputStream(xlsFile);
		wb.write(fOut);
		fOut.flush();
		fOut.close();
		
	}	
	
	
	
	//���õ�Ԫ����ʽ
	private CellStyle leftStyle(Workbook wb){
		CellStyle curStyle = wb.createCellStyle();
		Font curFont = wb.createFont();								//��������
		//curFont.setFontName("Times New Roman");						//����Ӣ������
		curFont.setFontName("΢���ź�");								//����Ӣ������
		curFont.setCharSet(Font.DEFAULT_CHARSET);					//�����������壬�Ǳ��뻹Ҫ�ٶԵ�Ԫ����б�������
		curFont.setFontHeightInPoints((short)10);						//�����С
		curStyle.setFont(curFont);
		
		curStyle.setBorderTop(CellStyle.BORDER_THICK);				//��ʵ��
		curStyle.setBorderBottom(CellStyle.BORDER_THIN);			//ʵ��
		curStyle.setBorderLeft(CellStyle.BORDER_MEDIUM);			//�Ƚϴ�ʵ��
		curStyle.setBorderRight(CellStyle.BORDER_THIN);				//ʵ��
		
		curStyle.setWrapText(true);  									//����   
		curStyle.setAlignment(CellStyle.ALIGN_RIGHT);				//������Ҷ���
		curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);	//��Ԫ��ֱ����
		
		return curStyle;
	}
	
}
