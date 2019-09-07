package poi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.junit.Test;


public class TesstJXL {

	@Test
	public void print() throws IOException, RowsExceededException, WriteException {
		WritableWorkbook workbook = null;
		String worksheet = "List";// �����excel�ļ���������
		String[] title = { "���", "�ͻ�����", "��ϵ�绰", "�ݷ�����", "�ٷ�ʱ��", "�ݽ�����������","�ͻ���Դ", "�Ƿ�ǩҪ����", "�Ƿ���ȡ����", "���", "����", "��ԥ���˱�����" };// excel������ı���

		OutputStream os = new FileOutputStream("c:\\testJXL.xls");
		workbook = Workbook.createWorkbook(os);

		// ������һҳ��sheet
		WritableSheet sheet1 = workbook.createSheet("MySheet1", 0); 		// ����ӵ�һ������
		// WritableSheet sheet2 = workbook.createSheet("MySheet2", 1);
		// //����ӵڶ�������

		for (int i = 0; i < title.length; i++) {
			Label label = new jxl.write.Label(i, 0, title[i]); 				// put the title	// Label(�к�,�к� ,���� )
																			// in row1
			sheet1.addCell(label);
		}
		
		workbook.write();		// ������ļ�
		workbook.close();		// �ر��ļ�
	}
	
	@Test
	public void printWithStyle() throws IOException, RowsExceededException, WriteException {
		WritableWorkbook workbook = null;
		String worksheet = "List";// �����excel�ļ���������
		String[] title = { "���", "�ͻ�����", "��ϵ�绰", "�ݷ�����", "�ٷ�ʱ��", "�ݽ�����������","�ͻ���Դ", "�Ƿ�ǩҪ����", "�Ƿ���ȡ����", "���", "����", "��ԥ���˱�����" };// excel������ı���
		
		OutputStream os = new FileOutputStream("c:\\testJXL.xls");
		workbook = Workbook.createWorkbook(os);
		
		// ������һҳ��sheet
		WritableSheet sheet = workbook.createSheet("MySheet1", 0); // ����ӵ�һ������
		// WritableSheet sheet2 = workbook.createSheet("MySheet2", 1);
		// //����ӵڶ�������
		
		for (int i = 0; i < title.length; i++) {
			// Label(�к�,�к� ,���� )
			Label label = new jxl.write.Label(i, 0, title[i]); // put the title
			// in row1
			sheet.addCell(label);
		}
		
		//�������
		jxl.write.Number number = new jxl.write.Number(3, 4, 3.14159); //put the number 3.14159 in cell D5
		sheet.addCell(number);

		//��Ӵ�������Formatting�Ķ��� 
		jxl.write.WritableFont wf = new jxl.write.WritableFont(WritableFont.TIMES,10,WritableFont.BOLD,true); 
		jxl.write.WritableCellFormat wcfF = new jxl.write.WritableCellFormat(wf); 
		jxl.write.Label labelCF = new jxl.write.Label(4,4,"�ı�",wcfF); 
		sheet.addCell(labelCF); 

		//��Ӵ���������ɫ,��������ɫ Formatting�Ķ��� 
		jxl.write.WritableFont wfc = new jxl.write.WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD,false,jxl.format.UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.RED); 
		jxl.write.WritableCellFormat wcfFC = new jxl.write.WritableCellFormat(wfc); 
		wcfFC.setBackground(jxl.format.Colour.BLUE);
		jxl.write.Label labelCFC = new jxl.write.Label(1,5,"����ɫ",wcfFC); 
		sheet.addCell(labelCFC); 

		//��Ӵ���formatting��Number���� 
		jxl.write.NumberFormat nf = new jxl.write.NumberFormat("#.##"); 
		jxl.write.WritableCellFormat wcfN = new jxl.write.WritableCellFormat(nf); 
		jxl.write.Number labelNF = new jxl.write.Number(1,1,3.1415926,wcfN); 
		sheet.addCell(labelNF); 

		//3.���Boolean���� 
		jxl.write.Boolean labelB = new jxl.write.Boolean(0,2,false); 
		sheet.addCell(labelB); 

		//4.���DateTime���� 
		jxl.write.DateTime labelDT = new jxl.write.DateTime(0,3,new java.util.Date()); 
		sheet.addCell(labelDT); 

		//��Ӵ���formatting��DateFormat���� 
		jxl.write.DateFormat df = new jxl.write.DateFormat("ddMMyyyyhh:mm:ss"); 
		jxl.write.WritableCellFormat wcfDF = new jxl.write.WritableCellFormat(df); 
		jxl.write.DateTime labelDTF = new jxl.write.DateTime(1,3,new java.util.Date(),wcfDF); 
		sheet.addCell(labelDTF); 

		//�ϲ���Ԫ��
		//sheet.mergeCells(int col1,int row1,int col2,int row2);//���Ͻǵ����½�
		sheet.mergeCells(4,5,8,10);//���Ͻǵ����½�
		wfc = new jxl.write.WritableFont(WritableFont.ARIAL,40,WritableFont.BOLD,false,jxl.format.UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.GREEN); 
		jxl.write.WritableCellFormat wchB = new jxl.write.WritableCellFormat(wfc); 
		wchB.setAlignment(jxl.format.Alignment.CENTRE);
		labelCFC = new jxl.write.Label(4,5,"��Ԫ�ϲ�",wchB); 
		sheet.addCell(labelCFC); //


		//���ñ߿�
		jxl.write.WritableCellFormat wcsB = new jxl.write.WritableCellFormat(); 
		wcsB.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THICK);
		labelCFC = new jxl.write.Label(0,6,"�߿�����",wcsB); 
		sheet.addCell(labelCFC); 		
		
		workbook.write();		// ������ļ�
		workbook.close();		// �ر��ļ�
	}
}
