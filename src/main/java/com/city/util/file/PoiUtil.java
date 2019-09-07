package com.city.util.file;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import javax.imageio.ImageIO;
public class PoiUtil {

	private static final String ENFONT = "Times New Roman";

	public HSSFFont defaultFont10(HSSFWorkbook wb) {
		HSSFFont curFont = wb.createFont(); // ��������
		curFont.setFontName(this.ENFONT);
		curFont.setCharSet(HSSFFont.DEFAULT_CHARSET); // �����������壬�Ǳ��뻹Ҫ�ٶԵ�Ԫ����б�������
		curFont.setFontHeightInPoints((short) 10);

		return curFont;
	}
	
	public HSSFFont defaultFont10Blod(HSSFWorkbook wb) {
		HSSFFont curFont = wb.createFont(); // ��������
		curFont.setFontName(this.ENFONT);
		curFont.setCharSet(HSSFFont.DEFAULT_CHARSET); // �����������壬�Ǳ��뻹Ҫ�ٶԵ�Ԫ����б�������
		curFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // �Ӵ�
		curFont.setFontHeightInPoints((short) 10);
		
		return curFont;
	}

	public HSSFFont defaultFont12(HSSFWorkbook wb) {
		HSSFFont curFont = wb.createFont(); // ��������
		curFont.setFontName(this.ENFONT);
		curFont.setCharSet(HSSFFont.DEFAULT_CHARSET); // �����������壬�Ǳ��뻹Ҫ�ٶԵ�Ԫ����б�������
		curFont.setFontHeightInPoints((short) 12);

		return curFont;
	}

	public HSSFFont blackFont12(HSSFWorkbook wb) {
		HSSFFont theFont = wb.createFont(); // ��������
		theFont.setFontName("����");
		theFont.setCharSet(HSSFFont.DEFAULT_CHARSET); // �����������壬�Ǳ��뻹Ҫ�ٶԵ�Ԫ����б�������
		theFont.setFontHeightInPoints((short) 12);

		return theFont;
	}

	public HSSFFont songBoldFont16(HSSFWorkbook wb) {
		HSSFFont curFont = wb.createFont(); // ��������
		curFont.setFontName("����");
		curFont.setCharSet(HSSFFont.DEFAULT_CHARSET); // �����������壬�Ǳ��뻹Ҫ�ٶԵ�Ԫ����б�������
		curFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // �Ӵ�
		curFont.setFontHeightInPoints((short) 16);

		return curFont;
	}

	public short money1Format(HSSFWorkbook wb) {
		HSSFDataFormat format = wb.createDataFormat();
		return format.getFormat("#,###,###.0"); // ���ø�ʽ
	}

	public short money2Format(HSSFWorkbook wb) {
		HSSFDataFormat format = wb.createDataFormat();
		return format.getFormat("#,###,###.00"); // ���ø�ʽ
	}

	public short rmb2Format(HSSFWorkbook wb) {
		HSSFDataFormat format = wb.createDataFormat();
		return format.getFormat("\"��\"#,###,###.00"); // ���ø�ʽ
	}

	public short rmb4Format(HSSFWorkbook wb) {
		HSSFDataFormat format = wb.createDataFormat();
		return format.getFormat("\"��\"#,###,##0.00"); // ���ø�ʽ
	}

	public short datevENFormat(HSSFWorkbook wb) {
		HSSFDataFormat format = wb.createDataFormat();
		return format.getBuiltinFormat("m/d/yy"); // ���ø�ʽ
	}

	// ָ��ͼƬ����Ϊjpg
	public void setPicture(HSSFWorkbook wb, HSSFPatriarch patriarch, String pic, int iRow, int iCol) throws IOException {
		// �ж��ļ��Ƿ����
		File imgFile = new File(pic);
		if (imgFile.exists()) {
			// ͼƬ����
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			BufferedImage bufferImg = ImageIO.read(imgFile);
			ImageIO.write(bufferImg, "jpg", byteArrayOut);

			HSSFClientAnchor anchor = new HSSFClientAnchor(190, 0, 1000, 0, (short) (iCol), iRow - 1, (short) (iCol + 1), iRow);
			patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
		}
	}

