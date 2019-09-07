package poi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
public class test {

	@Test
	public void testHSSF_base() throws IOException{
		/*
		 * �������裺
		 * 1������һ��������
		 * 2������һ��������
		 * 3������һ���ж���
		 * 4������һ����Ԫ�����ָ��������
		 * 5������Ԫ����������
		 * 6����ʽ�������Σ�������
		 * 7�����棬д�ļ�
		 * 8���رն���
		 */
		
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet();
		Row nRow = sheet.createRow(7);			//�ڰ���
		Cell nCell = nRow.createCell(4);		//������
		
		nCell.setCellValue("���ǲ������곤��");
		
		OutputStream os = new FileOutputStream("c:\\testpoi.xls");	//excel 2003
		wb.write(os);
		
		os.flush();
		os.close();
	}
	
	@Test	//����ʽ
	public void testHSSFStyle() throws IOException{
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet();
		Row nRow = sheet.createRow(7);			//�ڰ���
		Cell nCell = nRow.createCell(4);		//������
		
		nCell.setCellValue("���ǲ������곤��");
		
		//������ʽ
		CellStyle titleStyle = wb.createCellStyle();		//������Ԫ����ʽ
		Font titleFont = wb.createFont();					//����һ���������
		
		titleFont.setFontName("��������");					//������������
		titleFont.setFontHeightInPoints((short)24);			//���������С
		
		titleStyle.setFont(titleFont);						//���������
		
		
		nCell.setCellStyle(titleStyle);						//���õ�Ԫ����ʽ
		
		Row xRow = sheet.createRow(8);
		Cell xCell = xRow.createCell(6);
		
		CellStyle textSytle = wb.createCellStyle();
		Font textFont = wb.createFont();
		
		textFont.setFontName("Times New Roman");
		textFont.setFontHeightInPoints((short)14);
		
		textSytle.setFont(textFont);
		
		xCell.setCellValue("java.itcast.cn");
		xCell.setCellStyle(textSytle);
		
		OutputStream os = new FileOutputStream("c:\\testpoi.xls");	//excel 2003
		wb.write(os);
		
		os.flush();
		os.close();
	}
}
