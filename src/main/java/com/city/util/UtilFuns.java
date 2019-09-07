package com.city.util;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.text.DecimalFormat;

import java.net.URLEncoder;
import java.net.URLDecoder;
import java.util.Date;
public class UtilFuns {
	 static public String newLine(){
		  	return System.getProperty("line.separator"); 
		  }
		  

			/* ��֤�����Ƿ�Ϊ�� */
			public static boolean arrayValid(Object[] objects) {
				if (objects != null && objects.length > 0) {
					return true;
				} else {
					return false;
				}
			}

			/* ��֤list�Ƿ�Ϊ�� */
			public boolean listValid(List list) {
				if (list != null && list.size() > 0) {
					return true;
				} else {
					return false;
				}
			}
		  

		  //�������
		  public int age(String dateStart, String dateEnd) throws Exception{
			  int yearStart = Integer.parseInt(dateStart.substring(0,4));
			  int yearEnd = Integer.parseInt(dateEnd.substring(0,4));
			  return yearEnd-yearStart;
		  }
		  
		  //�Ƿ�Ϊ����
		  public boolean isOdd(int i){
			  if(i%2==0){
				  return false;
			  }else{
				  return true;
			  }
		  }

		  public String cutStr(String str,int len){
		  	try{
		  		str = str.substring(0,len);
		  	}catch(Exception e){
		  		return str;
		  	}
		  	return str;
		  }
		  
		  //���ع̶����ȴ����հ׵ط��ÿո���� by tony 20110926
		  public String fixSpaceStr(String str,int len){
			  StringBuffer sBuf = new StringBuffer();
			  try{
				  if(str.length()>len){
					  return str;
				  }else{
					  sBuf.append(str);
					  for(int i=0;i<(len-str.length());i++){
						  sBuf.append(" ");
					  }
					  return sBuf.toString();
				  }
			  }catch(Exception e){
				  return str;
			  }
		  }
		  
		  public String fixSpaceStr(int number,int len){
			  return fixSpaceStr(String.valueOf(number),len);
		  }
		  
		  //ǰ׺�ո�
		  public String prefixSpaceStr(String str,int len){
			  StringBuffer sBuf = new StringBuffer();
			  try{
				  if(str.length()>len){
					  return str;
				  }else{
					  for(int i=0;i<(len-str.length());i++){
						  sBuf.append(" ");
					  }
					  sBuf.append(str);
					  return sBuf.toString();
				  }
			  }catch(Exception e){
				  return str;
			  }
		  }
		  
		  //��ȡ�ַ�,�����������,��ȡ����ʡ�Ժ� by tony 20101108
		  public String suspensionStr(String str,int len){
			  try{
				  str = str.substring(0,len) + "...";
			  }catch(Exception e){
				  return str;
			  }
			  return str;
		  }

		  //url get��ʽ���ݲ��� by tony 20110328
		  public static String joinUrlParameter(List<String> sList){
			  StringBuffer sBuf = new StringBuffer();
			  for(Iterator it = sList.iterator(); it.hasNext();){
				  sBuf.append("&").append(it.next()).append("=").append(it.next());
			  }
			  return sBuf.substring(1, sBuf.length());	//ȥ����һ��&����
		  }
		  
		  /** SplitStr ���ܣ����طָ�������
		   * <br>���������String str ���÷���ϵͳʱ����ʽ
		   * <br>���������String SplitFlag ���÷ָ��ַ�
		   * <br>���������string[] ���طָ�������
		   * <br>���ߣ�������
		   * <br>ʱ�䣺2003-9-7
		   * <br>�÷���
		   */
		/*
		      String s[] = SplitStr("asd asd we sd"," ");
		      for (int i=0;i<s.length;i++){
		        System.out.println(s[i]);
		      }
		*/
		  static public String[] splitStr(String str,String SplitFlag){
		    int i =0;
		    try{
		      StringTokenizer st = new StringTokenizer(str, SplitFlag);
		      String tokens[] = new String[st.countTokens()];
		      //System.out.println(st.countTokens());
		      while (st.hasMoreElements()) {
		        tokens[i] = st.nextToken();
		        //System.out.println(tokens[i]);
		        i++;
		      }
		      return tokens;
		    }catch(Exception e){
		      return null;
		    }
		  }
		  
		  //����google����ʵ�ֶ���ؼ��ֵĲ�ѯ���ؼ���֮���ÿո�򶺺Ÿ��� by tony 20110523
		  //֧�ֵķָ��� Ӣ�Ķ���,���Ķ���,�ո�
		  public String[] splitFindStr(String str){
			if(str==null){
				return null;
			}
			String[] aStr = null;
			str = str.replaceAll(",", " ");		//Ӣ�Ķ���
			str = str.replaceAll("��", " ");		//���Ķ���
			aStr = this.splitStr(str, " ");		//�ո�  
			return aStr;
		 }
		 
		  /* ���ݺ���,���磬a,b,c ���� a;a,b;a,b,c by tony 20110330 */
		  static public String[] splitStair(String str,String SplitFlag){
			  try{
				  String[] _temp = splitStr(str, SplitFlag);
				  for(int i=1;i<_temp.length;i++){
					  _temp[i] = _temp[i-1]+SplitFlag+_temp[i];
				  }
				  return _temp;
			  }catch(Exception e){
				  return null;
			  }
		  }

		  /** SplitStr ���ܣ�������ϲ�Ϊһ���ַ���
		   * <br>���������String aStr Ҫ�ϲ�����
		   * <br>���������String SplitFlag ���÷ָ��ַ�
		   * <br>���������String Ҫ�ϲ�����
		   * <br>���ߣ�������
		   * <br>ʱ�䣺2004-1-9
		   * <br>�÷���
		   */


		  static public String joinStr(String[] aStr,String SplitFlag){
		    StringBuffer sBuffer = new StringBuffer();
		    if (aStr != null){
		      for (int i=0;i<aStr.length;i++){
		        sBuffer.append(aStr[i]).append(SplitFlag);
		      }
		      sBuffer.delete(sBuffer.length() - 1, sBuffer.length()); //ȥ�����ķָ��� SplitFlag
		    }else{
		      sBuffer = sBuffer.append("");
		    }
		    return sBuffer.toString();
		  }

