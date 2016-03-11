package hd.sw.dataCollect.crawler.tiku21;


/** 
* CopyRright(c)2016-3-11:<HD>                          
* Project:<视问-项目 > 21世纪题库
* Module:爬虫                                                                                  
* JDK version used:<JDK1.7>                                                            
* Author:<Gang Hu>                 
* Create Date: <创建日期:2016-3-11>                                         
* Version:0.1
* Comments:数据库基本元组。
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