	// ָ��ͼƬ����Ϊjpg
	public void setPicture(HSSFWorkbook wb, HSSFPatriarch patriarch, String pic, int iRowStart, int iColStart, int iRowStop, int iColStop) throws IOException {
		// �ж��ļ��Ƿ����
		File imgFile = new File(pic);
		if (imgFile.exists()) {
			// ͼƬ����
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			BufferedImage bufferImg = ImageIO.read(imgFile);
			ImageIO.write(bufferImg, "jpg", byteArrayOut);

			// ��,��(0-255),��(0-1023),��
			HSSFClientAnchor anchor = new HSSFClientAnchor(20, 1, 1018, 0, (short) (iColStart), iRowStart, (short) (iColStop), iRowStop);
			patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
		}
	}

	// ����
	public void setLine(HSSFWorkbook wb, HSSFPatriarch patriarch, int iRowStart, int iColStart, int iRowStop, int iColStop) {
		HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 350, 0, (short) (iColStart), iRowStart, (short) (iColStop), iRowStop);
		HSSFSimpleShape lineShape = patriarch.createSimpleShape(anchor);
		lineShape.setShapeType(HSSFSimpleShape.OBJECT_TYPE_LINE);
	}

	// �����и߶ȣ�ʵ�����Զ���Ӧ�߶� defaultRowHeight = 12.00f; //ÿһ�еĸ߶�ָ��   Ŀǰֻʵ�ָ��ݻس��������жϣ����ܸ��ݵ�Ԫ�����Զ��������ж�
	public float getCellAutoHeight(String str, float defaultRowHeight) {
		if (str == null) {
			return defaultRowHeight;
		}
		float height = 0.00f;
		int n = 0;
		if (str.endsWith("\n")) {
			n = str.split("\n").length; // �س�����
		} else {
			n = str.split("\n").length + 1; // �س�����
		}
		height = defaultRowHeight * n;

		return height; // ����
	}

	//�����ַ����߶�
	public float getregex(String charStr) {
		if (charStr.equals(" ")) {
			return 0.5f;
		}
		if (Pattern.compile("^[A-Za-z0-9]+$").matcher(charStr).matches()) {
			return 0.5f;
		}
		// �ж��Ƿ�Ϊȫ��
		if (Pattern.compile("^[\u4e00-\u9fa5]+$").matcher(charStr).matches()) {
			return 1.00f;
		}
		if (Pattern.compile("^x00-xff]+$").matcher(charStr).matches()) {
			return 1.00f;
		}
		return 0.5f;
	}

	public HSSFCellStyle titlev12(HSSFWorkbook wb, HSSFFont blackFont) {
		HSSFCellStyle curStyle = wb.createCellStyle();

		curStyle.setFont(blackFont);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // ��Ԫ��ֱ����

		return curStyle;
	}

	public HSSFCellStyle nobox(HSSFWorkbook wb) {
		HSSFCellStyle curStyle = wb.createCellStyle();

		curStyle.setBorderTop(HSSFCellStyle.BORDER_NONE); // ʵ���ұ߿�
		curStyle.setBorderRight(HSSFCellStyle.BORDER_NONE); // ʵ���ұ߿�
		curStyle.setBorderBottom(HSSFCellStyle.BORDER_NONE); // ʵ���ұ߿�
		curStyle.setBorderLeft(HSSFCellStyle.BORDER_NONE); // ʵ���ұ߿�

		curStyle.setTopBorderColor((short) 0);

		return curStyle;
	}

	// ʵ�ִ�ӡʱΪ�׿�Ŀ�ľ���ʵ��Ϳȥ���е��±߿��� by tony 20110709
	public HSSFCellStyle whiteBox(HSSFWorkbook wb) {
		HSSFCellStyle curStyle = wb.createCellStyle();

		curStyle.setTopBorderColor(HSSFColor.WHITE.index);
		curStyle.setRightBorderColor(HSSFColor.WHITE.index);
		curStyle.setBottomBorderColor(HSSFColor.WHITE.index);
		curStyle.setLeftBorderColor(HSSFColor.WHITE.index);

		curStyle.setBorderTop(HSSFCellStyle.BORDER_THIN); // ʵ���ұ߿�
		curStyle.setBorderRight(HSSFCellStyle.BORDER_THIN); // ʵ���ұ߿�
		curStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // ʵ���ұ߿�
		curStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN); // ʵ���ұ߿�

		return curStyle;
	}

	public HSSFCellStyle normalv12(HSSFWorkbook wb, HSSFFont defaultFont12) {
		HSSFCellStyle curStyle = wb.createCellStyle();
		curStyle.setFont(defaultFont12);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // ��Ԫ��ֱ����

		return curStyle;
	}

	public HSSFCellStyle normalv10(HSSFWorkbook wb, HSSFFont defaultFont10) {
		HSSFCellStyle curStyle = wb.createCellStyle();
		curStyle.setFont(defaultFont10);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // ��Ԫ��ֱ����

		return curStyle;
	}

	public HSSFCellStyle bnormalv12(HSSFWorkbook wb, HSSFFont defaultFont12) {
		HSSFCellStyle curStyle = wb.createCellStyle();
		curStyle.setFont(defaultFont12);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // ��Ԫ��ֱ����

		return curStyle;
	}

	public HSSFCellStyle moneyrv10_BorderThin(HSSFWorkbook wb, HSSFFont defaultFont10, short rmb4Format) {
		HSSFCellStyle curStyle = wb.createCellStyle();

		curStyle.setFont(defaultFont10);
		curStyle.setDataFormat(rmb4Format);

		curStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // ��Ԫ��ֱ����

		curStyle.setBorderTop(HSSFCellStyle.BORDER_THIN); // ʵ���ұ߿�
		curStyle.setBorderRight(HSSFCellStyle.BORDER_THIN); // ʵ���ұ߿�
		curStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // ʵ���ұ߿�
		curStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN); // ʵ���ұ߿�

		return curStyle;
	}

	public HSSFCellStyle numberrv10_BorderThin(HSSFWorkbook wb, HSSFFont defaultFont10) {
		HSSFCellStyle curStyle = wb.createCellStyle();
		curStyle.setFont(defaultFont10);

		curStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // ��Ԫ��ֱ����

		curStyle.setBorderTop(HSSFCellStyle.BORDER_THIN); // ʵ���ұ߿�
		curStyle.setBorderRight(HSSFCellStyle.BORDER_THIN); // ʵ���ұ߿�
		curStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // ʵ���ұ߿�
		curStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN); // ʵ���ұ߿�

		return curStyle;
	}

	public HSSFCellStyle moneyrv12_BorderThin(HSSFWorkbook wb, HSSFFont defaultFont12, short rmb2Format) {
		HSSFCellStyle curStyle = wb.createCellStyle();
		curStyle.setFont(defaultFont12);
		curStyle.setDataFormat(rmb2Format);

		curStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // ��Ԫ��ֱ����

		curStyle.setBorderTop(HSSFCellStyle.BORDER_THIN); // ʵ���ұ߿�
		curStyle.setBorderRight(HSSFCellStyle.BORDER_THIN); // ʵ���ұ߿�
		curStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // ʵ���ұ߿�
		curStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN); // ʵ���ұ߿�

		return curStyle;
	}

	public HSSFCellStyle money1(HSSFWorkbook wb, HSSFFont defaultFont10, short money1Format) {
		HSSFCellStyle curStyle = wb.createCellStyle();
		curStyle.setFont(defaultFont10);
		curStyle.setDataFormat(money1Format);

		curStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // ��Ԫ��ֱ����

		return curStyle;
	}

	public HSSFCellStyle money2(HSSFWorkbook wb, HSSFFont defaultFont10, short money2Format) {
		HSSFCellStyle curStyle = wb.createCellStyle();
		curStyle.setFont(defaultFont10);
		curStyle.setDataFormat(money2Format);

		curStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // ��Ԫ��ֱ����

		return curStyle;
	}

	public HSSFCellStyle datevEN(HSSFWorkbook wb, HSSFFont defaultFont10, short datevENFormat) {
		HSSFCellStyle curStyle = wb.createCellStyle();
		curStyle.setFont(defaultFont10);
		curStyle.setDataFormat(datevENFormat);

		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // ��Ԫ��ֱ����

		return curStyle;
	}

	public HSSFCellStyle notet10(HSSFWorkbook wb) {
		HSSFCellStyle curStyle = wb.createCellStyle();
		curStyle.setWrapText(true); // ����

		curStyle.setBorderTop(HSSFCellStyle.BORDER_THIN); // ʵ���ұ߿�
		curStyle.setBorderRight(HSSFCellStyle.BORDER_THIN); // ʵ���ұ߿�
		curStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // ʵ���ұ߿�
		curStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN); // ʵ���ұ߿�

		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP); // ��Ԫ��ֱ����

		return curStyle;
	}

	public HSSFCellStyle notevt10(HSSFWorkbook wb, HSSFFont defaultFont10) {
		HSSFCellStyle curStyle = wb.createCellStyle();
		curStyle.setWrapText(true); // ����
		curStyle.setFont(defaultFont10);

		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP); // ��Ԫ��ֱ����

		return curStyle;
	}

	public HSSFCellStyle noterv10(HSSFWorkbook wb, HSSFFont defaultFont10) {
		HSSFCellStyle curStyle = wb.createCellStyle();
		curStyle.setWrapText(true); // ����
		curStyle.setFont(defaultFont10);

		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // ��Ԫ��ֱ����

		return curStyle;
	}
	
	public HSSFCellStyle noterv10NoWrap(HSSFWorkbook wb, HSSFFont defaultFont10) {
		HSSFCellStyle curStyle = wb.createCellStyle();
		curStyle.setWrapText(false);  						//����   
		curStyle.setFont(defaultFont10);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);		//��Ԫ��ֱ����
		
		return curStyle;
	} 	

	public HSSFCellStyle notehv10(HSSFWorkbook wb, HSSFFont defaultFont10) {
		HSSFCellStyle curStyle = wb.createCellStyle();
		curStyle.setWrapText(true); 									// ����
		curStyle.setFont(defaultFont10);
		
		curStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); 	// ��Ԫ��ֱ����

		return curStyle;
	}

	// ������󣬴�ֱ����
	public HSSFCellStyle notehlv10(HSSFWorkbook wb, HSSFFont defaultFont10) {
		HSSFCellStyle curStyle = wb.createCellStyle();
		curStyle.setWrapText(true); // ����
		curStyle.setFont(defaultFont10);
		
		curStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // ��Ԫ��ֱ����

		return curStyle;
	}

	// ������ң���ֱ����
	public HSSFCellStyle notehrv10(HSSFWorkbook wb, HSSFFont defaultFont10) {
		HSSFCellStyle curStyle = wb.createCellStyle();
		curStyle.setWrapText(true); 									// ����
		curStyle.setFont(defaultFont10);
		
		curStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); 	// ��Ԫ��ֱ����

		return curStyle;
	}

	public HSSFCellStyle notehv10_BorderThin(HSSFWorkbook wb, HSSFFont defaultFont10) {
		HSSFCellStyle curStyle = wb.createCellStyle();
		curStyle.setWrapText(true); // ����

		curStyle.setFont(defaultFont10);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // ��Ԫ��ֱ����

		curStyle.setBorderTop(HSSFCellStyle.BORDER_THIN); // ʵ���ұ߿�
		curStyle.setBorderRight(HSSFCellStyle.BORDER_THIN); // ʵ���ұ߿�
		curStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // ʵ���ұ߿�
		curStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN); // ʵ���ұ߿�

		return curStyle;
	}

	public HSSFCellStyle notecv10_BorderThin(HSSFWorkbook wb, HSSFFont defaultFont10) {
		HSSFCellStyle curStyle = wb.createCellStyle();
		curStyle.setWrapText(true); 									// ����
		curStyle.setFont(defaultFont10);
		curStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		curStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); 	// ��Ԫ��ֱ����

		curStyle.setBorderTop(HSSFCellStyle.BORDER_THIN); 				// ʵ���ұ߿�
		curStyle.setBorderRight(HSSFCellStyle.BORDER_THIN); 			// ʵ���ұ߿�
		curStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); 			// ʵ���ұ߿�
		curStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN); 				// ʵ���ұ߿�

		return curStyle;
	}
}
