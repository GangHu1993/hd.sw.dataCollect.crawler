package hd.sw.dataCollect.crawler.tiku21;

import edu.uci.ics.crawler4j.crawler.Page;

/** 
* CopyRright(c)2016-3-11:<HD>                          
* Project:<视问-项目 > 21世纪题库
* Module:爬虫                                                                                  
* JDK version used:<JDK1.7>                                                            
* Author:<Gang Hu>                 
* Create Date: <创建日期:2016-3-11>                                         
* Version:0.1
* Comments:文件操作。
*/ 

public interface FileOperateInterface {
	/**
	 * write html to a file
	 *  
	 *  @param page
	 *  		the html page need to write
	 *  
	 */
	public void htmlFileWrite(Page page);
	
	/**
	 * write content to a file
	 *  
	 *  @param content
	 *  		the content need to write 
	 *  
	 */
	public void contentWrite(String content);
}
