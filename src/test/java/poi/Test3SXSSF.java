package poi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;


public class Test3SXSSF {
	public static void main(String[] args) throws Exception {
		Test3SXSSF tm = new Test3SXSSF();
		tm.jdbcex(true);
	}
	
	@Test
	public void print() throws Exception{
		String xlsFile = "c:/poiSXXFSBigData.xlsx";
		Workbook wb = new SXSSFWorkbook(100);
		Sheet sheet = wb.createSheet("�ҵĵ�һ��������");		//�����µ�sheet����

		Row nRow = null;
		Cell nCell   = null;
		
		for(int i=0;i<100;i++){
			nRow = sheet.createRow(i);
			for(int j=0;j<20;j++){
				nCell = nRow.createCell(j);
				nCell.setCellValue("���ǵ�Ԫ���ǲ���");
				nCell.setCellStyle(style(wb));
			}
				System.out.println(i);
		}
		FileOutputStream fOut = new FileOutputStream(xlsFile);
		wb.write(fOut);
		fOut.flush();
		fOut.close();
		
		System.out.println("finish.");
	}		
	
	@Test
	public void printXSSF() throws Exception{
		String xlsFile = "c:/poiXSSFData.xlsx";
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("�ҵĵ�һ��������");		//�����µ�sheet����
		
		Row nRow = null;
		Cell nCell   = null;
		
		for(int i=0;i<100;i++){
			nRow = sheet.createRow(i);
			for(int j=0;j<20;j++){
				nCell = nRow.createCell(j);
				nCell.setCellValue("���ǵ�Ԫ���ǲ���");
				nCell.setCellStyle(style(wb));
			}
			System.out.println(i);
		}
		FileOutputStream fOut = new FileOutputStream(xlsFile);
		wb.write(fOut);
		fOut.flush();
		fOut.close();
		
		System.out.println("finish.");
	}		

	@Test
	public void jdbcex(boolean isClose) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException, InterruptedException {
		String xlsFile = "c:/poiSXXFSDBBigData.xlsx";					//����ļ�
		Workbook wb = new SXSSFWorkbook(100);				//����excel�ļ����ڴ�ֻ��100����¼���ؼ���䡿
		Sheet sheet = wb.createSheet("�ҵĵ�һ��������");		//�����µ�sheet����

		Row nRow = null;
		Cell nCell   = null;

		//ʹ��jdbc�������ݿ�
		Class.forName("com.mysql.jdbc.Driver").newInstance();  
		
		String url = "jdbc:mysql://localhost:3306/jkmore100?characterEncoding=UTF-8";
		String user = "root";
		String password = "root";
		
		Connection conn = DriverManager.getConnection(url, user,password);   
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);   

		String sql = "select * from hpa limit 100000";   	//100���������
		ResultSet rs = stmt.executeQuery(sql);  						//bug Ҫ�ִζ�ȡ�������¼����
		
		
		long  startTime = System.currentTimeMillis();	//��ʼʱ��
		System.out.println("strat execute time: " + startTime);
		//context
		int rowNo = 0;
		int colNo = 0;
		while(rs.next()) {
			colNo = 0;
			nRow = sheet.createRow(rowNo++);

			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(rs.getString(colNo));
			
			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(rs.getString(colNo));
			
			if(rowNo%100==0){
				System.out.println("row no: " + rowNo);
			}
			
			Thread.sleep(1);			//��Ϣһ�£���ֹ��CPUռ��
		}
		
		long finishedTime = System.currentTimeMillis();	//�������ʱ��
		System.out.println("finished execute  time: " + (finishedTime - startTime)/1000 + "m");
		
		
		FileOutputStream fOut = new FileOutputStream(xlsFile);
		wb.write(fOut);
		fOut.flush();
		fOut.close();
		
		long stopTime = System.currentTimeMillis();		//д�ļ�ʱ��
		System.out.println("write xlsx file time: " + (stopTime - startTime)/1000 + "m");
		
		if(isClose){
			this.close(rs, stmt, conn);
		}
	}
	
	//close resource
	private void close(ResultSet rs, Statement stmt, Connection conn ) throws SQLException{
		rs.close();   
		stmt.close();   
		conn.close(); 
	}	
	
	//���õ�Ԫ����ʽ
	private CellStyle style(Workbook wb){
		CellStyle curStyle = wb.createCellStyle();
		Font curFont = wb.createFont();								//��������
		curFont.setFontName("΢���ź�");								//����Ӣ������
		curFont.setCharSet(XSSFFont.DEFAULT_CHARSET);					//�����������壬�Ǳ��뻹Ҫ�ٶԵ�Ԫ����б�������
		curFont.setFontHeightInPoints((short)10);						//�����С
		curStyle.setFont(curFont);
		
		curStyle.setBorderTop(XSSFCellStyle.BORDER_THICK);				//��ʵ��
		curStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);			//ʵ��
		curStyle.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);			//�Ƚϴ�ʵ��
		curStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);				//ʵ��
		
		curStyle.setWrapText(true);  									//����   
		curStyle.setAlignment(XSSFCellStyle.ALIGN_RIGHT);				//������Ҷ���
		curStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);	//��Ԫ��ֱ����
		
		return curStyle;
	}
}