		  /* ����,���м������ӷ��� add by tony 20100322 */
		  static public String joinStr(String[] aStr){
		    StringBuffer sBuffer = new StringBuffer();
		    if (aStr != null){
		      for (int i=0;i<aStr.length;i++){
		        sBuffer.append(aStr[i]);
		      }
		    }else{
		      sBuffer = sBuffer.append("");
		    }
		    return sBuffer.toString();
		  }
		  
		  /** JoinStr 
		   * <br>���ܣ�������ϲ�Ϊһ���ַ���
		   * <br>���������String sPrefix ����Ԫ�ؼӵ�ǰ׺
		   * <br>���������String sSuffix ����Ԫ�ؼӵĺ�׺
		   * <br>���������String SplitFlag ���÷ָ��ַ�
		   * <br>���������String �ϲ�����ַ���
		   * <br>���ߣ�������
		   * <br>ʱ�䣺2005-3-17
		   * <br>�÷���
		   */


		  static public String joinStr(String[] aStr,String sPrefix,String sSuffix,String SplitFlag){
		    StringBuffer sBuffer = new StringBuffer();
		    if (aStr != null){
		      for (int i=0;i<aStr.length;i++){
		        sBuffer.append(sPrefix).append(aStr[i]).append(sSuffix).append(SplitFlag);
		      }
		      sBuffer.delete(sBuffer.length() - SplitFlag.length(), sBuffer.length()); //ȥ�����ķָ��� SplitFlag
		    }else{
		      sBuffer = sBuffer.append("");
		    }
		    return sBuffer.toString();
		  }
		  
		  /* ��������in��ѯ�Ĵ�  'x','y' */
		  static public String joinInStr(String[] aStr){
			  StringBuffer sBuffer = new StringBuffer();
			  if (aStr != null){
				  for (int i=0;i<aStr.length;i++){
					  sBuffer.append("'").append(aStr[i]).append("'").append(",");
				  }
				  sBuffer.delete(sBuffer.length() - 1, sBuffer.length());
			  }else{
				  sBuffer = sBuffer.append("");
			  }
			  return sBuffer.toString();
		  }

		  /* ����,���м������ӷ��� add by tony 20100322 */
		  static public String joinStr(String[] aStr,String sPrefix,String sSuffix){
		    StringBuffer sBuffer = new StringBuffer();
		    if (aStr != null){
		      for (int i=0;i<aStr.length;i++){
		        sBuffer.append(sPrefix).append(aStr[i]).append(sSuffix);
		      }
		    }else{
		      sBuffer = sBuffer.append("");
		    }
		    return sBuffer.toString();
		  }

		  /* ����len(s)��symbol���� add by tony 20100407 */
		  static public String joinStr(String s, String symbol){
			  StringBuffer sBuf = new StringBuffer();
			  for (int i=0;i<s.length();i++){
				  sBuf.append(symbol);
		      }
			  return sBuf.toString();
		  }
		  
		  static public String joinStr(int len, String symbol){
			  StringBuffer sBuf = new StringBuffer();
			  for (int i=0;i<len;i++){
				  sBuf.append(symbol);
		      }
			  return sBuf.toString();
		  }  
		  
		  /** SysTime ���ܣ�����ϵͳʱ��
		 * <br>���������int style ���÷���ϵͳʱ����ʽ
		 * <br>���������string ����ϵͳʱ����ʽ
		 * <br>���ߣ�������
		 * <br>ʱ�䣺2003-6-24
		 * <br>�������⣺�������룬��JSP����ʾ������
		 */
		  static public String SysTime(String strStyle){
		    String s = "";
		    if (strStyle.compareTo("")==0){
		    	strStyle = "yyyy-MM-dd HH:mm:ss";	//default
		    }
		    java.util.Date date=new java.util.Date();
		    SimpleDateFormat dformat=new SimpleDateFormat(strStyle);
		    s = dformat.format(date);
		    return s;
		  }

		  static public String sysTime(){
		    String s = "";
		    java.util.Date date=new java.util.Date();
		    SimpleDateFormat dformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    s = dformat.format(date);
		    return s;
		  }

		  static public String sysDate(){
		    String s = "";
		    java.util.Date date=new java.util.Date();
		    SimpleDateFormat dformat=new SimpleDateFormat("yyyy-MM-dd");
		    s = dformat.format(date);
		    return s;
		  }


		  /* add by tony 20091113 */
		  public static boolean isNull(Object obj){
		    try{
		      if(obj==null){
		    	  return true;
		      }
		      return false;
		    }catch(Exception e){
		      return false;
		    }
		  }
		  
		  public static boolean isNotNull(Object obj){
		    try{
		      if(obj==null){
		    	  return false;
		      }
		      return true;
		    }catch(Exception e){
		      return true;
		    }
		  }  

		  public static boolean isEmpty(String str){
		    try{
		      if(str==null || str.equals("null") || str.equals("")){
		    	  return true;
		      }
		      return false;
		    }catch(Exception e){
		      return false;
		    }
		  }
		  
		  public static boolean isEmpty(String strs[]){
			  try{
				  if(strs==null || strs.length<=0){
					  return true;
				  }
				  return false;
			  }catch(Exception e){
				  return false;
			  }
		  }

		  public static boolean isNotEmpty(String str){
		    try{
		      if(str==null || str.equals("null") || str.equals("")){
		    	  return false;
		      }
		      return true;
		    }catch(Exception e){
		      return true;
		    }
		  }

		  public static boolean isNotEmpty(Object obj){
		    try{
		      if(obj==null || obj.toString().equals("null") || obj.toString().equals("")){
		    	  return false;
		      }
		      return true;
		    }catch(Exception e){
		      return true;
		    }
		  }
		  
		  public static boolean isNotEmpty(List obj){
			  try{
				  if(obj==null || obj.size()<=0){
					  return false;
				  }
				  return true;
			  }catch(Exception e){
				  return true;
			  }
		  }
		  
