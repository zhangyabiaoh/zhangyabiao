package com.city.my.controller.stat.chart;

import com.city.common.springdao.SqlDao;
import com.city.util.file.FileUtil;

import java.io.FileNotFoundException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ChartController {
	//@Resource
	SqlDao sqlDao;
	//�����������۱���ͼ
		/*
		 * �������裺
		 * 1����֯����Դ
		 * 2��ƴ�ӳ�xml
		 * 3������һ���ļ�txt��ʽ��xml ������
		 * 4��ת���ӦĿ¼�µ�index.html
		 */
		
		@RequestMapping("/stat/chart/factorySale.action")
		public String factorySale(HttpServletRequest request) throws FileNotFoundException{
			String path = request.getSession().getServletContext().getRealPath("/");	//��ʵ·��
			String dir = "factorysale";
			
			String sql = "SELECT f.factory_name,cp.countnum FROM (SELECT factory_id,factory_name FROM factory_c) f RIGHT JOIN (SELECT factory_id,COUNT(*) AS countnum FROM contract_product_c GROUP BY factory_id ) cp ON f.factory_id=cp.factory_id";
			this.writeXML(path, dir, this.getPieXml(this.getData(sql)));
			
			return "/stat/chart/jStat.jsp?forward="+dir;
		}
		
		//��Ʒ�������У�������Ʒ����
		@RequestMapping("/stat/chart/productSale.action")
		public String productSale(HttpServletRequest request) throws FileNotFoundException{
			String path = request.getSession().getServletContext().getRealPath("/");	//��ʵ·��
			String dir = "productsale";
			
			String sql = "SELECT product_no,SUM(cnumber) AS sumnum FROM contract_product_c GROUP BY product_no ORDER BY SUM(cnumber)  DESC LIMIT 15";
			this.writeXML(path, dir, this.getColumnAndLineXml(this.getData(sql)));
			
			return "/stat/chart/jStat.jsp?forward=" + dir;
		}
		
		//ϵͳ����ѹ��������ͼ
		@RequestMapping("/stat/chart/onlineInfo.action")
		public String onlineInfo(HttpServletRequest request) throws FileNotFoundException{
			String path = request.getSession().getServletContext().getRealPath("/");	//��ʵ·��
			String dir = "onlineinfo";
			
			String sql = "SELECT t.a1,p.countnum FROM (SELECT a1 FROM online_t) t LEFT JOIN (SELECT SUBSTRING(login_time,12,2) AS a1,COUNT(*) AS countnum FROM login_log_p GROUP BY SUBSTRING(login_time,12,2)) p ON t.a1=p.a1";
			this.writeXML(path, dir, this.getColumnAndLineXml(this.getData(sql)));
			
			return "/stat/chart/jStat.jsp?forward=" + dir;
		}
		
		//��ȡ����
		public List<String> getData(String sql){
			return sqlDao.executeSQL(sql);			//List<String>
		}
		
		//ƴ�ӱ���ͼxml
		public String getPieXml(List<String> dataList){
			//ƴ������λһ��xml�ַ���
			StringBuffer sBuf = new StringBuffer();
			sBuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sBuf.append("<pie>");
			for(int i=0;i<dataList.size();){
				//��forѭ���ڲ����Ƶ�ǰ��¼��ʶ
				sBuf.append("  <slice title=\"").append(dataList.get(i++)).append("\">").append(dataList.get(i++)).append("</slice>");
			}
			sBuf.append("</pie>");
			
			return sBuf.toString();
		}
		
		//�����״ͼxml
		public String getColumnAndLineXml(List<String> dataList){
			StringBuffer sBuf = new StringBuffer();
			sBuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sBuf.append("<chart>");
			sBuf.append("<series>");
			
			int xid = 0;			//��Ӧ��ʶ
			for(int i=0;i<dataList.size();){
				sBuf.append("<value xid=\"").append(xid++).append("\">").append(dataList.get(i++)).append("</value>");
				i++;		//skip
			}
			sBuf.append("</series>");
			sBuf.append("<graphs>");
			sBuf.append("<graph gid=\"30\" color=\"#FFCC00\" gradient_fill_colors=\"#111111, #1A897C\">");
			
			xid = 0;
			for(int i=0;i<dataList.size();){
				i++;		//skip
				sBuf.append("<value xid=\"").append(xid++).append("\">").append(dataList.get(i++)).append("</value>");
			}
			
			sBuf.append("</graph>");
			sBuf.append("</graphs>");
			sBuf.append("</chart>");
			
			return sBuf.toString();
		}
		
		//дxml�ı��ļ�����ʽutf-8
		public void writeXML(String path, String dir, String content) throws FileNotFoundException{
			//����ļ������Ŀ¼��û���ļ���ֱ�Ӵ��������Ŀ¼���ļ����ڣ����ǡ�
			FileUtil fu = new FileUtil();
			fu.createTxt(path + "/stat/chart/" + dir, "data.xml", content, "utf-8");
		}
}
