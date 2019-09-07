package com.city.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
public class DownloadUtil {
	/**
	 * @param filePath Ҫ���ص��ļ�·��
	 * @param returnName ���ص��ļ���
	 * @param response HttpServletResponse
	 * @param delFlag �Ƿ�ɾ���ļ�
	 */
	protected void download(String filePath,String returnName,HttpServletResponse response,boolean delFlag){
		this.prototypeDownload(new File(filePath), returnName, response, delFlag);
	}


	/**
	 * @param file Ҫ���ص��ļ�
	 * @param returnName ���ص��ļ���
	 * @param response HttpServletResponse
	 * @param delFlag �Ƿ�ɾ���ļ�
	 */
	protected void download(File file,String returnName,HttpServletResponse response,boolean delFlag){
		this.prototypeDownload(file, returnName, response, delFlag);
	}
	
	/**
	 * @param file Ҫ���ص��ļ�
	 * @param returnName ���ص��ļ���
	 * @param response HttpServletResponse
	 * @param delFlag �Ƿ�ɾ���ļ�
	 */
	public void prototypeDownload(File file,String returnName,HttpServletResponse response,boolean delFlag){
		// �����ļ�
		FileInputStream inputStream = null;
		ServletOutputStream outputStream = null;
		try {
			if(!file.exists()) return;
			response.reset();
			//������Ӧ����	PDF�ļ�Ϊ"application/pdf"��WORD�ļ�Ϊ��"application/msword"�� EXCEL�ļ�Ϊ��"application/vnd.ms-excel"��  
			response.setContentType("application/octet-stream;charset=utf-8");

			//������Ӧ���ļ�����,��ת�������ı���
			//returnName = URLEncoder.encode(returnName,"UTF-8");
			returnName = response.encodeURL(new String(returnName.getBytes(),"iso8859-1"));	//������ļ���,�����ҳ�����һ��,��������
			
			//attachment��Ϊ�������أ�inline�ͻ��˻����а�װƥ�������ֱ�Ӵ򿪣�ע��ı����ã�������棬������ܲ��ܿ���Ч��
			response.addHeader("Content-Disposition",   "attachment;filename="+returnName);  
			
			//���ļ�������Ӧ��
			inputStream = new FileInputStream(file);
			outputStream = response.getOutputStream();
			int length = 1024;
			int readLength=0;
			byte buf[] = new byte[1024];
			readLength = inputStream.read(buf, 0, length);
			while (readLength != -1) {
				outputStream.write(buf, 0, readLength);
				readLength = inputStream.read(buf, 0, length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//ɾ��ԭ�ļ�
			
			if(delFlag) {				
				file.delete();
			}
		}
	}

	/**
	 * by tony 2013-10-17
	 * @param byteArrayOutputStream ���ļ�����д��ByteArrayOutputStream
	 * @param response HttpServletResponse	д��response
	 * @param returnName ���ص��ļ���
	 */
	public void download(ByteArrayOutputStream byteArrayOutputStream, HttpServletResponse response, String returnName) throws IOException{
		response.setContentType("application/octet-stream;charset=utf-8");
		returnName = response.encodeURL(new String(returnName.getBytes(),"iso8859-1"));			//������ļ���,�����ҳ�����һ��,��������
		response.addHeader("Content-Disposition",   "attachment;filename=" + returnName);  
		response.setContentLength(byteArrayOutputStream.size());
		
		ServletOutputStream outputstream = response.getOutputStream();	//ȡ�������
		byteArrayOutputStream.writeTo(outputstream);					//д�������
		byteArrayOutputStream.close();									//�ر�
		outputstream.flush();											//ˢ����
	}
}
