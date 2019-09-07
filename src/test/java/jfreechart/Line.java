package jfreechart;

import java.awt.Font;
import java.awt.Rectangle;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class Line {

	public static void main(String[] args) {
		//����ͼ�ε����ݼ���
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(16, "������", "00");
		dataset.addValue(12, "������", "01");
		dataset.addValue(4, "������", "02");
		dataset.addValue(1, "������", "03");
		dataset.addValue(null, "������", "04");
		dataset.addValue(1, "������", "05");
		dataset.addValue(1, "������", "06");
		dataset.addValue(1, "������", "07");
		dataset.addValue(24, "������", "08");
		dataset.addValue(118, "������", "09");		
		dataset.addValue(109, "������", "10");	
		dataset.addValue(109, "������", "11");
		dataset.addValue(33, "������", "12");
		dataset.addValue(50, "������", "13");
		dataset.addValue(68, "������", "14");
		dataset.addValue(69, "������", "15");
		dataset.addValue(86, "������", "16");
		dataset.addValue(44, "������", "17");
		dataset.addValue(22, "������", "18");
		dataset.addValue(10, "������", "19");		
		dataset.addValue(21, "������", "20");			
		dataset.addValue(33, "������", "21");			
		dataset.addValue(31, "������", "22");			
		dataset.addValue(39, "������", "23");			
		
		JFreeChart chart = ChartFactory.createLineChart(
							"ϵͳ����ѹ��ͳ��ͼ",     		//ͼ�ε�������
							"������",               		//X����ı�ǩ����
							"����",                      //Y����ı�ǩ���� 
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
		CategoryAxis categoryAxis = (CategoryAxis) categoryPlot.getDomainAxis();
		//��ȡY�����
		NumberAxis numberAxis = (NumberAxis) categoryPlot.getRangeAxis();
		//����X���ϵ�����
		categoryAxis.setTickLabelFont(new Font("����",Font.BOLD,15));
		//����X���������
		categoryAxis.setLabelFont(new Font("����",Font.BOLD,15));
		//����Y���ϵ�����
		numberAxis.setTickLabelFont(new Font("����",Font.BOLD,15));
		//����Y���������
		numberAxis.setLabelFont(new Font("����",Font.BOLD,15));
		
		//����Y��Ŀ̶ȣ��������Զ���ʾ�̶ȣ�Ҫ���ó�1Ϊ�̶ȵ�λ
		numberAxis.setAutoTickUnitSelection(false);//�����Զ����ɿ̶�
		NumberTickUnit unit = new NumberTickUnit(1d);
		numberAxis.setTickUnit(unit);//������1Ϊ��λ
		
		//��ȡ��ͼ�������
		LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer) categoryPlot.getRenderer();
		
		//��ͼ������ʾ����
		lineAndShapeRenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		lineAndShapeRenderer.setBaseItemLabelsVisible(true);
		lineAndShapeRenderer.setBaseItemLabelFont(new Font("����",Font.BOLD,15));
		//����ͼ�ε�ת�۵㣨���Σ�
		/**
		 * ����һ��0��ʾ��һ����
		 * ����������ʾҪ��ʲôͼ����������ʾת�۵�
		 */
		Rectangle shape = new Rectangle(10,10);
		lineAndShapeRenderer.setSeriesShape(0, shape);
		lineAndShapeRenderer.setSeriesShapesVisible(0, true);
		
		//��ʾͼ��
		ChartFrame chartFrame = new ChartFrame("jk",chart);
		chartFrame.setVisible(true);
		chartFrame.pack();
	}
}
