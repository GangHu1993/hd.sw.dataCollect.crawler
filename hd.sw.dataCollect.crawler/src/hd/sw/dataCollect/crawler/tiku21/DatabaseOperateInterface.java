package hd.sw.dataCollect.crawler.tiku21;

/** 
* CopyRright(c)2016-3-11:<HD>                          
* Project:<����-��Ŀ > 21�������
* Module:����                                                                                  
* JDK version used:<JDK1.7>                                                            
* Author:<Gang Hu>                 
* Create Date: <��������:2016-3-11>                                         
* Version:0.1
* Comments:���ݿ������
*/ 

public interface DatabaseOperateInterface {
	/**
	 * insert data into mysql database
	 *  
	 *  @param row
	 *  		the data tuple to insert 
	 *  	
	 *  @return a flag representing inserting success or fail.
	 * 				
	 */
	public int insert(Metadata row);
}
