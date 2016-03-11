package hd.sw.dataCollect.crawler.tiku21;

/** 
* CopyRright(c)2016-3-11:<HD>                          
* Project:<视问-项目 > 21世纪题库
* Module:爬虫                                                                                  
* JDK version used:<JDK1.7>                                                            
* Author:<Gang Hu>                 
* Create Date: <创建日期:2016-3-11>                                         
* Version:0.1
* Comments:数据库操作。
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
