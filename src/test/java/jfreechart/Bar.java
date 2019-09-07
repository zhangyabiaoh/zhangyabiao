package jfreechart;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.DefaultCategoryDataset;

public class Bar {
	public static void main(String[] args) {
		//����ͼ�ε����ݼ���
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(3300, "����", "JK041/JK1060339");
		dataset.addValue(3000, "����", "JK040/JK1060338");
		dataset.addValue(2400, "����", "JK1060338/JK338");
		dataset.addValue(1304, "����", "JKF081342/62180");
		dataset.addValue(1200, "����", "20-37-265/JK1050163");
		dataset.addValue(1000, "����", "JK5300006/13080");
		dataset.addValue(980, "����", "J859101549/JK549");
		dataset.addValue(910, "����", "JK1400002/13077");
		dataset.addValue(300, "����", "20-37-264/JK1051087");
		dataset.addValue(120, "����", "JK5100004/13078");
		
		JFreeChart chart = ChartFactory.createBarChart3D(
							"�����������ͳ��ͼ",     		//ͼ�ε�������
							"������λ����",              //X����ı�ǩ����
							"����",                     //Y����ı�ǩ���� 
							dataset,             		//ͼ�ε����ݼ�
							PlotOrientation.VERTICAL,   //ͼ�����ʾ��ʽ��ˮƽ/��ֱ��
							true,                       //�Ƿ�����ͼ�ε��ӱ���
							true, 						//�Ƿ���ͼ�������ɹ�����ʾ
							true  						//�Ƿ�ͨ��ͼƬ�ĵ������URL��ַ
							);
		//���������������
		chart.getTitle().setFont(new Font("����",Font.BOLD,18));
		//�����ӱ��������
		chart.getLegend().setItemFont(new Font("����",Font.BOLD,15));
		//��ȡͼ���������
		CategoryPlot categoryPlot = (CategoryPlot) chart.getPlot();
		//��ȡX�����
		CategoryAxis3D categoryAxis3D = (CategoryAxis3D) categoryPlot.getDomainAxis();
		//��ȡY�����
		NumberAxis3D numberAxis3D = (NumberAxis3D) categoryPlot.getRangeAxis();
		//����X���ϵ�����
		categoryAxis3D.setTickLabelFont(new Font("����",Font.BOLD,15));
		//����X���������
		categoryAxis3D.setLabelFont(new Font("����",Font.BOLD,15));
		//����Y���ϵ�����
		numberAxis3D.setTickLabelFont(new Font("����",Font.BOLD,15));
		//����Y���������
		numberAxis3D.setLabelFont(new Font("����",Font.BOLD,15));
		
		//����Y��Ŀ̶ȣ��������Զ���ʾ�̶ȣ�Ҫ���ó�1Ϊ�̶ȵ�λ
		numberAxis3D.setAutoTickUnitSelection(false);//�����Զ����ɿ̶�
		NumberTickUnit unit = new NumberTickUnit(1d);
		numberAxis3D.setTickUnit(unit);//������1Ϊ��λ
		
		//��ȡ��ͼ�������
		BarRenderer3D barRenderer3D = (BarRenderer3D) categoryPlot.getRenderer();
		//��ͼ�α��������
		barRenderer3D.setMaximumBarWidth(0.08);
		//��ͼ������ʾ����
		barRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		barRenderer3D.setBaseItemLabelsVisible(true);
		barRenderer3D.setBaseItemLabelFont(new Font("����",Font.BOLD,15));
		
		//��ʾͼ��
		ChartFrame chartFrame = new ChartFrame("jk",chart);
		chartFrame.setVisible(true);
		chartFrame.pack();
	}
}
