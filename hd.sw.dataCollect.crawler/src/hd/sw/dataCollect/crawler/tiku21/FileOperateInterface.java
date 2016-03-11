package hd.sw.dataCollect.crawler.tiku21;

import edu.uci.ics.crawler4j.crawler.Page;

/** 
* CopyRright(c)2016-3-11:<HD>                          
* Project:<����-��Ŀ > 21�������
* Module:����                                                                                  
* JDK version used:<JDK1.7>                                                            
* Author:<Gang Hu>                 
* Create Date: <��������:2016-3-11>                                         
* Version:0.1
* Comments:�ļ�������
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
