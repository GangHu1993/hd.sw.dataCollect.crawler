package hd.sw.dataCollect.crawler.tiku21;


/** 
* CopyRright(c)2016-3-11:<HD>                          
* Project:<����-��Ŀ > 21�������
* Module:����                                                                                  
* JDK version used:<JDK1.7>                                                            
* Author:<Gang Hu>                 
* Create Date: <��������:2016-3-11>                                         
* Version:0.1
* Comments:���ݿ����Ԫ�顣
*/ 

public class Metadata {
	String title;
	String description;
	String webUrl;
	public Metadata(String title,String description,String webUrl){
		this.title =title.replaceAll("'", "''");;
		this.description = description.replaceAll("'", "''");;
		this.webUrl =webUrl.replaceAll("'", "''");;
	}
}
