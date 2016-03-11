package hd.sw.dataCollect.crawler.tiku21;

import java.util.ArrayList;

/** 
* CopyRright(c)2016-3-11:<HD>                          
* Project:<����-��Ŀ > 21�������
* Module:����                                                                                  
* JDK version used:<JDK1.7>                                                            
* Author:<Gang Hu>                 
* Create Date: <��������:2016-3-11>                                         
* Version:0.1
* Comments:��ҳ���ݹ��ˡ�
*/ 

public interface ContentFilterInterface {
	/**
	 * get title from html
	 *  
	 *  @return title of html.
	 * 				
	 */
	public String getTitle();
	
	/**
	 * get description from html
	 *  
	 *  @return description of html.
	 * 				
	 */
	public String getDescription();
	
	/**
	 * get main Content from html
	 *  
	 *  @return main Content of html.
	 * 				
	 */
	public String getContent();
	
	/**
	 * get iamge url from a string named re
	 *  
	 *  @param re
	 *  		the string that contains image url
	 *  
	 *  @return a ArrayList of image url.
	 * 				
	 */
	public ArrayList<String> getImage(String re);
	
	/**
	 * clean the tag of html
	 *  
	 *  @return a string after cleaning.
	 * 				
	 */
	public String deleteHtml();
}
