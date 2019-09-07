package com.city.my.pagination;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page<T> {
	  private int pageNo = 1;			//ҳ�룬Ĭ���ǵ�һҳ
	    private int pageSize = 10;		//ÿҳ��ʾ�ļ�¼����Ĭ����10
	    private int totalRecord;		//�ܼ�¼��
	    private int totalPage;			//��ҳ��
	    private List<T> results;		//��Ӧ�ĵ�ǰҳ��¼
	    private Map<String, Object> params = new HashMap<String, Object>();		//�����Ĳ������ǰ�����װ��һ��Map����
	 
	    public int getPageNo() {
	       return pageNo;
	    }
	 
	    public void setPageNo(int pageNo) {
	       this.pageNo = pageNo;
	    }
	 
	    public int getPageSize() {
	       return pageSize;
	    }
	 
	    public void setPageSize(int pageSize) {
	       this.pageSize = pageSize;
	    }
	 
	    public int getTotalRecord() {
	       return totalRecord;
	    }
	 
	    public void setTotalRecord(int totalRecord) {
	       this.totalRecord = totalRecord;
	       //��������ҳ����ʱ��������Ӧ����ҳ�������������Ŀ�����мӷ�ӵ�и��ߵ����ȼ������������Բ������š�
	       int totalPage = totalRecord%pageSize==0 ? totalRecord/pageSize : totalRecord/pageSize + 1;
	       this.setTotalPage(totalPage);
	    }
	 
	    public int getTotalPage() {
	       return totalPage;
	    }
	 
	    public void setTotalPage(int totalPage) {
	       this.totalPage = totalPage;
	    }
	 
	    public List<T> getResults() {
	       return results;
	    }
	 
	    public void setResults(List<T> results) {
	       this.results = results;
	    }
	   
	    public Map<String, Object> getParams() {
	       return params;
	    }
	   
	    public void setParams(Map<String, Object> params) {
	       this.params = params;
	    }
	 
	    public String toString() {
	       StringBuilder builder = new StringBuilder();
	       builder.append("Page [pageNo=").append(pageNo).append(", pageSize=").append(pageSize).append(", results=").append(results).append(", totalPage=").append(totalPage).append(", totalRecord=").append(totalRecord).append("]");
	       return builder.toString();
	    }
	 
		/* ҳ������ */
		public String pageLinks(String url) {
			int endPage = this.totalRecord/pageSize +1;
			
			StringBuffer sBuf = new StringBuffer();
			
			sBuf.append("<input type=\"hidden\" name=\"pageNo\" value=\"").append(this.pageNo).append("\">");		//��ҳ��������ǰҳ������
			
			sBuf.append("<span class=\"noprint\" style=\"padding:5px;\">");

			sBuf.append("&nbsp;��").append(this.pageNo).append("ҳ / ��").append(endPage).append("ҳ&nbsp;");
			sBuf.append("&nbsp;�ܹ�").append(this.totalRecord).append("����¼ ÿҳ").append(this.pageSize).append("����¼&nbsp;");
			
			sBuf.append("<a href=\"").append(url).append("?pageNo=1");
			sBuf.append("\">[��ҳ]");
			sBuf.append("</a>&nbsp;");
			
			sBuf.append("<a href=\"").append(url).append("?pageNo=");
			if(pageNo<=1){
				sBuf.append(1);
			}else{
				sBuf.append(pageNo-1);
			}	
			sBuf.append("\">[��һҳ]");
			sBuf.append("</a>&nbsp;");
				
			
			sBuf.append("<a href=\"").append(url).append("?pageNo=");
			if(pageNo>=endPage){
				sBuf.append(endPage);
			}else{
				sBuf.append(pageNo+1);
			}	
			sBuf.append("\">[��һҳ]");
			sBuf.append("</a>&nbsp;");
				
			sBuf.append("<a href=\"").append(url).append("?pageNo=").append(endPage);
			sBuf.append("\">[ĩҳ]");
			sBuf.append("</a>&nbsp;");

			sBuf.append("</span>");
			
			return sBuf.toString();
		}
}
