package com.city.util;

public class FormatStyle {

	public static void main(String[] args) {
		// TODO: Add your code here
		FormatStyle formatStyle = new FormatStyle();
		System.out.println(formatStyle.fileSize("10737418240"));
	}


	public String fileSize(String s1) {
		int iPos = 0;
		String s ="";
		StringBuffer sBuf = new StringBuffer();
		try{
			if(s1.trim().compareTo("")==0){
				return "";
			}
			long g = Long.parseLong("1099511627776");//����̫��JAVAֱ��д���޷�ʶ�𣬻���������Ƚ�ʧ��
			//int i = Integer.parseInt(s1);
			double i = Double.parseDouble(s1);

			if(i<=0){
				sBuf.append("");
			}else if(i<1024){
				sBuf.append(i).append(" B");	//��������
				iPos = sBuf.lastIndexOf(".00 B");	
				if(iPos>0){
					sBuf.delete(iPos,sBuf.length()-2);	
				}
			}else if(i<1024*1024){
				sBuf.append(new java.text.DecimalFormat(".00").format(i/1024)).append(" KB");	//��������
				iPos = sBuf.lastIndexOf(".00 KB");	
				if(iPos>0){
					sBuf.delete(iPos,sBuf.length()-3);	
				}
			}else if(i<1024*1024*1024){
				sBuf.append(new java.text.DecimalFormat(".00").format(i/(1024*1024))).append(" M");	//��������
				iPos = sBuf.lastIndexOf(".00 M");
				if(iPos>0){
					sBuf.delete(iPos,sBuf.length()-2);	
				}
			}else{
				sBuf.append(new java.text.DecimalFormat(".00").format(i/(1024*1024*1024))).append(" G");	//��������
				iPos = sBuf.lastIndexOf(".00 G");
				if(iPos>0){
					sBuf.delete(iPos,sBuf.length()-2);	
				}
			}			
		}catch(Exception e){
			return "";
		}
		return sBuf.toString();
	}
}