		  /** ���ܣ�����ת��Ϊnull���ֶΡ�
		   * <br>��Σ�String strvalue ����Ҫת�����ַ���
		   * <br>���Σ���Ϊ��null���ķ���ԭ����Ϊ��null������""��
		   * <br>���ߣ�������
		   * <br>ʱ�䣺2003-9-16
		   * <p>�÷���optionFuns.convertNull(String.valueOf(oi.next()))</p>
		   */
		  public static String convertNull(String strvalue)
		  {
		    try{
		      if(strvalue.equals("null") || strvalue.length()==0){
		        return "";
		      }else{
		        return strvalue.trim();
		      }
		    }catch(Exception e){
		      return "";
		    }
		  }

		  public static String[] convertNull(String[] aContent)
		  {
		    try{
		      for(int i=0;i<aContent.length;i++){
		        if(aContent[i].toLowerCase().compareTo("null")==0){
		          aContent[i] = "";
		        }
		      }
		      return aContent;
		    }catch(Exception e){
		      return null;
		    }
		  }
		    
		  public static String convertNull(Object o)
		  {
		    try{
		      String strvalue = String.valueOf(o);
		      if(strvalue.equals(null) || strvalue.equals("null") || strvalue.length()==0){
		        return "";
		      }else{
		        return strvalue.trim();
		      }
		    }catch(Exception e){
		      return "";
		    }
		  }
		  
		  //��Ϊnull������תΪ0��������ֵ��ֵ�����ݿ��ж��������
		  public static int ConvertZero(Object o)
		  {
		    try{
		      String s = convertNull(o);
		      if(s==""){
		        return 0;
		      }else{
		        return Integer.parseInt(s);
		      }
		    }catch(Exception e){
		      return 0;
		    }
		  }
		  
		  //��Ϊnull������תΪ0��������ֵ��ֵ�����ݿ��ж��������
		  public static int cvtPecrent(Object o)
		  {
		    try{
		      String s = convertNull(o);
		      if(s==""){
		        return 0;
		      }else{
		        return Integer.parseInt(s);
		      }
		    }catch(Exception e){
		      return 0;
		    }
		  }  
		  
		  //if 0 then return "";
		  public static String FormatZero(Object o)
		  {
		    try{
		      String s = convertNull(o);
		      if(s.compareTo("")==0){
		        return "";
		      }else{
		        return String.valueOf(s);
		      }
		    }catch(Exception e){
		      return "";
		    }
		  }
		  
		  //if 0 then return "";
		  public static String FormatZero(String s)
		  {
		    try{
		      if(s.compareTo("0")==0){
		        return "";
		      }else{
		        return s;
		      }
		    }catch(Exception e){
		      return "";
		    }
		  }
		  
		  //patter="####.000"
		  public static String FormatNumber(Object o,String patter)
		  {
		  	double d = 0;
		    try {
		      d = Double.parseDouble(String.valueOf(o));
		      DecimalFormat df = new DecimalFormat(patter);
		      return df.format(d);
		    }
		    catch (Exception e) {
		    	System.out.println(e.getMessage());
		       	return "";
		    }
		  }

		  
		  //patter="####.00"
		  public static String FormatNumber(String s)
		  {
		  	double d = 0;
		    try {
		      d = Double.parseDouble(s);
		      DecimalFormat df = new DecimalFormat(",###.00");
		      return df.format(d);
		    }
		    catch (Exception e) {
		    	System.out.println(e.getMessage());
		    	return "";
		    }
		  }
		  
		  //ֻ���ڱ������
		  public static String ConvertTD(String strvalue)
		  {
		    try{
		      strvalue = strvalue.trim();
		      if(strvalue.equals("null") || strvalue.length()==0){
		        return "&nbsp;";
		      }else{
		        return strvalue;
		      }
		    }catch(Exception e){
		      return "&nbsp;";
		    }
		  }

		  public static String ConvertSpaceTD(Object o)
		  {
		    try{
		      String strvalue = String.valueOf(o);
		      strvalue = strvalue.trim();
		      if(strvalue.equals("null") || strvalue.length()==0){
		        return "&nbsp;";
		      }else{
		        return " " + strvalue.trim();
		      }
		    }catch(Exception e){
		      return "&nbsp;";
		    }
		  }
		  
		  /*
		    ֻת���ģ�������null
		    ��ȡ��¼ʱȥ���������ߵĿո񣻶�¼������ʱ��ά���û������룬�����û��������˿ո�
		    ԭ��������ʱ�����û���������ո����磺��ע�ֶ�ԭ�������ݣ������û�����ա�
		  */
		  public static String ConvertCH(String strvalue)
		  {
		    System.out.println("ConvertCH:"+strvalue);
		    try{
		      if(strvalue==null){
		        return "null";
		      }else if(strvalue.length()==0){
		        return "";      
		      }else{
		        strvalue = new String(strvalue.getBytes("ISO8859_1"), "GB2312");
		        return strvalue;
		      }
		    }catch(Exception e){
		      return "";
		    }
		  }
		  
		  public static String ConvertCStr(String strvalue)
		  {
		    try{
		      strvalue = convertNull(strvalue);
		      if(strvalue.equals("")){
		        return "";
		      }else{
		        strvalue = new String(strvalue.getBytes("ISO8859_1"), "GB2312");
		        return strvalue;
		      }
		    }catch(Exception e){
		      return "";
		    }
		  }

		  public static String ConvertCStr(Object o)
		  {
		    String strvalue = "";
		    try{
		      strvalue = String.valueOf(o);
		      strvalue = convertNull(strvalue);
		      if(strvalue.equals("")){
		        return "";
		      }else{
		        strvalue = new String(strvalue.getBytes("ISO8859_1"), "GB2312");
		        return strvalue;
		      }
		    }catch(Exception e){
		      System.out.println("ConvertCStr:" + e.toString());
		      return "";
		    }
		  }
		  
		  /**
		   *UrlEncoder ����URL����
		   */
		    public String UrlEncoder(String s)
		    {
		        String s1 = "";
		        if(s == null)
		            return "";
		        try
		        {
		            s1 = URLEncoder.encode(s);
		        }
		        catch(Exception e)
		        {
		            System.out.println("URL Encoder :" + e.toString());
		            s1 = "";
		        }
		        return s1;
		    }

