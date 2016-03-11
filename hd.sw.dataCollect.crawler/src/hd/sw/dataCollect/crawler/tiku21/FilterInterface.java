package hd.sw.dataCollect.crawler.tiku21;

import java.util.ArrayList;

/** 
* CopyRright(c)2016-3-11:<HD>                          
* Project:<视问-项目 > 21世纪题库
* Module:爬虫                                                                                  
* JDK version used:<JDK1.7>                                                            
* Author:<Gang Hu>                 
* Create Date: <创建日期:2016-3-11>                                         
* Version:0.1
* Comments:过滤操作。
*/ 
public interface FilterInterface {
	/**
	 * get title
	 *  
	 *  @param html
	 *  		the string need to be filtered
	 *  
	 */
	public String getTitle(String html);
	
	/**
	 * get description
	 *  
	 *  @param html
	 *  		the string need to be filtered
	 *  
	 */
	public String getDescription(String html);
	
	/**
	 * get conten
	 *  
	 *  @param html
	 *  		the string need to be filtered
	 *  
	 */
	public String getContent(String html);
	
	/**
	 * get image url
	 *  
	 *  @param html
	 *  		the string need to be filtered
	 *  
	 *  @return a ArrayList of image url.
	 *  
	 */
	public ArrayList<String> getImage(String imContent);
	
	/**
	 * clean html tag
	 *  
	 *  @param html
	 *  		the string need to be cleaned
	 *  
	 *  @return the string that have been cleaned.
	 *  
	 */
	public String deleteHtml(String res);

}
