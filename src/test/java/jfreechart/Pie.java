package jfreechart;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
public class Pie {

	public static void main(String[] args) {
		//����ͼ�ε����ݼ���
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("����", 10062);
		dataset.setValue("ƽң����", 3256);
		dataset.setValue("��Ƥ����", 5200);
		dataset.setValue("�⻪", 5352);
		dataset.setValue("����", 3702);
		dataset.setValue("����", 2152);
		dataset.setValue("����", 5400);
		dataset.setValue("��Խ", 300);
		dataset.setValue("��˳", 4900);
		dataset.setValue("����", 3302);
		dataset.setValue("��ˮ־Զ", 3940);
		
		JFreeChart chart = ChartFactory.createPieChart3D(
							"���ɳ����������ͳ��ͼ",     	//ͼ�ε�������
							dataset,             		//ͼ�ε����ݼ�
							true,                       //�Ƿ�����ͼ�ε��ӱ���
							true, 						//�Ƿ���ͼ�������ɹ�����ʾ
							true  						//�Ƿ�ͨ��ͼƬ�ĵ������URL��ַ
							);
		//���������������
		chart.getTitle().setFont(new Font("����",Font.BOLD,18));
		//�����ӱ��������
		chart.getLegend().setItemFont(new Font("����",Font.BOLD,15));
		
		//��ȡͼ���������
		PiePlot3D piePlot3D = (PiePlot3D) chart.getPlot();
		//����ͼ�����������
		piePlot3D.setLabelFont(new Font("����",Font.BOLD,15));
		
		//��ͼ����������ֵ����ʽΪ����ͨ (60%)	{0}���� {1}��ֵ (2)�ٷֱ�
		String labelFormat = "{0} ({2})";
		piePlot3D.setLabelGenerator(new StandardPieSectionLabelGenerator(labelFormat));
		
		//��ʾͼ��
		ChartFrame chartFrame = new ChartFrame("jk",chart);
		chartFrame.setVisible(true);
		chartFrame.pack();
	}

}