		  /**
		   *URLDecoder ����URL����
		   */
		    public String UrlDecoder(String s)
		    {
		        String s1 = "";
		        if(s == null)
		            return "";
		        try
		        {
		            s1 = URLDecoder.decode(s);
		        }
		        catch(Exception e)
		        {
		            System.out.println("URL Encoder :" + e.toString());
		            s1 = "";
		        }
		        return s1;
		    }
		    
		  /**
		   * ���ַ���ת��������ĸ��д��������ĸСд�ĸ�ʽ
		   * @param source �����ַ���
		   * @return String
		   */
		  public static String format_Aaa(String source) {

		    if (source==null) return null;
		    if (source.equals("")) return "";

		    String a;
		    a = source.substring(0, 1);
		    a = a.toUpperCase();
		    return a + source.substring(1);

		  }
		  
		  /**
		   * ���ַ���ת����Long��
		   * @param param �����ַ���
		   * @return ������
		   */
		  public static long parseLong(String param) {
		    long l=0;
		    try {
		      l = Long.parseLong(param);
		    }
		    catch (Exception e) {
		    }

		    return l;
		  }

		  /**
		   * ���ַ���ת����Float��
		   * @param param �����ַ���
		   * @return ������
		   */
		  public static float parseFloat(String param) {
		    float l=0;
		    try {
		      l = Float.parseFloat(param);
		    }
		    catch (Exception e) {
		    }

		    return l;
		  }

		  /**
		   * ���ַ���ת����Integer��
		   * @param param �����ַ���
		   * @return ����
		   */
		  public static int parseInt(String param) {
		    int l=0;
		    try {
		      l = Integer.parseInt(param);
		    }
		    catch (Exception e) {
		    }

		    return l;
		  }


			public static Date parseDate(String currDate, String format) {
			    SimpleDateFormat dtFormatdB = null;
			    try {
			        dtFormatdB = new SimpleDateFormat(format);
			        return dtFormatdB.parse(currDate);
			    }catch (Exception e){
			        dtFormatdB = new SimpleDateFormat("yyyy-MM-dd");
			        try {
			            return dtFormatdB.parse(currDate);
			        }catch (Exception ex){}
			    }
			    return null;
			}

			public static Date parseDate(String currDate) {
			    SimpleDateFormat dtFormatdB = null;
			    dtFormatdB = new SimpleDateFormat("yyyy-MM-dd");
			    try {
			        return dtFormatdB.parse(currDate);
			    }catch (Exception e){
			        try {
			            return dtFormatdB.parse(currDate);
			        }catch (Exception ex){}
			    }
			    return null;
			}
			
			public static Date parseTime(String currDate, String format) {
			    SimpleDateFormat dtFormatdB = null;
			    try {
			        dtFormatdB = new SimpleDateFormat(format);
			        return dtFormatdB.parse(currDate);
			    }catch (Exception e){
			        dtFormatdB = new SimpleDateFormat("HH:mm:ss");
			        try {
			            return dtFormatdB.parse(currDate);
			        }catch (Exception ex){}
			    }
			    return null;
			}

			public static Date parseDateTime(String currDate, String format) {
			    SimpleDateFormat dtFormatdB = null;
			    try {
			        dtFormatdB = new SimpleDateFormat(format);
			        return dtFormatdB.parse(currDate);
			    }catch (Exception e){
			        dtFormatdB = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			        try {
			            return dtFormatdB.parse(currDate);
			        }catch (Exception ex){}
			    }
			    return null;
			}
			
		  /**
		   * ���ַ���ת����Double��
		   * @param param �����ַ���
		   * @return double��
		   */
		  public static double parseDouble(String param) {
		    double l=0;
		    try {
		      l = Double.parseDouble(param);
		    }
		    catch (Exception e) {
		    }

		    return l;
		  }

		  /**
		   * s�Ƿ����ArrayList�У����ڷ��������±꣬�����ڷ���-1
		   */
		  public static int existElements(String s,ArrayList aList) {
		    try{
		      for (int i = 0; i < aList.size(); i ++) {
		        if (s.equals(aList.get(i))){
		          return i;
		        }
		      }
		    }catch(Exception e){   }
		    return -1;
		  }

		  /**
		   * s�Ƿ����String�����У����ڷ��������±꣬�����ڷ���-1
		   */
		  public static int existElements(String s,String[] a) {
		    try{
		      for (int i = 0; i < a.length; i ++) {
		        if (s.compareTo((a[i].trim()))==0){  
		          return i;
		        }
		      }
		    }catch(Exception e){   }
		    return -1;
		  }
		  
		  /**
		   * �ж϶���o�Ƿ������set���󼯺��� create by tony 20090611
		   */  
		  public static boolean existElements(Object o, Set set) {
			  boolean isExists = false;
			  Iterator it = set.iterator();
			  while(it.hasNext())
			  {
			       Object obj = it.next();
			       if(o.equals(obj))
			       {
			    	   isExists=true;
			    	   break;
			       }
			  }
			  return isExists;
		  }

		  /**
		   * s�Ƿ����ArrayList�У����ڷ��������±꣬�����ڷ���-1
		   */
		  public static int IsIndexOfElements(String s,ArrayList aList) {
		    try{
		      String s1 = "";
		      for (int i = 0; i < aList.size(); i ++) {
		        s1 = String.valueOf(aList.get(i));
		        if (s1.indexOf(s)!=-1){
		          return i;
		        }
		      }
		    }catch(Exception e){   }
		    return -1;
		  }
		  
		  /**
		   * ��ArrayListת��ΪһάString���飬�������е�null���ɿ��ַ���
		   * @param aList �����Arraylist
		   */
		  public String[] ArrayListToString(ArrayList aList) {
		    String[] s = new String[aList.size()];
		    for (int i = 0; i < aList.size(); i ++) {
		      s[i] = this.convertNull(aList.get(i));
		    }
		    return s;
		  }
		  
		  
		  /**
		   * �������е�null���ɿ��ַ���
		   * @param al �����Arraylist��ͬʱҲ��������
		   */
		  public static void formatArrayList(ArrayList al) {

		    for (int i = 0; i < al.size(); i ++) {
		      if (al.get(i) == null)
		        al.set(i, "");
		    }

		  }

		    /** ComboList ���ܣ�ѡ���������б��������ҵ�����,�������һ������
		     * <br>���������String CurrentValue ���ҳ������ݿ��е�����
		     *               String[] content ��Ҫ��������������б�������
		     * <br>������������������б�
		      * <br>ע�����valuesΪ0��ʼ,�����м䲻�ܶϿ�
		     */
		    public String ComboList(String CurrentValue, String[] content) {
		      int i = 0;
		      StringBuffer sBuf = new StringBuffer();
		      String selected = " selected";
		      try{
		        sBuf.append("<option value='' selected>--��ѡ��--</option>");
		        for (i = 0; i < content.length; i++) {
		          sBuf.append("\n<option value='").append(i).append("'");
		          if (CurrentValue.compareTo(String.valueOf(i)) == 0) {
		            sBuf.append(selected);
		          }
		          sBuf.append(">").append(content[i]).append("</option>");
		        }
		        return sBuf.toString();
		      }catch(Exception e){
		        return "";
		      }
		    }

		    public String ComboListMust(String CurrentValue, String[] content) {
		      int i = 0;
		      StringBuffer sBuf = new StringBuffer();
		      String selected = " selected";
		      try{
		        for (i = 0; i < content.length; i++) {
		          sBuf.append("\n<option value='").append(i).append("'");
		          if (CurrentValue.compareTo(String.valueOf(i)) == 0) {
		            sBuf.append(selected);
		          }
		          sBuf.append(">").append(content[i]).append("</option>");
		        }
		        return sBuf.toString();
		      }catch(Exception e){
		        return "";
		      }
		    }
		    
		    /** ComboList ���ܣ�ѡ���������б��������ҵ�����,�������һ������
		     * <br>���������String CurrentValue ���ҳ������ݿ��е�����
		     *               String[] values  ��Ҫ��������������б�����������Ӧ��ֵ
		     *               String[] content ��Ҫ��������������б�������
		     * <br>������������������б�
		     * <br>�޸ģ�������
		     * <br>�޸�ʱ�䣺2003-9-4
		     * <br>ע�����values��content�������������ͬ.�ʺϴ����ݿ���ȡֵ
			<%
			  String[] aContextOPERATE_TYPE = {"����","�ֻ�","���"};
			  out.print(optionFuns.ComboList("",aContextOPERATE_TYPE,aContextOPERATE_TYPE));
			%>
		     */
		    public String ComboList(String CurrentValue,String[] values, String[] content) {
		      int i = 0;
		      StringBuffer sBuf = new StringBuffer();
		      String selected = " selected";

		      try{
		    	if(CurrentValue==null){
		    		CurrentValue = "";
		    	}
		        sBuf.append("<option value='' selected>--��ѡ��--</option>");
		        for (i = 0; i < content.length; i++) {
		          sBuf.append("<option value='").append(values[i]).append("'");
		          if (CurrentValue.compareTo(values[i]) == 0) {
		            sBuf.append(selected);
		          }
		          sBuf.append(">").append(content[i]).append("</option>");
		        }
		        return sBuf.toString();
		      }catch(Exception e){
		        return "";
		      }
		    }

		    public String ComboListMust(String CurrentValue,String[] values, String[] content) {
		      int i = 0;
		      StringBuffer sBuf = new StringBuffer();
		      String selected = " selected";

		      try{
		        for (i = 0; i < content.length; i++) {
		          sBuf.append("<option value='").append(values[i]).append("'");
		          if (CurrentValue.compareTo(values[i]) == 0) {
		            sBuf.append(selected);
		          }
		          sBuf.append(">").append(content[i]).append("</option>");
		        }
		        return sBuf.toString();
		      }catch(Exception e){
		        return "";
		      }
		    } 
		    
		  /** StrToTimestamp ���ܣ����ַ���ת��ΪTimestamp ��
		   * <br>���������String timestampStr ����Ҫת�����ַ���
		   *              String pattern Ҫת����format
		   * <br>��������������ʽ��ȷ���ظ�ʽ����ַ�����
		   *              ����ȷ����ϵͳ���ڡ�
		   * <br>���ߣ�������
		   * <br>ʱ�䣺2003-8-26
		   */
		  public static Timestamp StrToTimestamp(String timestampStr,String pattern) throws ParseException {
		    java.util.Date date = null;
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
		    try {
		      date = format.parse(timestampStr);
		    } catch (ParseException ex) {
		      throw ex;
		    }
		    return date == null ? null : new Timestamp(date.getTime());
		  }

		  //ex:utilFuns.StrToDateTimeFormat("2005-12-01 00:00:00.0,"yyyy-MM-dd")
		  public static String StrToDateTimeFormat(String timestampStr,String pattern) throws ParseException {
		    String s ="";
		    try{
		      s = String.valueOf(StrToTimestamp(timestampStr, pattern));
		      s = s.substring(0,pattern.length());
		    }catch(Exception e){ }
		    return s;
		  }

		  //ex:utilFuns.StrToDateTimeFormat("2005-12-01 00:00:00.0,"yyyy-MM-dd")
		  public static String dateTimeFormat(Date date,String pattern) throws ParseException {
		    String s ="";
		    try{
		        SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        s = dformat.format(date);
		        s = String.valueOf(StrToTimestamp(s, pattern));
		        s = s.substring(0,pattern.length());
		    }catch(Exception e){ }
		    return s;
		  }
		  public static String dateTimeFormat(Date date) throws ParseException {
			  String s ="";
			  try{
				  SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
				  s = dformat.format(date);
				  s = String.valueOf(StrToTimestamp(s, "yyyy-MM-dd"));
				  s = s.substring(0,"yyyy-MM-dd".length());
			  }catch(Exception e){ }
			  return s;
		  }
		  
		  //add by tony 20100228 ת������ ��ʽ����Ϊ��"yyyy-MM-dd HH:mm:ss"��һ����
		  public static String formatDateTimeCN(String date) throws ParseException {
			  String s ="";
			  try{
				  if(UtilFuns.isEmpty(date)){
					  return "";
				  }
				  if(date.indexOf(".")>-1){
					  date = date.substring(0, date.indexOf("."));
				  }
				  if(date.length()==4){			//yyyy
					  s = date+"��";
				  }else if(date.length()==7){	//yyyy-MM
					  s = date.replaceAll("-0", "-").replaceFirst("-", "��")+"��";
				  }else if(date.length()==10){	//yyyy-MM-dd
					  s = date.replaceAll("-0", "-").replaceFirst("-", "��").replaceFirst("-", "��")+"��";
				  }else if(date.length()==2){	//HH
					  s = date+"ʱ";
				  }else if(date.length()==5){	//HH:mm
					  s = date.replaceAll(":0", ":").replaceFirst(":", "ʱ")+"��";
				  }else if(date.length()==8){	//HH:mm:ss
					  s = date.replaceAll(":0", ":").replaceFirst(":", "ʱ").replaceFirst(":", "��")+"��";
				  }else if(date.length()==13){	//yyyy-MM-dd HH
					  s = date.replaceAll("-0", "-").replaceFirst("-", "��").replaceFirst("-", "��").replaceAll(" 0", " ").replaceFirst(" ", "��")+"ʱ";
				  }else if(date.length()==16){	//yyyy-MM-dd HH:mm
					  s = date.replaceAll("-0", "-").replaceFirst("-", "��").replaceFirst("-", "��").replaceAll(" 0", " ").replaceFirst(" ", "��").replaceAll(":0", ":").replaceFirst(":", "ʱ")+"��";
				  }else if(date.length()==19){	//yyyy-MM-dd HH:mm:ss
					  s = date.replaceAll("-0", "-").replaceFirst("-", "��").replaceFirst("-", "��").replaceAll(" 0", " ").replaceFirst(" ", "��").replaceAll(":0", ":").replaceFirst(":", "ʱ").replaceFirst(":", "��")+"��";
				  }
				  s = s.replaceAll("0[ʱ����]", "");	//���� 0ʱ0��0��Ķ��滻Ϊ��
			  }catch(Exception e){ }
			  
			  return s;
		  }
		  
		  //add by tony 2011-07-26 ����Ӣ�ĸ�ʽ���� oct.10.2011
		  public static String formatDateEN(String date) throws ParseException {
			  String s ="";
			  int whichMonth = 1;
			  try{
				  if(UtilFuns.isEmpty(date)){
					  return "";
				  }
				  String[] aString = date.replaceAll("-0", "-").split("-");
				  whichMonth = Integer.parseInt(aString[1]);
				  if(whichMonth==1){
					  s = "Jan";
				  }else if(whichMonth==2){
					  s = "Feb";
				  }else if(whichMonth==3){
					  s = "Mar";
				  }else if(whichMonth==4){
					  s = "Apr";
				  }else if(whichMonth==5){
					  s = "May";
				  }else if(whichMonth==6){
					  s = "Jun";
				  }else if(whichMonth==7){
					  s = "Jul";
				  }else if(whichMonth==8){
					  s = "Aug";
				  }else if(whichMonth==9){
					  s = "Sept";
				  }else if(whichMonth==10){
					  s = "Oct";
				  }else if(whichMonth==11){
					  s = "Nov";
				  }else if(whichMonth==12){
					  s = "Dec";
				  }
				  s = s+"."+aString[2]+","+aString[0];
				  
			  }catch(Exception e){ }
			  
			  return s;
		  }

		  //�������¸�ʽ 2010-7
		  public String formatShortMonth(String strDate){
			  return strDate.substring(0,7).replaceAll("-0", "-");
		  }
		  
		  //�������¸�ʽ 2010-07
		  public String formatMonth(String strDate){
			  return strDate.substring(0,7);
		  }
		  
		  
		  
		  //ɾ�����1���ַ�
		  public static String delLastChar(String s){
		    try{
		      if(s.length()>0){
		        s = s.substring(0,s.length()-1);  
		      }      
		    }catch(Exception e){
		      return "";
		    }
		    return s;
		  }
		  
		  //ɾ�����len���ַ�
		  public static String delLastChars(String s,int len){
		    try{
		      if(s.length()>0){
		        s = s.substring(0,s.length()-len);  
		      }      
		    }catch(Exception e){
		      return "";
		    }
		    return s;
		  }
		  
		  //�滻��ҳ���ַ�-���FCKEditorʹ�� .replaceAll("'","&apos;") //for viewpage
		  public String htmlReplaceAll(String s){
			  try{
				  StringBuffer sBuf = new StringBuffer();
				  //.replaceAll("\\\\","\\\\\\\\").replaceAll("&","&amp;")
				  sBuf.append(s.replaceAll(" ","&nbsp;").replaceAll("<","&lt;").replaceAll(">","&gt;").replaceAll("\"","&quot;").replaceAll("\n","<br\\>"));
				  return sBuf.toString();
			  }catch(Exception e){
				  return "";
			  }
		  }
		  
		  //for viewpage by jstl/make html
		  public static String htmlNewline(String s){
			  try{
				  //�粻�滻�ո�,html����ʱ���Զ��Ѷ���ո���ʾΪһ���ո�,����������ͨ���ո�������ʱ�ͳ���textarea�к�htmlҳ��չ�ֲ�һ�µ���� tony
				  //s.replaceAll(" ","&nbsp;") ���ܽ��пո���滻������ҳ�������������<img src="xxx.jpg" \>�ȱ�ǩ�����ݾͻ���ʾ�ң�<img&nbsp;src="xxx.jpg"nbsp;\>
				  return s.replaceAll(" ","&nbsp;").replaceAll("\n","<br\\>");  
			  }catch(Exception e){
				  return "";
			  }
		  }
		  

		  /** getPassString ���ܣ�����ת��Ϊ��λ��Ϊ*��
		   * <br>���������String strvalue ����Ҫת�����ַ���
		   *              int Flag λ����
		   * <br>�����������
		   * <br>���ߣ�����
		   * <br>ʱ�䣺2006-8-7
		   * <br>�������⣺
		   * <br>�÷���
		   *          <%=utilFuns.ConvertString("abcdef",3)%>
		   */
		  public static String getPassString( String strvalue, int Flag ) {
		    try {
		      if ( strvalue.equals("null") || strvalue.compareTo("")==0){
		        return "";
		      } else {
		        int intStrvalue = strvalue.length();
		        if ( intStrvalue > Flag ) {
		          strvalue = strvalue.substring( 0, intStrvalue - Flag );

		        }
		        for ( int i = 0; i < Flag; i++ ) {
		          strvalue = strvalue + "*";
		        }

		        //System.out.print( "strvalue:" + strvalue );
		        return strvalue;
		      }
		    }
		    catch (Exception e) {
		      return strvalue;
		    }
		  }
		  
		 /** getPassString ���ܣ�����ת��Ϊ��λ��Ϊ*��
		 * <br>���������String strvalue ����Ҫת�����ַ���
		 *              int Flag ��λ����
		 *              int sFlag ĩλ���� 
		 * <br>�����������
		 * <br>���ߣ�����
		 * <br>ʱ�䣺2006-8-7
		 * <br>�������⣺
		 * <br>�÷���
		 *          <%=optionFuns.getPassString(String.valueOf(oi.next()),3)%>
		 */
		public static String getPassString( String strvalue, int Flag, int sFlag ,int iPassLen ) {
		  try {
		    
		    if ( strvalue.equals( "null" ) ) {
		      return "";
		    } else {
		      String strvalue1="";
		      String strvalue2="";
		      int intStrvalue = strvalue.length();
		      if(sFlag>=Flag){
		        if ( intStrvalue > Flag ) {
		          strvalue1 = strvalue.substring( 0,  Flag );
		          strvalue2 = strvalue.substring(  sFlag, intStrvalue );
		        } else {
		          strvalue1 = "";
		          strvalue2 = "";
		        }
		        for ( int i = 0; i < iPassLen; i++ ) {
		          strvalue1 = strvalue1 + "*";
		        }
		        strvalue=strvalue1+strvalue2;
		      }
		      //System.out.print( "strvalue:" + strvalue );
		      return strvalue;
		    }
		  }
		  catch (Exception e) {
		    return strvalue;
		  }
		  } 
		  
		  
		  /* 
			by czs 2006-8-17
			OPTION:
				ȡ���ַ���iStartPosλ�õ�iEndPosλ�ã����м��ⲿ��ת��iPatternLen��sPattern
			EXSAMPLE:
				getPatternString("CHEN ZISHU",5,7,"*",3)
				RESULT: CHEN ***SHU

				getPatternString("CHEN ZISHU",10,0,".",3)
				RESULT: CHEN******

		  */
		  public static String getPatternString( String s, int iStartPos, int iEndPos, String sPattern, int iPatternLen ) {
		    try {
			  if (iEndPos==0) {
				iEndPos = s.length();
			  }
			  
			  String sStartStr = "";
			  String sCenterStr = "";
			  String sEndStr = "";
			  
		      if ( s.equals("null")){
		        return "";
		      } else {
		        int ints = s.length();
		        if ( ints > iStartPos ) {
		          sStartStr = s.substring( 0, iStartPos );
		        }else{
		          return s;
		        }
				if ( ints > iEndPos) {
		          sEndStr = s.substring( iEndPos, ints );
				}
		        for ( int i = 0; i < iPatternLen; i++ ) {
		          sCenterStr = sCenterStr + sPattern;
		        }
		        return sStartStr + sCenterStr + sEndStr;
		      }
		    }
		    catch (Exception e) {
		      System.out.println(e);
		      return s;
		    }
		  }

		  public static String getPatternString( String s, int iStartPos, String sPattern, int iPatternLen ) {
		    return getPatternString(s,iStartPos,0,sPattern,iPatternLen);
		  }

		  public static String getPatternString( String s, int iStartPos, String sPattern ) {
		    return getPatternString(s,iStartPos,0,sPattern,3);
		  }

		  
		    /** getQQString ���ܣ�����ת��Ϊ��λ��Ϊ*��
		* <br>���������String strvalue ����Ҫת�����ַ���
		*               
		* <br>�����������
		* <br>���ߣ�����
		* <br>ʱ�䣺2006-8-7
		* <br>�������⣺
		* <br>�÷���
		*          <%=optionFuns.getQQString(String.valueOf(oi.next()))%>
		*/
		public static String getQQString( String strvalue ) {
			try {
			  String QQ="";
			  if ( strvalue.equals("") ) {
			    return "";
			  } else {
			     QQ="<img src=\"http://wpa.qq.com/pa?p=1:"+strvalue
			        +":4\">"
			        +" <SPAN title=\"���½���!\" style=\"CURSOR: hand\""
			        +" onclick=\"window.open('http://wpa.qq.com/msgrd?V=1&amp;Uin="+strvalue
			        +"&amp;Site=21pan&amp;Menu=yes')\">"+strvalue+"</SPAN>";
			    }
			    strvalue=QQ;
			    //System.out.print( "strvalue:" + strvalue );
			    return strvalue;
			  
			}
			
			catch (Exception e) {
			  return strvalue;
			}
		}

			public String getNoExistString(String allString, String existString){
				return this.getNoExistString(this.splitStr(allString, ","), existString);
			}
			
			/* ����existString�е�ÿ���ִ�����allString�е� */
			public String getNoExistString(String[] allString, String existString){
				existString = existString + ",";
				if(allString==null&&allString.length==0){
					return "";
				}
				StringBuffer sBuf = new StringBuffer();
				for(int i=0;i<allString.length;i++){
					if(existString.indexOf(allString[i])==-1){
						sBuf.append(allString[i]).append(",");
					}
				}
				if(sBuf.length()>1){
					sBuf.delete(sBuf.length()-1, sBuf.length());
				}
				return sBuf.toString();
			}
			
		  public static void main(String[] args) throws Exception {

//			  
//			  
//			  java.util.List aList = new ArrayList();
//			  System.out.println(UtilFuns.isNotEmpty(aList));
//			  
//			  System.out.println(uf.formatDateTimeCN("2011"));
//			  System.out.println(uf.formatDateTimeCN("2011-01"));
//			  System.out.println(uf.formatDateTimeCN("2011-01-02"));
//			  System.out.println(uf.formatDateTimeCN("2011-01-02 03"));
//			  System.out.println(uf.formatDateTimeCN("2011-01-02 13:05"));
//			  System.out.println(uf.formatDateTimeCN("2011-01-02 13:05:05"));
//			  System.out.println(uf.formatDateTimeCN("03"));
//			  System.out.println(uf.formatDateTimeCN("13:05"));
//			  System.out.println(uf.formatDateTimeCN("13:05:05"));
			  
//			  UtilFuns uf = new UtilFuns();
//			  System.out.println(uf.getNoExistString("1,2,3", "1,2,3,4"));
//			  System.out.println(uf.getNoExistString("��ȫ,����,Ӫ��", "����,Ӫ��"));
//			  System.out.println("finish!");
			  
//			  Set<String> set = new HashSet<String>();
//			  set.add("abc");
//			  set.add("xyz"); 
//			  set.add("abc");  
//			  for(Iterator<String> it = set.iterator();it.hasNext();){
//			   System.out.println(it.next());   
//			  } 
			
		  	/*
		    System.out.println(SysTime("yyyy-MM-dd"));
		    System.out.println(SysTime("yyyy-MM-dd HH:mm:ss"));
		    
		    System.out.println(Double.parseDouble("12.11"));
		    System.out.println(FormatNumber("12.11000000000f"));
		    
		    System.out.println(getPatternString("CHEN ZISHU",8,0,".",3));
		    */
		    
		    //System.out.println(SysTime("yyyy��MM��"));
		    //System.out.println(SysTime("yyyyMM"));
		    //System.out.println(ConvertSpaceTD(""));
		    //System.out.println(ConvertTD(""));
		    
				/* process the stat data Start 
				Statement stmt1 = conn.createStatement(); 
				String sTableName = find_Type;
				String sUserName = findName;
				StringBuffer sBuffer = new StringBuffer();

				//Step 1 clear Table userState
				sBuffer.append("delete * from userStat;");

				//Step 2 read username from User_P and write inputnum in it
				sBuffer.append("select User_P.loginname,").append(sTableName).append(".createby,count(").append(sTableName).append(".createby)")
					.append(" from ").append(sTableName).append("")
					.append(" right join")
					.append(" User_P")
					.append(" on User_P.loginname=").append(sTableName).append(".createby")
					.append(" where 1=1");
				if (find_Name.compareTo("")!=0){
					sBuffer.append(" and ").append(sTableName).append(".createby='").append(sTableName).append("'");
				}
				if (find_DateStart.compareTo("")!=0){
					sBuffer.append(" and createdate<='").append(find_DateStart).append(" 00:00:00'");
				}
				if (find_DateStart.compareTo("")!=0){
					sBuffer.append(" and createdate>='").append(find_DateEnd).append(" 23:59:59'");
				}
				sBuffer.append(" group by ").append(sTableName).append(".createby")
					.append(";");


				//Step 3 read updatenum
				sBuffer.append("select count(updateby) from ").append(sTableName).append("")
					.append(" where ").append(sTableName).append(".updateby=''")
					.append(" and updatedate<='").append(find_DateStart).append(" 00:00:00'")
					.append(" and updatedate>='").append(find_DateEnd).append(" 23:59:59'")
					.append(";");

				//Step 4 update the userStat.updatenum value
				sBuffer.append("update userStat set updatenum='3' where updateby='").append(sTableName).append("'")
					.append(";");

				sBuffer.toString();

				 process the stat data End */

		/*    
		    try{
		      System.out.println(SysDate());
		       System.out.println(StrToDateTimeFormat("2003-08-21 18:28:47", "yyyy-MM-"));
		    }catch(Exception e){
		       
		    }
		    String s[] = SplitStr("asd,asd,we,sd",",");
		    for (int curLayNum=0;curLayNum<s.length;curLayNum++){
		      System.out.println(s[curLayNum]);
		    }
		    System.out.println(JoinStr(s,","));

		    System.out.println(ReturnSysTime("yyyy-MM-dd"));
		    //System.out.println(CoverDate(ReturnSysTime("yyyy-MM-dd HH:mm:ss"),"yyyy-MM-dd"));
		    try {
		      System.out.println(StrToTimestamp("2003-08-21 18:28:47", "yyyy-MM"));
		      System.out.println(StrToDateTimeFormat("2003-08-21 18:28:47", "yyyy-MM"));
		    }
		    catch (ParseException ex) {
		    }

		    try {
		      System.out.println(StrToTimestamp("2003-08-26", "yyyy-MM-dd"));
		    }
		    catch (ParseException ex) {
		      System.out.println("StrToTimestamp error.");
		    }*/
			  
			  System.out.println("finish!");
		  }

		/*
		<script language=JavaScript>

		  var today = new Date();
		  var strDate = (today.getFullYear() + "��" +
		(today.getMonth() + 1) + "��" + today.getDate() + "�� ");
		  var n_day = today.getDay();
		  switch (n_day)
		  {
		  case 0:{
		  strDate = strDate + "������"
		  }break;
		  case 1:{
		  strDate = strDate + "����һ"
		  }break;
		  case 2:{
		  strDate = strDate + "���ڶ�"
		  }break;
		  case 3:{
		  strDate = strDate + "������"
		  }break;
		  case 4:{
		  strDate = strDate + "������"
		  }break;
		  case 5:{
		  strDate = strDate + "������"
		  }break;
		  case 6:{
		  strDate = strDate + "������"
		  }break;
		  case 7:{
		  strDate = strDate + "������"
		  }break;
		  }
		  document.write(strDate);

		</script>
		*/

			public String replaceLast(String string, String toReplace, String replacement) {
				int pos = string.lastIndexOf(toReplace);
				if (pos > -1) {
					return string.substring(0, pos) + replacement + string.substring(pos + toReplace.length(), string.length());
				} else {
					return string;
				} 
			} 
			
			public static String getROOTPath(){
				UtilFuns uf = new UtilFuns();
				return uf.getClass().getResource("/").getPath().replace("/WEB-INF/classes/", "/").substring(1);
			}
			public String getClassRootPath(){
				return this.getClass().getResource("/").getPath();
			}
}
